import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginServiceService } from '../login-service.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private loginService:LoginServiceService, private router:Router) { }

  ngOnInit(): void {
    this.loginService.logout();
    this.router.navigateByUrl("/home");

  }

}
