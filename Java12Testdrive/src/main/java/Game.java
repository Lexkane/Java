public class Game {

    public static class SingletonHolder {
        public static final Game HOLDER_INSTANCE = new Game();
    }

    public static Game getInstance() {
        return Game.SingletonHolder.HOLDER_INSTANCE;
    }

    public static boolean run(State playerResult, State AIResult) {
        boolean result=false;
        if (playerResult == State.Paper) {
            result = switch (AIResult) {
                case Rock -> true;
                default -> false;
            };
        }
        if (playerResult == State.Rock) {
            result = switch (AIResult) {
                case Scissors -> true;
                default -> false;
            };
        }
        if (playerResult == State.Scissors) {
            result = switch (AIResult) {
                case Paper -> true;
                default -> false;
            };
        }


        return result;
    }
}