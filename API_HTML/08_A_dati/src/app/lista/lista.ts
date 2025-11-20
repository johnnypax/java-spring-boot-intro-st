import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-lista',
  imports: [CommonModule, FormsModule],
  templateUrl: './lista.html',
  styleUrl: './lista.css',
})
export class Lista {

  frase: string = "Prova di frase";
  unione: string | undefined | number = "ciao";
  nullabile?: string;

  elenco: string[] = ["Pane", "Salame", "Cavoli"];

  ingrediente?: string;

  salvataggio(): void{
    console.log(this.ingrediente)

    if(this.ingrediente)
      this.elenco.push(this.ingrediente);

    this.ingrediente = "";
  }

}
