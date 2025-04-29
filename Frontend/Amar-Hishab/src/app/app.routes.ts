import { Routes } from '@angular/router';
import { DefaultLayoutComponent } from './shared/modules/default-layout/default-layout.component';
import { AuthenticationGuard } from './modules/authentication/services/authentication.guard';
import { LoginComponent } from './modules/authentication/components/login/login.component';

export const routes: Routes = [
  { path: '', component: LoginComponent },

  {path:'home',
    component: DefaultLayoutComponent,
    canActivate: [AuthenticationGuard],
    children: [
      {path: 'auth', loadChildren: () => import('./modules/authentication/authentication.module').then(m => m.AuthenticationModule)},
      // { path: '', pathMatch: 'full', redirectTo: 'welcome' },
      // { path: 'welcome', loadChildren: () => import('./pages/welcome/welcome.routes').then(m => m.WELCOME_ROUTES) }
    ]
  },

];
