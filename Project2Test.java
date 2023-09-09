import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Project2Test {

    BufferedReader fileReader;
    BST<String> bst;
    public static void main(String[] args) {
        Project2Test project2Test = new Project2Test("datafile.txt");
        project2Test.bst.inorder();
    }

    public Project2Test (String filename) {
        try {
            fileReader = new BufferedReader(new FileReader(filename));
            bst = new BST<String>();
            while (readNextRecord()) {}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean readNextRecord() {
        if (fileReader == null) {
            System.out.println("Error: You must open the file first");
            return false;
        } else {
            try {
                String data = fileReader.readLine();
                if (data == null) {
                    return false;
                }
                //System.out.println(data);
                int titleId = Integer.parseInt(data);
                String title = fileReader.readLine();
                String author = fileReader.readLine();
                int numKeys = Integer.parseInt((fileReader.readLine()));
                Article article = new Article(titleId, title, author);
                //System.out.println(article);//testing
                String keyword;
                for (int i=0; i<numKeys; i++) {
                    keyword = fileReader.readLine();
                    bst.insert(keyword, article);
                }
                fileReader.readLine();
            } catch (NumberFormatException e) {
                System.out.println("Error: Number expected!");
                return false;
            } catch (Exception e) {
                System.out.println("Fatal Error: " + e);
                return false;
            }
        }
        return true;
    }
}
    /* public static void main(String args[]) {
        BST<String> tree = new BST<>();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");

        // Traverse tree
        System.out.print("Inorder (sorted): ");
        tree.inorder();
        System.out.print("\nPostorder: ");
        tree.postorder();
        System.out.print("\nPreorder: ");
        tree.preorder();
        System.out.print("\nThe number of nodes is " + tree.getSize());

        // Search for an element
        System.out.print("\nIs Peter in the tree? " + tree.search("Peter"));

        // Get a path from the root to Peter
        System.out.print("\nA path from the root to Peter is: ");
        java.util.ArrayList<BST.TreeNode<String>> path = tree.path("Peter");
        for (int i = 0; path != null && i < path.size(); i++)
            System.out.print(path.get(i).element + " ");

        Integer[] numbers = {2, 4, 3, 1, 8, 5, 6, 7};
        BST<Integer> intTree = new BST<>(numbers);
        System.out.print("\nInorder (sorted): ");
        intTree.inorder();
    }
}*/
