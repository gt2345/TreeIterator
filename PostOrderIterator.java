import java.util.Deque;
import java.util.LinkedList;

public class PostOrderIterator implements TreeIterator1 {

    private Deque<TreeNode> stack;
    private TreeNode cur;
    private TreeNode pre;

    public PostOrderIterator (TreeNode root) {
        this.stack = new LinkedList<>();
        cur = root;
        while(cur != null) {
            stack.addFirst(cur);
            pre = cur;
            cur = cur.left;

        }
    }

    @Override
    public boolean hasNext() {
        return stack.size() != 0;
    }

    @Override
    public Object next() {
        while (true) {
            cur = stack.peekFirst();

            if (pre.left == cur || pre.right == cur) {
                pre = cur;
                if (cur.left != null) {
                    stack.addFirst(cur.left);
                } else if (cur.right != null) {
                    stack.addFirst(cur.right);
                } else {
                    stack.removeFirst();
                    return cur.key;
                }
            }
            else if (cur.left == pre) {
                pre = cur;
                if (cur.right != null) {
                    stack.addFirst(cur.right);
                } else {
                    stack.removeFirst();
                    return cur.key;
                }
            }
            else {
                pre = cur;
                stack.removeFirst();
                return cur.key;
            }
        }
    }
}
