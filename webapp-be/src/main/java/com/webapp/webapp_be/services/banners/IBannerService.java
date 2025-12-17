package com.webapp.webapp_be.services.banners;

import com.webapp.webapp_be.dto.BannerDTO;
import com.webapp.webapp_be.models.Banner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IBannerService {
    Banner createBanner(BannerDTO bannerDTO);
    Banner updateBanner(Long id, BannerDTO bannerDTO);
    List<Banner> getAllBanner(PageRequest pageRequest);
    Banner getBannerById(Long id);
}
