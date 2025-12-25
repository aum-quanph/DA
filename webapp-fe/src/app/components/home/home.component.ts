import { CommonModule } from '@angular/common';
import { Component, CUSTOM_ELEMENTS_SCHEMA, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { CategoryService } from '../../services/category.service';
import { environment } from '../utils/appInfor';
import { ProductService } from '../../services/product.service';
import { Footer } from './footer/footer.component';
import { Header } from './header/header.component';
import { Banner } from "./banner/banner.component";
import { Product } from '../../models/product.entity';

@Component({
  selector: 'app-home',
  imports: [CommonModule, Footer, Header, Banner],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class HomeComponent implements OnInit {
  categories: any[] = [];
  products: Product[] = [];
  constructor(private router: Router,
    private productService: ProductService,
    private categoryService: CategoryService) {
  }
  ngOnInit(): void {
    this.getCategories();
    this.getProducts();
  }

  trackByProductId(index: number, item: any) {
    return item.id;
  }


  getCategories() {
    this.categoryService.getAllCategories().subscribe({
      next: (response: any) => {
        this.categories = response;
      },
      complete: () => {
        console.log('Finished fetching categories.');
      },
      error: (err) => {
        console.error('Error fetching categories: ', err);
      }
    });
  }

  getProducts() {
    this.productService.getProducts().subscribe({
      next: (response: any) => {
        response.forEach((product: any) => {
          product.url = `${environment.apiUrl}/products/images/${product.thumbnail}`;
        });
        this.products = response;
      },
      complete: () => {
        console.log("successfull");
      },
      error: (err: any) => {
        console.error(err);
      }
    })
  }

  scrollTop(): void {
    window.scrollTo({ top: 0, behavior: 'smooth' });
  }
}
