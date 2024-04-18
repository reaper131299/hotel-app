import { Component, OnInit } from '@angular/core';
import { Cart } from 'src/app/entities/cart';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css'],
})
export class CartComponent implements OnInit {
  cartItems: Cart[] = [];

  totalPrice: number = 0;

  constructor(private cartservice: CartService) {}

  ngOnInit(): void {
    this.getCartItems();
  }

  getCartItems() {
    this.cartservice.getItemsInCart().subscribe((data) => {
      this.cartItems = data;
    });
    this.calculatePrice();
  }

  deleteItem(menuId: number) {
    this.cartservice.deleteItemsInCart(menuId).subscribe((data) => {
      this.cartItems = data;
    });
    this.calculatePrice();
  }

  private calculatePrice() {
    this.totalPrice = 0;
    for (var i = 0; i < this.cartItems.length; i++) {
      this.totalPrice =
        this.totalPrice +
        this.cartItems[i].menuItem.price * this.cartItems[i].quantity;
      console.log(
        this.cartItems[i].menuItem.price * this.cartItems[i].quantity
      );
    }
  }
}
