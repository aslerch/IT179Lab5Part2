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
    /**
     * Starter add method
     * @param newChar
     * @param morsePointers
     */
    public void add(char newChar, String morsePointers) {
        add(root, newChar, morsePointers);
    }

    /**
     * Recursive add method
     * @param localRoot
     * @param newChar
     * @param morsePointers
     */
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        preorderString(root, 1, sb);
        return sb.toString();
    }

    private void preorderString(Node node, int depth, StringBuilder sb) {
        for (int i = 1; i < depth; i++) {
            sb.append("  ");
        }
        if (node == null)
            sb.append("null\n");
        else {
            sb.append(node.toString());
            sb.append("\n");
            preorderString(node.left, depth + 1, sb);
            preorderString(node.right, depth + 1, sb);
        }
    }

    public String decode(String message) {
        String [] info = message.split(" ");
        String returnString = "";
        for (int i = 0; i < info.length; i++) {
            returnString += decode(root, info[i]);
        }
        return returnString;
    }

    private Character decode(Node localRoot, String morseString) {
        Node charNode = localRoot;
        for (int i = 0; i < morseString.length(); i++) {
            if (morseString.charAt(i) == '.')
                charNode = charNode.left;
            if (morseString.charAt(i) == '-')
                charNode = charNode.right;
        }
        return (Character)charNode.data;
    }

}
