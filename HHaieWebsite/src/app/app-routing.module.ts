import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeScreenComponent } from './views/home-screen/home-screen.component';
import { TeamScreenComponent } from './views/team-screen/team-screen.component';
import { AboutScreenComponent } from './views/about-screen/about-screen.component';
import { ImpressumScreenComponent } from './views/impressum-screen/impressum-screen.component';
import { FAQScreenComponent } from './views/faqscreen/faqscreen.component';
import { NewsScreenComponent } from './views/news-screen/news-screen.component';
import { ErstiViewComponent } from './views/ersti-view/ersti-view.component';
import { AdminScreenComponent } from './components/admin-screen/admin-screen.component';


const routes: Routes = [
  { path: '', component: HomeScreenComponent, pathMatch: "full"},
  { path: 'about', component: AboutScreenComponent, pathMatch: "full"},
  { path: 'teams', component: TeamScreenComponent, pathMatch: "full"},
  { path: 'impressum', component: ImpressumScreenComponent, pathMatch: "full"},
  { path: 'news', component: NewsScreenComponent, pathMatch: "full"},
  { path: 'faq', component: FAQScreenComponent, pathMatch: "full"},
  { path: 'erstis', component: ErstiViewComponent, pathMatch: "full"},
  { path: 'adminpage', component: AdminScreenComponent, pathMatch: "full"},
  { path: '**', component: HomeScreenComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
