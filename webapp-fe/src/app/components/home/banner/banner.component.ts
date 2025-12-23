import { Component, CUSTOM_ELEMENTS_SCHEMA, OnInit } from '@angular/core';
import { BannerService } from '../../../services/banner.service';
import { NgFor } from '@angular/common';
@Component({
  selector: 'app-banner',
  imports: [NgFor],
  templateUrl: './banner.component.html',
  styleUrl: './banner.component.scss',
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class Banner implements OnInit {
  banners: any [] = [];
  constructor(private bannerService: BannerService) {}

  ngOnInit(): void {
    this.getAllBanner();
  }

  getAllBanner() {
    this.bannerService.getAllBanner().subscribe({
      next: ((response: any) => {
        this.banners = response;
      }),
      complete: () => {
        console.log("fetch data banner success full");
      },
      error: (err) => {
        console.error("error: ", err);
      }
    })
  }
}