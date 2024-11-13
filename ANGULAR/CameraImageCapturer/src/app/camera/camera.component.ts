import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { WebcamImage, WebcamModule } from 'ngx-webcam';
import { Observable, Subject } from 'rxjs';

@Component({
  selector: 'app-camera',
  standalone: true,
  imports: [CommonModule,WebcamModule],
  templateUrl: './camera.component.html',
  styleUrl: './camera.component.css'
})
export class CameraComponent {
  title="CAMERA"
  public webcamImage:WebcamImage | null=null;
  private trigger:Subject<void>=new Subject<void>;
  public showWebcam:boolean=false;

  toggleWebcam():void{
    this.showWebcam=!this.showWebcam; 
  }

  triggerSnapshot():void{
    this.trigger.next();
  }
  handleImage(webcamImage:WebcamImage):void{
    // console.log("Saved Web image ",webcamImage);
    this.webcamImage=webcamImage;
    console.log(this.webcamImage.imageAsBase64)
  }
  public get triggerObservable():Observable<void>{
    return this.trigger.asObservable();
  }

}


