import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from "@angular/router";


@Component({
  selector: 'app-tabbed-table',
  templateUrl: './tabbed-table.component.html',
  styleUrls: ['./tabbed-table.component.css']
})
export class TabbedTableComponent implements OnInit {
 // displayedColumns: string[] = ['post-id', 'posting-user', 'accepting-user', 'posted-time', 'start-time', 'end-time'];
 displayedColumns: string[] = ['height'];
  displayedColumns2: string[] = ['post-id', 'posting-user', 'accepting-user', 'posted-time', 'start-time', 'end-time', 'companyRating'];
  postData: string[];
  dataSource = this.postData;
  email: string;
  password:string;
  response: any;
  constructor(private router: Router, private http: HttpClient) { }
  ngOnInit() {
    let obs = this.http.get('https://pokeapi.co/api/v2/pokemon/ditto/');
    obs.subscribe((response) => {
      this.response = response;
     var result = JSON.stringify(this.response);
      
      var result2 = JSON.parse(result);
      this.postData[0] = (result2['height']);

    });
  }

  search() {
    alert("search called");
}
}
