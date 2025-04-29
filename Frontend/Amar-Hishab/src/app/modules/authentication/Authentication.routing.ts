import { Routes, RouterModule } from '@angular/router';
import { RegistrationComponent } from './components/registration/registration.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  { path: 'registration',component: RegistrationComponent,},
  { path: 'login',component: LoginComponent,},
];

export const AuthenticationRoutes = RouterModule.forChild(routes);
