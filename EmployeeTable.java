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
	public int hashCode(int employee_no) {
		// hash code of employee no % size_of_array_for_keys
	} // end hashCode
	
	// add a new employee, e, into the hash table
	public void put(Employee e) {
		
	} // end put
	
	// remove a given employee with id emp_no from hash table
	// return false if an employee with emp_no does not exist in the hash table
	// otherwise, remove it and return true
	public boolean remove(int emp_no) {
		
	} // end remove
	
	// find the index of the given employee id emp_no
	// return the index of the employee in the array if the employee with the given id exists
	// otherwise return -1
	public int search(int emp_no) {
		
	} // end search
	
	// test cases
	
	// HashMap java class implements hash table
	// design main function to utilize functions of this data structure
	
	// use Employee data structure from lab2, you can reuse code
	// (set the key to be employee no and the value to be an instance of an employee)
	
	// add all the employees in the data file to the HashSet structure
	
	// remove employees with nos...
	
	// search employees with nos...
	
	// show the size of the data structure that keeps the employees after the adding, removal, and search operation
	
} // end EmployeeTable
