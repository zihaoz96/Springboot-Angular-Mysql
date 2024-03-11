import { Component } from '@angular/core';
import { Store } from '@ngrx/store';
import { AuthState } from './redux/auth.reducer';
import * as AuthActions from './redux/auth.actions'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  
  constructor(private store: Store<{ auth: AuthState }>){
    if(sessionStorage.getItem("user")) this.store.dispatch(AuthActions.loginSuccess());
  }
}
