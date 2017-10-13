package com.voting;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Option;
import model.Poll;
import model.SingletonPoll;

@Controller
public class VotingController {

	@RequestMapping(value = "/poll", method = RequestMethod.POST)
	public ResponseEntity<String> createPoll(String title, String user) {
		System.out.println(title);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping(value = "/poll", method = RequestMethod.GET)
	public ResponseEntity<Poll> getPoll(Integer pollId, String user) {
		System.out.println("Get poll...");

		SingletonPoll singletonPoll = SingletonPoll.getInstance();

		return new ResponseEntity<Poll>(singletonPoll.getPoll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getPollJs() {
		System.out.println("getPollJs...");

		return "voting";
	}

	@RequestMapping(value = "/poll", method = RequestMethod.PUT)
	public ResponseEntity<String> editPoll(Integer poll, String title, String user) {
		System.out.println("Edit poll...");

		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping(value = "/poll/option", method = RequestMethod.POST)
	public ResponseEntity<String> addOption(@RequestBody Option option) {
		System.out.println("Add option...");
		System.out.println(option);

		Poll singletonPoll = SingletonPoll.getInstance().getPoll();
		singletonPoll.getOptions().add(option);
		
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	public ResponseEntity<String> removeOption(Integer poll, Integer option, String user) {
		System.out.println("Remove option...");

		return new ResponseEntity<String>(HttpStatus.OK);
	}

	public ResponseEntity<String> vote(Integer poll, Integer option, String user) {
		System.out.println("Vote...");

		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
