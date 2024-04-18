import { Address } from './address';
import { Cart } from './cart';

export class Customer {
  userId: number = 0;
  contactNumber: string = '';
  customerName: string = '';
  emailId: string = '';
  password: string = '';
  addresses: Address = new Address();
  carts: Cart = new Cart();
}
