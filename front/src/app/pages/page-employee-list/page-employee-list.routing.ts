import { Routes } from "@angular/router";
import { PageEmployeeListComponent } from "./page-employee-list.component";
import { PageEmpoyeeDetailComponent } from "./page-empoyee-detail/page-empoyee-detail.component";


export const PageEmployeeListRouting: Routes = [
    {
        path:'',
        component: PageEmployeeListComponent
    },
    {
        path:":id",
        component: PageEmpoyeeDetailComponent
    }
]