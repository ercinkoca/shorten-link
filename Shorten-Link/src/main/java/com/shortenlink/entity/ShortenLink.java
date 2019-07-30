package com.shortenlink.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShortenLink {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String longLink;
	private String shortLink;

}
