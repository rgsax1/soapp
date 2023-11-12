import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MaintenanceMechanicalListComponent } from './maintenance-mechanical-list.component';

describe('MaintenanceMechanicalListComponent', () => {
  let component: MaintenanceMechanicalListComponent;
  let fixture: ComponentFixture<MaintenanceMechanicalListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MaintenanceMechanicalListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MaintenanceMechanicalListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
