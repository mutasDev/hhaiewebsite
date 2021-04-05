import { Subscription } from "rxjs";

export class FileUpload {
    data: File;
    state: string;
    inProgress: boolean;
    progress: number;
    canRetry: boolean;
    canCancel: boolean;
    sub?: Subscription
    contextId?: string;
}