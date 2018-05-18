import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ForksComponent } from './forks.component';
import {ChartsModule} from "ng2-charts";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {ForksService} from "../../../services/github/forks.service";

describe('ForksComponent', () => {
  let component: ForksComponent;
  let fixture: ComponentFixture<ForksComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ForksComponent ],
      imports: [ChartsModule, HttpClientModule, ChartsModule, HttpClientModule],
      providers: [ForksService]
    })
    .compileComponents();
    component.ngOnInit();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ForksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
