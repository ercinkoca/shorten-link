package com.shortenlink.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shortenlink.entity.ShortenLink;

@Repository
public interface ShortenLinkRepository extends JpaRepository<ShortenLink, Long> {
	
	Optional<ShortenLink> findByLongLink(String longLink);
	Optional<ShortenLink> findByShortLink(String shortLink);

}
