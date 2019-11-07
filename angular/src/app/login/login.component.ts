import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from "@angular/router";
import { LoginServiceService } from '../login-service.service'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email: string;
  password: string;
  result: any;
  response: any;
  length: any;
  svc: LoginServiceService;
  constructor(svc: LoginServiceService, private router: Router, private http: HttpClient) {
    this.svc = svc;
  }

  ngOnInit() {
  }
  async search() {
    let obs = this.http.post('login', {email: this.email, password: this.password}).toPromise();
    await obs.then((response) => {
      this.response = response;
    });
    length = Object.keys(this.response).length;
    if (length == 10) {
      this.router.navigateByUrl('user-homepage');
      return true;
    } else if (length == 7) {
      this.router.navigateByUrl('company-homepage');
      return true;
    } else {
      alert("Incorrect login credentials.")
      return false;
    }
  }


}
