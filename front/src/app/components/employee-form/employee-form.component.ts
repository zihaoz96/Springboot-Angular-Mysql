import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { NotifType } from 'src/app/constant/NotifType';
import { Staff } from 'src/app/models/Staff';
import { NotifService } from 'src/app/services/notif.service';
import { RequestService } from 'src/app/services/request.service';
import { ModalComponent } from '../modal/modal.component';
import { selectOption } from './selectOption';

@Component({
  selector: 'app-employee-form',
  templateUrl: './employee-form.component.html',
  styleUrl: './employee-form.component.scss'
})
export class EmployeeFormComponent {
  @Input("staff") staff?:Staff
  selectFrom:string = "";
  selectTo:string = "";
  amount:string = "";

  selectOptionFrom:any[] = []
  selectOptionTo:any[] = []

  showModal:boolean = false;

  constructor(private requestService: RequestService, private modalService: NgbModal, private router: Router, private notifService: NotifService){
    this.selectOptionFrom = selectOption
    this.selectOptionTo = selectOption
  }

  submit(){
    console.log(this.selectFrom, this.selectTo)
    if(this.selectFrom != this.selectTo && this.selectFrom != "" && this.selectTo != ""){
      const modalRef = this.modalService.open(ModalComponent, {
        size: 'md', 
        centered: true, 
        backdrop: true, 
        keyboard: true,
      });
      modalRef.componentInstance.selectFrom = this.selectFrom
      modalRef.componentInstance.selectTo = this.selectTo
      modalRef.componentInstance.amount = this.amount

      modalRef.result
      .then(
        (result) => {
        if(result == "confirm"){
          const postData = { 
            id: this.staff?.id, 
            fromAcc: this.selectFrom, 
            toAcc: this.selectTo,
            amount: this.amount
          };
          this.requestService.post<any>('transfer', postData).then(response => {
            console.log(response)
            if(response.data.isOk){
              this.notifService.setMessageType(NotifType.SUCCESS)
              this.notifService.setMessage(response.data.message)
              this.notifService.show()
              this.router.navigateByUrl('/employees')
            }else{
              this.notifService.setMessageType(NotifType.FAILED)
              this.notifService.setMessage(response.data.message)
              this.notifService.show()
            }
          })
        }
      }, (reason)=>{
        console.log("Dismiss:", reason)
      })
    }
  }

  onSelect(){
    this.selectOptionFrom = selectOption.filter(option => option.value != this.selectTo)
    this.selectOptionTo = selectOption.filter(option => option.value != this.selectFrom)
  }

  exchange(){
    this.selectOptionFrom = selectOption
    this.selectOptionTo = selectOption
    const tmp = this.selectFrom
    this.selectFrom = this.selectTo
    this.selectTo = tmp

    this.onSelect()
  }
}
