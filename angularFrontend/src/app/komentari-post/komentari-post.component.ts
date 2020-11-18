import { Component, Input, OnInit } from '@angular/core';
import { KomentarService } from '../komentar.service';
import { Komentar } from '../model/komentar';

@Component({
  selector: 'app-komentari-post',
  templateUrl: './komentari-post.component.html',
  styleUrls: ['./komentari-post.component.css']
})
export class KomentariPostComponent implements OnInit {
  @Input() id:string
  komentari:Komentar[]
  constructor(private komenatService:KomentarService) { }

  ngOnInit(): void {
    this.komenatService.findByPost(this.id).subscribe(data=>{
      this.komentari=data;
    });
  }

}
