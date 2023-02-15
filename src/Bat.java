import java.util.Random;

public class Bat {
    public void printScorecard(Team t1) {
        System.out.println();
        System.out.println(t1.getTeamName());
        for(int i = 0; i < 11; i++) {
            if(t1.players.get(i).score == -1) {
                System.out.println(t1.players.get(i).name + " --> Did not play" );
            } else {
                System.out.println(t1.players.get(i).name + " --> " + t1.players.get(i).score);
            }
        }
        System.out.println();
    }

    int nonUniformDistributionForBatsman() {
        Random r = new Random();
        double v = r.nextDouble();

        if(v <= 0.30) {
            return 0;
        } else if(v <= 0.60) {
            return 1;
        } else if(v <= 0.74) {
            return 2;
        } else if(v <= 0.79) {
            return 3;
        } else if(v <= 0.91) {
            return 4;
        } else if(v <= 0.911) {
            return 5;
        } else if(v <= 0.97) {
            return 6;
        } else {
            return 7;
        }
    }

    int nonUniformDistributionForBowler() {
        Random r = new Random();
        double v = r.nextDouble();

        if(v <= 0.40) {
            return 0;
        } else if(v <= 0.52) {
            return 1;
        } else if(v <= 0.57) {
            return 2;
        } else if(v <= 0.60) {
            return 3;
        } else if(v <= 0.66) {
            return 4;
        } else if(v <= 0.661) {
            return 5;
        } else if(v <= 0.70) {
            return 6;
        } else {
            return 7;
        }
    }

    public Team doBatting(Team team1, Team team2, int totalOvers, boolean flag) {
        int currBatter = 0;
        boolean won = false;
        team1.players.get(currBatter).score = 0;
        for(int currOver = 1; currOver <= totalOvers; currOver++) {
            for(int currBall = 1; currBall <= 6; currBall++) {

                int ballResult;

                if(team1.players.get(currBatter).type == "Batsman") {
                    ballResult = nonUniformDistributionForBatsman();
                } else {
                    ballResult = nonUniformDistributionForBowler();
                }

                if(ballResult == 7) {
                    team1.wicketLeft--;
                    currBatter++;
                    team1.players.get(currBatter).score = 0;
                    if(team1.wicketLeft == 0) {
                        won = true;
                        break;
                    }
                } else {
                    team1.totalScore += ballResult;
                    team1.players.get(currBatter).score += ballResult;
                    if(flag == true) {
                        if (team1.totalScore > team2.totalScore) {
                            printScorecard(team1);
                            System.out.println(team1.getTeamName() + " scored " + team1.totalScore + " and lost " + (10 - team1.wicketLeft) + " wickets in " + currOver + "." + currBall + " overs. ");
                            System.out.println(team1.getTeamName() + " won the match!!!");
                            return team2;
                        }
                    }
                }
            }
            if(won == true) {
                break;
            }
        }

        printScorecard(team1);
        System.out.println(team1.getTeamName() + " scored " + team1.totalScore + " and lost " + (10 - team1.wicketLeft) + " wickets in " + totalOvers + " overs. ");

        if(flag == true) {
            if(team1.totalScore == team2.totalScore) {
                System.out.println("Match is Tie");
            } else {
                System.out.println(team2.getTeamName() + " won the match!!!");
            }
        }
        return team1;
    }
}
