import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectMaintenanceMechanicalComponent } from './select-maintenance-mechanical.component';

describe('SelectMaintenanceMechanicalComponent', () => {
  let component: SelectMaintenanceMechanicalComponent;
  let fixture: ComponentFixture<SelectMaintenanceMechanicalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SelectMaintenanceMechanicalComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SelectMaintenanceMechanicalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
