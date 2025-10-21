package week7;

class PlayerStats {
    protected String name;
    protected int age;
    protected String team;

    public PlayerStats(String name, int age, String team) {
        this.name = name;
        this.age = age;
        this.team = team;
    }

    public void displayInfo() {
        System.out.println(name + " | Age: " + age + " | Team: " + team);
    }
}



class FootballStats extends PlayerStats {
    private int goals;
    private int assists;

    public FootballStats(String name, int age, String team, int goals, int assists) {
        super(name, age, team);
        this.goals = goals;
        this.assists = assists;
    }

    public void displayStats() {
        displayInfo();
        System.out.println("Football Stats -> Goals: " + goals + ", Assists: " + assists);
        System.out.println("---------------------------------------------------");
    }
}


class CricketStats extends PlayerStats {
    private int runs;
    private int wickets;

    public CricketStats(String name, int age, String team, int runs, int wickets) {
        super(name, age, team);
        this.runs = runs;
        this.wickets = wickets;
    }

    public void displayStats() {
        displayInfo();
        System.out.println("Cricket Stats -> Runs: " + runs + ", Wickets: " + wickets);
        System.out.println("---------------------------------------------------");
    }
}


class BasketballStats extends PlayerStats {
    private int points;
    private int rebounds;

    public BasketballStats(String name, int age, String team, int points, int rebounds) {
        super(name, age, team);
        this.points = points;
        this.rebounds = rebounds;
    }

    public void displayStats() {
        displayInfo();
        System.out.println("Basketball Stats -> Points: " + points + ", Rebounds: " + rebounds);
        System.out.println("---------------------------------------------------");
    }
}


class HockeyStats extends PlayerStats {
    private int goals;
    private int penalties;

    public HockeyStats (String name, int age, String team, int goals, int penalties) {
        super(name, age, team);
        this.goals = goals;
        this.penalties = penalties;
    }

    public void displayStats() {
        displayInfo();
        System.out.println("Hockey Stats -> Goals: " + goals + ", Penalties: " + penalties);
        System.out.println("---------------------------------------------------");
    }
}


class BaseballStats extends PlayerStats {
    private int homeRuns;
    private int strikeouts;

    public BaseballStats(String name, int age, String team, int homeRuns, int strikeouts) {
        super(name, age, team);
        this.homeRuns = homeRuns;
        this.strikeouts = strikeouts;
    }

    public void displayStats() {
        displayInfo();
        System.out.println("Baseball Stats -> Homeruns: " + homeRuns + ", Strikeouts: " + strikeouts);
        System.out.println("---------------------------------------------------");
    }
}



public class SportStats {
    public static void main(String[] args) {
        FootballStats footballStats = new FootballStats("Messi", 37, "Barcelona", 672, 107);
        CricketStats cricketStats = new CricketStats("Virat Kohli", 35, "India", 1200, 5);
        BasketballStats basketballStats = new BasketballStats("LeBron James", 39, "Lackers", 2000, 800);
        HockeyStats hockeyStats = new HockeyStats("Sidney Crosby", 36, "Penguins", 100, 20);
        BaseballStats baseballStats = new BaseballStats("Shohei Ohtani", 29, "Angels", 35, 120);


        footballStats.displayStats();
        System.out.println();

        cricketStats.displayStats();
        System.out.println();

        basketballStats.displayStats();
        System.out.println();

        hockeyStats.displayStats();
        System.out.println();

        baseballStats.displayStats();
        System.out.println();
    }
}
