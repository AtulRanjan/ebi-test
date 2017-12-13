import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common'
import { ProjectService } from '../services/project.service'
import { ProjectDetail } from '../dtos/projectDetail'
import { BaseComponent } from './../base-component/base-component.component'

@Component({
  selector: 'app-project-detail',
  templateUrl: './project-detail.component.html',
  styleUrls: ['./project-detail.component.css']
})
export class ProjectDetailComponent extends BaseComponent implements OnInit {

  project : ProjectDetail;
  editMode: boolean = false;
  constructor(private projectService : ProjectService,
     private route : ActivatedRoute,
      private location : Location ) {
        super();

  }

  ngOnInit() {
    this.getProjectDetail();
  }

  getProjectDetail() : void{
    if(this.route.snapshot.paramMap.has("projectId")){
      const id = this.route.snapshot.paramMap.get("projectId");
      this.projectService.getProjectByProjectId(id).subscribe(project => this.project = project);
    }
  }
  goBack(): void{
    this.location.back();
  }
  updateProject():void {
    this.editMode = true;

  }
  toggleEdit():void {
    this.editMode = !this.editMode;
  }
  clearFields(): void {

  }
}
