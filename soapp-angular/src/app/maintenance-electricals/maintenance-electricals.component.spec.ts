import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MaintenanceElectricalsComponent } from './maintenance-electricals.component';

describe('MaintenanceElectricalsComponent', () => {
  let component: MaintenanceElectricalsComponent;
  let fixture: ComponentFixture<MaintenanceElectricalsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MaintenanceElectricalsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MaintenanceElectricalsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
