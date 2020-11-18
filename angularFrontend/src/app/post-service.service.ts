import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PostServiceService {

  constructor( private http:HttpClient) { }

  getAll():Observable<any>{
      return this.http.get("http://localhost:8080/api/posts");
   }

   deletePost(id) :Observable<any>{
     return this.http.delete("http://localhost:8080/api/posts/"+ id)
   }

   createPost(data) :Observable<any>{
     return this.http.post("http://localhost:8080/api/posts", data)
   }
   findOne(id) :Observable<any>{
    return this.http.get("http://localhost:8080/api/posts/"+ id)
   }

   updatePost(data){
    return this.http.put("http://localhost:8080/api/posts/"+ data.id,data)
   }
  }
