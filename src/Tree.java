import java.io.FileWriter;
import java.io.IOException;

public class Tree {
    Node root = null;
    int size = 0;

    // Inserir nó
    void insert(int info, Node place) {
        // Caso 1: Criar raiz
        if (place == null) {
            root = new Node(info);
            System.out.println("Inserted Root " + info);
        }

        /*
        Caso 2: Criar nodo à esquerda
        Se nodo da esquerda estiver vazio e
        a info for menor que a info da raiz,
        então o novo nodo irá para a esquerda
        */
        else if (info < place.info) {
            if (place.left == null) {
                place.left = new Node(info);
                System.out.println("Inserted Left " + info);
            }
            // Caso o nodo da esquerda estiver ocupado
            else {   // Recursividade
                insert(info, place.left);
            }

        }

        /*
        Caso 2: Criar nodo à direita
        Se nodo da direita estiver vazio e
        a info for maior que a info da raiz,
        então o novo nodo irá para a direita
        */
        else if (info > place.info) {
            if (place.right == null) {
                place.right = new Node(info);
                System.out.println("Inserted Right " + info);
            }
            // Caso o nodo da direita estiver ocupado
            else {   // Recursividade
                insert(info, place.right);
            }

        }
    }


    // Navegação pela árvore
    void preOrder(Node place) {
        if (place != null) {
            System.out.print(" " + place.info);
            preOrder(place.left);
            preOrder(place.right);
        }
    }

    void inOrder(Node place) {
        if (place != null) {
            inOrder(place.left);
            System.out.print(" " + place.info);
            inOrder(place.right);
        }
    }

    void postOrder(Node place) {
        if (place != null) {
            postOrder(place.left);
            postOrder(place.right);
            System.out.print(" " + place.info);
        }
    }

    // Método para criar um arquivo .dot com a estrutura da árvore
    static void criarArquivoDOT(Node root) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("arvore.dot");
            writer.write("digraph Arvore {\n");
            escreverDOTRecursivo(root, writer);
            writer.write("}\n");
            System.out.println("\nArquivo arvore.dot criado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao criar o arquivo DOT: " + e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Método recursivo para escrever a estrutura da árvore em formato DOT
    static void escreverDOTRecursivo(Node node, FileWriter writer) throws IOException {
        if (node != null) {
            writer.write("\t" + node.info + ";\n");

            if (node.left != null) {
                writer.write("\t" + node.info + " -> " + node.left.info + ";\n");
                escreverDOTRecursivo(node.left, writer);
            }

            if (node.right != null) {
                writer.write("\t" + node.info + " -> " + node.right.info + ";\n");
                escreverDOTRecursivo(node.right, writer);
            }
        }
    }

}

