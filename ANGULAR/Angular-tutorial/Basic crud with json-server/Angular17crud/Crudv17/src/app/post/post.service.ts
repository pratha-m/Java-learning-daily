import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { Post } from './post';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private apiURL="https://jsonplaceholder.typicode.com";

  httpOptions={
    headers:new HttpHeaders({
      "Content-Type":"application/json"
    })
  }

  constructor(private httpClient:HttpClient) { }
  // get all method
  getAll():Observable<any>{
    return this.httpClient.get(this.apiURL+"/posts/")
  }

  // craete
  create(post:Post):Observable<any>{
    return this.httpClient.post(
      this.apiURL+"/posts/",
      JSON.stringify(post),
      this.httpOptions
    ).pipe(catchError((error:HttpErrorResponse)=>{
      return throwError(()=>new Error(error.message));
    }))
  }

  //find data by id
  find(id:number):Observable<any>{
    return this.httpClient.get(this.apiURL+"/posts/"+id).pipe(catchError((error:HttpErrorResponse)=>{
      return throwError(()=>new Error(error.message));
    }))
  }

  // update
  update(id:number,post:Post):Observable<any>{
    return this.httpClient.put(
      this.apiURL+"/posts/"+id,
      JSON.stringify(post),
      this.httpOptions
    ).pipe(catchError((error:HttpErrorResponse)=>{
      return throwError(()=>new Error(error.message));
    }))
  }

  // delete
  delete(id:number){
    return this.httpClient.delete(
      this.apiURL+"/posts/"+id
    ).pipe(catchError((error:HttpErrorResponse)=>{
      return throwError(()=>new Error(error.message));
    }))
  }
}
