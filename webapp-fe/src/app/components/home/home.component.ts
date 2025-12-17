import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { CategoryService } from '../../services/category.service';
import { environment } from '../utils/appInfor';
import { ProductService } from '../../services/product.service';

@Component({
  selector: 'app-home',
  imports: [CommonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent implements OnInit {
  categories: any[] = [];
  products: any[] = [];
  constructor(private router: Router,
    private productService: ProductService,
    private categoryService: CategoryService) {
  }
  ngOnInit(): void {
    this.getCategories();
    this.getProducts();
  }

  trackByProductId(index: number, item: any) {
    return item.id; // hoặc item._id tùy API
  }


  getCategories() {
    this.categoryService.getAllCategories().subscribe({
      next: (response: any) => {
        // response.categories.forEach((category: any) => {
        //   category.url = `${environment.apiUrl}/categories/images/${category.image}`;
        // });
        this.categories = response;
        console.log('Categories: ', response);
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
        // response.products.forEach((product: any) => {
        //   product.url = `${environment.apiUrl}/products/images/${product.image}`
        // });
        this.products = response;
        console.log('products: ', response);
      },
      complete: () => {
        console.log("successfull");
      },
      error: (err: any) => {
        console.error(err);
      }
    })
  }
}
