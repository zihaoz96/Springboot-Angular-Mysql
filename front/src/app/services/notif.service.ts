import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NotifService {
  private showSubject: Subject<boolean> = new Subject<boolean>();
  private message:string = "";
  private messageType:string = "";

  constructor() { }

  show(): void{
    this.showSubject.next(true);

    setTimeout(() => {
      this.showSubject.next(false);
    }, 5000);
  }

  getObservable(): Observable<boolean>{
    return this.showSubject.asObservable();
  }

  getMessage():string {
    return this.message;
  }

  getMessageType():string {
    return this.messageType;
  }

  setMessage(message: string):void {
    this.message = message;
  }

  setMessageType(messageType: string):void {
    this.messageType = messageType;
  }
}
