import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Staff } from 'src/app/models/Staff';
import { RequestService } from 'src/app/services/request.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrl: './employee-list.component.scss'
})
export class EmployeeListComponent implements OnInit{
  employeeList: Staff[] = []
  pagination: number = 3
  pageTotal: number = 0
  currentPage: number = 0

  constructor(private requestService:RequestService){}

  ngOnInit(): void {
    this.requestService.get<any>("numberStaff")
    .then(response=>{
      console.log(response)
      const data = response.data
      if(data.code == 200){
        this.pageTotal = Math.ceil(data.object / this.pagination)
        console.log(this.pageTotal)
      }
    })

    this.getStaffList()
  }

  getStaffList(): void{
    const postData = { page: this.currentPage, numberPerPage: this.pagination };

    this.requestService.get<any>("staff", postData)
    .then(response=>{
      console.log(response)
      const data = response.data
      if(data.code == 200){
        this.employeeList = data.object
      }
    })
  }

  iterateTimes(): number[]{
    return Array(this.pageTotal).fill(0);
  }

  // page {0, 1, 2 .....}
  pageChange(page:number): void{
    if(page >= 0 && page < this.pageTotal){

      this.currentPage = page
      console.log(this.currentPage)
  
      this.getStaffList()
    }
  }
}
