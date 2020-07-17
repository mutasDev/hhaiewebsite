import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AboutScreenComponent } from './views/about-screen/about-screen.component';
import { GameOverviewScreenComponent } from './views/game-overview-screen/game-overview-screen.component';
import { TeamOverviewScreenComponent } from './views/team-overview-screen/team-overview-screen.component';
import { NewsScreenComponent } from './views/news-screen/news-screen.component';

@NgModule({
  declarations: [
    AppComponent,
    AboutScreenComponent,
    GameOverviewScreenComponent,
    TeamOverviewScreenComponent,
    NewsScreenComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
