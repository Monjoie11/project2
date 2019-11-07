import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router, Data } from "@angular/router";

@Component({
  selector: 'app-mb-tabbed-table',
  templateUrl: './mb-tabbed-table.component.html',
  styleUrls: ['./mb-tabbed-table.component.css']
})
export class MbTabbedTableComponent implements OnInit {
  displayedColumns: string[] = ['post-id', 'posting-user', 'accepting-user', 'posted-time', 'start-time', 'end-time'];
  displayedColumns2: string[] = ['post-id', 'posting-user', 'accepting-user', 'posted-time', 'start-time', 'end-time', 'accept-button'];
  displayedColumns3: string[] = ['post-id', 'posting-user', 'accepting-user', 'posted-time', 'start-time', 'end-time'];
  displayedColumns4: string[] = ['post-id', 'posting-user', 'accepting-user', 'posted-time', 'start-time', 'end-time', 'companyRating'];
  dataSource: any[] = [];
  response: any;
  constructor(private router: Router, private http: HttpClient, private changeDetectorRefs: ChangeDetectorRef) {


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
  }

  acceptPost(id){
    let obs = this.http.put('/add-user-acceptedpost/' + id, id);
    obs.subscribe((response) => {
      this.response = response;
      var result = JSON.stringify(this.response);
      var result2 = JSON.parse(result);
      if(result2 == true){
        alert("Post accepted")
      } else {
        alert("Error accepting post")
      }
      this.dataSource = [...this.dataSource];
    });
  }

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

/* import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-mb-tabbed-table',
  templateUrl: './mb-tabbed-table.component.html',
  styleUrls: ['./mb-tabbed-table.component.css']
})
export class MbTabbedTableComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

} */
