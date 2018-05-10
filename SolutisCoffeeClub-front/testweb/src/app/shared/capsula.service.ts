import { FormsModule } from '@angular/forms';
import { CapsulaCafe } from './../../capsula';
import { Observable } from 'rxjs/Observable';
import { HttpModule } from '@angular/http';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


const httpOptions = {
  headers: new HttpHeaders({'Content-Type':  'application/json'})
}

@Injectable()
export class CapsulaService {

  private capsulaUrl: string = 'http://localhost:8080/capsulas';
  private headers = new Headers({'Content-Type' : 'application.json'});

  constructor( private http: HttpClient) {}

   getAllCapsula(): Observable<any>{
     return this.http.get(this.capsulaUrl);
   }
   getCapsulaById(id:number) : Observable<any>{
    return this.http.get(this.capsulaUrl + '/' + id);   
  }
  saveCapsula(capsula: CapsulaCafe){
    let result: Observable<Object>;
    result = this.http.post(this.capsulaUrl, capsula);
    return result;
  }
  deleteCapsula(id: number){
    return this.http.delete(this.capsulaUrl + '/' + id);  
  }


}
