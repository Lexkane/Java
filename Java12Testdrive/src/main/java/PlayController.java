import java.util.Random;
//import java.util.concurrent.ThreadLocalRandom;

public class PlayController {


    public static class SingletonHolder {
        public static final PlayController HOLDER_INSTANCE = new PlayController();
    }

    public static PlayController getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }


    public  void  GenerateState(Player player) {
        Random random= new Random();
        var randomNum=random.nextInt(3)+1;
        //var randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        var  choice =
                switch (randomNum) {
                    case 1 -> State.Paper;
                    case 2 -> State.Scissors;
                    case 3 -> State.Rock;
                    default -> State.Error;
                };
        player.setChoice(choice);
    }

}
