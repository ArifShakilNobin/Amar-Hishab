import { Component } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { AuthenticationStorageService } from '../../services/authentication-storage.service';
import { AuthenticationService } from '../../services/authentication.service';
import { NzNotificationService } from 'ng-zorro-antd/notification';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  passwordVisible = false;
  password?: string;
  loginForm!: FormGroup;

  constructor(
    private authenticationStorageService: AuthenticationStorageService,
    private authenticationService: AuthenticationService,
    private route: ActivatedRoute,
    private router: Router,
    private fb: FormBuilder,
    private notification: NzNotificationService
  ) {
    if (this.authenticationService.getIsUserAuthenticated()) {
      this.router.navigateByUrl('/home');
    }
  }



  ngOnInit() {
    this.loginForm = this.fb.group({
      Email: ['', [Validators.required, Validators.email]],
      Password: ['', [Validators.required]],
    });
  }

  login() {
    const credentials = {
      Email: this.loginForm.controls['Email'].value,
      Password: this.loginForm.controls['Password'].value,
    };
    this.authenticationStorageService.login(credentials).subscribe({
      next: (response) => {
        if (response.success === true) {
          // this.router.navigate(['home/dashboard']);
          this.notification.success('Success', response.message);
          this.router.navigate(['home/event']);
        }

        if (response.success === false) {
          this.notification.error('Error', response.message);
        }
      },
    });
  }

  resetLoginForm() {
    this.loginForm.reset();
  }
  togglePasswordVisibility(): void {
    this.passwordVisible = !this.passwordVisible;
  }
}
