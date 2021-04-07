import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Team } from 'src/app/model/team';
import { FileUploadService } from 'src/app/services/file-upload.service';
import { TeamService } from 'src/app/services/team.service';
import { resolve } from 'url';

@Component({
  selector: 'app-admin-screen',
  templateUrl: './admin-screen.component.html',
  styleUrls: ['./admin-screen.component.scss']
})
export class AdminScreenComponent implements OnInit {


  public imageId: string;

  constructor(private teamService: TeamService,
    private cd: ChangeDetectorRef
  ) { }

  public teamG: Team[] = []


  public displayedColumns: string[] = ['Forename', 'Lastname', 'Nickname', 'Position']

  ngOnInit() {
    this.teamService.getTeamsByGame("RL").subscribe((x: Team[]) => {
      this.teamG = x;
    })

  }


  onUploadFinished(event: any) {
    console.log(event);
    this.imageId = event[0].id;
  }



}
