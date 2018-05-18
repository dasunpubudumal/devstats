import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable()
export class MentionsService {

  constructor(protected http: HttpClient) { }

  public _get(id: string) {
    return this.http.get<any>("/api/stackusermensions/".concat(id))
      .map(mentions => mentions);
  }

  public _getFavorites(id: string) {
    return this.http.get<any>("/api/stackuserfavorites/".concat(id))
      .map(fav => fav);
  }
}
