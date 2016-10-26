package model;

import java.util.List;

public class Option {

	private long id;
	private String description;
	
	private List<User> votes;
	
	private User creator;

	public Option() {}
		public Option(String description, List<User> votes, User creator) {
		super();
		this.description = description;
		this.votes = votes;
		this.creator = creator;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getVotes() {
		return votes;
	}

	public void setVotes(List<User> votes) {
		this.votes = votes;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}
	
	
	
}
