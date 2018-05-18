import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TwitterComponent } from './twitter.component';
import {TwittertimelineComponent} from "./twittertimeline/twittertimeline.component";
import {TwitterfollowersComponent} from "./twitterfollowers/twitterfollowers.component";
import {TwitterdashboardComponent} from "./twitterdashboard/twitterdashboard.component";
import {TwitterrealfollowersComponent} from "./twitterrealfollowers/twitterrealfollowers.component";
import {TempComponent} from "./temp/temp.component";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {CommitsService} from "../../services/github/commits.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {MaterializeModule} from "angular2-materialize";
import {FormsModule} from "@angular/forms";
import {
  AsyncLocalDatabase, AsyncLocalStorage, AsyncLocalStorageModule,
  JSONValidator
} from "angular-async-local-storage";
import {TwitterService} from "../../services/twitter/twitter.service";

describe('TwitterComponent', () => {
  let component: TwitterComponent;
  let fixture: ComponentFixture<TwitterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TwitterComponent, TwittertimelineComponent, TwitterfollowersComponent, TwitterdashboardComponent, TwitterrealfollowersComponent, TempComponent ],
      imports: [HttpClientModule,FormsModule, MaterializeModule, AsyncLocalStorageModule],
      providers: [HttpClient, Ng4LoadingSpinnerService, TwitterService, AsyncLocalStorage, AsyncLocalDatabase]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TwitterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
