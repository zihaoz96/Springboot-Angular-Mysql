import { Component } from '@angular/core';
import { NotifService } from 'src/app/services/notif.service';

@Component({
  selector: 'app-notif',
  standalone: false,
  templateUrl: './notif.component.html',
  styleUrl: './notif.component.scss'
})
export class NotifComponent {
  message: string = "";
  messageType: string = "";
  showMessage: boolean = false;

  constructor(private notifService: NotifService){
    notifService.getObservable().subscribe((status)=>{
      if(status){
        this.message = notifService.getMessage();
        this.messageType = notifService.getMessageType();
        this.showMessage = true;
      }else{
        this.showMessage = false;
      }
    })
  }
}
