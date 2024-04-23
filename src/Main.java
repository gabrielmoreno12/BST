
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
        for (int i=0; i<10; i++) {
            tree.insert(rand.nextInt(100), tree.root);
        }

        System.out.print("\nPRE-ORDER: ");
        tree.preOrder(tree.root);

        System.out.print("\nIN-ORDER: ");
        tree.inOrder(tree.root);

        System.out.print("\nPOS-ORDER: ");
        tree.postOrder(tree.root);

        tree.criarArquivoDOT(tree.root);

    }
}
