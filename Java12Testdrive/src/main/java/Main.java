import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hi input your name");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Player player1 = new Player(name);
        Player AI = new Player("AI");
        PlayController play = PlayController.getInstance();
        Game game = Game.getInstance();

        play.GenerateState(player1);
        play.GenerateState(AI);
        State playerResult = player1.getChoice();
        State AIResult = AI.getChoice();

        if (playerResult == AIResult) {
            System.out.println("There is  a draw,Try once more");
            System.out.print("You chose ==> ");
            System.out.println(playerResult.name());
            System.out.print("AI chose ==> ");
            System.out.println(AIResult.name());

        } else {
            var result = Game.run(playerResult, AIResult);
            if (result) {
                player1.AddVictory();
                System.out.println("You Won!Congratulations");
                System.out.print("You chose ==> ");
                System.out.println(playerResult.name());
                System.out.print("AI chose ==> ");
                System.out.println(AIResult.name());
            } else {
                System.out.println("You Lose! It's a pity,try once more");
                System.out.print("You chose ==> ");
                System.out.println(playerResult.name());
                System.out.print("AI chose ==> ");
                System.out.println(AIResult.name());
            }
        }
    }
}