import { Routes, RouterModule } from '@angular/router';
import { DefaultLayoutComponent } from './default-layout.component';

const routes: Routes = [
  { path: '', component: DefaultLayoutComponent},
];

export const DefaultLayoutRoutes = RouterModule.forChild(routes);
