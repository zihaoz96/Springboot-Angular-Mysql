import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import axios from 'axios';
import { NotifType } from 'src/app/constant/NotifType';
import { AuthService } from 'src/app/services/auth.service';
import { NotifService } from 'src/app/services/notif.service';
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

  constructor(private authService: AuthService, private router:Router){
    this.loginForm = new FormGroup({})
    // is login navigate to list employees
    if(authService.getStatusAuth()){
      router.navigateByUrl('/employees')
    }
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

      this.authService.login(username, password)
    }
  }
}
