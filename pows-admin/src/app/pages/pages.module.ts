import {NgModule} from '@angular/core';

import {PagesComponent} from './pages.component';
import {DashboardModule} from './dashboard/dashboard.module';
import {PagesRoutingModule} from './pages-routing.module';
import {HomepageComponent} from './homepage/homepage.component';
import {FooterComponent, HeaderComponent} from '../pows-theme/components';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

const PAGES_COMPONENTS = [
  PagesComponent,
];

@NgModule({
  imports: [
    PagesRoutingModule,
    DashboardModule,
    HeaderComponent,
    FooterComponent
  ],
  declarations: [
    ...PAGES_COMPONENTS,
    HomepageComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    RegisterComponent
  ],
})
export class PagesModule {
}
