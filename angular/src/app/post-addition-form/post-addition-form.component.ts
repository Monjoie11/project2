import { Component, OnInit } from '@angular/core';
import {MatDatepickerInputEvent} from '@angular/material/datepicker';

@Component({
  selector: 'app-post-addition-form',
  templateUrl: './post-addition-form.component.html',
  styleUrls: ['./post-addition-form.component.css']
})
export class PostAdditionFormComponent implements OnInit {
  events: string[] = [];

  addEvent(type: string, event: MatDatepickerInputEvent<Date>) {
    this.events.push(`${type}: ${event.value}`);
  }
  constructor() { }

  ngOnInit() {
  }

}
