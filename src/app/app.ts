import { Component } from '@angular/core';
import { Catalog } from './components/catalog/catalog';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [Catalog],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {}
