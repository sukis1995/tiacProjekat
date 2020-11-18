import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component"
import { KomentarEditComponent } from './komentar-edit/komentar-edit.component';
import { KomentariCreateComponent } from './komentari-create/komentari-create.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { PostCreateComponent } from './post-create/post-create.component';
import { PostEditComponent } from './post-edit/post-edit.component';
import { PostsComponent } from './posts/posts.component';
import { RegistrationComponent } from './registration/registration.component';
const routes: Routes = [
  {path:"home", component:HomeComponent},
  {path:"login", component:LoginComponent},
  {path:"posts", component:PostsComponent},
  {path:"logout", component:LogoutComponent},
  {path:"newPost", component:PostCreateComponent},
  {path:"posts/edit/:id", component:PostEditComponent},
  {path:"registration", component:RegistrationComponent},
  {path:"posts/:id/komentar", component:KomentariCreateComponent},
  {path:"komentari/:id", component:KomentarEditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }