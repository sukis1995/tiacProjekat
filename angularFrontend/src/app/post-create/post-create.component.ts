import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { PostServiceService } from '../post-service.service';

@Component({
  selector: 'app-post-create',
  templateUrl: './post-create.component.html',
  styleUrls: ['./post-create.component.css']
})
export class PostCreateComponent implements OnInit {
  formGroup: FormGroup;

  constructor(private postService:PostServiceService, private router:Router) { }

  ngOnInit(): void {
    this.formGroup= new FormGroup({
      tekst:new FormControl('')
    })
  }


  kreirajNoviPost(){
  
    if(confirm("Da li ste sigurni?")){
      this.postService.createPost(this.formGroup.value).subscribe(data=>{
        this.router.navigateByUrl("/posts")
    },(data=>{
      alert("Doslo je do greske prilikom kreiranja novog posta")
    }))
    }else{
      this.router.navigateByUrl("/posts")
    }
    
  }
}
