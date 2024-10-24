import { CommonModule, CurrencyPipe, LowerCasePipe, PercentPipe, SlicePipe, UpperCasePipe } from "@angular/common";
import { Component } from "@angular/core";
import { ReversePipe } from "./ReversePipe.pipe";

@Component({
    selector:"pipe-component",
    templateUrl:"./PipeComponent.component.html",
    standalone:true,
    imports:[LowerCasePipe,UpperCasePipe,CurrencyPipe,PercentPipe,SlicePipe,CommonModule,ReversePipe]
})

export class PipeComponent{
    username="Pratham chhabra"
    price=100
    fraction=0.56

}