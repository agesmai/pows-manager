import {DashboardComponent} from '../pages/dashboard/dashboard.component';
import {HomepageComponent} from '../pages/homepage/homepage.component';
import {PowsUserComponent} from '../pages/pows-user/pows-user.component';
import {TargetSystemsComponent} from '../pages/target-systems/target-systems.component';
import {PropertiesStoreComponent} from '../pages/properties-store/properties-store.component';

export const ApplicationRoutes = [
  {path: 'dashboard', component: DashboardComponent},
  {path: 'home', component: HomepageComponent},
  {path: 'pows-user', component: PowsUserComponent},
  {path: 'target-systems', component: TargetSystemsComponent},
  {path: 'properties-store', component: PropertiesStoreComponent},
  {path: '', component: HomepageComponent}
];
