package com.fanatics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fanatics.models.Review;
import com.fanatics.service.ReviewService;

@CrossOrigin
@RestController
@RequestMapping("/review")
public class ReviewController {
	
	@Autowired
	private ReviewService service;

	/**
	 * returns results from a GET method
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Review> getAll(){
		return service.getAll();
	} 
	
	/**
	 * GET BY review_id method
	 * @param id
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value="/{id}",
					method=RequestMethod.GET, 
					produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Review> findById(@PathVariable int id) {
		Review review = service.getById(id);
			
		if(review == null) {
			//return not found status
			return new ResponseEntity<Review>(HttpStatus.I_AM_A_TEAPOT);
		}
		else {
			//return ok status
			return new ResponseEntity<Review>(review, HttpStatus.OK);
		}
	}
	
	/**
	 * GET BY review_id method
	 * @param id
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value="/movie/{id}",
					method=RequestMethod.GET, 
					produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Review> getByMovieId(@PathVariable int id) {
		 return service.getByMovieId(id);
	}
	
	/**
	 * Creates a new Review
	 * @param review
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value="/new",
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Review> createNewReview(@RequestBody Review review) {
		review = service.newReview(review);
		if(review == null) {
			return new ResponseEntity<Review>(HttpStatus.CONFLICT);
		}
		else {
			return new ResponseEntity<Review>(review, HttpStatus.CREATED);
		}
	}
}