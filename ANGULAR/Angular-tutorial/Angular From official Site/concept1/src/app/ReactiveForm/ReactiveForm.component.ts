import { Component } from "@angular/core";
import { FormControl, FormGroup, ReactiveFormsModule } from "@angular/forms";

@Component({
    selector:"reactive-form",
    templateUrl:"./ReactiveForm.component.html",
    imports:[ReactiveFormsModule],
    standalone:true
})

export class ReactiveFormComponent{
    profileForm=new FormGroup({
        name:new FormControl(''),
        email:new FormControl('')
    })

    handleSubmit(){
        alert(`
            User Name is 
            ${this.profileForm.value.name} 
            and Email is
            ${this.profileForm.value.email}
        `)
    }
}