import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CartComponent } from './components/cart/cart.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { MenuCardComponent } from './components/menu-card/menu-card.component';
import { RegistrationPageComponent } from './components/registration-page/registration-page.component';
import { UnderDevelopmentComponent } from './components/under-development/under-development.component';

const routes: Routes = [
  { path: 'myCart', component: CartComponent },
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'homePage', component: HomePageComponent },
  { path: 'underDevelopment', component: UnderDevelopmentComponent },
  { path: 'menuCard', component: MenuCardComponent },
  { path: 'login', component: LoginPageComponent },
  { path: 'register', component: RegistrationPageComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
