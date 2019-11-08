import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {
  constructor(private router: Router, private http: HttpClient) { }
/*   email: string;
  password:string; */
  response: any;
  async loginRequest(login) {
    let obs = this.http.post('login', { email: login.email, password: login.password}).toPromise();
    await obs.then((response) => {
      this.response = response;
      return this.response;
    });
    console.log(this.response);
    return this.response;
  }
/*   async loginRequest(email, password) {
    let obs = this.http.post('login', { email: email, password: password}).toPromise();
    await obs.then((response) => {
      this.response = response;
      return this.response;
    });
    console.log(this.response);
  } */


}
