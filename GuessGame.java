import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GuessGame {

    // the number whose the player search for
    private int chosenNumber;

    // options
    private int option;

    // game level
    private String level;

    // history
    private List<Integer> counter = new ArrayList<Integer>();

    // maximum tries
    private final int MaxErros = 8;

    // player tries
    private int nbErrors;

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

    public void newGame(int opt, String level) {
        // get the option
        option = opt;

        this.level = level;

        // initialise the player tries
        nbErrors = 0;

        // generate new number
        chosenNumber = Generate_number();
    }

    public boolean foundNumber(int numberEntered) {
        return numberEntered == chosenNumber;
    }

    public void GameWinner() {
        if (nbErrors < MaxErros) {
            System.out
                    .println("It took you " + (nbErrors + 1) + " turns to guess my number, which was " + chosenNumber
                            + ".");
        }
    }

    public boolean Lost() {
        if (nbErrors == 8) {
            System.out.println("Oops!! No turns left. My number was " + chosenNumber + ".");
            return true;
        }
        return false;
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

    // history or not
    public boolean history() {
        if (this.level.toLowerCase().equals("e"))
            return true;
        else
            return false;
    }

    public void showhistory() {
        System.out.println("--------------");
        System.out.println("|   History   |");
        System.out.println("--------------");
        for (int cpt : counter) {
            System.out.println("|    " + cpt + "    |");
        }
        System.out.println("--------------");
    }

    public void Play() {
        try (Scanner input = new Scanner(System.in)) {

            System.out.println("Pick a Level (e => easy AND h => hard): ");
            String lvl = input.nextLine();
            System.out.println("Pick option (1 OR 2 OR 3): ");
            int option = input.nextInt();

            System.out.println("ur level is : " + lvl);

            newGame(option, lvl);

            System.out.println(chosenNumber);

            System.out.println(MaxMin(option) +
                    "You will have " + MaxErros + " turns.");

            int playeNumber = input.nextInt();

            // we'll iterate intil we found the number or not
            while (nbErrors < MaxErros) {
                counter.add(playeNumber);

                // check if the number found or not
                if (!foundNumber(playeNumber)) {

                    if (playeNumber > chosenNumber)
                        System.out.println("Your guess, " + playeNumber + ", is too high");
                    else
                        System.out.println("Your guess, " + playeNumber + ", is too low");

                    if (history()) {
                        showhistory();
                    }

                    nbErrors++;

                    if (Lost())
                        break;

                } else {
                    GameWinner();
                    break;
                }

                System.out.println(MaxMin(option) +
                        "You have " + (MaxErros - nbErrors) + " turns.");
                playeNumber = input.nextInt();
            }

        }
    }

}
