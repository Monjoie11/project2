import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MbTabbedTableComponent } from './mb-tabbed-table.component';

describe('MbTabbedTableComponent', () => {
  let component: MbTabbedTableComponent;
  let fixture: ComponentFixture<MbTabbedTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MbTabbedTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MbTabbedTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
