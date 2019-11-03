import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email: string;
  response: any;

  constructor(private router: Router, private http: HttpClient) {

  }

  ngOnInit() {
  }

  search() {
    let obs = this.http.get('login/' + this.email);
    obs.subscribe((response) => {
      this.response = response;
      console.log(this.response.length);
      if (this.response.length == 13) {
        this.router.navigateByUrl('login');
      } else if(this.response.length == 10) {
        this.router.navigateByUrl('login-company'); 
       } else{
         alert("Incorrect login credentials.")
       }
       return obs;
    });
  }

}
