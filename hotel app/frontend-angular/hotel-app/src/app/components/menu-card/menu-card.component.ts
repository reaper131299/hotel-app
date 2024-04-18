import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'src/app/entities/menu-item';
import { MenuService } from 'src/app/services/menu.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-menu-card',
  templateUrl: './menu-card.component.html',
  styleUrls: ['./menu-card.component.css'],
})
export class MenuCardComponent implements OnInit {
  menuItems: MenuItem[] = [];

  private addItemUrl1: string = 'http://localhost:8080/tasty/myCart?menuId=';

  private addItemUrl2: string = '&quantity=1';

  private addItemActualurl: string = '';

  private postId: any;

  constructor(
    private menuService: MenuService,
    private httpClient: HttpClient
  ) {}

  ngOnInit(): void {
    this.getMenuItems();
  }

  getMenuItems() {
    this.menuService.getMenuList().subscribe((data) => {
      this.menuItems = data;
    });
  }

  getMenuByCaterogy(catagory: string) {
    this.menuService.getMenuByCatagory(catagory).subscribe((data) => {
      this.menuItems = data;
    });
  }

  addItemToCart(menuId: number) {
    this.addItemActualurl = this.addItemUrl1 + menuId + this.addItemUrl2;
    this.httpClient.post<any>(this.addItemActualurl, {}).subscribe((data) => {
      this.postId = data;
    });
  }
}
