package bskerritt.student.ncirl.ie.edulocate;

/**
 * Created by New on 29/12/2017.
 */

// https://www.youtube.com/watch?v=EM2x33g4syY
public class Player {
    String playerId;
    String playerName;
    Boolean puzzleSolved = false;

    public Player() {
    }

    public Player(String playerId, String playerName, Boolean puzzleSolved) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.puzzleSolved = puzzleSolved;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Boolean getPuzzleSolved() {
        return puzzleSolved;
    }
}




