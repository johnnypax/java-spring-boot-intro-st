import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { LibroService } from '../../services/libro-service';
import { Libro } from '../../models/libro';
import { Autore } from '../../models/autore';
import { Router } from '@angular/router';

@Component({
  selector: 'app-inserisci',
  imports: [FormsModule],
  templateUrl: './inserisci.html',
  styleUrl: './inserisci.css',
})
export class Inserisci {

  titolo?: string;
  prezzo?: number;
  isbn?: string;
  anno?: number;
  autore?: string;

  constructor(private service: LibroService, private router: Router){
    console.log("Sono il costruttore di Inserisci")
  }

  salva(): void{

    const a: Autore = new Autore();
    a.cod = this.autore;

    const l: Libro = new Libro();
    l.tit = this.titolo;
    l.pre = this.prezzo;
    l.ann = this.anno;
    l.isb = this.isbn;
    l.aut = a;

    this.service.insert(l).subscribe({
      next: (responso: Libro) => {
          alert("STAPPOOOO");
          this.router.navigateByUrl("lista");
      },
      error: (err) => {
        alert("errore");
        console.log(err);
      }
    })

    // this.service.insert(l)
    //   .then(responso => {
    //     if(responso){
    //       alert("STAPPOOOO");
    //       this.router.navigateByUrl("lista")
    //     }
          
    //     else
    //       alert("ERRORE");
    //   })
    //   .catch(errore => {
    //     console.log(errore);
    //   })


  }

}
