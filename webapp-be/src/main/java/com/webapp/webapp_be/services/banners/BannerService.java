package com.webapp.webapp_be.services.banners;

import com.webapp.webapp_be.dto.BannerDTO;
import com.webapp.webapp_be.models.Banner;
import com.webapp.webapp_be.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BannerService implements IBannerService {
    private final BannerRepository bannerRepository;
    @Override
    public Banner createBanner(BannerDTO bannerDTO) {
        Banner newBaner = Banner.builder()
                .title(bannerDTO.getTitle())
                .image(bannerDTO.getImage())
                .subtitle(bannerDTO.getSubtitle())
                .ctaText(bannerDTO.getCtaText())
                .ctaLink(bannerDTO.getCtaLink())
                .build();
        return bannerRepository.save(newBaner);
    }

    @Override
    public Banner updateBanner(Long id, BannerDTO bannerDTO) {
        Banner banner = bannerRepository.findById(id)
                .orElseThrow(() -> new DateTimeException("Cannot find banner with id = "+id));

        banner.setTitle(bannerDTO.getTitle());
        banner.setImage(bannerDTO.getImage());
        banner.setCtaText(bannerDTO.getCtaText());
        banner.setCtaLink(bannerDTO.getCtaLink());
        banner.setSubtitle(bannerDTO.getSubtitle());

        return bannerRepository.save(banner);
    }

    @Override
    public List<Banner> getAllBanner() {
        return bannerRepository.findAll();
    }

    @Override
    public Banner getBannerById(Long id) {
        return bannerRepository.findById(id)
                .orElseThrow(() -> new DateTimeException("Cannot find banner with id: "+id));
    }
}
