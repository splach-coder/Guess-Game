public class Main {
    public static void main(String[] args) {
        System.out.println("********************************************************");
        System.out.println("\n\n\n\t\t\t\t\t\tGuess the magician's secret number!\n");
        System.out.println("How To Play : \n\n" +
                "The FunBrain Magician will pick a secret number and put it in his hat." +
                "\nYou guess what number it is." +
                "\nIf your guess is too high or too low, FunBrain will give you a hint." +
                "\nSee how many turns it takes you to win!\n\n");

        GuessGame game = new GuessGame();
        game.start();
    }
}