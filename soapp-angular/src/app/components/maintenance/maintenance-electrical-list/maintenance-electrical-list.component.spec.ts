import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MaintenanceElectricalListComponent } from './maintenance-electrical-list.component';

describe('MaintenanceElectricalListComponent', () => {
  let component: MaintenanceElectricalListComponent;
  let fixture: ComponentFixture<MaintenanceElectricalListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MaintenanceElectricalListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MaintenanceElectricalListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
