import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-star-rating',
  templateUrl: './star-rating.component.html',
  styleUrls: ['./star-rating.component.css']
})
export class StarRatingComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  onRate($event:{oldValue:number, newValue:number, starRating:StarRatingComponent}) {

/*     alert(`Old Value:${$event.oldValue}, 
      New Value: ${$event.newValue}, 
      Checked Color: ${$event.starRating}, 
      Unchecked Color: ${$event.starRating}`);
  } */
}
}
