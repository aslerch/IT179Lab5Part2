/** A class that represents the morse code alphabet */
public class MorseTree<Character> {

    /** Building block class of MorseTree binary tree */
    private class Node<Character> {
        /** Fields */
        private Character data;
        private Node<Character> left;
        private Node<Character> right;

        /** Constructor */
        public Node(Character data) {
            this.data = data;
            left = null;
            right = null;
        }

        /** Methods */
        public String toString() {
            return data.toString();
        }
    }

    /** Fields */
    private Node<Character> root = new Node('*');

    /** Constructor */
    public MorseTree() {}

    /** Methods */
    public void add(char newChar, String morsePointers) {
        add(root, newChar, morsePointers);
    }

    private void add(Node<Character> localRoot, char newChar, String morsePointers) {
        for (int i = 0; i < morsePointers.length(); i++) {
            if (morsePointers.charAt(i) == '.') {
                if (localRoot.left == null)
                    localRoot.left = new Node(newChar);
                else
                    localRoot = localRoot.left;
            }
            else {
                if (localRoot.right == null)
                    localRoot.right = new Node(newChar);
                else
                    localRoot = localRoot.right;
            }
        }
    }

}
