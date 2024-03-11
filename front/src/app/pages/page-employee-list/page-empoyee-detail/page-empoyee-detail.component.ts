import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Staff } from 'src/app/models/Staff';
import { RequestService } from 'src/app/services/request.service';

@Component({
  selector: 'app-page-empoyee-detail',
  templateUrl: './page-empoyee-detail.component.html',
  styleUrl: './page-empoyee-detail.component.scss'
})
export class PageEmpoyeeDetailComponent{
  idStaff: string | any = null;
  staff:Staff | any = null
  
  constructor(private requestService:RequestService, private route: ActivatedRoute){
    this.route.params.subscribe(params => {
      this.idStaff = params['id'];
      this.requestService.get<any>("staff/"+this.idStaff)
      .then(response=>{
        console.log(response)
        const data = response.data
        if(data.code == 200){
          this.staff = data.object
        }
      })
    });
  }
}
