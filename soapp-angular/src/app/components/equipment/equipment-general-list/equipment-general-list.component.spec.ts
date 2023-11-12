import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EquipmentGeneralListComponent } from './equipment-general-list.component';

describe('EquipmentGeneralListComponent', () => {
  let component: EquipmentGeneralListComponent;
  let fixture: ComponentFixture<EquipmentGeneralListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EquipmentGeneralListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EquipmentGeneralListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
