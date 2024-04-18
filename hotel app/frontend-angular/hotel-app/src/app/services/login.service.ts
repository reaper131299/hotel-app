import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  private menuCardUrl1: string =
    'http://localhost:8080/tasty/login?userPassword=';

  private menuCardUrl2: string = '&userEmailId=';

  private actualUrl = '';

  private postData = {};

  constructor(private httpClient: HttpClient) {}
  customerLogin(email: string, password: string) {
    this.actualUrl =
      this.menuCardUrl1 + password + this.menuCardUrl2 + password;
    return this.httpClient.get(`${this.actualUrl}`);
  }
}
