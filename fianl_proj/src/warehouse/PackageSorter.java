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
	 * 
	 */
	public void insert(Package data) {
		root = recursiveInsert(root, data);
	}
	
	/**
	 * 
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
	 */
	public PackageSorter() {
		// TODO Auto-generated constructor stub
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