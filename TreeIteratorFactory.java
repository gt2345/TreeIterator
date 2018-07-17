public class TreeIteratorFactory {
    private static final IteratorType DEFAULT_TYPE = IteratorType.PREORDER;

    public static TreeIterator1 getTreeIterator(TreeNode root, IteratorType type) {
        switch (type) {
            case PREORDER:
                return new PreOrderIterator(root);
            case INORDER:
                return new InOrderIterator(root);
            case POSTORDER:
                return new PostOrderIterator(root);
            default:
                throw new IllegalArgumentException("Invalid type " + type);
        }
    }

    public static TreeIterator1 getTreeIterator(TreeNode root) {
        return getTreeIterator(root, DEFAULT_TYPE);
    }
}
