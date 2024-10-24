import { Component, EventEmitter, Output } from "@angular/core";

@Component({
    selector:"app-child",
    templateUrl:"./child.component.html",
    styleUrls:["./child.component.css"],
    standalone:true
})
export class ChildComponent{
    @Output() addItemEvent = new EventEmitter<string>();
    addItem(){
        this.addItemEvent.emit("helllo")
    }
}