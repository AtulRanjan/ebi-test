import { NgModule } from '@angular/core'
import { CommonModule } from '@angular/common'
import { MatMenuModule,  MatButtonModule, MatToolbarModule, MatIconModule, MatCardModule,
  MatTableModule,MatInputModule, MatPaginatorModule, MatSortModule } from '@angular/material'
import { MatExpansionModule } from '@angular/material/expansion';


@NgModule({
  declarations:[],
  imports:[
        MatMenuModule, MatButtonModule, MatToolbarModule, MatIconModule, MatCardModule, MatTableModule,MatInputModule,
        MatPaginatorModule, MatSortModule, MatExpansionModule
  ],
  exports:[
        MatMenuModule, MatButtonModule, MatToolbarModule, MatIconModule, MatCardModule, MatTableModule,MatInputModule,
        MatPaginatorModule, MatSortModule, MatExpansionModule
  ]
})

export class MatModule{}
