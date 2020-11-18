import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KomentariCreateComponent } from './komentari-create.component';

describe('KomentariCreateComponent', () => {
  let component: KomentariCreateComponent;
  let fixture: ComponentFixture<KomentariCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KomentariCreateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KomentariCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
