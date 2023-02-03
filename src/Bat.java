public class Bat {
    public Team doBatting(Team team1, Team team2, int totalOvers, boolean flag) {
        for(int currOver = 1; currOver <= totalOvers; currOver++) {
            for(int currBall = 1; currBall <= 6; currBall++) {
                int ballResult = (int)(Math.random() * (8 -0));

                if(ballResult == 7) {
                    team1.wicketLeft--;
                    if(team1.wicketLeft == 0) {
                        System.out.println(team1.getTeamName() + " scored " + team1.totalScore + " and lost " + (10 - team1.wicketLeft) + " wickets in " + currOver + "." + currBall + " overs. ");
                        return team1;
                    }
                } else {
                    team1.totalScore += ballResult;
                    if(flag == true) {
                        if (team1.totalScore > team2.totalScore) {
                            System.out.println(team1.getTeamName() + " scored " + team1.totalScore + " and lost " + (10 - team1.wicketLeft) + " wickets in " + currOver + "." + currBall + " overs. ");
                            System.out.println(team1.getTeamName() + " won the match!!!");
                            return team2;
                        }
                    }
                }
            }
        }

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
