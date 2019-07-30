package com.shortenlink.service.impl;

import java.util.Optional;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shortenlink.entity.ShortenLink;
import com.shortenlink.exception.BadRequestException;
import com.shortenlink.exception.NotFoundException;
import com.shortenlink.model.ShortenLinkRequest;
import com.shortenlink.model.ShortenLinkResponse;
import com.shortenlink.repository.ShortenLinkRepository;
import com.shortenlink.service.ShortenLinkService;

@Service
public class ShortenLinkServiceImpl implements ShortenLinkService {
	
	@Autowired
	private ShortenLinkRepository shortenLinkRepo;
	
	
	@Override
	public ShortenLinkResponse shortLink(@Valid ShortenLinkRequest request) {
		
			ShortenLinkResponse response=new ShortenLinkResponse();
			ShortenLink shortenLink=new ShortenLink();
			shortenLink.setLongLink(request.getLongLink());
			if(request.getLongLink().isEmpty() || request.getLongLink().startsWith(" ") || request.getLongLink().equals("")) {
				throw new BadRequestException(-300, "The request must not be empty or start with a space", "The request must not be empty or start with a space");
			}
			shortenLink.setShortLink(createShortLink(request.getLongLink()));
			Optional<ShortenLink> optShortenLink=shortenLinkRepo.findByLongLink(shortenLink.getLongLink());
			if(!optShortenLink.isPresent()) {
				shortenLinkRepo.save(shortenLink);
				response.setShortLink(shortenLink.getShortLink());
			}else {
				response.setShortLink(optShortenLink.get().getShortLink());
			}
			return response;
	}
	
	
	@Override
	public ShortenLinkRequest getLongLink(@Valid ShortenLinkResponse request) {
		Optional<ShortenLink> shortenLink=shortenLinkRepo.findByShortLink(request.getShortLink());
		ShortenLinkRequest response=new ShortenLinkRequest();
		if(!shortenLink.isPresent()) {
			throw new NotFoundException(-400, "There is no short link", "There is no short link");
		}else {
			response.setLongLink(shortenLink.get().getLongLink());
		}
		return response;
	}
	
	
	
	private static String createShortLink(String baseUrl) {
		StringBuilder shortLink=new StringBuilder("");
	    int leftLimit = 65; // letter 'A'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 20;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
	        while(91<=randomLimitedInt && 96>=randomLimitedInt) { // written to avoid non-letter symbols.
	        	randomLimitedInt=leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
	        }
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	    String[] baseArray=null;
	    baseArray=baseUrl.split("/");
	    if((baseUrl.contains("http") || baseUrl.contains("https")) && baseArray.length>2) {
	    	shortLink.append(baseArray[0]+"//"+baseArray[2]);
	    }else {
	    	shortLink.append(baseArray[0]);
	    }
	    shortLink.append("/");
	    shortLink.append(generatedString);
		return shortLink.toString();
	}



	


}
