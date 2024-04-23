public class Node {
    int info;
    Node left, right;

    Node(int info) {
        this.info = info;
        this.left = this.right = null;
    }

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
