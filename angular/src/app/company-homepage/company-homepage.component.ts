import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-company-homepage',
  templateUrl: './company-homepage.component.html',
  styleUrls: ['./company-homepage.component.css']
})
/* export class TableBasicExample {
  displayedColumns: string[] = ['position', 'name', 'weight', 'symbol'];
  dataSource = ELEMENT_DATA;
} */

export class CompanyHomepageComponent implements OnInit {
  constructor(){}
  ngOnInit() {
  }

}

window.onload = function() {
  alert("hi");
  document.getElementById("bioLabel").innerHTML = "Company Bio";
};

