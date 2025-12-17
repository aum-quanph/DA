import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "../components/utils/appInfor";

export interface Category {
    name: string;
    description: string;
    image: string;
    url?: string;
}

@Injectable({
    providedIn: 'root',
})


export class CategoryService {
    constructor(private http: HttpClient) {}

    getAllCategories() {
        return this.http.get<Category[]>(`${environment.apiUrl}/categories`);
    }
}