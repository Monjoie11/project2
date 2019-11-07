import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {
  email: string;
  password:string;
  response: any;
  loginRequest(email, password) {
    let obs = this.http.post('login', { email: email, password: password})
    obs.subscribe((response) => {
      this.response = response;
       return this.response;
    });
    return this.response;
  }
  constructor(private router: Router, private http: HttpClient) { }
}
