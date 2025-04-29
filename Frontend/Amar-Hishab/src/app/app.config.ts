import {
  ApplicationConfig,
  importProvidersFrom,
  provideZoneChangeDetection,
} from '@angular/core';
import { provideRouter } from '@angular/router';
import { routes } from './app.routes';
import { provideClientHydration } from '@angular/platform-browser';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';

import { provideNzIcons } from 'ng-zorro-antd/icon';
import { en_US, provideNzI18n} from 'ng-zorro-antd/i18n';
import { registerLocaleData, DatePipe } from '@angular/common';
import en from '@angular/common/locales/en';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { NgxUiLoaderModule, NgxUiLoaderConfig } from 'ngx-ui-loader';
import { NgxUiLoaderRouterModule } from 'ngx-ui-loader';
import { NgxUiLoaderHttpModule, NgxUiLoaderHttpConfig } from 'ngx-ui-loader';

import { NZ_CONFIG, NzConfig } from 'ng-zorro-antd/core/config';

import { POSITION, SPINNER } from 'ngx-ui-loader';

import { TitleCasePipe } from '@angular/common';
import { CoreModule } from './core/core/core.module';
import { SharedModule } from './shared/modules/shared/shared.module';

// Register locale data
registerLocaleData(en);

// NG-ZORRO config
const ngZorroConfig: NzConfig = {
  notification: { nzPlacement: 'topRight' },
};

// NGX UI Loader config
const ngxUiLoaderConfig: NgxUiLoaderConfig = {
  bgsColor: 'red',
  bgsPosition: POSITION.centerCenter,
  bgsSize: 40,
  bgsType: SPINNER.rectangleBounce,
};

const ngxUiLoaderHttpConfig: NgxUiLoaderHttpConfig = {
  // showForeground: true,
};

export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    provideClientHydration(),
    provideNzIcons([]), // You can use your `icons` array if you have it
    provideNzI18n(en_US),
    { provide: NZ_CONFIG, useValue: ngZorroConfig },
    importProvidersFrom(
      BrowserModule,
      FormsModule,
      ReactiveFormsModule,
      // IconsProviderModule,
      NgxUiLoaderModule.forRoot(ngxUiLoaderConfig),
      NgxUiLoaderRouterModule,
      NgxUiLoaderHttpModule.forRoot(ngxUiLoaderHttpConfig),
      SharedModule,
      CoreModule,
      // LandingModule
    ),
    provideAnimationsAsync(),
    provideHttpClient(withInterceptorsFromDi()),
    DatePipe,
    TitleCasePipe,
  ],
};
