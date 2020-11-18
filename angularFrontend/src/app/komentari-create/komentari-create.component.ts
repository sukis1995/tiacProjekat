import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { KomentarService } from '../komentar.service';

@Component({
  selector: 'app-komentari-create',
  templateUrl: './komentari-create.component.html',
  styleUrls: ['./komentari-create.component.css']
})
export class KomentariCreateComponent implements OnInit {
  formGroup:FormGroup
  constructor(private komentarService:KomentarService,private router:Router,private route:ActivatedRoute) { }
id:string
  ngOnInit(): void {
    this.id=this.route.snapshot.paramMap.get("id")
    this.formGroup= new FormGroup({
      tekst:new FormControl(''),
      idPost:new FormControl('')
    })
  }

  kreirajNoviKomentar(){
    if(confirm("Da li ste sigurni da zelite da ostavite komentar")){

      this.komentarService.save(this.formGroup.value).subscribe(data=>{
        this.router.navigateByUrl("/posts")
      },(data=>{
        alert("Doslo je do greske prilikom dodavanja komentara")
        this.router.navigateByUrl("/posts")
      }))
    }
   
  }

}
