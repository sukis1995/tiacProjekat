import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class OcenaService {

  constructor(private http:HttpClient) { }


  postOcena(value,idPost){
    var data={
      "idPost":idPost,
      "vrednost":value
    }
    return this.http.post("http://localhost:8080/api/ocene/"+idPost,data);

  }
}
