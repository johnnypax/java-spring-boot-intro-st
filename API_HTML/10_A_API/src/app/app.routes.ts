import { Routes } from '@angular/router';
import { Lista } from './components/lista/lista';
import { Inserisci } from './components/inserisci/inserisci';

export const routes: Routes = [
    {path: "", redirectTo: "lista", pathMatch: "full"},
    {path: "lista", component: Lista},
    {path: "inserisci", component: Inserisci}
];
