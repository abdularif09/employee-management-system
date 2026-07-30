import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GettaskDetailsComponent } from './gettask-details.component';

describe('GettaskDetailsComponent', () => {
  let component: GettaskDetailsComponent;
  let fixture: ComponentFixture<GettaskDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GettaskDetailsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GettaskDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
