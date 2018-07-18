public class TreeIteratorFactory {
    private static final TreeIterator.Type DEFAULT_TYPE = TreeIterator.Type.PREORDER;

    public static TreeIterator getTreeIterator(TreeNode root, TreeIterator.Type type) {
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

    public static TreeIterator getTreeIterator(TreeNode root) {
        return getTreeIterator(root, DEFAULT_TYPE);
    }
}
