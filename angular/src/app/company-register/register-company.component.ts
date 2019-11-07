import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from "@angular/router";
import { CompanyRegisterServiceService } from '../company-register-service.service'

@Component({
  selector: 'app-register-company',
  templateUrl: './register-company.component.html',
  styleUrls: ['./register-company.component.css']
})
export class RegisterCompanyComponent implements OnInit {
  companyName: string;
  companyEmail: string;
  companyPassword: string;
  companyWebsiteUrl: string;
  companyAccessLevel: string;
  companyCode: string;
  companyBiography: string;
  result: any;

  public containers = [0];
  public counter : number = 1;
  svc: CompanyRegisterServiceService;
  constructor(svc: CompanyRegisterServiceService, private router: Router, private http: HttpClient)  { 
    this.svc = svc;
  }

  ngOnInit() {
  }

  register() {
    this.result = this.svc.registerCompany(this.companyName, this.companyEmail, this.companyPassword, this.companyWebsiteUrl, this.companyAccessLevel, this.companyCode, this.companyBiography);
    if (this.result == true) {
      alert("registration successful");
      this.router.navigateByUrl('login');
      return true;
    } else {
      alert("registration failed");
      this.router.navigateByUrl('login');
      return false;
    }
  }

  add() {
    if(this.containers.length < 5){
      this.containers.push(this.counter);
      this.counter ++;
    }
  }
  

  remove() {
    let element = document.getElementsByClassName('company-code');
    if(this.containers.length > 1){
      element[this.containers.length - 1].parentNode.removeChild(element[this.containers.length - 1]);
      const index = this.containers.indexOf(this.containers.length - 1, 0);
      if (index > -1) {
        this.containers.splice(index, 1);
        this.counter--;
      }
    }
  }


}
