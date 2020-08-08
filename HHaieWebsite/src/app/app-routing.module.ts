import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeScreenComponent } from './views/home-screen/home-screen.component';
import { TeamScreenComponent } from './views/team-screen/team-screen.component';
import { AboutScreenComponent } from './views/about-screen/about-screen.component';


const routes: Routes = [
  { path: '', component: HomeScreenComponent},
  { path: 'about', component: AboutScreenComponent},
  { path: 'teams', component: TeamScreenComponent},
  { path: '**', component: HomeScreenComponent },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
