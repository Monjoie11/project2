import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class PostAdditionServiceService {
  response: any;
  addPost(shiftDate, startTime, EndTime, companyName) {
    alert([companyName, shiftDate, startTime, EndTime]);
    let obs = this.http.post('addPost/', {shiftDate: shiftDate, startTime: startTime, EndTime: EndTime, companyName: companyName})
    obs.subscribe((response) => {
      this.response = response;
      return response;
    });
    return this.response;
  }
  constructor(private router: Router, private http: HttpClient)  { }
}
