import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PageEmpoyeeDetailComponent } from './page-empoyee-detail.component';

describe('PageEmpoyeeDetailComponent', () => {
  let component: PageEmpoyeeDetailComponent;
  let fixture: ComponentFixture<PageEmpoyeeDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PageEmpoyeeDetailComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PageEmpoyeeDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
