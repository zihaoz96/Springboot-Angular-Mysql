import { Injectable } from '@angular/core';
import { RequestService } from './request.service';
import { NotifService } from './notif.service';
import { NotifType } from '../constant/NotifType';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private requestService:RequestService, private notifService: NotifService, private router:Router) { }

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
        sessionStorage.setItem("user", username)
        this.router.navigateByUrl('/employees')
      }

      // show notify message
      this.notifService.setMessage(data.message)
      this.notifService.show()
    });
  }

  logout() {
    sessionStorage.removeItem("user")
    this.router.navigateByUrl('/login')
  }

  getStatusAuth(): string|null {
    return sessionStorage.getItem("user")
  }
}
