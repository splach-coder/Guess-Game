public class Main {
    public static void main(String[] args) {
        System.out.println("********************************************************");
        System.out.println("\n\n\n\t\t\t\t\t\tGuess the magician's secret number!\n");
        System.out.println("How To Play : \n\n" +
                "The FunBrain Magician will pick a secret number and put it in his hat." +
                "\nYou guess what number it is." +
                "\nIf your guess is too high or too low, FunBrain will give you a hint." +
                "\nSee how many turns it takes you to win!\n\n");

        System.out.println("Pick a Level :\n");
        System.out.println("Easy\t\t\t\t\t\tHard\n");
        System.out.println("(Show previous guesses)\t\t\t\t(Don't show guesses)\n");
        System.out.println("\t1- 1 and 10\t\t\t\t\t1- 1 and 10");
        System.out.println("\t2- 1 and 100\t\t\t\t\t2- 1 and 100");
        System.out.println("\t3- -1000 and 1000\t\t\t\t3- -1000 and 1000");

        GuessGame game = new GuessGame();
        game.start();
    }
}