import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Uno } from './uno/uno';
import { Due } from './due/due';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Uno, Due],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('07_ANG_intro');
}
