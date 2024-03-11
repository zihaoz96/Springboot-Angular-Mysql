import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NotifComponent } from './components/notif/notif.component';
import { CommonModule } from '@angular/common';
import { StoreModule } from '@ngrx/store';
import { authReducer } from './redux/auth.reducer';
import { StoreDevtoolsModule } from '@ngrx/store-devtools';
import { PageLoginModule } from './pages/page-login/page-login.module';
import { PageEmployeeListModule } from './pages/page-employee-list/page-employee-list.module';

@NgModule({
  declarations: [
    AppComponent,
    NotifComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CommonModule,
    PageLoginModule,
    PageEmployeeListModule,
    StoreModule.forRoot({ auth:authReducer }),
    StoreDevtoolsModule.instrument({
      maxAge: 25,
    }),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
