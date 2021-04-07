import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { AboutScreenComponent } from "./views/about-screen/about-screen.component";
import { NewsScreenComponent } from "./views/news-screen/news-screen.component";
import { TopMenuComponent } from "./components/general/top-menu/top-menu.component";
import { PlayerCardComponent } from "./components/team/player-card/player-card.component";
import { TeamCardComponent } from "./components/team/team-card/team-card.component";
import { GameSelectionComponent } from "./components/game/game-selection/game-selection.component";
import { HomeScreenComponent } from "./views/home-screen/home-screen.component";
import { TeamScreenComponent } from "./views/team-screen/team-screen.component";
import { ImpressumScreenComponent } from "./views/impressum-screen/impressum-screen.component";
import { FAQScreenComponent } from "./views/faqscreen/faqscreen.component";
import {
  SplitInfoComponent,
} from "./components/home/split-info/split-info.component";
import { BigPanelComponent } from "./components/general/big-panel/big-panel.component";
import { DTITYComponent } from "./components/general/dtity/dtity.component";
import { LogoComponent } from "./components/general/logo/logo.component";
import { PartnerComponent } from "./components/home/partner/partner.component";
import { BottomBarComponent } from "./components/general/bottom-bar/bottom-bar.component";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { MatButtonModule } from "@angular/material/button";
import { MatCardModule } from "@angular/material/card";
import { MatTableModule } from "@angular/material/table";
import { MatDialogModule, MatIconModule, MatProgressBarModule, MatSnackBarModule, MatToolbarModule } from "@angular/material";
import { GameCardComponent } from "./components/game/game-card/game-card.component";
import { TeamSelectComponent } from "./components/team/team-select/team-select.component";
import { ErstiViewComponent } from "./views/ersti-view/ersti-view.component";
import { JoinComponent } from "./components/general/join/join.component";
import { AdminScreenComponent } from './components/admin-screen/admin-screen.component';
import { TeamService } from "./services/team.service";
import { HttpClient, HttpClientModule } from "@angular/common/http";
import { FileUploadComponent } from './components/general/file-upload/file-upload.component';
import { UploadSnackbarComponent } from './components/general/upload-snackbar/upload-snackbar.component';
import { SecureImageComponent } from './components/general/secure-image/secure-image.component';



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
    ImpressumScreenComponent,
    FAQScreenComponent,
    SplitInfoComponent,
    BigPanelComponent,
    DTITYComponent,
    LogoComponent,
    PartnerComponent,
    BottomBarComponent,
    GameCardComponent,
    TeamSelectComponent,
    ErstiViewComponent,
    JoinComponent,
    AdminScreenComponent,
    FileUploadComponent,
    UploadSnackbarComponent,
    SecureImageComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatToolbarModule,
    MatTableModule,
    MatDialogModule,
    HttpClientModule,
    MatIconModule,
    MatProgressBarModule,
    MatSnackBarModule,
  ],
  providers: [TeamService],
  bootstrap: [AppComponent],
  entryComponents: [JoinComponent, UploadSnackbarComponent],
})
export class AppModule {}
