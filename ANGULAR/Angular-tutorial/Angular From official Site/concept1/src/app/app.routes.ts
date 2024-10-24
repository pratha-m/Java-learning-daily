import { Routes } from '@angular/router';
import { FirstComponent } from './FirstComponent/First.component';
import { SecondComponent } from './SecondComponent/Second.component';
import { FormComponent } from './FormComponent/Form.component';

export const routes: Routes = [
    {path:"first-component",title:"First Componet",component:FirstComponent},
    {path:"second-component",title:"Second Component",component:SecondComponent},
    {path:"form-component",title:"Form Component",component:FormComponent}
];