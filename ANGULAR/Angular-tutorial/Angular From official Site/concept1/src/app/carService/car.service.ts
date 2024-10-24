import { Injectable } from "@angular/core";

@Injectable({
    providedIn:"root"
})

export class CarService{
    cars=["Sunflower GT","Flexus Sport","Sprout Mach one"];

    getCars():string[]{
        return this.cars;
    }
    getCar(id:number){
        return this.cars[id];
    }
}