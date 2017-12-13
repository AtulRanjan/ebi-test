import { Component, OnInit, ViewChild } from '@angular/core';
import { ProjectService } from '../services/project.service';
import { MatTableDataSource, MatPaginator, MatSort } from '@angular/material'
import { BaseComponent } from './../base-component/base-component.component'
import { Project } from '../dtos/project'
import { ProjectDetail } from '../dtos/projectDetail'
@Component({
    selector: 'app-project',
    styleUrls : ['./project.component.css'],
    templateUrl: './project.component.html'
})
export class ProjectComponent extends BaseComponent implements OnInit{

    public projectId : string;
    public title : string;
    public sourceType : string;
    public studyType : string;
    public evaCenterName : string;
    public centerName : string;
    public taxonomyId : number;
    public dataSource = new MatTableDataSource<Project>();
    public projectDetail: ProjectDetail;
    public displayedColumns =  ['projectId', 'title', 'studyType', 'sourceType','evaCenterName', 'centerName','taxonomyId'];
    @ViewChild(MatPaginator) public paginator: MatPaginator;
    @ViewChild(MatSort) public sort: MatSort;

    constructor(private projectService: ProjectService) {
      super();
    }
    ngAfterViewInit() {
      // this.dataSource.paginator = this.paginator;
      // this.dataSource.sort = this.sort;
    }
    ngOnInit() {
      // this.dataSource.paginator = this.paginator;
      // this.dataSource.sort = this.sort;
    }

    getProjects() {
      this.showLoading();
      this.projectService.getProjects(this.taxonomyId, this.title, this.sourceType, this.studyType, this.evaCenterName, this.centerName)
      .subscribe(
        data => {
            this.isLoading = false;
            this.dataSource.data  = data;
        },
        error => {
            this.handleError(error);
        });
    }
    clearOptions() {
        this.projectId = '';
        this.taxonomyId = null;
        this.studyType = '';
        this.sourceType = '';
        this.evaCenterName = '';
        this.centerName = '';
    }
}
