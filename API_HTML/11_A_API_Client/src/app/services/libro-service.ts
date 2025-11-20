import { Injectable } from '@angular/core';
import { Libro } from '../models/libro';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class LibroService {
  
  constructor(private httpClient: HttpClient){

  }

  getAll(): Observable<Libro[]>{
    return this.httpClient.get<Libro[]>("http://localhost:8082/api/libri");
  }

  insert(l: Libro): Observable<Libro>{
    return this.httpClient.post<Libro>("http://localhost:8082/api/libri", l);
  }

}
