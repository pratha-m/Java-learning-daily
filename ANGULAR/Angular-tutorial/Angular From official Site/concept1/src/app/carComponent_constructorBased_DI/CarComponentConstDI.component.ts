import { Component } from "@angular/core";
import { CarService } from "../carService/car.service";

@Component({
    selector:"car-component-constructor-based",
    templateUrl:"./CarComponentConstDI.component.html",
    standalone:true
})

export class CarComponentConstructorBaseDI{
    display=""
    constructor(private carService:CarService){
        this.display=this.carService.getCars().join("❤️");
    }
}