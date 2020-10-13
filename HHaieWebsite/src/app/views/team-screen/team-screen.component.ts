import { ChangeDetectorRef, Component, OnInit } from "@angular/core";
import { GameChoiceService } from "src/app/services/game-choice.service";

@Component({
  selector: "app-team-screen",
  templateUrl: "./team-screen.component.html",
  styleUrls: ["./team-screen.component.scss"],
})
export class TeamScreenComponent implements OnInit {
  public game: string;

  private gameChoiceService: GameChoiceService;

  constructor(
    gameChoiceService: GameChoiceService,
    private cd: ChangeDetectorRef
  ) {
    this.gameChoiceService = gameChoiceService;
  }

  ngOnInit() {
    this.game = this.gameChoiceService.getChosenGame();
  }

  changeGame() {
    this.game = this.gameChoiceService.getChosenGame();
    this.cd.detectChanges();
  }
}
