import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css'],
})
export class LoginPageComponent implements OnInit {
  eamilId: string = '';
  password: string = '';
  isUser: any;

  private menuCardUrl1: string =
    'http://localhost:8080/tasty/login?userPassword=';

  private menuCardUrl2: string = '&userEmailId=';

  private actualUrl = '';

  constructor(private httpClient: HttpClient, private router: Router) {}

  ngOnInit(): void {}

  login() {
    this.actualUrl =
      this.menuCardUrl1 + this.password + this.menuCardUrl2 + this.eamilId;
    this.httpClient
      .post<any>(this.actualUrl, { isUser: true })
      .subscribe((data) => {
        this.isUser = data;
        if (this.isUser.isUser == true) {
          this.router.navigate(['homePage']);
        }
      });
  }
}
