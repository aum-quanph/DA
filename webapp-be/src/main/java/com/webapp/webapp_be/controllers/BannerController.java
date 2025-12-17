package com.webapp.webapp_be.controllers;

import com.webapp.webapp_be.dto.BannerDTO;
import com.webapp.webapp_be.models.Banner;
import com.webapp.webapp_be.services.banners.IBannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/banners")
@RequiredArgsConstructor
public class BannerController {
    private final IBannerService bannerService;

    @PostMapping("")
    public ResponseEntity<?> createBanner(@RequestBody BannerDTO bannerDTO) {
        try {
            Banner newBanner = bannerService.createBanner(bannerDTO);
            return ResponseEntity.ok(newBanner);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public String updateBanner() {
        return null;
    }
}
