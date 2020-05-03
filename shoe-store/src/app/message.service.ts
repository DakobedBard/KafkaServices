import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class MessageService {
  messages: string[] = [];

  tabName:string;
  strs: Array<string> = [];

  tabID: number;

  editTabMode: boolean = true;

  constructor(){}
  add(message: string) {
    this.messages.push(message);
  }

  clear() {
    this.messages = [];
  }
  setEditMode(edit:boolean){
    this.editTabMode = edit;
  }
  getEditMode():boolean{
    return this.editTabMode;
  }
}
