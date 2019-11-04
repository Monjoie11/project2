import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-homepage',
  templateUrl: './user-homepage.component.html',
  styleUrls: ['./user-homepage.component.css']
})
export class UserHomepageComponent implements OnInit {

  changes(event){
    alert("hello");
    document.getElementById("bioLabel").innerHTML = "Company Biography"
  }

  constructor() { }

  ngOnInit() {
  }

}


