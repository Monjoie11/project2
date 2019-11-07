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
  response: any;
  result: any;
  svc: LoginServiceService;
  constructor(svc: LoginServiceService, private router: Router, private http: HttpClient) {
    this.svc = svc;
  }

  ngOnInit() {
  }
  search() {
    this.result = this.svc.loginRequest(this.email, this.password);
    if (this.response.length == 13) {
      this.router.navigateByUrl('user-homepage');
      return true;
    } else if (this.response.length == 10) {
      this.router.navigateByUrl('company-homepage');
      return true;
    } else {
      alert("Incorrect login credentials.")
      return false;
    }
  }


}
