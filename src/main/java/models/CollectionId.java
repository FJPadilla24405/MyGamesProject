package models;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class CollectionId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int userId;
    private int gameId;

    public CollectionId() {}

    public CollectionId(int userId, int gameId) {
        this.userId = userId;
        this.gameId = gameId;
    }

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gameId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CollectionId other = (CollectionId) obj;
		return gameId == other.gameId && userId == other.userId;
	}

	@Override
	public String toString() {
		return "(userId: "+userId+" | gameId: "+gameId+")";
	}
	
	
}
