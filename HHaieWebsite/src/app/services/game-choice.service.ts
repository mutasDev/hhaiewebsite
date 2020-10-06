import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GameChoiceService {

  private gameChoice: string;
  constructor() { }


  chooseGame(game: string) {
    this.gameChoice = game;
  }

  getChosenGame(): string {
    return this.gameChoice? this.gameChoice : "none";
  }
}
