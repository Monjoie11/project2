import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router, Data } from "@angular/router";

export interface Element {
  postId: number;
  postingUser: string;
  acceptingUser: string;
  postedTime: string;
  startTime: string;
  endTime: string;
  shiftDate: string;
}

@Component({
  selector: 'app-tabbed-table',
  templateUrl: './tabbed-table.component.html',
  styleUrls: ['./tabbed-table.component.css']
})
export class TabbedTableComponent implements OnInit {
  displayedColumns: string[] = ['post-id', 'posting-user', 'accepting-user', 'shift-date', 'start-time', 'end-time'];
  displayedColumns2: string[] = ['post-id', 'posting-user', 'accepting-user', 'shift-date', 'start-time', 'end-time'];
  displayedColumns3: string[] = ['post-id', 'posting-user', 'accepting-user', 'shift-date', 'start-time', 'end-time'];
  displayedColumns4: string[] = ['post-id', 'posting-user', 'accepting-user', 'shift-date', 'start-time', 'end-time', 'userRating'];
  dataSource: any[] = [];
  response: any;
  constructor(private router: Router, private http: HttpClient, private changeDetectorRefs: ChangeDetectorRef) {


  }

  async ngOnInit() {
    let obs = this.http.get('user/created-posts').toPromise();
/*     obs.subscribe((response) => { */
  await obs.then((response) => {
      this.response = response;
      var result = JSON.stringify(this.response);
      var result2 = JSON.parse(result);
      console.log(result2);
      var rowCounter: number = 0;

      for (var key of Object.keys(result2)) {
        let model;
        if (result2[rowCounter]['acceptingUser'] == null && result2[rowCounter]['postingUser'] == null) {
          model = { postId: result2[rowCounter]['postId'], postingUser: result2[rowCounter]['postingUser'], acceptingUser: result2[rowCounter]['acceptingUser'], shiftDate: result2[rowCounter]['shiftDate'], startTime: result2[rowCounter]['startTime'], endTime: result2[rowCounter]['endTime'] }
        } else if(result2[rowCounter]['acceptingUser'] != null && result2[rowCounter]['postingUser'] == null) {
          model = { postId: result2[rowCounter]['postId'], postingUser: result2[rowCounter]['postingUser'], acceptingUser: result2[rowCounter]['acceptingUser']['email'], shiftDate: result2[rowCounter]['shiftDate'], startTime: result2[rowCounter]['startTime'], endTime: result2[rowCounter]['endTime'] }
        } else if(result2[rowCounter]['acceptingUser'] == null && result2[rowCounter]['postingUser'] != null) {
          model = { postId: result2[rowCounter]['postId'], postingUser: result2[rowCounter]['postingUser']['email'], acceptingUser: result2[rowCounter]['acceptingUser'], shiftDate: result2[rowCounter]['shiftDate'], startTime: result2[rowCounter]['startTime'], endTime: result2[rowCounter]['endTime'] }
        } else {
          model = { postId: result2[rowCounter]['postId'], postingUser: result2[rowCounter]['postingUser']['email'], acceptingUser: result2[rowCounter]['acceptingUser']['email'], shiftDate: result2[rowCounter]['shiftDate'], startTime: result2[rowCounter]['startTime'], endTime: result2[rowCounter]['endTime'] }
        }
        this.dataSource.push(model);
        rowCounter++;
      }

      this.dataSource = [...this.dataSource];
    });
  }

