import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './components/login/login.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { AuthenticationRoutes } from './Authentication.routing';
import { SharedModule } from '../../shared/modules/shared/shared.module';
import { NgZorroAntdModule } from '../../ng-zorro-antd.module';

@NgModule({
  declarations: [LoginComponent, RegistrationComponent],
  imports: [CommonModule, AuthenticationRoutes,SharedModule,NgZorroAntdModule],
})
export class AuthenticationModule {}
