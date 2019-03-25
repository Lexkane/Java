public class Player {
    private String Name;
    private int Score = 0;

    private State Choice;

    private Player() {
    }

    public Player(String name) {
        this.Name = name;
        this.Score = 0;
    }

    public int getScore() {
        return Score;
    }

    public void AddVictory() {
        Score += 1;
    }

    public void EraseScore() {
        Score = 0;
    }


    public State getChoice() {
        return Choice;
    }

    public void setChoice(State choice) {
        Choice = choice;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

}
