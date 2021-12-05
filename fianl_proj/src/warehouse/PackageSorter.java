/**
 * Author  : Yipeng Liu
 * Class   : CS 46B
 * Project : Final Project: worked example for BST
 * Date    : 12/04/2021
 * Resources used: Lecture 22 BST lecture code example
 */
package warehouse;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * @author Yipeng Liu
 * @author Bufan Zhou
 *
 */
public class PackageSorter implements Queue<Package> {
	private static class BSTNode<T extends Comparable<T>>{
		private T data;
		private BSTNode<T> leftChild;
		private BSTNode<T> rightChild;
		
		public BSTNode(T data) {
			this.data = data;
		}
	}
	
	private BSTNode<Package> root;
	
	/**
	 * Constructor
	 */
	public PackageSorter() {
		// TODO Auto-generated constructor stub
		this.root = null;
	}
	
	/**
	 * Inserts the data to the tree
	 */
	public void insert(Package data) {
		root = recursiveInsert(root, data);
	}
	
	/**
	 * A private helper method to recursively insert the data into the tree.
	 */
	public BSTNode<Package> recursiveInsert(BSTNode<Package> node,Package data) {
		if (node == null) 
			return new BSTNode<Package>(data);
		else if(data.compareTo(node.data) < 0)
			node.leftChild = recursiveInsert(node.leftChild,data);
		else if(data.compareTo(node.data) > 0) 
			node.rightChild = recursiveInsert(node.rightChild,data);
		return node;
	}
	
	/**
	 * 
	 * @param data
	 */
	public void delete(Package data) {
		this.root = this.recursiveDelete(data, this.root);
	}
	
	/**
	 * A private helper method that recursively deletes the data from the tree.
	 * @param data
	 * @param node
	 * @return
	 */
	private BSTNode<Package> recursiveDelete(Package data, BSTNode<Package> node) {
		if (node == null) {
			return null;
		} else if (data.compareTo(node.data) < 0) {
			node.leftChild = this.recursiveDelete(data, node.leftChild);
		} else if (data.compareTo(node.data) > 0) {
			node.rightChild = this.recursiveDelete(data, node.rightChild);
		} else { // data.equals(node.data)
			if (node.leftChild == null && node.rightChild == null) {
				return null;
			} else if (node.leftChild == null) {
				return node.rightChild;
			} else if (node.rightChild == null) {
				return node.leftChild;
			} else {
				BSTNode<Package> leftMax = this.getMax(node.leftChild);
				Package tempData = leftMax.data;
				node.data = tempData;
				node.leftChild = this.recursiveDelete(tempData, node.leftChild);
			}
		}
		return node;
	}
	
	/**
	 * Returns the node with the maximum data starting with a root node.
	 * @param root
	 * @return
	 */
	public BSTNode<Package> getMax(BSTNode<Package> root) {
		while (root.rightChild != null) {
			root = root.rightChild;
		}
		return root;
	}
	
	/**
	 * Returns the node with the minimum data starting with a root node.
	 * @param root
	 * @return
	 */
	public BSTNode<Package> getMin(BSTNode<Package> root) {
		while (root.leftChild != null) {
			root = root.leftChild;
		}
		return root;
	}
	
	public boolean contains(Package data) {
		if(find(data) == null) {return false;}
		else {return true;}
	}
	
	public BSTNode<Package> find(Package key) {
		return recursiveFind(root,key);
	}
	
	private BSTNode<Package> recursiveFind(BSTNode<Package> node, Package key) {
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
	
	/**
	 * This method creates a test tree that can be used for testing.
	 * @return
	 */
	public static PackageSorter testSortor(){
		PackageSorter bst = new PackageSorter();
		// Add more.
		return bst;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Package> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Package> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean add(Package e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean offer(Package e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Package remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Package poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Package element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Package peek() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return recursiveToString("Tree: ", root, "");		
	}	
	
	/**
	 * 
	 * @param s
	 * @param node
	 * @param indent
	 * @return
	 */
	private String recursiveToString(String s,  
			BSTNode<Package> node, String indent) {
		if(node != null) {
			s += "\n" + indent + node.data;
			indent += "  ";
		
			s = recursiveToString(s, node.leftChild, indent);
			s = recursiveToString(s, node.rightChild, indent);
		}
		return s;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
