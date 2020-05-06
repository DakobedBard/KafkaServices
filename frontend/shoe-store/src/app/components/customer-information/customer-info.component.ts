import { Component, OnInit } from '@angular/core';
import { Customer } from '../../models/customer';

@Component({
  selector: 'app-customer-info',
  templateUrl: './customer-info.component.html',
  styleUrls: ['./customer-info.component.scss']
})
export class CustomerInfoComponent implements OnInit {
  customerInfor: Customer = new Customer()
  // customerInfor: Customer = new Customer("a", "Charles","Goodwin", "Charles Goodwin", "809", "dfd", "Seattle",
  // "US", 1, "NW", "98115", 220451231,1232132131, "mddarr@gmail.com", "dfdf");
  constructor() { }

  ngOnInit() {
    // this.customerInfor = JSON.parse(localStorage.getItem('user'));
  }

}
