import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StackerrorComponent } from './stackerror.component';
import {MaterializeModule} from "angular2-materialize";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {CommitsService} from "../../../services/github/commits.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";

describe('StackerrorComponent', () => {
  let component: StackerrorComponent;
  let fixture: ComponentFixture<StackerrorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StackerrorComponent ],
      imports: [HttpClientModule, MaterializeModule],
      providers: [HttpClient, Ng4LoadingSpinnerService, CommitsService]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StackerrorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
