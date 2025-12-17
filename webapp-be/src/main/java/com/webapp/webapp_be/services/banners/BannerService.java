package com.webapp.webapp_be.services.banners;

import com.webapp.webapp_be.dto.BannerDTO;
import com.webapp.webapp_be.models.Banner;
import com.webapp.webapp_be.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BannerService implements IBannerService {
    private final BannerRepository bannerRepository;
    @Override
    public Banner createBanner(BannerDTO bannerDTO) {
        Banner newBaner = Banner.builder()

                .build();
        return null;
    }

    @Override
    public Banner updateBanner(Long id, BannerDTO bannerDTO) {
        return null;
    }

    @Override
    public Page<Banner> getAllBanner(PageRequest pageRequest) {
        return null;
    }

    @Override
    public Banner getBannerById(Long id) {
        return null;
    }
}
