import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MaintenanceElectricalComponent } from './maintenance-electrical.component';

describe('MaintenanceElectricalComponent', () => {
  let component: MaintenanceElectricalComponent;
  let fixture: ComponentFixture<MaintenanceElectricalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MaintenanceElectricalComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MaintenanceElectricalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
