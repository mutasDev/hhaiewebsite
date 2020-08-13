import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeScreenComponent } from './views/home-screen/home-screen.component';
import { TeamScreenComponent } from './views/team-screen/team-screen.component';
import { AboutScreenComponent } from './views/about-screen/about-screen.component';
import { ImpressumScreenComponent } from './views/impressum-screen/impressum-screen.component';
import { FAQScreenComponent } from './views/faqscreen/faqscreen.component';


const routes: Routes = [
  { path: '', component: HomeScreenComponent},
  { path: 'about', component: AboutScreenComponent},
  { path: 'teams', component: TeamScreenComponent},
  { path: 'impressum', component: ImpressumScreenComponent},
  { path: 'faq', component: FAQScreenComponent},
  { path: '**', component: HomeScreenComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
