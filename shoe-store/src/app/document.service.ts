import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import { Product } from './product';
import { MessageService } from './message.service';


@Injectable({ providedIn: 'root' })
export class Service {

  private productsURL = 'http://localhost:8035/products/';
  documents: any = [];
  httpOptions:any = { 
    headers: new HttpHeaders({
      'Content-Type': 'multipart/form-data'
    }),
  }; 

  constructor(
    private http: HttpClient,
    private messageService: MessageService) { }

  /** GET documents from the server */

  getProducts(id: any) {
    return this.http.get(this.productsURL+'/list/');

  }


  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  /** Log a DocumentService message with the MessageService */
  private log(message: string) {
    this.messageService.add(`Service: ${message}`);
  }
}
