import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { PageEmployeeListRouting } from './page-employee-list.routing';
import { SharedModule } from '../shared/shared.module';
import { PageEmployeeListComponent } from './page-employee-list.component';
import { PageEmpoyeeDetailComponent } from './page-empoyee-detail/page-empoyee-detail.component';
import { EmployeeListComponent } from 'src/app/components/employee-list/employee-list.component';
import { EmployeeDetailComponent } from 'src/app/components/employee-detail/employee-detail.component';
import { EmployeeFormComponent } from 'src/app/components/employee-form/employee-form.component';



@NgModule({
  declarations: [
    PageEmployeeListComponent,
    PageEmpoyeeDetailComponent,
    EmployeeListComponent,
    EmployeeDetailComponent,
    EmployeeFormComponent
  ],
  imports: [
    RouterModule.forChild(PageEmployeeListRouting),
    SharedModule
  ]
})
export class PageEmployeeListModule { }
