import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String [] args) {

    }

    public MorseTree<Character> buildTree() {
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

}
