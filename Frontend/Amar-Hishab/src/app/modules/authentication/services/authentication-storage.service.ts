import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Inject, Injectable, PLATFORM_ID } from '@angular/core';
import { Observable, catchError, map, tap } from 'rxjs';
import { AuthenticationService } from './authentication.service';
import { Router } from '@angular/router';
import {
  ErrorHandler,
  HttpErrorHandler,
} from '../../../shared/services/http-error-handler.service';
import { ServerResponse } from '../../../shared/dto/server-response.dto';
import { User } from '../models/User';
import { applicationUrls } from '../../../shared/application-constants/application-urls.const';
import { isPlatformBrowser } from '@angular/common';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationStorageService {
  private handleError: ErrorHandler;
  private isBrowser!: boolean;

  constructor(
    private httpClient: HttpClient,
    private authenticationService: AuthenticationService,
    private httpErrorHandler: HttpErrorHandler,
    private router: Router,
    @Inject(PLATFORM_ID) private platformId: Object,

  ) {
    this.handleError = this.httpErrorHandler.createErrorHandler(
      'Authentication Service'
    );
    this.isBrowser = isPlatformBrowser(this.platformId);

  }

  registration(userLoginCredential: User): Observable<ServerResponse> {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.httpClient.post<ServerResponse>(applicationUrls.user.register,userLoginCredential,{ headers }).pipe(
      catchError(this.handleError<never>('User signup')),
      tap({
        next: (response: ServerResponse) => {
          if (response.success) {
            // console.log('Registration response:', response);

            this.router.navigate(['/login']);
          }
        },
        error: (error) => {
          this.authenticationService.currentUserSubject.next(error);
        },
      })
    )
  }
  login(credentials: any): Observable<any> {
    return this.httpClient.post<any>(applicationUrls.user.login, credentials).pipe(
      tap(response => {
        // console.log('Login response:', response);

        if (response && response.success && response.data && response.data.token) {
          localStorage.setItem('token', response.data.token);
        } else {
          console.error('Token not found in the response');
        }
      })
    );
  }

  logout() {
    // localStorage.removeItem('token');
    // this.router.navigate(['/login']);
    if (typeof window !== 'undefined') {
      localStorage.removeItem('token');
    }
    this.router.navigate(['/login']);
  }

  getToken() {
    // return localStorage.getItem('token');
    return typeof window !== 'undefined' ? localStorage.getItem('token') : null;

  }


}
