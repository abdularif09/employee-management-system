import { Injectable } from '@angular/core';

import { HttpClient,HttpParams } from '@angular/common/http';
import { Observable,throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeServiceService {
  baseUrl ="http://localhost:8095/";

  constructor(private http:HttpClient) { }

  get<T>(url: string, params?: HttpParams): Observable<T> {
    return this.http.get<T>(this.baseUrl+ url, { params });
  }

  post<T>(url: string, body: any): Observable<T> {
    return this.http.post<T>( this.baseUrl+ url, body);
  }

  put<T>(url: string, body: any): Observable<T> {
    return this.http.put<T>( this.baseUrl+ url, body);
  }

  delete<T>(url: string): Observable<T> {
    return this.http.delete<T>( this.baseUrl+ url);
  }

}
