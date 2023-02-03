import java.util.*;
public class Main {
    public static void main(String[] args) {
        Team team1 = new Team();
        Team team2 = new Team();

        Scanner scn = new Scanner(System.in);
        int totalOvers;
        System.out.println("Enter total overs: ");
        totalOvers = scn.nextInt();

        Scanner scn2 = new Scanner(System.in);
        System.out.println("Enter the name of team 1: ");
        team1.setTeamName(scn2.nextLine());

        Scanner scn3 = new Scanner(System.in);
        System.out.println("Enter the name of team 2: ");
        team2.setTeamName(scn3.nextLine());

        System.out.println("Enter the number of players: ");
        int players = scn3.nextInt();
        team1.setTeamSize(players);
        team2.setTeamSize(players);

        System.out.println("Enter the team number for toss(enter 0 for " + team1.getTeamName() + " or 1 for " + team2.getTeamName() + " ): ");
        int option = scn3.nextInt();

        Team doingToss, hadChoice;

        if(option == 0) {
            doingToss = team1;
            hadChoice = team2;
        } else {
            doingToss = team2;
            hadChoice = team1;
        }

        int tossResult = (int)(Math.random() * (2 -0));
        Team batFirst, bowlFirst;

        if(tossResult == 0) {
            //'doingToss' won the toss
            System.out.println(doingToss.getTeamName() + " won the toss. ");
            System.out.println("Team " + doingToss.getTeamName() + " please enter your choice as 0 for batting and 1 for bowling: ");
            int choice = scn3.nextInt();

            if(choice == 0) {
                batFirst = doingToss;
                bowlFirst = hadChoice;
            } else {
                bowlFirst = doingToss;
                batFirst = hadChoice;
            }
        } else {
            //'hadChoice' won the toss
            System.out.println(hadChoice.getTeamName() + " won the toss");
            System.out.println("Team " + hadChoice.getTeamName() + " please enter your choice as 0 for batting and 1 for bowling: ");
            int choice = scn3.nextInt();
            if(choice == 0) {
                batFirst = hadChoice;
                bowlFirst = doingToss;
            } else {
                bowlFirst = hadChoice;
                batFirst = doingToss;
            }
        }

        team1 = batFirst;
        team2 = bowlFirst;

        System.out.println();
        System.out.print("Team " + team1.getTeamName() + " will bat first");
        System.out.println(" and Team " + team2.getTeamName() + " will bowl first");
        System.out.println();

        Bat bat = new Bat();
        team1 = bat.doBatting(team1, team2, totalOvers, false);
        team2 = bat.doBatting(team2, team1, totalOvers, true);

    }


}