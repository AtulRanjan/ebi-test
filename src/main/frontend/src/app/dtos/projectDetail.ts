import { Project } from './project'
import { Taxonomy } from './taxonomy'
export class ProjectDetail extends Project{
  constructor(){
    super()
  }
  public description : string;
  public taxonomy : Taxonomy;
}
