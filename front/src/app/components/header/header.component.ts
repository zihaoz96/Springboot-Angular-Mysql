import { Component } from '@angular/core';
import { Store } from '@ngrx/store';
import { AuthState } from 'src/app/redux/auth.reducer';
import * as AuthActions from '../../redux/auth.actions'
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {
  username:string = ""

  constructor(private store: Store<{ auth: AuthState }>, private router:Router){
    this.username = sessionStorage.getItem("user")|| "User"
  }

  logout(): void{
    this.store.dispatch(AuthActions.logout());
    sessionStorage.removeItem("user")
    this.router.navigateByUrl('/login')
  }
}
