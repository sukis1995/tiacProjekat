import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KomentariPostComponent } from './komentari-post.component';

describe('KomentariPostComponent', () => {
  let component: KomentariPostComponent;
  let fixture: ComponentFixture<KomentariPostComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KomentariPostComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KomentariPostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
