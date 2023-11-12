import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EquipmentGeneralComponent } from './equipment-general.component';

describe('EquipmentGeneralComponent', () => {
  let component: EquipmentGeneralComponent;
  let fixture: ComponentFixture<EquipmentGeneralComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EquipmentGeneralComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EquipmentGeneralComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
