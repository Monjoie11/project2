import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class UserRegisterServiceService {
  userFirstName: string;
  userLastName: string;
  userEmail: string;
  userPassword: string;
  userTelephone: string;
  userAccessLevel: string;
  userCode: string;
  userBiography: string;
  response: any;
  registerUser(userFirstName, userLastName, userEmail, userPassword, userTelephone, userAccessLevel, userCode, userBiography) {
    let obs = this.http.post('register/', {userFirstName: userFirstName, userLastName: userLastName, userEmail: userEmail, userPassword: userPassword, userTelephone: userTelephone, userAccessLevel: userAccessLevel, userCode: userCode, userBiography: userBiography})
    obs.subscribe((response) => {
      this.response = response;
      return response;
    });
    return this.response;
  }
  constructor(private router: Router, private http: HttpClient)  { }
}
