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

    // Remover um nó com a informação especificada
    Node remove(int info, Node node) {
        // Se o nó for null, não há nada para remover
        if (node == null) {
            System.out.println("\nNode " + info + " not found");
            return null;
        } else {
            // Se a informação for menor que a do nó atual, procuramos na subárvore esquerda
            if (info < node.info) {
                node.left = remove(info, node.left);
            }
            // Se a informação for maior que a do nó atual, procuramos na subárvore direita
            else if (info > node.info) {
                node.right = remove(info, node.right);
            }
            // Se encontramos o nó a ser removido
            else {
                // Caso 1: Nó sem filhos ou com apenas um filho
                if (node.left == null) {
                    return node.right;
                } else if (node.right == null) {
                    return node.left;
                }
                // Caso 2: Nó com dois filhos
                else {
                    // Encontramos o menor valor na subárvore direita
                    node.info = findMinValue(node.right);
                    // Removemos o menor valor encontrado
                    node.right = remove(node.info, node.right);
                }
            }
            return node;
        }
    }

    // Encontra o menor valor na subárvore direita
    int findMinValue(Node node) {
        // Percorre a árvore pela esquerda até encontrar o menor valor
        while (node.left != null) {
            node = node.left;
        }
        return node.info;
    }

    // Busca nó
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

    // Calcula a altura da árvore
    int height() {
        return height(root) - 1;
    }

    // Auxilia o calculo da altura
    int height(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }

    // Apaga informações da árvore
    void clear() {
        root = null;
    }

    // Verifica se nó é tipo folha
    Boolean isLeaf(int info) {
        return (search(info) == null) ? null
                : (search(info).left == null
                && search(info).right == null);

    }

    // Navegação pré-ordem: visitar o nó raiz antes de seus filhos
    void preOrder(Node place) {
        if (place != null) {
            System.out.print(" " + place.info);
            preOrder(place.left);
            preOrder(place.right);
        }
    }

    // Navegação in-ordem: visitar o nó esquerdo, raiz, e depois o direito
    void inOrder(Node place) {
        if (place != null) {
            inOrder(place.left);
            System.out.print(" " + place.info);
            inOrder(place.right);
        }
    }

    // Navegação post-ordem: visitar os filhos antes do nó raiz.
    void postOrder(Node place) {
        if (place != null) {
            postOrder(place.left);
            postOrder(place.right);
            System.out.print(" " + place.info);
        }
    }

    // Criar um arquivo .dot com a estrutura da árvore
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

    // Escreve a estrutura da árvore em formato DOT
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

