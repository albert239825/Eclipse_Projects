
public abstract class Account {
	
	double funds;
	String owner;
	
	//An Abstract class must have AT LEAST ONE ABSTRACT METHOD
	public abstract void deductFunds(double money);
	
	public Account(double f, String o) {
		this.funds = f;
		this.owner = o;
	}
}
/*
Cannot create an instance of an abstract class
Account a = new SavingsAccount()
This is so that we can create an array of accounts 
	(can be made up of saving accounts and other classes that extend the abstract class

Example: 
Abstract class: Mammal
Nobody says look at that mammal, they say look at that dog

Any subclass that extends a abstract class, that subclass must implement all methods defined in the abstract class

Abstract classes are used when you know that all child classes will share a method, even if it is implemented differently

BIG TAKE AWAY:
An Abstract class must have AT LEAST ONE ABSTRACT METHOD
Only can extended one class
can extend multiple interfaces
Cannot define an abstract method in an abstract class 

Static Binding:
Object a = "Hi beta"
int x = a.length() //ERROR this is static binding
Do I have this method
Compile time error

Dynamic binding:
int x = ((String) cup).length();
What method do I call?
runtime error

Static Meaning:
Used Designate that something exists as part of a class not just a specific object
Static variables and methods exist even if it is not initiated

class Monster {
	String name
	Static int count = 0;
	
	Public Monster() {
		name = "";
		count++;
	}
}

If I create a monster count == 1
If I create another monster, count for both will == 2

Monster a = new Monster();
a.count == 1
Monster b = new Monster();
a.count == 2;
b.count == 2;

if you set a static variable to something, it assigns that value to all instances of that object
if Private
a.setCount(500);

a.count == 500;
b.count == 500;

*/