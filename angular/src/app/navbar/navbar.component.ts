import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router} from "@angular/router";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  response: any;

  async goHome($event){
    let obs = this.http.get('userType').toPromise();
    await obs.then((response) => {
      this.response = response;
    });
    console.log(this.response);
    if(this.response == true){
      this.router.navigateByUrl('user-homepage');
    } else {
      this.router.navigateByUrl('company-homepage');

    }
  }

  async logout($event){
    let obs = this.http.get('logout').toPromise();
    await obs.then((response) => {
      this.response = response;
    });
    console.log(this.response);
    this.router.navigateByUrl('login');
  }

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit() {
  }

}
