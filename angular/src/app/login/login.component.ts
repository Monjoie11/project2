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
  password: string;

  constructor(private router: Router, private http: HttpClient) {

  }

  ngOnInit() {
  }

  search() {
    //let obs = this.http.get('login/' + this.email);
    let obs = this.http.post('login', {"email":this.email, "password":this.password} );
    obs.subscribe((response) => {
      this.response = response;
      let len = Object.keys(this.response).length;
      console.log("Length: ");
      console.log(len);
      if (len == 13) {
        this.router.navigateByUrl('user-homepage');
      } else if(len == 10) {
        this.router.navigateByUrl('company-homepage'); 
       } else{
         alert("Incorrect login credentials.")
       }
       return obs;
    });
  }

}
