import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { KomentarService } from '../komentar.service';
import { Post } from '../model/post';
import { PostServiceService } from '../post-service.service';

@Component({
  selector: 'app-post-item',
  templateUrl: './post-item.component.html',
  styleUrls: ['./post-item.component.css']
})
export class PostItemComponent implements OnInit {
  @Input() post:Post
  prikazani:boolean
  constructor(private postService:PostServiceService, private router: Router, private komentarService:KomentarService) { }

  ngOnInit(): void {
  }


  prikaziKomentare(){
    
    this.prikazani=!this.prikazani;
  }

  obrisiPost(id){
    if(confirm("Da li ste sigurni da zelite da obrisete post?")){
      this.postService.deletePost(id).subscribe(data=>{
        console.log("Uspesno obrisan post")
      },(data=>{
        alert("Doslo je do greske prilokkm brisanja posta")
      }))
    }
   
  }

  promeniPost(id){
    this.router.navigateByUrl("/posts/edit/"+id)
  }
  dodajKomentar(idPost){
    this.router.navigateByUrl("/posts/"+ idPost+"/komentar");
  }

}
