package models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "collections")
public class Collection {

    @EmbeddedId
    private CollectionId id;

    @Column(length = 250)
    private String review;

    @Column
    private Byte score;

    @Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean played;

    public Collection() {
		this.id = new CollectionId(1, 1);
		this.review = "";
		this.score = 0;
		this.played = false;
    }
    
	public Collection(int userId, int gameId, String review, Byte score, Boolean played) {
		this.id = new CollectionId(userId, gameId);
		this.review = review;
		this.score = score;
		this.played = played;
	}
	
	public Collection(int userId, int gameId) {
		this.id = new CollectionId(userId, gameId);
		this.played = false;
	}

	public CollectionId getId() {
		return id;
	}

	public void setId(CollectionId id) {
		this.id = id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Byte getScore() {
		return score;
	}

	public void setScore(Byte score) {
		this.score = score;
	}

	public Boolean getPlayed() {
		return played;
	}

	public void setPlayed(Boolean played) {
		this.played = played;
	}

	@Override
	public String toString() {
		return "Collection: \n\tid = " + id + "\n\treview = " + review + "\n\tscore = " + score
				+ "\n\tplayed = " + played + "\n";
	}
}
