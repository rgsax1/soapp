import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MaintenanceMechanicalComponent } from './maintenance-mechanical.component';

describe('MaintenanceMechanicalComponent', () => {
  let component: MaintenanceMechanicalComponent;
  let fixture: ComponentFixture<MaintenanceMechanicalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MaintenanceMechanicalComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MaintenanceMechanicalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
