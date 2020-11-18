import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { OcenaService } from '../ocena.service';

@Component({
  selector: 'app-ocena',
  templateUrl: './ocena.component.html',
  styleUrls: ['./ocena.component.css']
})
export class OcenaComponent implements OnInit {
  selected:number=0;
  hovered:number=0;
  readonly = false;
  rate:number=0;
  @Output()
  change: EventEmitter<number> = new EventEmitter<number>();
  @Input() idPost;
  constructor(private ocenaService:OcenaService) {
    
   }

  ngOnInit(): void {

  }

   oceni(value){
    
    //this.change.emit(value)
    console.log(value)
    console.log(this.idPost)
    this.ocenaService.postOcena(value,this.idPost).subscribe(data=>{
      alert("Uspesno ste ocenili post")
    }, (data=>{
      alert("Doslo je do greske prilikom ocenjivanja posta")
    }));

  }

  
}
