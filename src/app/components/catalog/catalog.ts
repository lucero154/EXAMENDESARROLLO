import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { CategoryService, Category } from '../../services/category.service';
import { ProductService, Product } from '../../services/product';

@Component({
  selector: 'app-catalog',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './catalog.html',
  styleUrls: ['./catalog.css']
})
export class Catalog implements OnInit {
  categories: Category[] = [];
  products: Product[] = [];
  selectedCategoryId!: number;

  constructor(
    private categoryService: CategoryService,
    private productService: ProductService
  ) {}

  ngOnInit(): void {
    this.categoryService.getCategories().subscribe(data => {
      this.categories = data;
    });
  }

  onCategoryChange(): void {
    this.productService
      .getProductsByCategory(this.selectedCategoryId)
      .subscribe(data => this.products = data);
  }
}
