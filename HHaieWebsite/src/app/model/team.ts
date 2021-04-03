import { Player } from "./player";

export interface Team {
    id?: number,
    game?: String,
    league?: String,
    name?: String,
    players?: Player[],
}

