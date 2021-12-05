/**
 * Author  : Yipeng Liu
 * Class   : CS 46B
 * Project : Final Project: worked example for BST
 * Date    : 12/04/2021
 * Resources used: Lecture 22 BST lecture code example
 */
package warehouse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.TreeSet;

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
	
	/**
	 * Return the number of packages in the tree of the PackageSorter
	 */
	@Override
	public int size() {
		return this.sizeRecurse(this.root);
	}
	
	/**
	 * A recursive helper method to count the nodes in the tree (pre-order)
	 * @param node
	 * @return
	 */
	private int sizeRecurse(BSTNode<Package> node) {
		if (node == null) {
			return 0;
		}
		return 1+this.sizeRecurse(node.leftChild) + this.sizeRecurse(node.rightChild);
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public boolean contains(Object o) {
		if(find((Package) o) == null) {return false;}
		else {return true;}
	}
	
	/**
	 * A recursive helper method that populates an ArrayList with an in-order traversal.
	 * @param list
	 * @param node
	 */
	private void collectToList(ArrayList<Package> list, BSTNode<Package> node) {
		if (node == null) {
			return;
		}
		this.collectToList(list, node.leftChild);
		list.add(node.data);
		this.collectToList(list, node.rightChild);
	}

	@Override
	public Iterator<Package> iterator() {
		ArrayList<Package> packages = new ArrayList<Package>();
		this.collectToList(packages, this.root);
		return packages.listIterator();
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
		StringBuilder result = new StringBuilder();
		if(!this.isEmpty()) {
			for (Package p : this) {
				result.append(p);
			}
		}
		return result.toString();
	}
	
	public String toStringPreOrder() {
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
		Package package1 = new Package("apples", "San Jose", "2022-02-11");
		Package package2 = new Package("bananas", "San Jose", "2022-03-04");
		Package package3 = new Package("pears", "Los Angeles", "2022-01-02");
		Package package4 = new Package("pork", "Los Angeles", "2022-03-13");
		Package package5 = new Package("chicken", "New York", "2022-01-07");
		Package package6 = new Package("rice", "New York", "2022-01-01");
		Package package7 = new Package("pants", "San Diego", "2022-02-07");
		Package package8 = new Package("socks", "San Diego", "2022-02-09");
		Package package9 = new Package("shoes", "San Francisco", "2022-01-23");
		Package package10 = new Package("iPad", "San Francisco", "2022-01-23");
		
		PackageSorter ps = new PackageSorter();
		
		ps.insert(package1);
		ps.insert(package2);
		ps.insert(package3);
		ps.insert(package4);
		ps.insert(package5);
		ps.insert(package6);
		ps.insert(package7);
		ps.insert(package8);
		ps.insert(package9);
		ps.insert(package10);
		
		System.out.println("test insert()");
		System.out.println(ps);
		
		ps.delete(package7);
		System.out.println("test delete()");
		System.out.println(ps);
		
		ps.delete(package1);
		System.out.println("test delete()");
		System.out.println(ps);
	}
}
