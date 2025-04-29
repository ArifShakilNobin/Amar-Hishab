import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedModule } from '../../shared/modules/shared/shared.module';
import { AuthenticationModule } from '../../modules/authentication/authentication.module';
import { DefaultLayoutModule } from '../../shared/modules/default-layout/default-layout.module';
import { httpInterceptorProviders } from '../../shared/services/http-interceptors';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    SharedModule,
    AuthenticationModule,
    DefaultLayoutModule
  ],
  providers: [httpInterceptorProviders],

})
export class CoreModule { }
