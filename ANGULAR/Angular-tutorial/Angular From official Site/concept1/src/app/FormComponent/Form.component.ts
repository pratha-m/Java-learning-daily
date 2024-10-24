import { Component } from "@angular/core";
import { FormsModule } from "@angular/forms";

@Component({
    selector:"app-form",
    templateUrl:"./Form.component.html",
    standalone:true,
    imports:[FormsModule]
})
export class FormComponent{
    favoriteFramework:string="";
    username:string="pratham"

    showAlert(){
        alert(this.favoriteFramework);
    }
}