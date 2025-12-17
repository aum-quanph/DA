package com.webapp.webapp_be.repository;

import com.webapp.webapp_be.models.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannerRepository extends JpaRepository<Banner, Long> {
}
