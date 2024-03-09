import { Component, Input } from '@angular/core';
import { Staff } from 'src/app/models/Staff';

@Component({
  selector: 'app-employee-detail',
  templateUrl: './employee-detail.component.html',
  styleUrl: './employee-detail.component.scss'
})
export class EmployeeDetailComponent {
  @Input("staff") staff?:Staff
}
