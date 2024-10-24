// Component Communication with @Input
import { Component,Input } from "@angular/core";

@Component({
    selector:"app-student",
    templateUrl:"./student.component.html",
    styleUrls:["./student.component.css"],
    standalone:true
})
export class StudentComponent{
    @Input() studentName:string="";
    @Input() studentCity:string="";
    @Input() studentZipCode:number=0;
}