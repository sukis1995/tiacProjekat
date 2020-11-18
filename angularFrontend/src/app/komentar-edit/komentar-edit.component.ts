import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { Form, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { KomentarService } from '../komentar.service';
import { Komentar } from '../model/komentar';

@Component({
  selector: 'app-komentar-edit',
  templateUrl: './komentar-edit.component.html',
  styleUrls: ['./komentar-edit.component.css']
})
export class KomentarEditComponent implements OnInit {
  komentar:Komentar
  id:string
formGroup:FormGroup
  constructor(private komentarService:KomentarService, private router:Router, private route:ActivatedRoute) { }
 
  ngOnInit(): void {
    this.id=this.route.snapshot.paramMap.get("id")
    this.komentarService.findOne(this.id).subscribe(data=>{
      this.komentar=data;
      this.formGroup=new FormGroup({
        tekst:new FormControl(this.komentar.tekst,[Validators.required]),
        id:new FormControl(this.komentar.id,[Validators.required]),
        idPost:new FormControl(this.komentar.idPost,[Validators.required])
      })
    },(data=>{
      alert("Doslo je do greske prilikom ucitavnja komentara")
      this.router.navigateByUrl("/posts")
    }))
  }


  editKomentar(){
    if(confirm("Da li ste sigurni da zelite da izvrsite promenu"))
    this.komentarService.edit(this.formGroup.value).subscribe(data=>{
      alert("Uspesno ste editovali komentar")
      this.router.navigateByUrl("/posts")
    },(data=>{
      alert("Doslo je do greske prilikom editovanja komentara")
      this.router.navigateByUrl("/posts")
    }))
  }

}
