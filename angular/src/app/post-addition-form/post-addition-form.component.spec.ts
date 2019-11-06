import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PostAdditionFormComponent } from './post-addition-form.component';

describe('PostAdditionFormComponent', () => {
  let component: PostAdditionFormComponent;
  let fixture: ComponentFixture<PostAdditionFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PostAdditionFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PostAdditionFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
