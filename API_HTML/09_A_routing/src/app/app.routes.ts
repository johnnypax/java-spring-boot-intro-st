import { Routes } from '@angular/router';
import { Uno } from './uno/uno';
import { Due } from './due/due';
import { Tre } from './tre/tre';

export const routes: Routes = [
    { path: "", redirectTo: "uno", pathMatch: "full"},
    { path: "uno", component: Uno},
    { path: "due", component: Due},
    { path: "tre", component: Tre},
];
