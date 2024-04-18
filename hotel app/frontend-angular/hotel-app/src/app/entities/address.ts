import { Customer } from './customer';

export class Address {
  addressId: number = 0;
  addressLine1: string = '';
  addressLine2: string = '';
  cityName: string = '';
  districtName: string = '';
  stateName: string = '';
  townName: string = '';
  zipCode: string = '';
  customer: Customer = new Customer();
}
