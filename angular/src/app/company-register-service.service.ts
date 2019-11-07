import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class CompanyRegisterServiceService {
  companyName: string;
  companyEmail: string;
  companyPassword: string;
  companyWebsiteUrl: string;
  companyAccessLevel: string;
  companyCode: string;
  companyBiography: string;
  response: any;
  registerCompany(companyName, companyEmail, companyPassword, companyWebsiteUrl, companyAccessLevel, companyCode, companyBiography) {
    let obs = this.http.post('register-company', {companyName: companyName, companyEmail: companyEmail, password: companyPassword, companyLink: companyWebsiteUrl, accessLevel: companyAccessLevel, accessCode: companyCode, companyBiography: companyBiography})
    obs.subscribe((response) => {
      this.response = response;
      return response;
    });
    return this.response;
  }
  constructor(private router: Router, private http: HttpClient)  { }
}
