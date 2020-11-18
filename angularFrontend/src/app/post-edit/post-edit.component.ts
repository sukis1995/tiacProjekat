import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl,Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Post } from '../model/post';
import { PostServiceService } from '../post-service.service';

@Component({
  selector: 'app-post-edit',
  templateUrl: './post-edit.component.html',
  styleUrls: ['./post-edit.component.css']
})
export class PostEditComponent implements OnInit {
  post:Post
  id:string
  formGroup:FormGroup
  constructor(private postService:PostServiceService, private router:Router, private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.paramMap.get("id")
    this.postService.findOne(this.id).subscribe(data=>{
      this.post=data
    this.formGroup=new FormGroup({
        tekst:new FormControl(data.tekst,[Validators.required]),
        id:new  FormControl(data.id,[Validators.required])
      })
     
    },(data=>{
      alert("Doslo je do greske prilikom ucitavnja posta")
    }));
  
  }

  editPost(){
    if(confirm("Da li ste sigurni da zelite da promenite post"))
    this.postService.updatePost(this.formGroup.value).subscribe(data=>{
      alert("Uspesno ste editovali post");
      this.router.navigateByUrl("/posts")
    },(data=>{
      alert("Doslo je do greske prilikom edita posta");
      this.router.navigateByUrl("/posts")
    }))
  }

}
