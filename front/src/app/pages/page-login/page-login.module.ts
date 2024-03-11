import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PageLoginComponent } from './page-login.component';
import { RouterModule } from '@angular/router';
import { PageLoginRouting } from './page-login.routing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from 'src/app/components/login/login.component';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [
    PageLoginComponent,
    LoginComponent
  ],
  imports: [
    RouterModule.forChild(PageLoginRouting),
    ReactiveFormsModule,
    SharedModule
  ]
})
export class PageLoginModule { }
