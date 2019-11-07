import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router, Data } from "@angular/router";

@Component({
  selector: 'app-tabbed-table2',
  templateUrl: './tabbed-table.component.html',
  styleUrls: ['./tabbed-table.component.css']
})
export class TabbedTableComponent2 implements OnInit {
  displayedColumns: string[] = ['post-id', 'posting-user', 'accepting-user', 'shift-date', 'start-time', 'end-time'];
  displayedColumns2: string[] = ['post-id', 'posting-user', 'accepting-user', 'shift-date', 'start-time', 'end-time', 'accept-button', 'deny-button'];
  displayedColumns3: string[] = ['post-id', 'posting-user', 'accepting-user', 'shift-date', 'start-time', 'end-time'];
  displayedColumns4: string[] = ['post-id', 'posting-user', 'accepting-user', 'shift-date', 'start-time', 'end-time', 'companyRating'];
  dataSource: any[] = [];
  response: any;
  constructor(private router: Router, private http: HttpClient, private changeDetectorRefs: ChangeDetectorRef) {


   }

  ngOnInit() {
    let obs = this.http.get('/company/posts');
    obs.subscribe((response) => {
      this.response = response;
      var result = JSON.stringify(this.response);
      var result2 = JSON.parse(result);
      var rowCounter: number = 0;

      for (var key of Object.keys(result2)) {
       //let model = {postId: result2['results'][rowCounter]['name']}
       let model = {postId: result2['postId'], postingUser: result2['postingUser']['email'], acceptingUser: result2['acceptingUser']['email'], shiftDate: result2['shiftDate'], startTime: result2['startTime'], endTime: result2['endTime']};
       this.dataSource.push(model); 
       rowCounter++;
      }
      this.dataSource = [...this.dataSource];
    });
  }

  acceptPost(id){
    let obs = this.http.put('/accept-company-acceptedpost/' + id, id);
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

  denyPost(id){
    let obs = this.http.put('/reject-company-acceptedpost/' + id, id);
    obs.subscribe((response) => {
      this.response = response;
      var result = JSON.stringify(this.response);
      var result2 = JSON.parse(result);
      if(result2 == true){
        alert("Post denied")
      } else {
        alert("Error denying post")
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
