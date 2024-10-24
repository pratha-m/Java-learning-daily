import { Component, inject } from "@angular/core";
import { CarService } from "../carService/car.service";

@Component({
    selector:"car-component",
    templateUrl:"./carComponent.component.html",
    standalone:true
})

export class CarComponent{
    display=""
    carService=inject(CarService)

    constructor(){
        this.display=this.carService.getCars().join(" , ")
    }

}