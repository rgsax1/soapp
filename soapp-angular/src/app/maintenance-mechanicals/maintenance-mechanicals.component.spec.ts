import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MaintenanceMechanicalsComponent } from './maintenance-mechanicals.component';

describe('MaintenanceMechanicalsComponent', () => {
  let component: MaintenanceMechanicalsComponent;
  let fixture: ComponentFixture<MaintenanceMechanicalsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MaintenanceMechanicalsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MaintenanceMechanicalsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
