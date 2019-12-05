// Bryant Hernandez
// CS 272 - Lab 2

import java.util.Arrays;
public class Employee {
	
	// instance data
    private String name;
    private int no;
	private int age;
	private String state;
	private int zip;
	private int [] advisors = new int [3];
	
	// No-argument constructor
	public Employee() {
		name = null;
		no = 0;
		age = 0;
		state = null;
		zip = 0;
		advisors = null;
	} // end constructor
	
	// Copy constructor
	public Employee (Object obj) {
		if ((obj != null) && (obj instanceof Employee)) {
			// Create new instance of Employee object
			Employee emp= (Employee) obj;
			this.name = new String(emp.name);
			this.no = emp.no;
			this.age = emp.age;
			this.state = new String(emp.state);
			this.zip = emp.zip;
			for(int i = 0; i<emp.advisors.length; i++)
				this.advisors[i] = emp.advisors[i];
		} // end if
	} // end constructor
	
	// get and set methods
		// Name
			public String getName() {
				return name;
			}
			public void setName( String na ) {
				name = na;
			}
		// No
			public int getNo() {
				return no;
			}
			public void setNo( int n ) {
				no = n;
			} 
		// Age
			public int getAge() {
				return age;
			}
			public void setAge ( int a ) {
				age = a;
			}
		// State
			public String getState() {
				return state;
			}
			public void setState( String st ) {
				state = st;
			}
		// Zip
			public int getZip() {
				return zip;
			}
			public void setZip( int z ) {
				zip = z;
			}
		// Advisors
			public int[] getAdvisors() {
				return advisors;
			}
			public void setAdvisors( int a, int b, int c ) {
				advisors = new int [] {a, b, c};
			}
			
	// toString method
		public String toString() {
			String r = "Name: " + name + "\nNo: " + no + "\nAge: " + age + "\nState: "
						+ state + "\nZip: " + zip + "\nAdvisors: " + Arrays.toString(advisors);
					
			return r;
		}
		
	// equals method
	public boolean equals (Object obj) {
		if ((obj != null) && (obj instanceof Employee))
		{
			Employee candidate = (Employee) obj;
			return (candidate.no == no);
		}
		else
			return false;
	} // end equals
		
	// create method to check array for duplicates (static)
	public static boolean contains(int[] arr, int key) {
		for (int i : arr) {
			if (key == i)
				return true;
		}
		return false;
	} // end contains
	
	// static method
	public static int [] getAllAdvisors(Employee e1, Employee e2) {
		int [] all = new int [6];
		if ((e1 != null) && (e2 != null)) {
			int cnt = 0;
			for (int i = 0; i<e1.getAdvisors().length; i++) {
				if(contains(all, e1.getAdvisors()[i]))
					continue;
				else
					all[cnt] = e1.getAdvisors()[i];
				cnt++;
			}
			for (int i = 0; i<e2.getAdvisors().length; i++) {
				if(contains(all, e2.getAdvisors()[i]))
					continue;
				else
					all[cnt] = e2.getAdvisors()[i];
				cnt++;
			}
		} // end if
		
		// check for all non-zero integers
		int cntr = 0;
		for (int i = 0; i < all.length; i++) {
			if (all[i] != 0)
				cntr++;
		}
		// check array for 0's then add all non-zeros to new array
		int [] allf = new int [cntr];
		for (int i = 0; i < all.length; i++) {
			if (all[i] == 0)
				break;
			else
				allf[i] = all[i];
		} // end for
		
		return allf;
	} // end static
	
// MAIN METHOD
	public static void main(String args[]) {
		// thoroughly test code, design test cases
	
		// test no-argument constructor
		Employee w1 = new Employee();
		
		// test toString
		System.out.println("Printing w1...\n" + w1.toString());
		
		// test set methods
		System.out.println("\nTesting set methods on w1...");
		w1.setName("Steve Jobs"); w1.setNo(800123456); w1.setAge(64); w1.setState("CA"); w1.setZip(94016); w1.setAdvisors(25, 34, 88);
		System.out.println("w1 has been updated.");
		
		// test get methods
		System.out.println("\nTesting get methods on w1...");
		System.out.println("Name: " + w1.getName());
		System.out.println("No: " + w1.getNo());
		System.out.println("Age: " + w1.getAge());
		System.out.println("State: " + w1.getState());
		System.out.println("Zip: " + w1.getZip());
		System.out.println("Advisors: " + Arrays.toString(w1.getAdvisors()));
		
		// test copy constructor
		Employee w2 = new Employee (w1);
		System.out.println("\nCopying w1 to w2, then printing w2...\n" + w2.toString());

		// test arrays are not linked
		w1.setAdvisors(174, 554, 58);
		System.out.println("\nChanging advisors for w1, then printing w1 and w2...\nw1\n" + w1.toString() + "\nw2\n" + w2.toString());
		
		// test equals method
		System.out.println("\nTesting wether Employees w1 and w2 are equal.");
		if(w1.equals(w2))
			System.out.println("w1 and w2 are equal.");
		else
			System.out.println("w1 and w2 are not equal.");
		
		// create another employee
		Employee w3 = new Employee();
		w3.setName("Jeff Bezos"); w3.setNo(800778948); w3.setAge(55); w3.setZip(87101); w3.setState("CA"); w3.setAdvisors(74, 59, 11);
		System.out.println("\nPrinting w3...\n" + w3.toString());
		
		// test equals method
				System.out.println("\nTesting wether Employees w1 and w3 are equal.");
				if(w1.equals(w3))
					System.out.println("w1 and w3 are equal.");
				else
					System.out.println("w1 and w3 are not equal.");
		
		// test getAllAdvisors method
		System.out.println("\nTesting the getAllAdvisors method using w1 and w2...");
		System.out.println(Arrays.toString(getAllAdvisors(w1, w2)));
		
		// test getAllAdvisors method
				System.out.println("\nTesting the getAllAdvisors method using w1 and w1...");
				System.out.println(Arrays.toString(getAllAdvisors(w1, w1)));
		
	} // end main
			
} // end class
