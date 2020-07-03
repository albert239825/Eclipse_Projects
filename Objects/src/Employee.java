
//Class Employee
public class Employee implements Comparable<Employee>, Expenses {
	/*
	// Overridding method - Classes
	// B extends A
	 *  	A has method egg()
	 *  	B has method egg()
	 *  Same Method Name, Same Parameters, Same return type
	 *  	Child class overrides parent class' egg()
	 *  
	 *  
	 *  Overloading Methods
	 *  	Two Methods, Same Name, Different Parameters
	 *  public raise (int r)      <------|
	 *  public raise (double r)   <------|  This is valid
	 *  public raise (String r)   <------|
	 *  public raise (int c) <---- NOT ALLOWED
	 *  
	 *  Polymorphism: The mechanism of selecting the appropriate method for a particular object in the class heirarchy
	 *  Inheritance: Parent and Child classes
	 *  
	 *  Dynamic Binding - We make a decision at run time, for which method is called
	 *  A cur = new B();
	 *  	At Compile: cur = A
	 *  	At Run: cur = B
	 *  
	 *  Static Binding/Early Binding
	 *  	This happens with overloaded methods at compile time
	 *  	Determines which method it will call
	 *  	Call raise(int r) or raise (double r)
	 *  
	 *  public boolean equals(Employee e2) {
	 *  	if (this.salary == e2.salary) {
	 *  		return true;
	 *  	}
	 *  	else {
	 *  		return false;
	 *  	}
	 *  }
	 */
	private String name;
	private double salary;
	private double hoursWorked;

	Employee() {
		name = null;
		salary = 0.0;
		hoursWorked = 0.0;
	}

	Employee(String name, double salary, double hoursWorked) {
		this.name = name;
		this.salary = salary;
		this.hoursWorked = hoursWorked;
	}

	Employee(String n, double s) {
		this.name = n;
		this.salary = s;
		this.hoursWorked = 8;
	}

	//Accessors and Mutators / Getters and Setters
	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}
	
	public double getExpenses() {
		return salary;
	}

	public void setSalary(double sal) {
		this.salary = sal;
	}


	public void raise(int r) {
		salary += r;
	}

	public String toString() {
		return "Name: " + name + "\nSalary: " + salary;
	}
	public boolean equals(Employee e2) {
		if (this.salary == e2.salary) {
			return true;
		}
		else {
			return false;
		}
	}

	public int compareTo(Employee o) {
		return (int) (this.hoursWorked - o.hoursWorked);
	}
	
	
}
