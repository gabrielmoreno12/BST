public class Node {
    int info;
    Node left, right;
    int height;

    Node(int info) {
        this.info = info;
        this.left = this.right = null;
        this.height = 0;
    }

    int getHeight() {
        return height;
    }

    void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Node(").append(info).append(")");

        if (left != null || right != null) {
            sb.append(" [");
            if (left != null) {
                sb.append("left node: ").append(left.info);
            }
            if (left != null && right != null) {
                sb.append(", ");
            }
            if (right != null) {
                sb.append("right node: ").append(right.info);
            }
            sb.append("]");
        }

        return sb.toString();
    }

}
