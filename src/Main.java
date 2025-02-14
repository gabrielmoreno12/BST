class Main {
    public static void main(String[] args) {

        // Criação de uma árvore nula
        Tree tree = new Tree();

        tree.insert(50, null);   // Insere 50 como raiz
        tree.insert(25, tree.root);  // Insere 25 como filho esquerdo de 50
        tree.insert(75, tree.root); // Insere 75 como filho direito de 50
        tree.insert(20, tree.root); // Insere 20 como filho esquerdo de 25
        tree.insert(30, tree.root); // Insere 30 como filho direito de 25
        tree.insert(70, tree.root); // Insere 70 como filho esquerdo de 75
        tree.insert(80, tree.root); // Insere 80 como filho direito de 75
        tree.insert(10, tree.root); // Insere 10 como filho esquerdo de 20
        tree.insert(40, tree.root); // Insere 40 como filho direito de 30
        tree.insert(60, tree.root); // Insere 60 como filho esquerdo de 70
        tree.insert(90, tree.root); // Insere 90 como filho direito de 80
        tree.insert(11, tree.root);
        tree.insert(9, tree.root);
        tree.insert(23, tree.root);


        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);

        tree.criarArquivoDOT(tree.root);

    }
}
