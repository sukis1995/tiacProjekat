import { Component, OnInit } from '@angular/core';
import { Post } from '../model/post';
import { PostServiceService } from '../post-service.service';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {
  posts:Post[];
  constructor(private postService:PostServiceService) { }

  ngOnInit(): void {
   this.postService.getAll().subscribe(data=>{
     console.log("Uspesno ucitani postovi")
      this.posts=data;
    
   })
  }

  


}
