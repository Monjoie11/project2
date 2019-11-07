import { Component, OnInit } from '@angular/core';
import {MatDatepickerInputEvent} from '@angular/material/datepicker';
import { PostAdditionServiceService } from '../post-addition-service.service'

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

  constructor(svc: PostAdditionServiceService) { 
    this.svc = svc;
  }

  ngOnInit() {
  }

  postEvent(){
    this.result = this.svc.addPost(this.shiftDate, this.startTime, this.endTime, this.companyName);
    if(this.result == true){
      alert("Post was Added")
    } else {
      alert("Post failed")
    }

  }

}
