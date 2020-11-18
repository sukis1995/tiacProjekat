import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KomentarItemComponent } from './komentar-item.component';

describe('KomentarItemComponent', () => {
  let component: KomentarItemComponent;
  let fixture: ComponentFixture<KomentarItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KomentarItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KomentarItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
