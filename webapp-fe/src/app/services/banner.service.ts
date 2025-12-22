import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "../components/utils/appInfor";
import { BannerResponse } from "../responses/banner/banner.response";

@Injectable({
    providedIn: 'root',
})

class BannerService {
    constructor(private http: HttpClient) {}

    getAllBanner() {
        return this.http.get(`${environment.apiUrl}/banners`)
    }
}