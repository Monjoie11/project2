import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-company-homepage',
  templateUrl: './company-homepage.component.html',
  styleUrls: ['./company-homepage.component.css']
})
export class CompanyHomepageComponent implements OnInit {
  url: string;
  onSelectFile(event) { // called each time file input changes
      if (event.target.files && event.target.files[0]) {
        var reader = new FileReader();
  
        reader.readAsDataURL(event.target.files[0]); // read file as data url
  
        reader.onload = (event) => { // called once readAsDataURL is completed
          this.url = event.target.result as string;
        }
      }
  }
  constructor(){}

  ngOnInit() {
  }

}

