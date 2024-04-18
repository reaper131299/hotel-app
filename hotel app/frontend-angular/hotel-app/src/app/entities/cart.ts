import { Customer } from './customer';
import { MenuItem } from './menu-item';

export class Cart {
  cartEntryId: number = 0;

  quantity: number = 0;

  customer: Customer = new Customer();

  menuItem: MenuItem = new MenuItem();
}
