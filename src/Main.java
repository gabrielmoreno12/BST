class Main {
    public static void main(String[] args) {

        // Criação de uma árvore nula
        Tree tree = new Tree();

        // Método de inserção
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

        // Método de verificação de folha
        System.out.println("\n"+tree.isLeaf(1));
        System.out.println(tree.isLeaf(5));
        System.out.println(tree.isLeaf(7));
        System.out.println(tree.isLeaf(13));
        System.out.println(tree.isLeaf(2));
        System.out.println(tree.isLeaf(10));
        System.out.println(tree.isLeaf(6));
        System.out.println(tree.isLeaf(11));
        System.out.println(tree.isLeaf(99));


        // Remoção
        tree.remove(14, tree.root);
        tree.remove(9, tree.root);
        tree.remove(8, tree.root);

        System.out.print("\nPRE-ORDER: ");
        tree.preOrder(tree.root);

        System.out.print("\nIN-ORDER: ");
        tree.inOrder(tree.root);

        System.out.print("\nPOS-ORDER: ");
        tree.postOrder(tree.root);

        System.out.println("\n\n"+tree.search(6));
        System.out.println(tree.height());

        Tree.criarArquivoDOT(tree.root);

    }
}
