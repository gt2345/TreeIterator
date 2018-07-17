import java.util.Iterator;

public interface TreeIterator1 extends Iterator {

    boolean hasNext();

    Object next();
}

enum IteratorType {
    INORDER, PREORDER, POSTORDER
}
