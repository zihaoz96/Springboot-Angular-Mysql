import { Injectable } from '@angular/core';
import { RequestService } from './request.service';
import { NotifService } from './notif.service';
import { NotifType } from '../constant/NotifType';
import { Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { AuthState } from '../redux/auth.reducer';
import { Observable } from 'rxjs';
import * as AuthActions from '../redux/auth.actions'

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  isAuthenticated$: Observable<boolean> | undefined;

  constructor(private requestService:RequestService, private notifService: NotifService, private router:Router, private store: Store<{ auth: AuthState }>) {
    if(sessionStorage.getItem("user")) this.store.dispatch(AuthActions.loginSuccess());
    this.isAuthenticated$ = this.store.select((state) => state.auth.isAuthenticated);
  }

  login(username: string, password: string) {
    const postData = { username: username, password: password };
    console.log(username, password)

    this.requestService.post<any>('login', postData).then(response => {
      console.log(response);
      const data = response.data

      // Set notify message
      if(data.code != 200){
        this.notifService.setMessageType(NotifType.FAILED)
      }else{
        this.notifService.setMessageType(NotifType.SUCCESS)
        this.store.dispatch(AuthActions.loginSuccess());

        sessionStorage.setItem("user", username)
        this.router.navigateByUrl('/employees')
      }

      // show notify message
      this.notifService.setMessage(data.message)
      this.notifService.show()
    });
  }

  logout() {
    this.router.navigateByUrl('/login')
    this.store.dispatch(AuthActions.logout());

    sessionStorage.removeItem("user")
  }

  getStatusAuth(): Observable<boolean> | undefined  {
    return this.isAuthenticated$
  }
}
