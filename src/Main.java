
import java.util.Random;

class Main {
    public static void main(String[] args) {

        Random rand = new Random();

        // Criação de uma árvore nula
        Tree tree = new Tree();

        /*
        Uso do método insert() para inserir 10 nodos aleatórios na árvore
        contendo valores aleatórios entre 0(inclusive) e 100
         */
//        for (int i=0; i<10; i++) {
//            tree.insert(rand.nextInt(100), tree.root);
//        }

        tree.insert(2, tree.root);
        tree.insert(1, tree.root);
        tree.insert(8, tree.root);
        tree.insert(6, tree.root);
        tree.insert(5, tree.root);
        tree.insert(9, tree.root);
        tree.insert(7, tree.root);
        tree.insert(11, tree.root);
        tree.insert(10, tree.root);
        tree.insert(13, tree.root);

        System.out.println(tree.remove(9, tree.root));

        System.out.print("\nPRE-ORDER: ");
        tree.preOrder(tree.root);

        System.out.print("\nIN-ORDER: ");
        tree.inOrder(tree.root);

        System.out.print("\nPOS-ORDER: ");
        tree.postOrder(tree.root);

        System.out.println("\n"+tree.search(6));

        tree.criarArquivoDOT(tree.root);

    }
}
