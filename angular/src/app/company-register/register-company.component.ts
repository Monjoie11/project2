import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from "@angular/router";

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
  response: any;

  public containers = [0];
  public counter : number = 1;
  constructor(private router: Router, private http: HttpClient)  { }

  ngOnInit() {
  }

  search() {
    let obs = this.http.post('register/', { companyName: this.companyName, email: this.companyEmail, password: this.companyPassword, telephone: this.companyWebsiteUrl, accessLevel: this.companyAccessLevel, userCode: this.companyCode, biography: this.companyBiography })
    obs.subscribe((response) => {
      this.response = response;
      if (this.response == true) {
        alert("registration successful");
        this.router.navigateByUrl('login');
      } else {
        alert("registration failed");
        this.router.navigateByUrl('login');
      }
    });
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
