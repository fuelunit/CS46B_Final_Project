package treeDemo;

/**
 * Lecture 22
 * @author ethan
 *
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>> {
	
	private static class BSTNode<T extends Comparable<T>>{
		private T data;
		private BSTNode<T> leftChild;
		private BSTNode<T> rightChild;
		
		public BSTNode(T data) {
			this.data = data;
		}
	}
	
	private BSTNode<T> root;
	
	public BinarySearchTree(T data) {
		root = new BSTNode<T>(data);
	}
	
	public void insert(T data) {
		root = recursiveInsert(root,data);
	}
	
	private BSTNode<T> recursiveInsert(BSTNode<T> node, T data) {
		if (node == null) {
			return new BSTNode<T>(data);
		}
		if (data.compareTo(node.data) < 0) {
			return this.recursiveInsert(node.leftChild, data);
		} else if (data.compareTo(node.data) > 0) {
			return this.recursiveInsert(node.rightChild, data);
		} else {
			return node;
		}
	}
	
	public void delete(T data) {
		this.root = recursiveDelete(this.root, data);
	}
	
	private BSTNode<T> recursiveDelete(BSTNode<T> node, T data){
		if (node == null) {
			return node;
		} else if (data.compareTo(node.data) < 0) {
			node.leftChild = this.recursiveDelete(node.leftChild, data);
		} else if (data.compareTo(node.data) > 0) {
			node.rightChild = this.recursiveDelete(node.rightChild, data);
		} else {
			if (node.leftChild == null && node.rightChild == null) {
				return null;
			} else if (node.leftChild == null) {
				return node.rightChild;
			} else if (node.rightChild == null) {
				return node.leftChild;
			} else {
				BSTNode<T> leftMax = this.getMax(node.leftChild);
				T tempData = leftMax.data;
				node.data = tempData;
				node.leftChild = this.recursiveDelete(node.leftChild, tempData);
			}
		}
		return node;
	}
	
	public BSTNode<T> getMax(BSTNode<T> root) {
		while (root.rightChild != null) {
			root = root.rightChild;
		}
		return root;
	}
	
	public BSTNode<T> getMin(BSTNode<T> root) {
		while (root.leftChild != null) {
			root = root.leftChild;
		}
		return root;
	}
	
	public boolean contains(T data) {
		if(find(data) == null) {return false;}
		else {return true;}
	}
	
	public BSTNode<T> find(T key) {
		return recursiveFind(root,key);
	}
	
	private BSTNode<T> recursiveFind(BSTNode<T> node,T key) {
		if (node == null || node.data.equals(key)) {
			return node;
		} else if (key.compareTo(node.data) < 0) {
			return this.recursiveFind(node.leftChild, key);
		} else if (key.compareTo(node.data) > 0) {
			return this.recursiveFind(node.rightChild, key);
		} else {
			return node;
		}
	}
	
	//This method creates a test tree that you can use as
	//you build out your find and insert methods
	//After you have created your insert method, 
	//you should use that method to create test trees in the main method
	public static BinarySearchTree<Integer> testTree(){
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(9);
		bst.root.rightChild = new BSTNode<Integer>(11);
		bst.root.leftChild = new BSTNode<Integer>(7);
		bst.root.leftChild.leftChild = new BSTNode<Integer>(2); 
		bst.root.leftChild.rightChild = new BSTNode<Integer>(8); 
		bst.root.rightChild.rightChild = new BSTNode<Integer>(15); 
		return bst;
	}
	
	public String toString() {
		return recursiveToString("Tree: ", root, "");		
	}	

	private String recursiveToString(String s,  
			BSTNode<T> node, String indent) {
		if(node != null) {
			s += "\n" + indent + node.data;
			indent += "  ";
		
			s = recursiveToString(s, node.leftChild, indent);
			s = recursiveToString(s, node.rightChild, indent);
		}
		return s;
	}
	
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = testTree();
		System.out.println(bst);

		System.out.println(bst.contains(8));
//		bst.insert(3);
//		bst.insert(4);
//		System.out.println(bst.toString());
		bst.delete(2);
		System.out.println(bst.toString());
	}
	

}
