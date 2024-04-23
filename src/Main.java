
import java.util.Random;

class Main {
    public static void main(String[] args) {

        Random rand = new Random();
        Tree tree = new Tree();


        for (int i=0; i<5; i++) {
            tree.insert(rand.nextInt(10), tree.root);
        }

        System.out.print("\nPRE-ORDER: ");
        tree.preOrder(tree.root);

        System.out.print("\nIN-ORDER: ");
        tree.inOrder(tree.root);

        System.out.print("\nPOS-ORDER: ");
        tree.posOrder(tree.root);

        tree.criarArquivoDOT(tree.root);

    }
}
