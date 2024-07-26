
package com.backend.confee;

import com.backend.confee.entity.Sponsor;
import com.backend.confee.service.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class ConfeeApplication {

//	@Autowired
//	private SponsorService sponsorService;

	public static void main(String[] args) {
		SpringApplication.run(ConfeeApplication.class, args);
	}

//	@GetMapping
//	public String hello() {
//		return "Hello World";
//	}

//	@GetMapping("/api/sponsor/{sponsorId}")
//	public ResponseEntity<byte[]> getQrCode(@PathVariable String sponsorId) {
//		Sponsor sponsor = sponsorService.getSponsorBySponsorId(sponsorId);
//		if (sponsor != null) {
//			HttpHeaders headers = new HttpHeaders();
//			headers.add(HttpHeaders.CONTENT_TYPE, "image/png");
//			return new ResponseEntity<>(sponsor.getQrCodeImage(), headers, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
}

