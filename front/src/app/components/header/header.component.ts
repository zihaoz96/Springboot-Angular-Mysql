import { Component } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {
  username:string = ""

  constructor(private authService:AuthService){
    this.username = sessionStorage.getItem("user")|| "User"
  }

  logout(): void{
    this.authService.logout()
  }
}
