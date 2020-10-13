import { ChangeDetectorRef, Component, Input, OnInit } from "@angular/core";
import { GameChoiceService } from "src/app/services/game-choice.service";

@Component({
  selector: "app-game-card",
  templateUrl: "./game-card.component.html",
  styleUrls: ["./game-card.component.scss"],
})
export class GameCardComponent implements OnInit {
  @Input()
  public game: string;

  public title: string;
  private titles: Map<string, string> = new Map<string, string>();
  private texts: Map<string, string> = new Map<string, string>();
  public text: string;
  private gameChoiceService: GameChoiceService;
  private cd: ChangeDetectorRef;

  constructor(gameChoiceService: GameChoiceService, cd: ChangeDetectorRef) {
    this.gameChoiceService = gameChoiceService;
    this.cd = cd;
  }

  getGame(): string {
    return this.gameChoiceService.getChosenGame();
  }

  ngOnInit() {
    this.setup();
  }

  initialize() {
    this.title = this.titles.get(this.getGame());
    this.text = this.texts.get(this.getGame());
    this.cd.detectChanges();
  }

  changeGame(event: string) {
    this.gameChoiceService.chooseGame(event);
    this.initialize();
  }

  ngOnChanges() {
    this.initialize();
  }

  setup() {
    this.titles.set("lol", "League of Legends");
    this.titles.set("rl", "Rocket League");
    this.titles.set("cs", "Counter Strike");
    this.titles.set("ow", "Overwatch");
    this.titles.set("r6", "Rainbow 6: Siege");
    this.titles.set("hs", "Hearthstone");
    this.titles.set("ssbu", "Super Smash Bros. Ultimate");
    this.titles.set("vl", "Valorant");

    this.texts.set(
      "lol",
      "Seinen Ursprung hat unser erstes LoL Team auf der LAN-Party der TUHH. Seit der 3. Season der Uniliga (damals noch UEG) sind wir in der Uniliga dabei (WS16/17). Dort sind wir direkt über den Sieg im Wildcard-Turnier in die 1. Liga eingestiegen und haben am Ende der Season  sogar den 1. Platz geholt. Im anschließenden Sommersemester haben wir Deutschland international vertreten: 3. Platz im European Qualifier des International College Cup Qualifiers (Online),    2. Platz im Finale der University eSports Masters in Porto (Portugal) und 2. Platz auf der Milan Games Week in Mailand (Italien). Nach einigen weniger erfolgreichen Seasons und dem Rebranding zu den Hamburger Haien, sind wir nun bereit wieder oben in der Uniliga mitzumischen. Aktuell stellen wir mehrere Teams aus allen Skill-Leveln von Gold bis High Master. Wenn ihr Interesse habt, selber kompetitiv zu spielen, meldet euch bei uns."
    );

    this.texts.set(
      "rl",
      "Unsere Rocket League Abteilung besteht zwar erst seit gut einem Jahr, jedoch konnten wir uns bereits von Anfang an für die 1. Liga qualifizieren und holten letztes Semester sogar den 3. Platz. Aktuell haben wir als einzige Organisation in Rocket League sogar zwei Teams in der 1. Liga. Neben der Uniliga stellen wir auch Teams in der Nitro League. Unsere Teams bewegen sich aktuell in den Skill-Leveln von Diamond bis Grand-Champ. Wir freuen uns immer über Verstärkung, also melde dich, wenn du Interesse hast."
    );

    this.texts.set(
      "cs",
      "Auch unsere CS:GO Abteilung ist noch recht jung. Trotzdem konnten wir bereits zwei Aufstiege in die 2. Liga feiern und streben in dieser Saison den Aufstieg in die 1. Liga an. Aktuell stellen wir Teams aus allen Skill-Leveln von LE bis Facit 10. Wenn du Lust auf kompetitives CS:GO hast, dann schreib uns an."
    );

    this.texts.set(
      "r6",
      "Rainbow 6 startet dieses Semester das erste Mal in der Uniliga. Wir sind natürlich auch schon mit einem Team dabei und suchen immer weitere Verstärkung für diese und kommende Seasons. Also melde dich, wenn du Interesse hast."
    )

    this.texts.set(
      "ow",
      "In Overwatch sind wir seit letzter Season vertreten. Dort konnten wir uns direkt für die 1. Liga qualifizieren. Nach einer erfolgsarmen Season stellen wir uns nun neu auf und wollen mit mindestens einem Team erneut in der Uniliga mitmischen. Unsere Overwatch Abteilung freut sich immer über Verstärkung, also melde dich gerne!"
    )

    this.texts.set(
      "hs",
      "Auch in Hearthstone vertreten wir die Hamburger Unis in der Uniliga. Wenn auch du Lust hast, für Hamburg in der Uniliga mitzumischen, melde dich gerne bei uns."
    )

    this.texts.set(
      "vl",
      "Valorant startet diese Season zum ersten Mal in der Uniliga und auch dort planen wir die Hamburger Unis zu vertreten. Aktuell befindet sich unser Roster in der Planung, also melde dich gerne, falls du Interesse hast!"
    )

    this.texts.set(
      "ssbu",
      "Bisher wird Smash noch nicht in der Uniliga gespielt, jedoch ist dies in nächster Zeit geplant. Wir haben bereits einige Spieler die in der Hamburger Smashszene unterwegs sind und freuen uns immer über Verstärkung. "
    )
    this.initialize();
  }
}