  async yourFn($event) {
    this.dataSource = [];
    if ($event.index === 0) {
      let obs = this.http.get('user/created-posts').toPromise();
      await obs.then((response) => {
        this.response = response;
        var result = JSON.stringify(this.response);
        var result2 = JSON.parse(result);
        console.log(result2);
        var rowCounter: number = 0;

        for (var key of Object.keys(result2)) {
          let model;
          if (result2[rowCounter]['acceptingUser'] == null && result2[rowCounter]['postingUser'] == null) {
            model = { postId: result2[rowCounter]['postId'], postingUser: result2[rowCounter]['postingUser'], acceptingUser: result2[rowCounter]['acceptingUser'], shiftDate: result2[rowCounter]['shiftDate'], startTime: result2[rowCounter]['startTime'], endTime: result2[rowCounter]['endTime'] }
          } else if(result2[rowCounter]['acceptingUser'] != null && result2[rowCounter]['postingUser'] == null) {
            model = { postId: result2[rowCounter]['postId'], postingUser: result2[rowCounter]['postingUser'], acceptingUser: result2[rowCounter]['acceptingUser']['email'], shiftDate: result2[rowCounter]['shiftDate'], startTime: result2[rowCounter]['startTime'], endTime: result2[rowCounter]['endTime'] }
          } else if(result2[rowCounter]['acceptingUser'] == null && result2[rowCounter]['postingUser'] != null) {
            model = { postId: result2[rowCounter]['postId'], postingUser: result2[rowCounter]['postingUser']['email'], acceptingUser: result2[rowCounter]['acceptingUser'], shiftDate: result2[rowCounter]['shiftDate'], startTime: result2[rowCounter]['startTime'], endTime: result2[rowCounter]['endTime'] }
          } else {
            model = { postId: result2[rowCounter]['postId'], postingUser: result2[rowCounter]['postingUser']['email'], acceptingUser: result2[rowCounter]['acceptingUser']['email'], shiftDate: result2[rowCounter]['shiftDate'], startTime: result2[rowCounter]['startTime'], endTime: result2[rowCounter]['endTime'] }
          }
          this.dataSource.push(model);
          rowCounter++;
        }

        this.dataSource = [...this.dataSource];
      });
    }
    if ($event.index === 1) {
      let obs = this.http.get('user/accepted-posts').toPromise();
      await obs.then((response) => {
        this.response = response;
        var result = JSON.stringify(this.response);
        var result2 = JSON.parse(result);
        console.log(result2);
        var rowCounter: number = 0;

        for (var key of Object.keys(result2)) {
          if (result2[rowCounter]['status'] == 'REPLIEDTO') {
            let model;
            if (result2[rowCounter]['acceptingUser'] == null && result2[rowCounter]['postingUser'] == null) {
              model = { postId: result2[rowCounter]['postId'], postingUser: result2[rowCounter]['postingUser'], acceptingUser: result2[rowCounter]['acceptingUser'], shiftDate: result2[rowCounter]['shiftDate'], startTime: result2[rowCounter]['startTime'], endTime: result2[rowCounter]['endTime'] }
            } else if(result2[rowCounter]['acceptingUser'] != null && result2[rowCounter]['postingUser'] == null) {
              model = { postId: result2[rowCounter]['postId'], postingUser: result2[rowCounter]['postingUser'], acceptingUser: result2[rowCounter]['acceptingUser']['email'], shiftDate: result2[rowCounter]['shiftDate'], startTime: result2[rowCounter]['startTime'], endTime: result2[rowCounter]['endTime'] }
            } else if(result2[rowCounter]['acceptingUser'] == null && result2[rowCounter]['postingUser'] != null) {
              model = { postId: result2[rowCounter]['postId'], postingUser: result2[rowCounter]['postingUser']['email'], acceptingUser: result2[rowCounter]['acceptingUser'], shiftDate: result2[rowCounter]['shiftDate'], startTime: result2[rowCounter]['startTime'], endTime: result2[rowCounter]['endTime'] }
            } else {
              model = { postId: result2[rowCounter]['postId'], postingUser: result2[rowCounter]['postingUser']['email'], acceptingUser: result2[rowCounter]['acceptingUser']['email'], shiftDate: result2[rowCounter]['shiftDate'], startTime: result2[rowCounter]['startTime'], endTime: result2[rowCounter]['endTime'] }
            }
            this.dataSource.push(model);
          }
          rowCounter++;
        }
        this.dataSource = [...this.dataSource];
      });
    }
    if ($event.index === 2) {
      let obs = this.http.get('user/accepted-posts').toPromise();
      await obs.then((response) => {
        this.response = response;
        var result = JSON.stringify(this.response);
        var result2 = JSON.parse(result);
        console.log(result2);
        var rowCounter: number = 0;

        for (var key of Object.keys(result2)) {
          if (result2[rowCounter]['status'] == 'ACCEPTED') {
            let model;
            if (result2[rowCounter]['acceptingUser'] == null && result2[rowCounter]['postingUser'] == null) {
              model = { postId: result2[rowCounter]['postId'], postingUser: result2[rowCounter]['postingUser'], acceptingUser: result2[rowCounter]['acceptingUser'], shiftDate: result2[rowCounter]['shiftDate'], startTime: result2[rowCounter]['startTime'], endTime: result2[rowCounter]['endTime'] }
            } else if(result2[rowCounter]['acceptingUser'] != null && result2[rowCounter]['postingUser'] == null) {
              model = { postId: result2[rowCounter]['postId'], postingUser: result2[rowCounter]['postingUser'], acceptingUser: result2[rowCounter]['acceptingUser']['email'], shiftDate: result2[rowCounter]['shiftDate'], startTime: result2[rowCounter]['startTime'], endTime: result2[rowCounter]['endTime'] }
            } else if(result2[rowCounter]['acceptingUser'] == null && result2[rowCounter]['postingUser'] != null) {
              model = { postId: result2[rowCounter]['postId'], postingUser: result2[rowCounter]['postingUser']['email'], acceptingUser: result2[rowCounter]['acceptingUser'], shiftDate: result2[rowCounter]['shiftDate'], startTime: result2[rowCounter]['startTime'], endTime: result2[rowCounter]['endTime'] }
            } else {
              model = { postId: result2[rowCounter]['postId'], postingUser: result2[rowCounter]['postingUser']['email'], acceptingUser: result2[rowCounter]['acceptingUser']['email'], shiftDate: result2[rowCounter]['shiftDate'], startTime: result2[rowCounter]['startTime'], endTime: result2[rowCounter]['endTime'] }
            }
            this.dataSource.push(model);
          }
          rowCounter++;
        }
        this.dataSource = [...this.dataSource];
      });
    }
    if ($event.index === 3) {
      let obs = this.http.get('user/accepted-posts').toPromise();
      await obs.then((response) => {
        this.response = response;
        var result = JSON.stringify(this.response);
        var result2 = JSON.parse(result);
        console.log(result2);
        var rowCounter: number = 0;

        for (var key of Object.keys(result2)) {
          if (result2[rowCounter]['status'] == 'COMPLETED') {
            let model;
            if (result2[rowCounter]['acceptingUser'] == null && result2[rowCounter]['postingUser'] == null) {
              model = { postId: result2[rowCounter]['postId'], postingUser: result2[rowCounter]['postingUser'], acceptingUser: result2[rowCounter]['acceptingUser'], shiftDate: result2[rowCounter]['shiftDate'], startTime: result2[rowCounter]['startTime'], endTime: result2[rowCounter]['endTime'] }
            } else if(result2[rowCounter]['acceptingUser'] != null && result2[rowCounter]['postingUser'] == null) {
              model = { postId: result2[rowCounter]['postId'], postingUser: result2[rowCounter]['postingUser'], acceptingUser: result2[rowCounter]['acceptingUser']['email'], shiftDate: result2[rowCounter]['shiftDate'], startTime: result2[rowCounter]['startTime'], endTime: result2[rowCounter]['endTime'] }
            } else if(result2[rowCounter]['acceptingUser'] == null && result2[rowCounter]['postingUser'] != null) {
              model = { postId: result2[rowCounter]['postId'], postingUser: result2[rowCounter]['postingUser']['email'], acceptingUser: result2[rowCounter]['acceptingUser'], shiftDate: result2[rowCounter]['shiftDate'], startTime: result2[rowCounter]['startTime'], endTime: result2[rowCounter]['endTime'] }
            } else {
              model = { postId: result2[rowCounter]['postId'], postingUser: result2[rowCounter]['postingUser']['email'], acceptingUser: result2[rowCounter]['acceptingUser']['email'], shiftDate: result2[rowCounter]['shiftDate'], startTime: result2[rowCounter]['startTime'], endTime: result2[rowCounter]['endTime'] }
            }
            this.dataSource.push(model);
          }
          rowCounter++;
        }
        this.dataSource = [...this.dataSource];
      });
    }
  }
}

