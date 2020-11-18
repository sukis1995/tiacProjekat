import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  constructor(private http:HttpClient) { }


  login(data):Observable<any>{
    return this.http.post("http://localhost:8080/login",data,{headers:new HttpHeaders().set('Content-Type', 'application/json'),
    observe: 'response'});
  }


  logout(){
    localStorage.removeItem("JWT");
  }


  registration(data):Observable<any>{
    return this.http.post("http://localhost:8080/api/korisnici/registration",data)
  }
}
