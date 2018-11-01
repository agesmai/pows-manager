import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {PagesComponent} from './pages/pages.component';
import {FooterComponent, HeaderComponent} from './pows-theme/components';
import {RouterModule} from '@angular/router';
import {ApplicationRoutes} from './routing/routing';
import {FormsModule} from '@angular/forms';
import {DashboardComponent} from './pages/dashboard/dashboard.component';
import {HomepageComponent} from './pages/homepage/homepage.component';
import {CommonModule} from '@angular/common';
import {PowsUserComponent} from './pages/pows-user/pows-user.component';
import {TargetSystemsComponent} from './pages/target-systems/target-systems.component';
import {PropertiesStoreComponent} from './pages/properties-store/properties-store.component';
import { AlertComponent } from '@/src/app/_directives';

@NgModule({
  declarations: [
    AppComponent,
    PagesComponent,
    DashboardComponent,
    HomepageComponent,
    PowsUserComponent,
    TargetSystemsComponent,
    PropertiesStoreComponent,
    HeaderComponent,
    FooterComponent,
    AlertComponent
  ],
  imports: [
    RouterModule.forRoot(ApplicationRoutes),
    CommonModule,
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
