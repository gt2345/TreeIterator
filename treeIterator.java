import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class treeIterator implements Iterator {

    private Deque<TreeNode> stack;
    private TreeNode cur;
    private TreeNode pre; // only used in post order
    private Type type;

    public treeIterator(TreeNode root, Type type) { //suppose root != null
        this.stack = new LinkedList<>();
        this.type = type;
        switch (type) {
            case preOrder:
                stack.addFirst(root);
                break;
            case inOder:
            case postOrder:
                //go all the way to the most left
                cur = root;
                while(cur != null) {
                    stack.addFirst(cur);
                    pre = cur;
                    cur = cur.left;

                }
                break;
        }
    }

    @Override
    public boolean hasNext() {
        return stack.size() != 0;
        // return cur != null;
    }

    @Override
    public Integer next() {
        if(stack.isEmpty()) {
            return null;
        }
        else {
            switch (type) {
                case preOrder:
                    cur = stack.removeFirst();
                    if (cur.right != null) {
                        stack.addFirst(cur.right);
                    }
                    if (cur.left != null) {
                        stack.addFirst(cur.left);
                    }
                    return cur.key;
                case inOder:
                    Integer retval = null;
                    do {
                        if (cur != null) {
                            stack.addFirst(cur);
                            cur = cur.left;
                        } else {
                            cur = stack.removeFirst();
                            retval = cur.key;
                            cur = cur.right;
                        }

                    } while (cur != null);
                    return retval;
                case postOrder:
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
            return null;
        }
    }

    public static void main(String[] args) {
        TreeNode tr3 = new TreeNode(3);
        tr3.left = new TreeNode(1);
        tr3.right = new TreeNode(4);
        TreeNode tr8 = new TreeNode(8);
        tr8.right = new TreeNode(11);
        TreeNode root = new TreeNode(5);
        root.left = tr3;
        root.right = tr8;

        TreeIterator1 iter = TreeIteratorFactory.getTreeIterator(root, IteratorType.POSTORDER);
        while (iter.hasNext()) {
            System.out.println(iter.next());

        }
    }
}


class TreeNode {
    Integer key;
    TreeNode left;
    TreeNode right;

    public TreeNode(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }


}

enum Type {
    inOder, preOrder, postOrder
}
