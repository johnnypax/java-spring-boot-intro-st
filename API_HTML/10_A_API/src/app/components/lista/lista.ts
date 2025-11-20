import { Component } from '@angular/core';
import { LibroService } from '../../services/libro-service';
import { Libro } from '../../models/libro';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-lista',
  imports: [CommonModule],
  templateUrl: './lista.html',
  styleUrl: './lista.css',
})
export class Lista {

  elenco: Libro[] = [];

  constructor(private service: LibroService){

  }

  ngOnInit(){
    this.service.getAll()
      .then(dati => {
        this.elenco = dati;
      })
      .catch(errore => {
        console.log(errore);
      })
  }

}
