import { Component, OnInit } from "@angular/core";
import { MatDialog } from "@angular/material";
import { JoinComponent } from '../../general/join/join.component';

@Component({
  selector: "app-split-info",
  templateUrl: "./split-info.component.html",
  styleUrls: ["./split-info.component.scss"],
})
export class SplitInfoComponent implements OnInit {
  constructor(private dialog: MatDialog) {}

  ngOnInit() {}

  onJoinClick() {
    const dialogref = this.dialog.open(JoinComponent, {
      height: '85%', width: '80%',
    });
  }
}
