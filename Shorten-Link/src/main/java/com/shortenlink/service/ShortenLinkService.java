package com.shortenlink.service;

import javax.validation.Valid;

import com.shortenlink.model.ShortenLinkRequest;
import com.shortenlink.model.ShortenLinkResponse;

public interface ShortenLinkService {

	ShortenLinkResponse shortLink(@Valid ShortenLinkRequest request);

	ShortenLinkRequest getLongLink(@Valid ShortenLinkResponse request);

}
