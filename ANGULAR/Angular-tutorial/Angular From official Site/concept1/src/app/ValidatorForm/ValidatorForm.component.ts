import { Component } from "@angular/core";
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from "@angular/forms";

@Component({
    selector:"validator-form",
    templateUrl:"./ValidatorForm.component.html",
    imports:[ReactiveFormsModule],
    standalone:true
})
export class ValidatorFormComponent{
    profileForm=new FormGroup({
        name:new FormControl('',Validators.required),
        email:new FormControl('',[Validators.required,Validators.email])
    })
}