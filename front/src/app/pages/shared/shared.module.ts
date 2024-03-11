import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from 'src/app/components/header/header.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [HeaderComponent],
  imports: [CommonModule, CommonModule, FormsModule],
  exports: [HeaderComponent, CommonModule, FormsModule]
})
export class SharedModule { }
