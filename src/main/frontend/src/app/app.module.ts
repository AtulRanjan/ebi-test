import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule} from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'
import { MatModule } from './material.module'
import { AppComponent } from './app.component';
import { ProjectComponent } from './project/project.component';
import { ProjectDetailComponent } from './project-detail/project-detail.component';
import { ProjectService } from './services/project.service';
import { TaxonomyService } from './services/taxonomy.service';
import { NavbarComponent } from './navbar/navbar.component';
import { TaxonomyComponent } from './taxonomy/taxonomy.component';
import { BaseComponent } from './base-component/base-component.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ProjectComponent,
    TaxonomyComponent,
    ProjectDetailComponent,
    BaseComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    BrowserAnimationsModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    MatModule
  ],
  providers: [ProjectService, TaxonomyService],
  bootstrap: [AppComponent]
})
export class AppModule { }
