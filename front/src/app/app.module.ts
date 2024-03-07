import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NotifComponent } from './components/notif/notif.component';
import { PageLoginComponent } from './pages/page-login/page-login.component';
import { LoginComponent } from './components/login/login.component';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { EmployeeListComponent } from './components/employee-list/employee-list.component';
import { PageEmpoyeeDetailComponent } from './pages/page-employee-list/page-empoyee-detail/page-empoyee-detail.component';
import { EmployeeDetailComponent } from './components/employee-detail/employee-detail.component';
import { EmployeeFormComponent } from './components/employee-form/employee-form.component';
import { PageNotFoundComponent } from './pages/page-not-found/page-not-found.component';
import { PageEmployeeListComponent } from './pages/page-employee-list/page-employee-list.component';
import { HeaderComponent } from './components/header/header.component';
import { StoreModule } from '@ngrx/store';
import { authReducer } from './redux/auth.reducer';
import { StoreDevtoolsModule } from '@ngrx/store-devtools';

@NgModule({
  declarations: [
    AppComponent,
    NotifComponent,
    LoginComponent,
    HeaderComponent,
    EmployeeFormComponent,
    EmployeeListComponent,
    EmployeeDetailComponent,
    PageLoginComponent,
    PageNotFoundComponent,
    PageEmployeeListComponent,
    PageEmpoyeeDetailComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    CommonModule,
    StoreModule.forRoot({ auth:authReducer }),
    StoreDevtoolsModule.instrument({
      maxAge: 25,
    }),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
