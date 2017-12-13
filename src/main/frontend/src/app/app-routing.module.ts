import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { ProjectComponent} from './project/project.component';
import { TaxonomyComponent} from './taxonomy/taxonomy.component';
import { ProjectDetailComponent } from './project-detail/project-detail.component';

const routes: Routes = [
    {
        path: '',
        redirectTo: 'app/projects',
        pathMatch: 'full'
    },
    {
        path: 'app/projects',
        component: ProjectComponent
    },
    {
      path: 'app/taxonomies',
      component: TaxonomyComponent
    },
    {
      path: 'app/projectdetail/:projectId',
      component: ProjectDetailComponent
    }

];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
