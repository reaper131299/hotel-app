import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cart } from '../entities/cart';

@Injectable({
  providedIn: 'root',
})
export class CartService {
  private baseUrl: String = 'http://localhost:8080/tasty/myCart';

  private urlForDelete: string = '';

  constructor(private httpClient: HttpClient) {}

  getItemsInCart(): Observable<Cart[]> {
    return this.httpClient.get<Cart[]>(`${this.baseUrl}`);
  }

  deleteItemsInCart(menuId: number): Observable<Cart[]> {
    this.urlForDelete = this.baseUrl + '?cartEntryId=' + menuId;
    return this.httpClient.delete<Cart[]>(`${this.urlForDelete}`);
  }
}
