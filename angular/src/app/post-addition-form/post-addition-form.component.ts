import { Component, OnInit } from '@angular/core';
import {MatDatepickerInputEvent} from '@angular/material/datepicker';
import { PostAdditionServiceService } from '../post-addition-service.service'
import { HttpClient } from '@angular/common/http';
import { Router } from "@angular/router";

@Component({
  selector: 'app-post-addition-form',
  templateUrl: './post-addition-form.component.html',
  styleUrls: ['./post-addition-form.component.css']
})
export class PostAdditionFormComponent implements OnInit {
  companyName: string;
  shiftDate: any;
  startTime: string;
  endTime: string;
  result: any;
  svc: PostAdditionServiceService;

  constructor(svc: PostAdditionServiceService, private router: Router, private http: HttpClient) { 
    this.svc = svc;
  }

  ngOnInit() {
  }

  async postEvent(){
    //this.result = this.svc.addPost(this.shiftDate, this.startTime, this.endTime, this.companyName);
    let obs = this.http.post('addPost/', {shiftDate: this.shiftDate, startTime: this.startTime, EndTime: this.endTime, companyName: this.companyName}).toPromise()
    await obs.then((response) => {
      this.result = response;
    });
    if(this.result == true){
      alert("Post was Added")
    } else {
      alert("Post failed")
    }

  }

}
