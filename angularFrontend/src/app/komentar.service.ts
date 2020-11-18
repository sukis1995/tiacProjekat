import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class KomentarService {

  constructor(private http:HttpClient) { }



  findByPost(id):Observable<any>{
    return this.http.get("http://localhost:8080/api/komentari/"+id);
  }

  edit(data):Observable<any>{
    return this.http.put("http://localhost:8080/api/komentari/"+data.id,data);

  }
  findOne(id):Observable<any>{
    return this.http.get("http://localhost:8080/api/komentari/komentar/"+id);
  }

  delete(id):Observable<any>{
    return this.http.delete("http://localhost:8080/api/komentari/"+id)
  }
  
  save(data):Observable<any>{
   
    return this.http.post("http://localhost:8080/api/komentari",data);
  }
}
