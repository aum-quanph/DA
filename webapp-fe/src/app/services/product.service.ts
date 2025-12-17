import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "../components/utils/appInfor";

export interface Product {
    name: string;
    description: string;
    image: string;
    url?: string;
}

@Injectable({
    providedIn: 'root',
})


export class ProductService {
    constructor(private http: HttpClient) {}

    getProducts() {
        return this.http.get<Product[]>(`${environment.apiUrl}/products`);
    }
}