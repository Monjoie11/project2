import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {
  userFirstName: string;
  userLastName: string;
  userEmail: string;
  userPassword: string;
  userTelephone: string;
  userAccessLevel: string;
  userCode: string;
  userBiography: string;
  response: any;

  public containers = [0];
  public counter: number = 1;
  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit() {
  }

  search() {
    let obs = this.http.post('register/', { firstName: this.userFirstName, lastName: this.userLastName, email: this.userEmail, password: this.userPassword, telephone: this.userTelephone, accessLevel: this.userAccessLevel, userCode: this.userCode, biography: this.userBiography })
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
    if (this.containers.length < 5) {
      this.containers.push(this.counter);
      this.counter++;
    }
  }


  remove() {
    let element = document.getElementsByClassName('company-code');
    if (this.containers.length > 1) {
      element[this.containers.length - 1].parentNode.removeChild(element[this.containers.length - 1]);
      const index = this.containers.indexOf(this.containers.length - 1, 0);
      if (index > -1) {
        this.containers.splice(index, 1);
        this.counter--;
      }
    }
  }
}
