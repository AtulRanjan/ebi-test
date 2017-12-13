import { Component, OnInit } from '@angular/core';
import { TaxonomyService } from '../services/taxonomy.service';
import { Taxonomy } from '../dtos/taxonomy'

@Component({
    selector: 'app-taxonomies',
    templateUrl: './taxonomy.component.html'
})
export class TaxonomyComponent implements OnInit {

    public taxonomyId : number;
    public taxonomyCommonName : string;
    public taxonomyScientificName : string;
    public isLoading: boolean = false;
    public contentText: string = '';
    public taxonomies: Taxonomy[];
    public taxonomy: Taxonomy;
    constructor(private taxonomyService: TaxonomyService) { }

    ngOnInit() {
    }

    getTaxonomies() {
      console.log("getTaxonomies called!")
      this.showLoading();
      this.taxonomyService.getTaxonomies(this.taxonomyCommonName, this.taxonomyScientificName).subscribe(
        data => {
            this.isLoading = false;
            this.taxonomies = data;
        },
        error => {
            this.handleError(error);
        });
    }

    getTaxonomiesByTaxonomyId() {
      if (this.taxonomyId) {
        this.showLoading();
        this.taxonomyService.getTaxonomyByTaxonomyId(this.taxonomyId).subscribe(
          data => {
              this.isLoading = false;
              this.taxonomy = data;
          },
          error => {
              this.handleError(error);
          });
      }
      else {
        this.handleInvalidInputField();
      }
    }

    clearOptions() {
        this.taxonomyId = null;
        this.taxonomyCommonName = '';
        this.taxonomyScientificName = '';
    }

    private showLoading() {
        this.isLoading = true;
        this.contentText = '';
    }

    private handleInvalidInputField() {
        this.contentText = 'Please check input field(s)';
    }

    private nonNull(inputString: string): boolean {
        return (typeof inputString != 'undefined' && inputString) ? true : false;
    }

    private handleError(error: Response | any) {
        let errorBody = error.json();
        let message = 'Unknown exception occurred';
        if (errorBody.message) {
            message = errorBody.message;
        }
        this.contentText = message;
        this.isLoading = false;
    }
}
