import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
 

@Injectable({
  providedIn: 'root'
})
export class AuthApiCallService implements HttpInterceptor {

  constructor() { }

  intercept(req: HttpRequest<any>,
    next: HttpHandler): Observable<HttpEvent<any>> {

const idToken = localStorage.getItem("JWT");

if (idToken) {
  
  const cloned = req.clone({
      headers: req.headers.set("Authorization",
           idToken)
  });

  return next.handle(cloned);
}
else {
  return next.handle(req);
}
}
}
