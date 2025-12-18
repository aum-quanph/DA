package com.webapp.webapp_be.controllers;

import com.webapp.webapp_be.dto.BannerDTO;
import com.webapp.webapp_be.models.Banner;
import com.webapp.webapp_be.services.banners.IBannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBanner(@PathVariable("id") Long id, @RequestBody BannerDTO bannerDTO) {
        try {
            bannerService.updateBanner(id, bannerDTO);
            return ResponseEntity.ok(String.format("Update banner with id = %d success full", id));
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Banner> getBannerById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(bannerService.getBannerById(id));
    }

    @GetMapping("")
    public ResponseEntity<List<Banner>> getAllbanner() {
        return ResponseEntity.ok(bannerService.getAllBanner());
    }

}
