import { CommonModule, NgOptimizedImage } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { StudentComponent } from './student/student.component';
import { ChildComponent } from './child/child.component';
import { commentsComponent } from './comments/comment.component';
import { FormComponent } from './FormComponent/Form.component';
import { ReactiveFormComponent } from './ReactiveForm/ReactiveForm.component';
import { ValidatorFormComponent } from './ValidatorForm/ValidatorForm.component';
import { CarComponent } from './carComponent/carComponent.component';
import { CarComponentConstructorBaseDI } from './carComponent_constructorBased_DI/CarComponentConstDI.component';
import { PipeComponent } from './pipeComponent/PipeComponent.component';

interface EachStudent{
  studentName:string;
  studentZipCode:number;
  studentCity:string;
  studentId:number
}
interface user{
  id:number;
  name:string;
}
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    FormsModule,CommonModule,StudentComponent,ChildComponent,commentsComponent,NgOptimizedImage,
    RouterOutlet,RouterLink,RouterLinkActive,FormComponent,ReactiveFormComponent,ValidatorFormComponent,
    CarComponent,CarComponentConstructorBaseDI,PipeComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  // ***Expressions concept***
  // title = 'concept1';
  // name:string="Pratham chhabra"
  // city:string="Rajpura";
  // zipCode:number=123;

  // ***Two way data binding,ngModel,ngFor concepts***
  // studentName:string="";
  // studentZipCode:number=0;
  // studentCity:string="";
  // students:Array<EachStudent>=new Array<EachStudent>;
  // AddStudent(){
  //   let studId:number=this.students.length+1;
  //   this.students.push({
  //     studentName:this.studentName,
  //     studentCity:this.studentCity,
  //     studentZipCode:this.studentZipCode,
  //     studentId:studId
  //   });
  //   this.studentName="";
  //   this.studentCity="";
  //   this.studentZipCode=0;
  // }
  // deleteStudent(studId:number){
  //   this.students=this.students.filter((eachStud)=>eachStud.studentId!==studId);
  // }

  // @if and @else 
  // isServerRunning:boolean=true;
  
  // @for
  // users:Array<user>=[
  //   {id: 0, name: 'Sarah'},
  //   {id: 1, name: 'Amy'}, 
  //   {id: 2, name: 'Rachel'}, 
  //   {id: 3, name: 'Jessica'}, 
  //   {id: 4, name: 'Poornima'}
  // ];

  // Property Binding in Angular
  // isEditable:boolean=true;

  // Event handling
  // message:string="Mouse over";
  // onMouseOver(){
  //   alert(this.message);
  // }

  // Component Communication with @Input
  // studentName:string="Simran";
  // studentCity:string="Rajpura";
  // studentZipCode:number=1234;

  // Component Communication with @Output
  // To create the communication path from child to parent components, use the @Output decorator on a class property and assign it a value of type
  // items=new Array();
  // addItem(item:String){
  //   this.items.push(item)
  // }

  // Optimizing images
  // logoUrl = '/assets/logo.svg';
  // logoAlt = 'Angular logo';
  // username = 'youngTech';
}