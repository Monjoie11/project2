import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router, Data } from "@angular/router";
import { MatTableDataSource } from '@angular/material';

export interface Element {
  postId: number;
  postingUser: string;
  acceptingUser: string;
  postedTime: string;
  startTime: string;
  endTime: string;
  shiftDate: string;
}

@Component({
  selector: 'app-tabbed-table',
  templateUrl: './tabbed-table.component.html',
  styleUrls: ['./tabbed-table.component.css']
})
export class TabbedTableComponent implements OnInit {
  displayedColumns: string[] = ['post-id', 'posting-user', 'accepting-user', 'shift-date', 'start-time', 'end-time'];
  displayedColumns2: string[] = ['post-id', 'posting-user', 'accepting-user', 'shift-date', 'start-time', 'end-time'];
  displayedColumns3: string[] = ['post-id', 'posting-user', 'accepting-user', 'shift-date', 'start-time', 'end-time'];
  displayedColumns4: string[] = ['post-id', 'posting-user', 'accepting-user', 'shift-date', 'start-time', 'end-time', 'userRating'];
  dataSource: any[] = [];
  response: any;
  constructor(private router: Router, private http: HttpClient, private changeDetectorRefs: ChangeDetectorRef) {


   }

  ngOnInit() {
    let obs = this.http.get('/user/created-posts');
    obs.subscribe((response) => {
      this.response = response;
      var result = JSON.stringify(this.response);
      var result2 = JSON.parse(result);
      var rowCounter: number = 0;

      for (var key of Object.keys(result2)) {
       let model = {postId: result2['postId'], postingUser: result2['postingUser']['email'], acceptingUser: result2['acceptingUser'], shiftDate: result2['shiftDate'], startTime: result2['startTime'], endTime: result2['endTime']}
       this.dataSource.push(model); 
       rowCounter++;
      }

      this.dataSource = [...this.dataSource];
    });
  }

  yourFn($event){
    //this.dataSource = [];
    if($event.index === 0){
      let obs = this.http.get('/user/created-posts');
      obs.subscribe((response) => {
        this.response = response;
        var result = JSON.stringify(this.response);
        var result2 = JSON.parse(result);
        var rowCounter: number = 0;
  
        for (var key of Object.keys(result2)) {
         let model = {postId: result2['postId'], postingUser: result2['postingUser']['email'], acceptingUser: result2['acceptingUser'], shiftDate: result2['shiftDate'], startTime: result2['startTime'], endTime: result2['endTime']}
         this.dataSource.push(model); 
         rowCounter++;
        }
  
        this.dataSource = [...this.dataSource];
      });
    } 
    if($event.index === 1){
      let obs = this.http.get('/user/accepted-posts');
      obs.subscribe((response) => {
        this.response = response;
        var result = JSON.stringify(this.response);
        var result2 = JSON.parse(result);
        var rowCounter: number = 0;
  
        for (var key of Object.keys(result2)) {
          if(result2['status'] === 'REPLIEDTO'){
            let model = {postId: result2['postId'], postingUser: result2['postingUser']['email'], acceptingUser: result2['acceptingUser'], shiftDate: result2['shiftDate'], startTime: result2['startTime'], endTime: result2['endTime']}
            this.dataSource.push(model); 
          }
         rowCounter++;
        }
        this.dataSource = [...this.dataSource];
      });
    } 
    if($event.index === 2){
      let obs = this.http.get('/user/accepted-posts');
      obs.subscribe((response) => {
        this.response = response;
        var result = JSON.stringify(this.response);
        var result2 = JSON.parse(result);
        var rowCounter: number = 0;
  
        for (var key of Object.keys(result2)) {
          if(result2['status'] === 'ACCEPTED'){
            let model = {postId: result2['postId'], postingUser: result2['postingUser']['email'], acceptingUser: result2['acceptingUser'], shiftDate: result2['shiftDate'], startTime: result2['startTime'], endTime: result2['endTime']}
            this.dataSource.push(model); 
          }
         rowCounter++;
        }
        this.dataSource = [...this.dataSource];
      });
    } 
    if($event.index === 3){
      let obs = this.http.get('/user/accepted-posts');
      obs.subscribe((response) => {
        this.response = response;
        var result = JSON.stringify(this.response);
        var result2 = JSON.parse(result);
        var rowCounter: number = 0;
  
        for (var key of Object.keys(result2)) {
          if(result2['status'] === 'COMPLETED'){
            let model = {postId: result2['postId'], postingUser: result2['postingUser']['email'], acceptingUser: result2['acceptingUser'], shiftDate: result2['shiftDate'], startTime: result2['startTime'], endTime: result2['endTime']}
            this.dataSource.push(model); 
          }
         rowCounter++;
        }
        this.dataSource = [...this.dataSource];
      });
    } 
}
}

/* import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from "@angular/router";


@Component({
  selector: 'app-tabbed-table',
  templateUrl: './tabbed-table.component.html',
  styleUrls: ['./tabbed-table.component.css']
})
export class TabbedTableComponent implements OnInit {
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
} */
