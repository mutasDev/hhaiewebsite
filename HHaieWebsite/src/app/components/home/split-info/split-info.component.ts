import { Component, OnInit } from "@angular/core";
import { MatDialog } from "@angular/material";

@Component({
  selector: "app-split-info",
  templateUrl: "./split-info.component.html",
  styleUrls: ["./split-info.component.scss"],
})
export class SplitInfoComponent implements OnInit {
  constructor(private dialog: MatDialog) {}

  ngOnInit() {}

  onJoinClick() {
    const dialogref = this.dialog.open(DialogContent);

    dialogref.afterClosed().subscribe(result => console.log("ok"));
  }
}
export class DialogContent {}
