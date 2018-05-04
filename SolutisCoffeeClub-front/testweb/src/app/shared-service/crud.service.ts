import { Injectable } from '@angular/core';
import {Http, Response, Headers, RequestOptions} from '@angular/http';

@Injectable()
export class CrudService {

  private baseUrl: string ='http://localhost:8080/';
  private headers = new Headers({"Context-Type":"application/json"});
  private options = new RequestOptions({headers:this.headers})
  constructor(private _http:Http) { }

  getUsers(){
    return this._http.get(this.baseUrl+'/capsulas', this.options);
  }

}
