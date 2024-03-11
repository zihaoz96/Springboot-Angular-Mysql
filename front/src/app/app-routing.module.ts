import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PageNotFoundComponent } from './pages/page-not-found/page-not-found.component';
import { AuthGuard } from './shared/auth.guard';

const routes: Routes = [
  { 
    path: 'login', 
    loadChildren: () => import('./pages/page-login/page-login.module').then(m => m.PageLoginModule)
  },
  {
    path: 'employees',
    canActivate: [AuthGuard], // if is login
    loadChildren: () => import('./pages/page-employee-list/page-employee-list.module').then(m => m.PageEmployeeListModule)
  },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
