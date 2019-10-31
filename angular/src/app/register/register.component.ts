import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {

  public containers = [0];
  public counter : number = 1;
  constructor()  { }

  ngOnInit() {
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
