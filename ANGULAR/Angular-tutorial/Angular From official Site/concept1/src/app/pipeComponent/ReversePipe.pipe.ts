import { Pipe, PipeTransform } from "@angular/core";

@Pipe({
    name:"reverse-pipe",
    standalone:true
})
export class ReversePipe implements PipeTransform{
    transform(value:String):String{
        if(!value) return "";
        return value.split("").reverse().join("");
    }
}