// design a hash table to implement open-address hashing data structure
// employee structure is the data structure in lab2
// each employee should also have an int variable employee_no

public class EmployeeTable {

	// proper instance variables
	Object[] keys; // employee ids
	Object[] data; // employees
	boolean[] used;
	int num;
	
	// proper constructors
	public EmployeeTable(){
		keys = new Object[733];
		data = new Object[733];
		used = new boolean[733];
		for(int i = 0; i < used.length; i++)
			used[i] = false;
		num = 0;
	} // end constructor
	
	// hash function
	private int hash(Object e) {
		return Math.abs(e.hashCode()) % keys.length;
	} // end hash
	
	
	
	// find index of key
	private int findIndex(Object e) {
		int idx = hash(e);
		int counter = 0;
		while(counter< data.length && used[idx]) {
			if(e == keys[idx])
				return idx;
			else {
				idx++; counter++;
			} // end else
		} // end while
		
		return -1; // can't find search key
	} // end findIndex
	
	// add a new employee, e, into the hash table
	public void put(Employee e) {
		
		// hash table is full (special)
		
		// calculate index of employee
		int idx = findIndex(e);
		
		// case 1: employee exists
		if(idx != -1)
			data[idx] = e;
		
		else { // case 2: employee does not exist
			idx = hash(e);
			
			// loop to next available idx
			if(keys[idx] != null) {
				while(used[idx]) {
					if(idx == used.length-1) {
						idx = 0;
					} // end if
					else
						idx++;
				} // end while
			} // end if
		
			keys[idx] = e.getNo();
			data[idx] = e;
			used[idx] = true;
			num++;
		} // end else
		
	} // end put
	
	/*public Object get(Object e) {
		int idx = findIndex(e);
		// case 1: employee does not exist
		if(idx == -1)
			return null;
		else
			return e;
	} // end get*/
	
	// remove a given employee with id emp_no from hash table
	// return false if an employee with emp_no does not exist in the hash table
	// otherwise, remove it and return true
	public boolean remove(int emp_no) {
		int idx = findIndex(emp_no);
		if(idx == -1)
			return false;
		else {
			keys[idx] = null; data[idx] = null; num--;
			return true;
		} // end else
	} // end remove
	
	// find the index of the given employee id emp_no
	// return the index of the employee in the array if the employee with the given id exists
	// otherwise return -1
	public int search(int emp_no) {
		int idx = findIndex(emp_no);
		if(idx != -1)
			return idx;
		else
			return -1;
	} // end search
	
	// test cases
	public static void main(String args[]) {
		
		System.out.println("Creating an EmployeeTable group1...");
		EmployeeTable group1 = new EmployeeTable();
		
		System.out.println("Creating a new employee emp1...");
		Employee emp1 = new Employee();
		emp1.setName("Rick Sanchez"); emp1.setAge(55); emp1.setNo(137); emp1.setState("TX"); emp1.setZip(80501);

		// add employee to employee table
		System.out.println("Adding emp1 to group1 using put method...");
		group1.put(emp1);
		
		// test search
		System.out.println("\nSearching for employee with no. 137 in group1...");
		int idx = group1.search(137);
		if(idx != -1)
			System.out.println("Employee was found at index " + idx + ".");
		else
			System.out.println("Employee was not found in the table.");
		
	} // end main
	
	// HashMap java class implements hash table
	// design main function to utilize functions of this data structure
	
	// use Employee data structure from lab2, you can reuse code
	// (set the key to be employee no and the value to be an instance of an employee)
	
	// add all the employees in the data file to the HashSet structure
	
	// remove employees with nos...
	
	// search employees with nos...
	
	// show the size of the data structure that keeps the employees after the adding, removal, and search operation
	
} // end EmployeeTable
