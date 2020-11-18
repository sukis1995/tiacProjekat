import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginServiceService } from '../login-service.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  formGroup: FormGroup
  constructor(private loginService:LoginServiceService, private router:Router) { }

  ngOnInit(): void {
    this.formGroup=new FormGroup({
      username:new FormControl("",[Validators.required]),
      password:new FormControl("",[Validators.required]),
      repeatedPassword:new FormControl("",[Validators.required])
    })
  }

  registration(){
    console.log(this.formGroup.controls.repeatedPassword)
    console.log(this.formGroup.controls.password)
    if(this.formGroup.controls.repeatedPassword.value===this.formGroup.controls.password.value){
      this.loginService.registration(this.formGroup.value).subscribe(data=>{
        this.router.navigateByUrl("/home")
     }, (data=>{
       alert("Niste ste uspesno registrovali, pokusajte ponovo")
     }))
    }else{
      alert("Niste uneli identicne lozinke")
    }
     
  }

}
