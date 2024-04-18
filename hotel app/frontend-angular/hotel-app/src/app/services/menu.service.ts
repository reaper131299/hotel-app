import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MenuItem } from '../entities/menu-item';

@Injectable({
  providedIn: 'root',
})
export class MenuService {
  private menuCardUrl: string = 'http://localhost:8080/tasty/menuCard';
  private menuCatagoryUrl: string =
    'http://localhost:8080/tasty/catagoryMenuCard?foodType=';
  catagoryUrl: string = '';
  constructor(private httpClient: HttpClient) {}
  getMenuList(): Observable<MenuItem[]> {
    return this.httpClient.get<MenuItem[]>(`${this.menuCardUrl}`);
  }

  getMenuByCatagory(catagory: string): Observable<MenuItem[]> {
    this.catagoryUrl = this.menuCatagoryUrl + catagory;
    return this.httpClient.get<MenuItem[]>(`${this.catagoryUrl}`);
  }
}
