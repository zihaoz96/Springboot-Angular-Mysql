import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NotifType } from 'src/app/constant/NotifType';
import { NotifService } from 'src/app/services/notif.service';
import { Store } from '@ngrx/store';
import * as AuthActions from '../../redux/auth.actions'
import { AuthState } from 'src/app/redux/auth.reducer';
import { RequestService } from 'src/app/services/request.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent implements OnInit{
  loginForm: FormGroup;
  username: string = "";
  password: string = "";

  constructor(
    private notifService: NotifService, 
    private router:Router, 
    private requestService:RequestService, 
    private store: Store<{ auth: AuthState }>
  ){
      
    this.loginForm = new FormGroup({})
    // is login navigate to list employees
    this.store.select(state => state.auth.isAuthenticated)?.subscribe(state=>{
      if(state) 
        router.navigateByUrl('/employees')
    })
  }

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      username: new FormControl(null,[
        Validators.required,
        Validators.minLength(5)
      ]),
      password: new FormControl(null,[
        Validators.required,
        Validators.minLength(5)
      ])
    })
  }

  submit():void {
    if(this.loginForm!.valid){
      const username = this.loginForm.get("username")?.value
      const password = this.loginForm.get("password")?.value

      const postData = { username: username, password: password };

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
  }
}
