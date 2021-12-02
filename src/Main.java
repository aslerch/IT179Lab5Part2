import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** Driver class for the program */
public class Main {

    static Scanner keyboard = new Scanner(System.in);
    static MorseTree tree = buildTree();

    /** Main method */
    public static void main(String [] args) {

        String userInput = askForValidMorseCode("Please enter encoded message or stop to exit: ");
        while ( ! userInput.equalsIgnoreCase("stop") ) {
            String decodedMessage = decode(userInput);
            System.out.println("The decoded message is: " + decodedMessage);
            userInput = askForValidMorseCode("Please enter encoded message or stop to exit: ");
        }
        System.out.print("Thank you for using our decoder!");
    }

    /**
     * Creates and fills a MorseTree object with
     * @return MorseTree object
     */
    public static MorseTree<Character> buildTree() {
        MorseTree<Character> tree = new MorseTree<>();
        try {
            Scanner fileReader = new Scanner(new File("letters.txt"));
            while (fileReader.hasNextLine()) {
                String [] info = fileReader.nextLine().split(" ");
                tree.add(info[0].charAt(0), info[1]);
            }
        } catch (FileNotFoundException e) {
            System.out.print("file cannot be found");
        }
        return tree;
    }

    /**
     * Decodes a morse code message
     * @param message message that is in morse code
     * @return decoded message
     */
    public static String decode(String message) {
        return tree.decode(message);
    }

    /**
     * Asks for a String that is valid morse code
     * @param informationRequestMessage The request message
     * @return A String
     */
    private static String askForValidMorseCode(String informationRequestMessage) {
        boolean isOnlyDotsAndDashes;
        String output = "";
        do {
            isOnlyDotsAndDashes = true;
            System.out.print(informationRequestMessage);
            output = keyboard.nextLine();
            if (output.equalsIgnoreCase("stop"))
                return output;
            for (int i = 0; i < output.length(); i++) {
                if (output.charAt(i) != '.' && output.charAt(i) != '-' && output.charAt(i) != ' ') {
                    System.out.println("Input not valid morse code");
                    isOnlyDotsAndDashes = false;
                    break;
                }
            }
        } while (isOnlyDotsAndDashes == false);
        return output;
    }

}
