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
}

//var ELEMENT_DATA: Element[] = [
    //{postId: 1, postingUser: 'John', acceptingUser: 'Brian', postedTime: '8:00', startTime: '10:00', endTime: '1:00'},
//];

@Component({
  selector: 'app-tabbed-table2',
  templateUrl: './tabbed-table.component.html',
  styleUrls: ['./tabbed-table.component.css']
})
export class TabbedTableComponent2 implements OnInit {
  displayedColumns: string[] = ['post-id', 'posting-user', 'accepting-user', 'posted-time', 'start-time', 'end-time'];
  displayedColumns2: string[] = ['post-id', 'posting-user', 'accepting-user', 'posted-time', 'start-time', 'end-time'];
  displayedColumns3: string[] = ['post-id', 'posting-user', 'accepting-user', 'posted-time', 'start-time', 'end-time'];
  displayedColumns4: string[] = ['post-id', 'posting-user', 'accepting-user', 'posted-time', 'start-time', 'end-time', 'companyRating'];
  //dataSource = ELEMENT_DATA;
  dataSource: any[] = [];
  response: any;
  constructor(private router: Router, private http: HttpClient, private changeDetectorRefs: ChangeDetectorRef) {
   // this.dataSource = new MatTableDataSource<Element>(ELEMENT_DATA);


   }

  ngOnInit() {
    let obs = this.http.get('https://unpkg.com/pokemons@1.1.0/pokemons.json');
    obs.subscribe((response) => {
      this.response = response;
      var result = JSON.stringify(this.response);
      var result2 = JSON.parse(result);
      var rowCounter: number = 0;

      for (var key of Object.keys(result2['results'])) {
       let model = {postId: result2['results'][rowCounter]['name']}
       this.dataSource.push(model); 
       rowCounter++;
       if(rowCounter == 20){ //comment this out later
         break;
       }
      }
      this.dataSource = [...this.dataSource];
    });
    //this.refresh();
  }

/*   refresh() {
    this.changeDetectorRefs.detectChanges();
  } */

  yourFn($event){
    this.dataSource = [];
    if($event.index === 0){
      let obs = this.http.get('https://unpkg.com/pokemons@1.1.0/pokemons.json');
      obs.subscribe((response) => {
        this.response = response;
        var result = JSON.stringify(this.response);
        var result2 = JSON.parse(result);
        var rowCounter: number = 0;
  
        for (var key of Object.keys(result2['results'])) {
          let model = {postId: result2['results'][rowCounter]['name']}
          this.dataSource.push(model); 
         rowCounter++;
         if(rowCounter == 20){ //comment this out later
           break;
         }
        }
        this.dataSource = [...this.dataSource];
      });
    } 
    if($event.index === 1){
      let obs = this.http.get('https://unpkg.com/pokemons@1.1.0/pokemons.json');
      obs.subscribe((response) => {
        this.response = response;
        var result = JSON.stringify(this.response);
        var result2 = JSON.parse(result);
        var rowCounter: number = 0;
  
        for (var key of Object.keys(result2['results'])) {
         if(result2['results'][rowCounter]['name'].startsWith("B")){
          let model = {postId: result2['results'][rowCounter]['name']}
          this.dataSource.push(model); 
         }
         rowCounter++;
         if(rowCounter == 20){ //comment this out later
           break;
         }
        }
        this.dataSource = [...this.dataSource];
      });
    } 
    if($event.index === 2){
      let obs = this.http.get('https://unpkg.com/pokemons@1.1.0/pokemons.json');
      obs.subscribe((response) => {
        this.response = response;
        var result = JSON.stringify(this.response);
        var result2 = JSON.parse(result);
        var rowCounter: number = 0;
  
        for (var key of Object.keys(result2['results'])) {
         if(result2['results'][rowCounter]['name'].startsWith("C")){
          let model = {postId: result2['results'][rowCounter]['name']}
          this.dataSource.push(model); 
         }
         rowCounter++;
         if(rowCounter == 20){ //comment this out later
           break;
         }
        }
        this.dataSource = [...this.dataSource];
      });
    } 
    if($event.index === 3){
      let obs = this.http.get('https://unpkg.com/pokemons@1.1.0/pokemons.json');
      obs.subscribe((response) => {
        this.response = response;
        var result = JSON.stringify(this.response);
        var result2 = JSON.parse(result);
        var rowCounter: number = 0;
  
        for (var key of Object.keys(result2['results'])) {
         if(result2['results'][rowCounter]['name'].startsWith("V")){
          let model = {postId: result2['results'][rowCounter]['name']}
          this.dataSource.push(model); 
         }
         rowCounter++;
         if(rowCounter == 20){ //comment this out later
           break;
         }
        }
        this.dataSource = [...this.dataSource];
      });
    } 
}
}
