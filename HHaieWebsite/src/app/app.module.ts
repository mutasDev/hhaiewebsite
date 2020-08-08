import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AboutScreenComponent } from './views/about-screen/about-screen.component';
import { NewsScreenComponent } from './views/news-screen/news-screen.component';
import { TopMenuComponent } from './components/general/top-menu/top-menu.component';
import { PlayerCardComponent } from './components/team/player-card/player-card.component';
import { TeamCardComponent } from './components/team/team-card/team-card.component';
import { GameSelectionComponent } from './components/game/game-selection/game-selection.component';
import { HomeScreenComponent } from './views/home-screen/home-screen.component';
import { TeamScreenComponent } from './views/team-screen/team-screen.component';
import { HeaderComponent } from './components/general/header/header.component';
import { ImpressumScreenComponent } from './views/impressum-screen/impressum-screen.component';
import { FAQScreenComponent } from './views/faqscreen/faqscreen.component';
import { SplitInfoComponent } from './components/home/split-info/split-info.component';
import { BigPanelComponent } from './components/general/big-panel/big-panel.component';

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
    TeamScreenComponent,
    HeaderComponent,
    ImpressumScreenComponent,
    FAQScreenComponent,
    SplitInfoComponent,
    BigPanelComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
