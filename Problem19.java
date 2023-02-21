package Xplore_Problems;

import java.util.Arrays;
import java.util.Scanner;

public class Problem19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        player[] p = new player[4];
        for (int i = 0; i < 4; i++)
            p[i] = new player(sc.nextInt(), sc.next(), sc.nextInt(), sc.next(), sc.next());

        int ans1 = findPlayerWithLowestRun(p, sc.next());
        player[] ans2 = findPlayerByMatchType(p, sc.next());
        sc.close();
        if (ans1 == 0) System.out.println("No such player");
        else System.out.println(ans1);
        if (ans2.length == 0) System.out.println("No player with such match Type");
        else {
            int[] arr = new int[ans2.length];
            for (int i = 0; i < ans2.length; i++) {
                arr[i] = ans2[i].getId();
            }
            Arrays.sort(arr);
            for (int i = arr.length-1; i >=0; i--)
                System.out.println(arr[i]);
        }
    }

    private static int findPlayerWithLowestRun(player[] p, String t) {
        int runs = Integer.MAX_VALUE;
        for (int i = 0; i < p.length; i++)
            if (p[i].getPlayerType().equals(t)) {
                runs = Math.min(runs, p[i].getRun());
            }
        return (runs == Integer.MAX_VALUE) ? 0 : runs;
    }

    private static player[] findPlayerByMatchType(player[] p, String matchT) {
        player[] r = new player[0];
        for (int i = 0; i < p.length; i++) {
            if (p[i].getMatchesType().equalsIgnoreCase(matchT)) {
                r = Arrays.copyOf(r, r.length + 1);
                r[r.length - 1] = p[i];
            }
        }
        return r;
    }
}

class player {
    private int id, run;
    private String name, matchesType, playerType;

    public player(int id, String name, int run, String playerType, String matchesType) {
        this.id = id;
        this.name = name;
        this.run = run;
        this.playerType = playerType;
        this.matchesType = matchesType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatchesType() {
        return matchesType;
    }

    public void setMatchesType(String matchesType) {
        this.matchesType = matchesType;
    }

    public String getPlayerType() {
        return playerType;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }


}