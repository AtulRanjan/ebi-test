import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-base-component',
  templateUrl: './base-component.component.html',
  styleUrls: ['./base-component.component.css']
})
export class BaseComponent implements OnInit {
  public isLoading: boolean = false;
  public contentText: string = '';
  constructor() { }

  ngOnInit() {
  }

  protected showLoading() {
      this.isLoading = true;
      this.contentText = '';
  }

  protected handleInvalidInputField() {
      this.contentText = 'Please check input field(s)';
  }

  protected nonNull(inputString: string): boolean {
      return (typeof inputString != 'undefined' && inputString) ? true : false;
  }

  protected handleError(error: Response | any) {
      let errorBody =error.message || {};
      let message = 'Unknown exception occurred';
      if (errorBody.message) {
          message = errorBody.message;
      }
      this.contentText = message;
      this.isLoading = false;
  }
}
