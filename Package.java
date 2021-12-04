/**
 * Author  : Yipeng Liu
 * Partner : Bufan Zhou
 * Class   : CS 46B
 * Project : Final Project: worked example for BST
 * Date    : 12/03/2021
 */
package warehouse;

import java.time.LocalDate;
import java.util.Iterator;

/**
 * A package that arrives at the warehouse.
 * @author Yipeng Liu
 * 
 * @see LocalDate
 */
public class Package implements Comparable<Package>{
	private String name;
	private String destination;
	private LocalDate dueDate;
	
	/**
	 * Default Constructor
	 */
	public Package() {
		this.name = null;
		this.destination = null;
		this.dueDate = null;
	}
	
	/**
	 * Explicit Constructor: LocalDate version
	 * @param name
	 * @param destination
	 * @param dueDate
	 */
	public Package(String name, String destination, LocalDate dueDate) {
		this.name = name;
		this.destination = destination;
		this.dueDate = dueDate;
	}
	
	/**
	 * Explicit Constructor: String date version
	 * 
	 * @param name
	 * @param destination
	 * @param dueDateStr: a text string such as 2007-12-03. 
	 */
	public Package(String name, String destination, String dueDateStr) {
		this.name = name;
		this.destination = destination;
		this.dueDate = LocalDate.parse(dueDateStr);
	}
	
	/**
	 * First compare by dueDate, then by destination, and lastly by name.
	 */
	@Override
	public int compareTo(Package o) {
		if (!this.dueDate.equals(o.dueDate)) {
			return this.dueDate.compareTo(o.dueDate);
		} else if (!this.destination.equals(o.destination)) {
			return this.destination.compareTo(o.destination);
		}
		return this.name.compareTo(o.name);
	}
	
	@Override
	public boolean equals(Object o) {
		return this.compareTo((Package) o) == 0;
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode() + this.destination.hashCode() + this.dueDate.hashCode();
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("**************\n");
		result.append("Package Name: ");
		result.append(this.name);
		result.append("\n");
		result.append("Destination : ");
		result.append(this.destination);
		result.append("\n");
		result.append("Due Date    : ");
		result.append(this.dueDate);
		result.append("\n");
		return result.toString();
	}
	
	public static void main() {
		
	}
}
