import { Injectable } from '@angular/core';
import { Libro } from '../models/libro';

@Injectable({
  providedIn: 'root',
})
export class LibroService {
  
  async getAll(): Promise<Libro[]>{
    const response = await fetch("http://localhost:8082/api/libri");

    if(response.ok){
      const dati: Libro[] = await response.json();
      return dati;
    }

    return [];
  }

}
