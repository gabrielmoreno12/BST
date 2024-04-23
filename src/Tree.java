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

    // Método para remover um nó com a informação especificada
    Node remove(int info, Node node) {
        // Usa o método search para encontrar o nó a ser removido
        Node nodeToRemove = search(root, info);

        // Se o nó não for encontrado, imprime uma mensagem e retorna o nó atual
        if (nodeToRemove == null) {
            System.out.println("Node " + info + " not found");
            return nodeToRemove;
        }

        // Caso o nó seja encontrado, implementa a lógica de remoção
        if (nodeToRemove.left == null) {
            // Caso 1: Nó sem filhos ou com apenas um filho
            System.out.println("Node " + nodeToRemove.info + " removed");
            return nodeToRemove.right;
        } else if (nodeToRemove.right == null) {
            System.out.println("Node " + nodeToRemove.info + " removed");
            return nodeToRemove.left;
        } else {
            // Caso 2: Nó com dois filhos
            int minValue = findMinValue(nodeToRemove.right);
            System.out.println("Node " + nodeToRemove.info + " removed");
            nodeToRemove.info = minValue;
            nodeToRemove.right = remove(minValue, nodeToRemove.right);
            return nodeToRemove;
        }
    }

    // Método auxiliar para encontrar o menor valor na subárvore direita
    int findMinValue(Node node) {
        return (node.left == null) ? node.info : findMinValue(node.left);
    }

    // Métodos de busca
    Node search(int info) {
        return search(root, info);
    }

    Node search(Node place, int info) {
        if (place == null) {
            return null;
        } else if (place.info == info) {
            return place;
        }

        Node leftResult = search(place.left, info);
        if (leftResult != null) {
            return leftResult;
        }

        return search(place.right, info);
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

