public class TreeNode<E> { //modify the tree node
	protected TreeNode<E> left;
	protected E element;
	protected TreeNode<E> right;
	protected Node<Article> head;

	public TreeNode(E e) {
		element = e;
	}

  public void addFirst(Article a) {
    Node<Article> newNode = new Node<>(a); // Create a new node of the article type
    newNode.next = head; // link the new node with the head
    head = newNode; // head points to the new node

    //size++; // Increase list size
  }

}
