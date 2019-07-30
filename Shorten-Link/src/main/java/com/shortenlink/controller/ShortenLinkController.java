package com.shortenlink.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shortenlink.model.ShortenLinkRequest;
import com.shortenlink.model.ShortenLinkResponse;
import com.shortenlink.service.ShortenLinkService;

@RestController
@RequestMapping("/shorten-link")
public class ShortenLinkController {
	
	@Autowired
	private ShortenLinkService service;
	
	@PostMapping("/short-link")
	public ShortenLinkResponse shortLink(@RequestBody @Valid ShortenLinkRequest request) {
		return service.shortLink(request);
	}
	
	@GetMapping("/get-long-link")
	public ShortenLinkRequest getLongLink(@RequestBody @Valid ShortenLinkResponse request) {
		return service.getLongLink(request);
	}

}
