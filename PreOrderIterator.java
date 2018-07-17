import java.util.Deque;
import java.util.LinkedList;

public class PreOrderIterator implements TreeIterator1 {

    private Deque<TreeNode> stack;
    private TreeNode cur;

    public PreOrderIterator(TreeNode root) {
        this.stack = new LinkedList<>();
        stack.addFirst(root);
    }

    @Override
    public boolean hasNext() {
        return stack.size() != 0;
    }

    @Override
    public Object next() {
        cur = stack.removeFirst();
        if (cur.right != null) {
            stack.addFirst(cur.right);
        }
        if (cur.left != null) {
            stack.addFirst(cur.left);
        }
        return cur.key;
    }
}
