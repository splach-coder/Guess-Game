import java.util.Scanner;

public class GuessGame {

    // the number whose the player search for
    private int chosenNumber;

    // options
    private int option;

    // maximum tries
    private final int MaxErros = 8;

    // player tries
    private int nbErrors;

    private int playerTries = 0;

    // Generate Number
    public int Generate_number() {
        int min, max;

        // we generate between 1 and 10
        if (option == 1) {
            min = 1;
            max = 10;
        } else if (option == 2) {
            min = 1;
            max = 100;
        } else {
            min = -1000;
            max = 1000;
        }

        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    public void newGame(int opt) {
        // get the option
        option = opt;

        // initialise the player tries
        nbErrors = MaxErros;

        playerTries = 1;

        // generate new number
        chosenNumber = Generate_number();
    }

    public boolean foundNumber(int numberEntered) {
        return numberEntered == chosenNumber;
    }

    public void GameWinner() {
        if (nbErrors > 0) {
            System.out
                    .println("It took you " + playerTries + " turns to guess my number, which was " + chosenNumber + ".");
        }
    }

    public void Lost() {
        if (nbErrors == MaxErros) {
            System.out.println("Oops!! No turns left. My number was " + chosenNumber + ".");
        }
    }

    public String MaxMin(int opt) {
        int min, max;

        // we generate between 1 and 10
        if (option == 1) {
            min = 1;
            max = 10;
        } else if (option == 2) {
            min = 1;
            max = 100;
        } else {
            min = -1000;
            max = 1000;
        }

        return "Pick a number between " + min + " and " + max + ". ";
    }

    public void Play() {
        try (Scanner input = new Scanner(System.in)) {

            System.out.println("Pick a Level (e => easy AND h => hard): ");
            // String level = input.nextLine();
            System.out.println("Pick option (1 OR 2 OR 3): ");
            int option = input.nextInt();

            newGame(option);

            System.out.println(chosenNumber);

            System.out.println(MaxMin(option) +
                    "You will have " + MaxErros + " turns.");

            int playeNumber = input.nextInt();

            // we'll iterate intil we found the number or not
            while (nbErrors > 0) {
                // check if the number found or not
                if (!foundNumber(playeNumber)) {
                    System.out.println(MaxMin(option) +
                            "You have " + nbErrors + " turns.");
                    playeNumber = input.nextInt();

                    if (playeNumber > chosenNumber)
                        System.out.println("Your guess, " + playeNumber + ", is too high");
                    else
                        System.out.println("Your guess, " + playeNumber + ", is too low");

                    nbErrors--;
                    playerTries++;
                    Lost();
                    
                } else {
                    GameWinner();
                    break;
                }
            }
            
        }
    }

}
