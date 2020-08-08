import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AboutScreenComponent } from './views/about-screen/about-screen.component';
import { NewsScreenComponent } from './views/news-screen/news-screen.component';
import { TopMenuComponent } from './components/top-menu/top-menu.component';
import { PlayerCardComponent } from './components/team/player-card/player-card.component';
import { TeamCardComponent } from './components/team/team-card/team-card.component';
import { GameSelectionComponent } from './components/game/game-selection/game-selection.component';
import { HomeScreenComponent } from './views/home-screen/home-screen.component';
import { TeamScreenComponent } from './views/team-screen/team-screen.component';

@NgModule({
  declarations: [
    AppComponent,
    AboutScreenComponent,
    NewsScreenComponent,
    TopMenuComponent,
    PlayerCardComponent,
    TeamCardComponent,
    GameSelectionComponent,
    HomeScreenComponent,
    TeamScreenComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
