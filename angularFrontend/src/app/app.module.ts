import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { AppComponent } from './app.component';
import { SecurityComponent } from './security/security.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './home/home.component';
import { PostsComponent } from './posts/posts.component';
import { AuthApiCallService } from './auth-api-call.service';
import { LogoutComponent } from './logout/logout.component';
import { PostItemComponent } from './post-item/post-item.component';
import { PostCreateComponent } from './post-create/post-create.component';
import { PostEditComponent } from './post-edit/post-edit.component';
import { KomentarItemComponent } from './komentar-item/komentar-item.component';
import { KomentariPostComponent } from './komentari-post/komentari-post.component';
import { RegistrationComponent } from './registration/registration.component';
import { OcenaComponent } from './ocena/ocena.component';
import { KomentariCreateComponent } from './komentari-create/komentari-create.component';
import { KomentarEditComponent } from './komentar-edit/komentar-edit.component';
@NgModule({
  declarations: [
    AppComponent,
    SecurityComponent,
    LoginComponent,
    HomeComponent,
    PostsComponent,
    LogoutComponent,
    PostItemComponent,
    PostCreateComponent,
    PostEditComponent,
    KomentarItemComponent,
    KomentariPostComponent,
    RegistrationComponent,
    OcenaComponent,
    KomentariCreateComponent,
    KomentarEditComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule

  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthApiCallService, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
