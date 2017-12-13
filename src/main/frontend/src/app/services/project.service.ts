import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders} from '@angular/common/http'
import { Observable } from 'rxjs/Observable';
import { Project } from '../dtos/project';
import { ProjectDetail } from '../dtos/projectDetail'
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

@Injectable()
export class ProjectService {

    private options: {};
    private projectURL = 'http://localhost:8889/ebitest/api/v1/projects';

    constructor(private http: HttpClient) { }

    setRequestOptions() {
        this.options = {'headers' :  new HttpHeaders({ 'Content-Type': 'application/json' })};
    }

    getProjects(taxonomyId: number, title: string, sourceType: string, studyType: string, evaCenterName: string, centerName: string): Observable<Project[]> {
        this.setRequestOptions();
        // let params: URLSearchParams = new URLSearchParams();
        let params : HttpParams = new HttpParams()
        params= taxonomyId ? params.append('taxonomyId', String(taxonomyId)) : params ;
        params= title ? params.append('title', title) : params;
        params= sourceType ? params.append('sourceType', sourceType) : params;
        params= studyType ? params.append('studyType', studyType) : params;
        params= evaCenterName ? params.append('evaCenterName', evaCenterName) : params;
        params= centerName ? params.append('centerName', centerName) : params;
        this.options['params'] = params;
        return this.http.get<Project[]>(this.projectURL, this.options)
    }

    getProjectByProjectId(projectId:string): Observable<ProjectDetail> {
        this.setRequestOptions();
         const url = `${this.projectURL}/${[projectId]}`;
        let detail = this.http.get<ProjectDetail>(url, this.options);
        return detail;
    }

}
