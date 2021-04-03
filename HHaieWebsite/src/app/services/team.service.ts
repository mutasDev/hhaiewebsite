import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Team } from '../model/team';

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  constructor(private httpClient: HttpClient) { }
  
  getTeamsByGame(game: String) {
   return this.httpClient.get("http://localhost:8080/team/game/"+ game);
  }
}
