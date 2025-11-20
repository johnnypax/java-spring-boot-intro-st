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

  constructor(private service: LibroService) {
    console.log("Sono il costruttore di Lista")
  }

  ngOnInit() {
    this.renderizzaTabella();
  }

  private renderizzaTabella(): void {
    this.service.getAll().subscribe(
      {
        next: (res: Libro[]) => {
          this.elenco = res;
        },
        error: (err) => {

        }
      }
    )
  }

  elimina(isbn?: string): void {
    
  }
}
