import { Route } from '@angular/compiler/src/core';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { KomentarService } from '../komentar.service';
import { Komentar } from '../model/komentar';

@Component({
  selector: 'app-komentar-item',
  templateUrl: './komentar-item.component.html',
  styleUrls: ['./komentar-item.component.css']
})
export class KomentarItemComponent implements OnInit {
@Input() komentar:Komentar
  constructor(private komentarService:KomentarService, private router:Router) { }

  ngOnInit(): void {
    
  }


  goToEdit(id){
    this.router.navigateByUrl("/komentari/"+id)
  }

  delete(id){
    console.log(id)
    this.komentarService.delete(id).subscribe(data=>{
      alert("Uspesno ste obrisali komenatr")
    }, (data=>{
      alert("Doslo je do greske prilikom brisanja")
    }))
  }
}
