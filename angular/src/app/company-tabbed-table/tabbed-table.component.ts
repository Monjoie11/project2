import { Component, OnInit,  ChangeDetectorRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from "@angular/router";

export interface PeriodicElement {
  postId: number;
  postingUser: string;
  acceptingUser: string;
  postedTime: string;
  startTime: string;
  endTime: string;
}
const ELEMENT_DATA: PeriodicElement[] = [
  {postId: 1, postingUser: 'John', acceptingUser: 'Brian', postedTime: '8:00', startTime: '10:00', endTime: '1:00'},
  {postId: 2, postingUser: 'Hannah', acceptingUser: 'Jeff', postedTime: '9:00', startTime: '10:00', endTime: '1:00'},
  {postId: 3, postingUser: 'Java', acceptingUser: 'Shalom', postedTime: '8:30', startTime: '10:00', endTime: '1:00'},
  {postId: 4, postingUser: 'Jesus', acceptingUser: 'Jared', postedTime: '10:00', startTime: '10:00', endTime: '1:00'},
  {postId: 5, postingUser: 'Rulez!!', acceptingUser: 'Michael', postedTime: '11:00', startTime: '10:00', endTime: '1:00'},
  {postId: 6, postingUser: 'Carbon', acceptingUser: 'Andrew', postedTime: '11:30', startTime: '10:00', endTime: '1:00'},
  {postId: 7, postingUser: 'Nitrogen', acceptingUser: 'Jacoburu', postedTime: '12:00', startTime: '10:00', endTime: '1:00'},
  {postId: 8, postingUser: 'Oxygen', acceptingUser: 'Tony', postedTime: '1:00', startTime: '10:00', endTime: '1:00'},
  {postId: 9, postingUser: 'Fluorine', acceptingUser: 'Ariel', postedTime: '5:00', startTime: '10:00', endTime: '1:00'},
  {postId: 10, postingUser: 'Neon', acceptingUser: 'Harambe', postedTime: '4:30', startTime: '10:00', endTime: '1:00'},
];

@Component({
  selector: 'app-tabbed-table2',
  templateUrl: './tabbed-table.component.html',
  styleUrls: ['./tabbed-table.component.css']
})
export class TabbedTableComponent2 implements OnInit {
  displayedColumns: string[] = ['post-id', 'posting-user', 'accepting-user', 'posted-time', 'start-time', 'end-time'];
  displayedColumns2: string[] = ['post-id', 'posting-user', 'accepting-user', 'posted-time', 'start-time', 'end-time', 'companyRating'];
  dataSource = ELEMENT_DATA;
  response: any;
  constructor(private router: Router, private http: HttpClient, private changeDetectorRefs: ChangeDetectorRef) { }

  ngOnInit() {
      let obs = this.http.get('https://pokeapi.co/api/v2/pokemon/ditto/');
      obs.subscribe((response) => {
        this.response = response;
       var result = JSON.stringify(this.response);
        
        var result2 = JSON.parse(result);
        ELEMENT_DATA[0]['postId'] = result2['height'];
  
      });
      this.refresh();
    }

    refresh(){
      this.changeDetectorRefs.detectChanges();
    }
  }
