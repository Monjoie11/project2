import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-job-dropdown',
  templateUrl: './job-dropdown.component.html',
  styleUrls: ['./job-dropdown.component.css']
})
export class JobDropdownComponent implements OnInit {
  selected = 'FRONTHOUSE';

  constructor() { }

  ngOnInit() {
  }

}

/* 
import {Component} from '@angular/core';


@Component({
  selector: 'select-value-binding-example',
  templateUrl: 'select-value-binding-example.html',
  styleUrls: ['select-value-binding-example.css'],
})
export class SelectValueBindingExample {
  selected = 'option2';
}*/