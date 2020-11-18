import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { LoginServiceService } from '../login-service.service';

import { Router } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
@Component({
  selector: 'LoginComponent',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
    formGroup:FormGroup;
  constructor(private loginService: LoginServiceService, private router:Router) { }

  ngOnInit(): void {
    this.formGroup=new FormGroup({
      username:new FormControl("",[Validators.required]),
      password:new FormControl("",[Validators.required]),
    })
  }

  loginProces(){
    if(this.formGroup.valid){
      this.loginService.login(this.formGroup.value).subscribe((data:HttpResponse<any>)=>{
        this.storeToken(data.headers.get("Authorization"));
        alert("Uspesno ste se ulogovali")
      this.router.navigateByUrl("/home")
        
      }, (data=>{
        alert("Pogresno ste uneli korisnicko ime ili sifru")
      }))
    }
  }


  storeToken(token){
    localStorage.setItem("JWT",token);
    
  }

}
