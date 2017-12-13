import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams} from '@angular/common/http'
import { Observable } from 'rxjs/Observable';
import { Taxonomy } from '../dtos/taxonomy';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

@Injectable()
export class TaxonomyService {

    private options: {};
    private taxonomyURL = 'http://localhost:8889/ebitest/api/v1/taxonomies';

    constructor(private http: HttpClient) { }

    setRequestOptions() {
        this.options = {headers: new Headers({ 'Content-Type': 'application/json' })};
    }

    getTaxonomies(taxonomyCommonName: string, taxonomyScientificName): Observable<Taxonomy[]> {
        this.setRequestOptions();
        let params: URLSearchParams = new URLSearchParams();
        params.set('taxonomyCommonName', taxonomyCommonName);
        params.set('taxonomyScientificName', taxonomyScientificName);
        this.options['params'] = params;
        return this.http.get<Taxonomy[]>(this.taxonomyURL, this.options);
    }

    getTaxonomyByTaxonomyId(taxonomyId : number): Observable<Taxonomy> {
        this.setRequestOptions();
        const url = '${this.taxonomyURL}/${taxonomyId}';
        return this.http.get<Taxonomy>(url, this.options);
    }

}
