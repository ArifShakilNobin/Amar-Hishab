import { Injectable, Inject, PLATFORM_ID } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { BehaviorSubject, Observable, Subject } from 'rxjs';
import { isPlatformBrowser } from '@angular/common';
import { LoginResponse } from '../models/login-response.dto';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  public currentUserSubject!: BehaviorSubject<LoginResponse | null>;
  public currentUser!: Observable<LoginResponse | null>;
  private isAuthenticated = false;
  private token: string | null = '';
  private tokenTimer: any;
  private userId!: number | null;

  private isBrowser: boolean;

  onUserTypeStartEditing = new Subject<number>();

  constructor(
    private http: HttpClient,
    private router: Router,
    @Inject(PLATFORM_ID) private platformId: Object
  ) {
    this.isBrowser = isPlatformBrowser(platformId);

    let userData: LoginResponse | null = null;
    if (this.isBrowser) {
      const stored = localStorage.getItem('currentUserData');
      if (stored && stored !== '{}') {
        userData = JSON.parse(stored);
      }
    }

    this.currentUserSubject = new BehaviorSubject<LoginResponse | null>(userData);
    this.currentUser = this.currentUserSubject.asObservable();
  }

  getToken(): string | null {
    return this.token;
  }

  getIsUserAuthenticated(): boolean {
    return this.isAuthenticated;
  }

  get CurrentUserValue(): LoginResponse | null {
    return this.currentUserSubject.value;
  }

  public saveCurrentUserInfo(currentUserInfo: LoginResponse): void {
    const tokenExpiresIn = currentUserInfo.tokenDuration;
    this.setAutoLogoutTimer(tokenExpiresIn);

    const now = new Date();
    const tokenExpirationDate = new Date(now.getTime() + tokenExpiresIn * 1000);
    currentUserInfo.tokenExpirationDate = tokenExpirationDate;

    this.currentUserSubject.next(currentUserInfo);

    if (this.isBrowser) {
      localStorage.setItem('currentUserInfo', JSON.stringify(currentUserInfo));
    }

    this.token = currentUserInfo.token;
    this.isAuthenticated = true;
    this.userId = currentUserInfo.id;
  }

  logout(): void {
    this.token = null;
    this.isAuthenticated = false;
    this.currentUserSubject.next(null);
    this.userId = null;
    clearTimeout(this.tokenTimer);
    this.clearCurrentUserInfo();

    this.router.navigate(['/']);
  }

  public clearCurrentUserInfo(): void {
    if (this.isBrowser) {
      localStorage.removeItem('currentUserInfo');
    }
  }

  public getCurrentUserInfo(): LoginResponse | null {
    if (!this.isBrowser) return null;

    const stored = localStorage.getItem('currentUserInfo');
    if (!stored || stored === '{}') return null;

    const currentUserInfo: LoginResponse = JSON.parse(stored);
    currentUserInfo.tokenExpirationDate = new Date(currentUserInfo.tokenExpirationDate);
    return currentUserInfo;
  }

  public setAutoLogoutTimer(duration: number): void {
    this.tokenTimer = setTimeout(() => {
      this.logout();
    }, duration * 1000);
  }
}
