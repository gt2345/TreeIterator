import java.util.Deque;
import java.util.LinkedList;

public class InOrderIterator implements TreeIterator1 {

    private Deque<TreeNode> stack;
    private TreeNode cur;

    public InOrderIterator(TreeNode root) {
        this.stack = new LinkedList<>();
        cur = root;
        while(cur != null) {
            stack.addFirst(cur);
            cur = cur.left;
        }
    }


    @Override
    public boolean hasNext() {
        return stack.size() != 0;
    }

    @Override
    public Object next() {
        if(stack.isEmpty()) {
            return null;
        }
        else {
            Object ret = null;
            do {
                if (cur != null) {
                    stack.addFirst(cur);
                    cur = cur.left;
                } else {
                    cur = stack.removeFirst();
                    ret = cur.key;
                    cur = cur.right;
                }

            } while (cur != null);
            return ret;
        }
    }
}
