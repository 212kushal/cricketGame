import java.util.ArrayList;
import java.util.*;
import java.util.Arrays;

public class Team {
    private String teamName;
    private int teamSize;

    public ArrayList<Player> players = new ArrayList<Player>();

    public int totalScore = 0;
    public int wicketLeft = 10;

    public void setTeamName(String name) {
        teamName = name;
    }
    public void setTeamSize(int size) {
        teamSize = size;
    }
    public String getTeamName() {
        return teamName;
    }

    public int getTeamSize() {
        return teamSize;
    }
}
