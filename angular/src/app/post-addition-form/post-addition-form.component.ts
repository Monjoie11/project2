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
  content: string;
  result: any;
  svc: PostAdditionServiceService;

  constructor(svc: PostAdditionServiceService, private http: HttpClient, private router: Router) { 
    this.svc = svc;
  }

  ngOnInit() {
  }

  async postEvent(){
    let obs = this.http.post('post/create', {shiftDate: this.shiftDate, startTime: this.startTime, endTime: this.endTime, companyName: this.companyName, content: this.content}).toPromise()
    await obs.then((response) => {
      this.result = response;
    });
    if(this.result == true){
      alert("Post was Added")
    } else {
      alert("Post failed")
    }
    this.router.navigateByUrl('marketboard');

  }

}
