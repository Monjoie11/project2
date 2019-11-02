import { Component, OnInit } from '@angular/core';

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
  selector: 'app-tabbed-table',
  templateUrl: './tabbed-table.component.html',
  styleUrls: ['./tabbed-table.component.css']
})
export class TabbedTableComponent implements OnInit {
  displayedColumns: string[] = ['post-id', 'posting-user', 'accepting-user', 'posted-time', 'start-time', 'end-time'];
  dataSource = ELEMENT_DATA;
  constructor() { }

  ngOnInit() {
  }

}
