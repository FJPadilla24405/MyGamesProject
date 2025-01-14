package models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "image", nullable = false, length = 100)
    private String image;

    @Column(name = "playtime", nullable = false)
    private int playtime;

    @Column(name = "metacritic", nullable = false)
    private int metacritic;

    @Column(name = "genres", nullable = false, length = 255)
    private String genres;

    @Column(name = "platforms", nullable = false, length = 255)
    private String platforms;

    @Enumerated(EnumType.STRING)
    @Column(name = "rating", nullable = false)
    private Rating rating;

    @Column(name = "byUser", nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private boolean byUser;
	
    public enum Rating {
        Everyone,
        Everyone10Plus,
        Teen,
        Mature,
        AdultsOnly,
        RatingPending
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPlaytime() {
		return playtime;
	}

	public void setPlaytime(int playtime) {
		this.playtime = playtime;
	}

	public int getMetacritic() {
		return metacritic;
	}

	public void setMetacritic(int metacritic) {
		this.metacritic = metacritic;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getPlatforms() {
		return platforms;
	}

	public void setPlatforms(String platforms) {
		this.platforms = platforms;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public boolean isByUser() {
		return byUser;
	}

	public void setByUser(boolean byUser) {
		this.byUser = byUser;
	}

	@Override
	public String toString() {
		return "Game: \n\tid = " + id + "\n\tname = " + name + "\n\tdate = " + date + "\n\timage = " + image
				+ "\n\tplaytime = " + playtime + "\n\tmetacritic = " + metacritic + "\n\tgenres = " + genres
				+ "\n\tplatforms = " + platforms + "\n\trating = " + rating + "\n\tbyUser = " + byUser + "\n";
	}
	
}
