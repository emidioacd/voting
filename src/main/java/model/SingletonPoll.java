package model;

import java.util.ArrayList;
import java.util.List;

public class SingletonPoll {

	static SingletonPoll singletonPoll = new SingletonPoll();
	
	Poll poll;
	
	private SingletonPoll() {
		System.out.println("creating poll...");
		poll = new Poll();
		poll.setId(1);
		poll.setTitle("Onde jantamos?");

		User u1 = new User("Emanuel", "emanuel@gmail.com");
		User u2 = new User("Emidio", "emidio@gmail.com");

		Option o1 = new Option("Redentora", null, u1);
		Option o2 = new Option("Escondidinho", null, u2);
		Option o3 = new Option("Máfia das Pizzas", null, u1);
		Option o4 = new Option("Escondidinho", null, u2);
		
		List<Option> options = new ArrayList<Option>();
		options.add(o1);
		options.add(o2);
		options.add(o3);
		options.add(o4);
		
		poll.setOptions(options);
	}

	public static SingletonPoll getInstance(){

		return singletonPoll;
	}
	
	public Poll getPoll(){
		return poll;
	}
}
