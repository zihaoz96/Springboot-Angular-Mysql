import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PageNotFoundComponent } from './pages/page-not-found/page-not-found.component';
import { AuthGuard } from './shared/auth.guard';
import { PageLoginComponent } from './pages/page-login/page-login.component';
import { PageEmployeeListComponent } from './pages/page-employee-list/page-employee-list.component';
import { PageEmpoyeeDetailComponent } from './pages/page-employee-list/page-empoyee-detail/page-empoyee-detail.component';

const routes: Routes = [
  { path: 'login', component: PageLoginComponent },
  {
    path: 'employees',
    // canActivate: [AuthGuard], // if is login
    children: [
      { 
        path: '', 
        component: PageEmployeeListComponent 
      },
      {
        path: ':id',
        component: PageEmpoyeeDetailComponent,
      },
    ]
  },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
