import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectMaintenanceElectricalComponent } from './select-maintenance-electrical.component';

describe('SelectMaintenanceElectricalComponent', () => {
  let component: SelectMaintenanceElectricalComponent;
  let fixture: ComponentFixture<SelectMaintenanceElectricalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SelectMaintenanceElectricalComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SelectMaintenanceElectricalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
