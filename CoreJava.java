
Class Declaration
------------------------------------------

<public> <abstract> <final> class className
		<extends superclassName>
		<implements interfaceName>

		{
			//class body( consists of attributes and methods)
		}


Class Attributes and Methods
-------------------------------
datatype Variable;	<---------Attributes
Ex: int a;	
    float b;
			local variable
			  |	
public void setMethod(int a){	<--------Methods(Functions)
	this.a=a;	
}

public int getMethod(){
	return a;
}




Difference b/w array and VARARGS(Variable Length Arguments) in Method Parameter
----------------------------------------------------------------------------------
Class Car{

public void setTirePressures(int[] pressures){   <---int[] array
	
}

public void setTirePressures(int ... pressures){    <---varargs 

}
}
Public static void main(String[] args){

Car car1= new Car();

car1.SetTirePressures(31,22,32,33);		<------This is will work on VARARGS not on int[] array
car1.SetTirePressures(new int[]{31,22,32,33});	<------This will work on both

}

NOTE: Both are int[] arrays


Method Variable(Local Variable) and Ternary Operatoer
------------------------------------------------------------
--Local variable are accessible only inside the block { } that generated

public class Car{
	public int speed;   <--------Global Variable
	public int gasoline;

public void setSpeed(int newSpeed){
     	int maxSpeed=60;    <--------Local Variable

	speed = newSpeed <= maxSpeed ? newSpeed : maxSpeed;

		       condition     ?    if    :   else  ;  <-----------Ternary Operator

}
}


Method OverLoading 
----------------------------------------------
There are two ways to overload the method in java

1.By changing number of arguments

    	public int add(int a,int b){	<-----------2 arguments
		return a+b;
	}
        public int add(int a, int b, int c){	<------3 arguments
		return a+b+c;
	}
	

2.By changing the data type

	public int multiply(int a,int b){	<-----------int return type and int type arguments
		return a*b;
	}	
	
	public double multiply(double a,double b){	<----------- double return type and double type arguments
		return a*b*c;
	}	

Method OverRiding
-------------------------------------------------

Rules for Java Method Overriding
1.The method must have the same name as in the parent class
2.The method must have the same parameter as in the parent class.
3.There must be an IS-A relationship (inheritance).


class Vehicle{  

  	void run(){
		System.out.println("Vehicle is running");
	}  

}  

//Creating a child class  

class Bike extends Vehicle{  
	
  	void run(){		<----------- defining the same method as in the parent class  
		System.out.println("Bike is running safely");
	}  

  	public static void main(String args[]){ 					
  		Bike obj = new Bike();  	<-------creating an instance of child class  			 
  		obj.run();  			<-------calling the method with child class instance 
  }  
}  

Constructor
-------------------------
A Constructor is a special type of method that java uses to create instances of a class.
	--The  constructor has no return value not even void.
	--Must have the same name as the class it initializes.
----A Class can have any No. of constructors with different signatures(must).
	Signature means method overloading (diff data type parameters/arguments)

1.No argument constructor

	Car() { 
		//code
	}
2. single argument constructor
3.multiple argument constructor

--One Constructor can call another Constructor in the same Class using the  " this() " statement
Ex: 

	Car(int newSpeed){		<----Single Argument Constructor
		speed = newSpeed;
	}
	
	Car(int newSpeed, boolean en){		<----Multiple Arguments Constructor
		this(newSpeed);			<----Calling first Constructor using this()
		engineState= en;
	}

Declaring Constants
-------------------------
--To declare constant use final keyword.
--the variable name should be UPPERCASE with UnderScore as per naming rule.
--Declaring an attribute to be FINAL means that its value cannot be changed once assigned a value.

Ex:
	public final int MAX_SPEED = 65;
	public static final int MAX_SPEED = 65;

static keyword
------------------
--when u declare a method to be static, it is not allowed to access any instance attributes.
--when calling a static method, just use the class name not the instance name
	Ex: double squareRoot= Math.sqrt(4.2);	<-----className.method(arg) 
	//Math ma = new Math();			<----objInstance.method(arg) is wrong 
	//ma.sqrt(4.2);
		
EX: public static int void main(String[] args)
-- Math.min, Math.sin etc.. all are static methods

New Keyword
-------------------
Car car1;	<--------car1 is reference for object and creates " reference table "
car1 = new Car();	<------assigning object instance to object reference using "new" keyword
				by calling the  no argument constructor

--The new operation will fill in the addresses for the attributes and method memory locations.
--Reference table is used to keep track of the objects it has constructed


Working with objects
--------------------------
public Car{
 	public int gasoline; 
}	
--if its public int gasoline; , we can set gasoline value using dot notation 
	Ex: Car.gasoline = 12;

--if its private int gasoline; , we need to follow the below

--> To work with object first we need to instantiate the object and then manipulate the object via its methods.
Ex:
	public Car{
		private int gasoline;
		
		public int getGasoline(){
			return gasoline;
		}

		public void setGasoline(int gasoline){
			this.gasoline=gasoline;
		}
	}
	
	Car racerX= new Car();	<--------Instantiate the object
	if(racerX.getGasoline() < 2){	<------manipulating its objects
		racerX.setGasoline(12);
	}


JAR Files and Namespaces
-------------------------------
Java Provides a program that collects all of the class files into file called a "JAR".

Ex:lib/rt.jar, lib/tools.jar, lib/dt.jar

--Packages allows you to have two different classes with the same name, as long as they are in different packages

Ex: package com.lq.Car.Driver;		<----------fully qualified name
    package com.sql.Data.Driver;

Packages are useful: 

	1. To make classes easier to find and use
	2. To organize the project program elements
	3. To avoid Naming Conflicts

Packaging classes
------------------------
The CLASSPATH variable lists all the directories where java packages can be found

Creating packages- 
	1. Create a directory with the same name as that of the package.
	2. Define all the classes and interfaces that are to be put in the 	   package and save as .java files in the directory created.
	3. within each source file,  declare the package at the beginning 	   of each file using the "package" keyword followed by a package
	   name.
		
	Ex: package packageName;

Importing packages
-------------------------------------
To  import package to a class from another package to use is
	1. Refering to the full qualified name
		import com.lq.exercises.Car.getName;
	2. Importing the package member
		import com.lq.exercises.Car;
	3. Importing entire package
		import com.lq.exercises.*;

NOTE: Only public package members(attributes and methods) are accessible outside the package in which they are defined

Example:
----------

package com.learnquest.simple;

import java.io.*;	<----all classes are available
import java.sql.Connection;	<-----only connection

public classs DatabaseReader { 
	Connection conn = new Connection();
}

Namespace Clashes
------------------------
if we are importing same named classes from different packages into a single class from another package the namespace clash will occurs then use the fully qualified name. 

Example:
---------
package co.lq;

import java.util.Date;
import java.sql.Date;		

public class DatePrinter
{
	public static void printDate(Date aDate)
	{
		System.out.println(aDate.toString());
	}													
															full qualified name																		|
	public static void printSQLDate(Date aDate)	<----use fully qualified name as " public static void printSQLDate(java.sql.Date aDate) "
	{
		System.out.println(aDate.toString());
	}
}


Math Class
------------------
Note that java.lang.Math is a class, and because it is part of the java.lang package, is implicitly available without importing.  We only use import with java.lang.Math if we are using static imports.

public class Main
{
	public static void main(String[] args) {

		
		String a= "abc".substring(1,2);
		System.out.println(a);

		char data[] = {'a', 'b', 'c'};
        	String str = new String(data);
        	System.out.println(str);

	        char b= "abc".charAt(1);
        	System.out.println(b);

	        System.out.println("helloworld".indexOf("w"));

        	System.out.println("siva".compareTo("s"));

	        System.out.println("siva".contains("b"));

		int min=1000;
		int max=9999;
        	int c = (int)(Math.random()*(max-min+1)+min);  
	        System.out.println(c);  
        
        
	}
}

String class
-------------------
A string object represents an ordered sequence of characters

Note : check string methods and constructors documentation in " https://docs.oracle.com/javase/8/docs/api/ "

--To create a strings anything enclosed in quotes( " " ) is converted to a string reference and object by java.

Ex: String userName = "siva"; 		<---shorthand
    String userName = new String("siva");


String Buffer and String Builder
-----------------------------------
String firstName = "chris";
String lastName = "wells";
String fullName = firstName + " " + lastName;


--System.out.println("Siva"); 	<--this is an anonymous string
 it's not reusable, we won't be able to work with it in any other way.

--The problem is because of the immutable nature of strings, which is necessary in order to use them in things like maps and hash tables, 
every time we want to make a change to a string, we need a new string, so there's a lot of copying.

--That's why it'll impact performance because we're creating lots of objects and eventually, the ones that we're not using anymore need to be garbage collected. 
To help reduce these performance problems, Java from the get-go had a StringBuffer class, from version 1, we already had a StringBuffer class.
In Java 5, they introduced a identical copy of 	string buffer called StringBuilder.

--StringBuilder is going to be used to manipulate string data much more efficiently. 


Example:

String nameString = new String("pete");
String companion = nameString.substring(0,3);	<----this is exclusive
//pet

Dynamic Strings with StringBuilder
-------------------------------------
StringBuilder provides dynamic string manipulation without the performance overhead of the string class

Ex:

StringBuilder nameBuffer = new StringBuider("john");

nameBuffer.append(" ");
nameBuffer.append("Richard");
nameBuffer.append(" ");

nameBuffer.append(" ");
nameBuffer.append("Cornwell");

System.out.println(nameBuffer.toString());	<---coverting to string

Note: StringBuilders must be coverted to Strings before they can be printed.

--StringBuffer and StringBuilder are either one of them avoids the performance issues of the String class in terms of manipulation and editing

--The difference is that the original StringBuffer class was synchronized, which meant that it would work if it was for some reason shared across multiple threads, it would lock itself, so only one thread could work at a time, but most of the time we're simply using it in a single thread. In fact, because of this string concatenation example, Sun had modified the compiler itself to use StringBuffer to do the concatenations under the covers, and those StringBuffers were invisible to you, the programmer, and yet they were incurring the overhead of synchronization.In Java 5, StringBuilder is introduced as a complete work alike of StringBuffer, except it doesn't have that overhead. 


O-O relationships
---------------------------
Is-a
-----
-Inheritance
-A Station wagon(derived class) "is-a" Car(base class)

Has-a(Association)
------
-Aggregation/Composition
-A Car(class) "has-a" engine(attribute)
-Implemented using instance data


Inheritance
---------------------

Inheritance allows us to include the attributes and methods of one class in another related class.

NOTE- A child class can only inherit non-private(public) members of the parent class.

Ex: A StationWagon(sub class) is herits Car(base class) attributes and methods


Polymorphism
-------------------
In java, It means that two or more classes may have the same method name and signature but diff implementations of the code

-polymorphic behaviour in java is defined via inheritance
-A parent class specifies,at least, the name and signature of a method
-All descandants of that parent inherit the declaration
-A class that inherits that method can (re)-implement the method, as necessary, in which every way it wants, including overriding a parents implementation

Ex: Car(parent) has setSpeed method and his child classes StationWagon called sW and  a SportsCar called sC and regard them both as though they were Cars(they inherit the setSpeed method from Car and (override) the method)


Interface
---------------
-In java, Classes can have attributes, method declarations(signatures) and method implementations.

---An interface consists of method signatures(without method implementation)
-An Interface is a list of methods signatures, and any class that inherits from that interface, is going to have to make sure that all of those methods are implemented. This one now ensure that all users of that interface, have access to the same signatures to the method, whether the user is a class that's implementing it, or the user as a class that's calling it, we have a common understanding of the method signatures. This is what enables them to be used polymorphically.


Inheritance
-------------------
In java, a class can inherit from only one other class(single inheritance)

--In java multiple inheritance is not allowed and alternatively introduce Interfaces
-java allows multiple inheritance of interface, just not of class
-An interface is a list of methods that must be coded in any class that uses the interface.
-It ensures that all users of the interfacce use the same signature for the methods, and enables them to be used polmorphically.

-when designing java solutions, starting with interfaces is a good practice
-methods intended for public use initally exists Only in the interface
-define your interfaces, THEN develop classes.

Interface Example
----------------
-Here SUV inherits Cargo and (inherits/implements) the Converitable interface
and similarly SportsCar


		Car(C)
		  /\
	Cargo(c)	SportsCar(c)
	  /\			\
    SUV(c)  StationWagon(c)	 \
	\________________________Convertible(I)


Association(Has-a Relation)
-----------------------------
Association allows objects of one class to send "messages" to other objects.

--This allows an object to access the attributes and methods of other objects.
--Association is implemented by holding a reference to the other object

EX: A Car(c)  "has-a" Engine(c)


			has-a
	Car(C)	---------------Engine(c)
		  /\
	Cargo(c)	SportsCar(c)
	  /\			\
    SUV(c)  StationWagon(c)	 \
	\________________________Convertible(I)


java.lang.object class Methods
--------------------------------
1. Object clone ()
2. boolean equals (Object obj)
3. void finalize ()
4. Class getClass ()
5. int hashCode ()
6. String toString ()
7. Void notify ()
8. void notifyAll ()
9. void wait ()
10. void wait (long ms)
11. void wait (long ms, int ns)

NOTE: check java.lang(package) and Object class in https://docs.oracle.com/javase/8/docs/api/index.html


Implementing hashCode(), equals(), toString() methods in Car(base) class
-------------------------------------------------------------------------
Note: overriding from object class

hashCode()-Get a value that represents this object, as uniquely as possible within the confines of an int
-----------

@Override
public int hashCode(){
	return carName.hashCode;
}

equals()-Determine whether this object is semantically equal to another object
--------

@Override
public boolean equals (Object obj) {
	if(!(obj instanceof Car))         <---checking is this obj is instanceof car
		if(obj == this)    <--------checking null 
			return true;
	Car other = (Car) obj;   <-----boxing
	return name.equals(other.getCarName());

toString()-Convert this object to human readable string
----------

@Override
Public String toString(){
	if(manufactured== null)
		return String.format("%s has %d gas ", getCarName(), getGasoline());  <----alternate for System.out.printf method
	else
		return String.format("%s has %d gas and it is %d years old", getCarName(), getGasoline(), getAge());
}


Inheritance in java
------------------------------------------------

Multilevel Inheritance
-----------------------
-Multilevel inheritance allows several levels of superclass.
-In Java a class can only extend from one other class.

EX: A <--- B <--- C 


Hierachical Inheritance
-------------------------
-Hierachical Inheritance has one superclass and many subclasses

EX:        A(super)
	/     \
	B     C
		
Overloading Existing methods
------------------------------
An overloaded method has the same name as another method in the same class(or in a parent class) but has a diff parameter list
Ex: Constructors
    Print methods
EX: 

#PARENT CLASS
public class Car{

	private String name;
	private int speed;

	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}

	public int getSpeed(){
		return name;
	}
	
	public void setSpeed(int speed){
		this.speed=speed;
	}

}

#SUB CLASS
public class SportsCar extends Car{
	
	@override				<---------overriding
	public void setSpeed(int speed){
		super.setSpeed(speed *10); // overriding speed as 10 times greater
	}

	protected double speed;	//new attribute		<---------overloading
	public void setSpeed(double speed){	//changing the signature from int to double
		this.speed=speed;
	}
	

}



Constructors
----------------

A class should have default constructor with no arguments
public Car{
	public Car() { 	<----default constructor
		super();
	}
 } 

Super() : Super is used to call the parent class constructors in child class constructors
--------
Note: super() is always should be the first line of code in the constructor

Note: if we dont provide default constructor, java will provides


--If there is no default constructor in parent class, it will show error in the child class for default constructor

//parent
public Car{


	public Car(String name) { 
		this.name=name;
	}
 } 

//child
public SportsCar{
	public SportsCar() { 
		super();	<----error
	}

}
	

Abstract Class
----------------------------------
An abstract class is class that may not be instantiated
Car car= new sportsCar();
--References can be created from an abtract class
Car car1;
--An abstract class is a class,we can include attributes, methods, and abstract methods.
-- Abstract methods have no code, they're basically placeholders with a signature.
Example:
---------
public abstract class Car{		<----absract class
	private String name;		<--attributes
	protected int speed;

	public int getSpeed(){		<----methods(With code)
		return speed;
	}
	
	public abstract void setSpeed(int speed);	<----abstract method(without code)
}


--In Car class,we had this issue of max speed being a private static constant of this class, and different types of cars might have different max speeds. We're no longer going to have this private static final int MAX_SPEED=200 constant. 

public class Car{
	private static final int MAX_SPEED=200;
}

--Instead, We're going to have a public abstract method called getMaxSpeed, because individual cars has individual MAX_SPEED and by using abstract method we can set individual MAX_SPEED in each Car instances.

public abstract class Car{	<---abstract class
	public abstract int getMaxSpeed();	<----abstract method

}

NOTE:
------
--If SportsCar is an child class of Car class, it must implement the getMaxSpeed methods since that's the abstract,
--we can either make SportsCar/Cargo itself as abstract or implement that method.

public abstract class Cargo extends Car{	<--abstract class and implementation
	@Override
	public int getMaxSpeed(){
		return 100;
	}
}

public class SportsCar extends Car{	
	@Override			<--implementation
	public int getMaxSpeed(){
		return 200;
	}
}

Concrete Class
---------------
A Concrete class extends an abstract class and provides an implementation for all inherited abstract methods or declare itself as abstract class.

//parent
public abstract class Car{		<----absract class
	private String name;		<--attributes
	protected int speed;

	public int getSpeed(){		<----methods(With code)
		return speed;
	}
	
	public abstract void setSpeed(int speed);	<----abstract methods(without code)
	public abstract void setName(String name);
}

//Child
public class SportsCar extends Car{	
	@Override			<--implementation
	public void setSpeed(int speed){
		this.speed=speed;
	}
	@Override			<--implementation
	public void setName(String name){
		this.name=name;
	}
}

Reference type
-----------------

Car car1  =new Car();	//Car() is a constructor
|     |		|
type  reference	object

--we can get access to the methods, which was declared only in the type
public class Car{
	private String name;		
	protected int speed;

	public int getSpeed(){		
		return speed;
	}
}

public class SportsCar extends Car{
	public race(){
		setSpeed(MAX_SPEED);
	}
}

SportsCar car= new SportsCar();
Car car1=car;

car.race();
car1.race();	//error, because its type is Car and race() is declared in SportsCar

Casting
---------------
--UpCasting
	object<--Car<--Cargo<---SUV
--DownCasting
	object-->Car-->Cargo-->SUV

--Upcasting doesn't need explicit casting, but Downcasting needs
EX:	
	//upcasting
	Car car1=new SportsCar();
	Car car2= (Car) car1;	<---it doesn't need explicit type casting, because a car1 is Car type 


	//downcasting
	SportsCar car1=new SportsCar();
	Car car2= (Car) car1;		<---it needs explicit type casting, because car1 type is SportsCar

Note: A SportsCar is-a  Car and A Car is not a SportsCar

instanceof
--------------
instanceof is checking is this object reference(car1) is an instance of that class(Car)
EX: Car car1=new Car();
	if(car1 instanceof Car){	<---we are checking car1 is an instance of Car
		return true;
	}
	else{
		return false;
	}
	
// Java program to demonstrate working of printf()
 
class JavaFormatter1 {
    public static void main(String args[])
    {
        int x = 100;
        System.out.printf(
            "Printing simple integer: x = %d\n", x);
 
        // this will print it upto 2 decimal places
        System.out.printf(
            "Formatted with precision: PI = %.2f\n",
            Math.PI);
 
        float n = 5.2f;
 
        // automatically appends zero to the rightmost part
        // of decimal
        System.out.printf(
            "Formatted to specific width: n = %.4f\n", n);
 
        n = 2324435.3f;
 
        // here number is formatted from right margin and
        // occupies a width of 20 characters
        System.out.printf(
            "Formatted to right margin: n = %20.4f\n", n);
    }
}
output:
Printing simple integer: x = 100
Formatted with precision: PI = 3.14
Formatted to specific width: n = 5.2000
Formatted to right margin: n =         2324435.2500


Abstract class
------------------	
1) Abstract class can have abstract and non-abstract methods.	
2) Abstract class doesn't support multiple inheritance.	
3) Abstract class can have final, non-final, static and non-static variables.	
4) Abstract class can provide the implementation of interface.	
5) The abstract keyword is used to declare abstract class.	
6) An abstract class can extend another Java class and implement multiple Java interfaces.	
7) An abstract class can be extended using keyword "extends".	
8) A Java abstract class can have class members like private, protected, etc.	
9)Example:
public abstract class Shape{
public abstract void draw();
}	


Interface
----------------
1)Interface can have only abstract methods. Since Java 8, it can have default and static methods also.	
2)Interface supports multiple inheritance.
3)Interface has only static and final variables.
4)Interface can't provide the implementation of abstract class.
5)The interface keyword is used to declare interface.
6)An interface can extend another Java interface only.
7)An interface can be implemented using keyword "implements".
8)Members of a Java interface are public by default.
9)Example:
public interface Drawable{
void draw();
}


Interfaces
------------------------------------------------
An interface can only have final attributes
--An interface can only have abstract methods(without implementation)
--An interface can extend another Java interface only, not class.
--Interfaces can extend one or more interfaces
Syntax:
--------
interface interfaceName{
	static final attributes;
	static methods;
}
interface Bike{
	public static speed;
	public static int Run(Bike speed);

}

Implementing interfaces
---------------------------
To implement an interface, a class must provide an implementation of each method in the interface.
Ex: 
//Interface
interface Convertible{
	void putTopUp();
	void putTopDown();
}

public SUV extends Car implements Convertible {	

	public boolean topIsUp;	
	
	@Override
	public void putTopUp(){
		topIsUp= true;
	}
	@Override
	public void putTopDown(){
		topIsUp= false;
	}
}

--If a given class implements a specific interface, it may be assigned to references of that interface type.
	Convertible ragTopSUV =new SUV();

-- Classes that are otherwise unrelated can be manipulated using an interface they both implement.
 EX:
 SUV is-a(implements) Convertible, SportsCar is-a Convertible

public static void main(String[] args) {
	Convertible[] cars = new Convertible[3];
	
	cars[0] = new SUV();
	cars[1] = new SportsCar();
	cars[2] = new SUV();

	for(Convertible car : cars){
		car.putTopUp();
	}
}

Bean Properties: Bean properties are property(getter and setter) that are setted to atributes that doesn't created/existing.
----------------
Ex:
public interface Vehicle{

	//Bean property for Name
	public String getName();
	public void setName(String name);  <---abstract methods

	//Bean property for Speed
	public int getSpeed();
	public void setSpeed(String speed);

}
NOTE: Here Name and Speed attributes are not created

Example:
		 implements
	Car(C) ---------------> Vehicle
		  /\
	Cargo(c)	SportsCar(c)
	  /\			\
    SUV(c)  StationWagon(c)	 \implements
	\__implements____________Convertible(I)

Extending Interfaces
---------------------
public interface SoftTopWithLight extends Convertible {		//Convertible is also interface
	void turnLightOn();
	void turnLightOff();
}

public interface RearWindowDefogger{
	void turnDefoggerOn();
	void turnDefoggerOff();
}

--An interface can extend/inherit more than one interfaces(multiple inheritance).

public interface DeluxeSoftTop extends SoftTopWithLight, RearWindowDefogger {		<---multiple inheritance(extends)
	String getRoofMaterial();
}

--Here a class called LuxurySportsCar implements all abstract methods of DeluxeSoftTop interface.
--To Manage the data associated with the methods in interfaces, you are typically need to add new attributes.

public class LuxurySportsCar extends SportsCar implements DeluxeSoftTop {
	private boolean lightIsOn;	
	private String roofType;	//attributes for interface methods
	private boolean defoggerIsOn;
	
	@Override
	public void turnLightOn(){
		lightIsOn= true;
	}
	@Override
	public void turnLightOff(){
		lightIsOn= false;
	}
	public boolean isLightOn() {
		return lightIsOn;
	}
	@Override
	public void turnDefoggerOn(){
		defoggerIsOn= true;
	}
	@Override
	public void turnDefoggerOff(){
		defoggerIsOn= false;
	}
	@Override
	public String getRoofMaterial(){
		return getRoofMaterial;

	}
}

--if initially an interface is created and implemented by classes, then we add new method in that interface, the code breakage will happen, we need to refactor(add the @Override for the new method in classes) the classes that implements that interface.
For that disadvantage, In java 8 they introduced Default methods

Default and static Methods
----------------------------
In java 8, when declaring a method  on an interface, adefault implmentation can be provided.
--The default implementation can only be written inn terms of other methods or static members, not instance data.
--The default implementation will be provided to any class that does not otherwise provide its own implementation

public void forward(int distance){
	this.distance=distance;
}
public default void void reverse(int distance){	 <---default method
	forward(-distance);	<--Default implementation
}

//if forward is 10 mts then reverse is -10 mts.


	
public interface CustomInterface {
    
    public abstract void method1();		<---abstract method
    
    public default void method2() {		<---default method
        System.out.println("default method");
    }
    
    public static void method3() {		<---static method
        System.out.println("static method");
    }
}

public class CustomClass implements CustomInterface {

    @Override
    public void method1() {
        System.out.println("abstract method");
    }
    
    public static void main(String[] args){
        CustomInterface instance = new CustomClass();
        instance.method1();
        instance.method2();
        CustomInterface.method3();		//we can't call the static method with the instance of object
						
    }
}

Private Default and private static methods since java 9
-------------------------------------------------------------
Since java 9, you will be able to add private methods and private static method in interfaces.

These private methods will improve code re-usability inside interfaces. Foe example, if two default methods needed to share code, a private interface method would allow them to do so, but without exposing that private method to it’s implementing classes.

Using private methods in interfaces have four rules :

1. Private interface method cannot be abstract.
2. Private method can be used only inside interface.
3. Private static method can be used inside other static and non-static interface methods.
4. Private non-static methods cannot be used inside private static methods.

public interface CustomInterface {
    
    public abstract void method1();
    
    public default void method2() {
        method4();  //private method inside default method
        method5();  //static method inside other non-static method
        System.out.println("default method");
    }
    
    public static void method3() {
        method5(); //static method inside other static method
        System.out.println("static method");
    }
    
    private void method4(){
        System.out.println("private method");
    } 
    
    private static void method5(){
        System.out.println("private static method");
    } 
}

public class CustomClass implements CustomInterface {

    @Override
    public void method1() {
        System.out.println("abstract method");
    }
    
    public static void main(String[] args){
        CustomInterface instance = new CustomClass();
        instance.method1();
        instance.method2();
        CustomInterface.method3();
    }
}

Default Method and Multiple Inheritance Ambiguity Problems
-------------------------------------------------------------
Since Java classes can implement multiple interfaces and each interface can define a default method with the same method signature, the inherited methods can conflict with each other.

EXAMPLE:

public interface InterfaceA { 
    default void defaultMethod(){ 
        System.out.println("Interface A default method"); 
    } 
}

public interface InterfaceB {
    default void defaultMethod(){
        System.out.println("Interface B default method");
    }
}

public class Impl implements InterfaceA, InterfaceB  {
}

--The above code will fail to compile with the following error:

java: class Impl inherits unrelated defaults for defaultMethod() from types InterfaceA and InterfaceB

--In order to fix this class, we need to provide a default method implementation:


public class Impl implements InterfaceA, InterfaceB {

    public void defaultMethod(){  
    }

}
--Further, if we want to invoke default implementation provided by any super interface rather than our own implementation, we can do so as follows:

public class Impl implements InterfaceA, InterfaceB {
    public void defaultMethod(){
        // existing code here..
        InterfaceA.super.defaultMethod();
    }
}
We can choose any default implementation or both as part of our new method.

Functional Interfaces
-------------------------------
Functional Interface is an interface that has only one abstract method declared in it.

Ex: run() (java.lang.Runnable) method
    close() (java.lang.AutoCloseable) method

In java 8, we can use a new annotation that an interface type declaration is intended to be a functional interface

@FunctionalInterface
public interface someInterface {
	
	public void onlyAllowedOneMethod();  //abstract method
}

--Prior to java 8, we use Adapter or Anonymous inner classes to instantiate objects of functional interfaces.

					Parent Class/interface no arg constructor
						|
	button.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {		<---sub class
			System.out.println("The button was clicked using old fashion code!");
		}
	});

Example : for Anonymous inner classes
menu.addItem("Find", new Handler() {
    public boolean handleEvent(Event e) {
        System.out.println("Find for " + e);
        return true;
    } 
});

Lambda Expressions
----------------------------------
A lambda expression is used as an anonymous function.
--A shorthand notation that allows you to write a method in the same place you are going to use it.
--Makes it easy to pass a block of code as a parameter to code that is expecting an implementation of the functional interface.
-- use lambda function as that method used once or locally
	
Syntax:
	(parameters) -> { body }

Ex: (arg1, arg2) -> { code/block of code } 
    (type arg1, type arg2) -> { body }

--for single argument no required of parentheses ()
e -> {body}

--Each lambda expression can be implicitly assigned to a functional interface.
Examples:

button.addActionListener( (e) -> {
	System.out.println("The button was clicked, from lambda expressions");
});

menu.addItem("Find", e -> {
        System.out.println("Find for " + e);
        return true;
});

Functional Interfaces and Lambdas
----------------------------------------
Java has evolved from Java 1.0, but many key aspects of that evolution have been entirely within the compiler, which performs some tricks on your behalf to make things easier.  Examples of such things are:

1.Autoboxing
2.Generics
3.Anonymous Inner Classes
4.Lambdas

In this reading, we're going to talk about the latter two topics.

Consider the following code:

interface Handler {
    public boolean handleEvent(Event e);
}

interface Menu {
    public addItem(String Label, Handler menuHandler);
}

and somewhere ..

public void makeMenu(Menu menu){
    menu.addItem("Find", ...);
}

--Prior to the introduction of Anonymous Inner Classes, we would have to create a complete class and pass an instance of it to addItem, as such:

class MyStubMenuItemHandler implements Handler {
    public boolean handleEvent(Event e) {
        System.out.println("Find for " + e);
        return true;
    }
}
menu.addItem("Find", new MyStubMenuItemHandler());

With the introduction of Anonymous Inner Classes, we have a much shorter path:

menu.addItem("Find", new Handler() {
    public boolean handleEvent(Event e) {
        System.out.println("Find for " + e);
        return true;
    } 
});

--However, there is no real magic going on here.  The compiler sees what you are doing, creates a new class with a generated name, 
	emits a .class file for it, and calls new on that generated class for you.  
--Just as we had before, but less work for us, and the handler code is co-located with where we use it.
But that is still more verbose than it needs to be, so Java 8 introduced lambdas.  
Continuing the example, we can now rewrite this in Java 8 as:

menu.addItem("Find", e -> {
        System.out.println("Find for " + e);
        return true;
});

and if we don't need the logging statement, we could simplify it all the way down to this:

menu.addItem("Find", e -> true);

How did the compiler know what to do?
1.It analyzed the code.
2.It saw that Menu:addItem takes a String and a Handler.  So the only possible thing that can be used for the second parameter is a Handler instance.
3.The next critical step is that it recognizes that Handler is a functional interface.  Only a functional interface can be implemented with a lambda. 
 Were it not a functional interface, we could not use a lambda.
4.Finally, it looked at the one method of the functional interface, and derived the number & types of the arguments, as well as the return type. 
 So with all of that discovered, the compiler was capable of generating the required code to implement the lambda.

Lists
-------------------------------
import java.util.List;

List<Vehicle> vehicles = Arrays.asList(car1, mach5, wagon, suv, train);

vehicles.forEach( vehicle -> {
	if(vehicle instanceof SportsCar)
		((SportsCar) vehicle).race();
	else
		Vehicle.travelAtSpeedLimit(vehicle);
	System.out.println(vehicle);
});

--shorthand of above code:

vehicles.forEach( vehicle -> Vehicle.travelAtSpeedLimit(vehicle) );
vehicles.forEach( vehicle -> System.out.println(vehicle) );
 
here we're making for each serpartely for travelAtSpeedLimit and printing

--shorthand of above code, again: 

vehicles.forEach( Vehicle::travelAtSpeedLimit );
vehicles.forEach( System.out::println );

--here, we're removing lambda function and compiler will now that travelAtSpeedLimit and println 
has a parameter/arg and add parameter coming from the forEach automatically to those methods by using " :: " symbol


StringBuilder Example
----------------------
class Box { 

@Override
public String toString() {

	StringBuilder builder = new StringBuilder();

		builder.append("Box |Length = );
		builder.append(length);		<---length is attribute
		builder.append("Width = ");
		builder.append(width);
		builder.append("Height = );
		builder.append(height);
		builder.append("Name = );
		builder.append(getName());

	builder.toString();

	}

}

When we encounter a Box or Cube, toString() from the Box class is used. Otherwise, toString() from Shape is used. This is polymorphic behavior. 
Even though we are working with an array of Shape objects, the behavior from the class that defines the actual object type in the array is used when methods are called.

------------------------------------------------------------------------------------------------------

Course-4(Java Class library)
------------------------------------

Week 1- Java Generics
week2 - Java Collections
week3 - Input and Output
week4- Exception
week5 - Annotation 
week6 - Enum

Introduction to Generics (Check https://docs.oracle.com/javase/tutorial/java/generics )
-------------------------------------------------------------------------------------------

Generics allows "abstraction over types"

--You can write generic code without losing type safety.
--Provides a way to declare the types of objects in a container such as collection, list, map.
--Allows compile-time type checking and helps(greatly) to avoid runtime typecasting exceptions
--Reduces(almost eliminates) the need for down-casting.
--Widely used in the Collection framework.

public class VehicleApp {
	/*			
	public static void race(Object[] raceCars) {
		for (Object raceCar: raceCars) {	<---ERROR
			raceCar.race();		
		}
	}*/
 
//Object[] is array of object
//Error because race() method is undefined in type Object, 
even if we change Object to SportsCar its still error because the type of Object[] and SportsCar doesnt match
	
	/*			
	public static void race(Object[] raceCars) {
		for (Object raceCar: raceCars) {	
			if(raceCar instanceof SportsCar) {
				SportsCar racer = (SportsCar) raceCar;
				racer.race();	
			}	
		}
	}*/

//Here we are checking the instance of raceCar is from SportsCar and type casting the raceCar from Car to SportsCar

	/*
	public static void race(SportsCar[] raceCars) {
		for (SportsCar raceCar: raceCars) {	
			raceCar.race();		
		}
	}*/
//Here we are changing both array and type as SportsCar

//Collections-------------------
	public static void race(Collection<SportsCar> raceCars) {
		for (SportsCar raceCar: raceCars) {	
			raceCar.race();		
		}
	}

//here we removed array and added Collection<SportsCar> and type SportsCar
//Collection<SportsCar> is for type Safety(generics), and mentioning it will have only SportsCar object instances

}

Generics   
--------------

List<String> cs = new ArrayList<String>();

cs.add(0, "this is a string");
cs.add(new Object());	//ERROR, not a String
String s = cs.get(0);	//no downcast needed


Why Use Generics?
--------------------

--In a nutshell, generics enable types (classes and interfaces) to be parameters when defining classes, interfaces and methods.
Much like the more familiar formal parameters used in method declarations, type parameters provide a way for you to re-use the same code with different inputs. 
The difference is that the inputs to formal parameters are values, while the inputs to type parameters are types.

Code that uses generics has many benefits over non-generic code:

Stronger type checks at compile time.
A Java compiler applies strong type checking to generic code and issues errors if the code violates type safety. Fixing compile-time errors is easier than fixing runtime errors, which can be difficult to find.

Elimination of casts.
---------------------
The following code snippet without generics requires casting:

List list = new ArrayList();
list.add("hello");
String s = (String) list.get(0);

When re-written to use generics, the code does not require casting:

List<String> list = new ArrayList<String>();
list.add("hello");
String s = list.get(0);   // no cast

Enabling programmers to implement generic algorithms.
By using generics, programmers can implement generic algorithms that work on collections of different types, can be customized, and are type safe and easier to read.

Generic Types
------------------
A generic type is a generic class or interface that is parameterized over types. The following Box class will be modified to demonstrate the concept.

A Simple Box Class:
Begin by examining a non-generic Box class that operates on objects of any type. It needs only to provide two methods: set, which adds an object to the box, and get, which retrieves it:

public class Box {
    private Object object;

    public void set(Object object) { this.object = object; }
    public Object get() { return object; }
}

Since its methods accept or return an Object, you are free to pass in whatever you want, provided that it is not one of the primitive types. There is no way to verify, at compile time, how the class is used. One part of the code may place an Integer in the box and expect to get Integers out of it, while another part of the code may mistakenly pass in a String, resulting in a runtime error.

A Generic Version of the Box Class
A generic class is defined with the following format:

class name<T1, T2, ..., Tn> { /* ... */ }

The type parameter section, delimited by angle brackets (<>), follows the class name. It specifies the type parameters (also called type variables) T1, T2, ..., and Tn.

To update the Box class to use generics, you create a generic type declaration by changing the code "public class Box" to "public class Box<T>". This introduces the type variable, T, that can be used anywhere inside the class.

With this change, the Box class becomes:

/**
 * Generic version of the Box class.
 * @param <T> the type of the value being boxed
 */
public class Box<T> {
    // T stands for "Type"
    private T t;

    public void set(T t) { this.t = t; }
    public T get() { return t; }
}

As you can see, all occurrences of Object are replaced by T. A type variable can be any non-primitive type you specify: any class type, any interface type, any array type, or even another type variable.

This same technique can be applied to create generic interfaces.

Type Parameter Naming Conventions
By convention, type parameter names are single, uppercase letters. This stands in sharp contrast to the variable naming conventions that you already know about, and with good reason: Without this convention, it would be difficult to tell the difference between a type variable and an ordinary class or interface name.

The most commonly used type parameter names are:

E - Element (used extensively by the Java Collections Framework)
K - Key
N - Number
T - Type
V - Value
S,U,V etc. - 2nd, 3rd, 4th types

You'll see these names used throughout the Java SE API and the rest of this lesson.

Invoking and Instantiating a Generic Type
To reference the generic Box class from within your code, you must perform a generic type invocation, which replaces T with some concrete value, such as Integer:

Box<Integer> integerBox;
You can think of a generic type invocation as being similar to an ordinary method invocation, but instead of passing an argument to a method, you are passing a type argument — Integer in this case — to the Box class itself.

Type Parameter and Type Argument Terminology: Many developers use the terms "type parameter" and "type argument" interchangeably, but these terms are not the same. When coding, one provides type arguments in order to create a parameterized type. Therefore, the T in Foo<T> is a type parameter and the String in Foo<String> f is a type argument. This lesson observes this definition when using these terms.
Like any other variable declaration, this code does not actually create a new Box object. It simply declares that integerBox will hold a reference to a "Box of Integer", which is how Box<Integer> is read.

An invocation of a generic type is generally known as a parameterized type.

To instantiate this class, use the new keyword, as usual, but place <Integer> between the class name and the parenthesis:

Box<Integer> integerBox = new Box<Integer>();
The Diamond
In Java SE 7 and later, you can replace the type arguments required to invoke the constructor of a generic class with an empty set of type arguments (<>) as long as the compiler can determine, or infer, the type arguments from the context. This pair of angle brackets, <>, is informally called the diamond. For example, you can create an instance of Box<Integer> with the following statement:

Box<Integer> integerBox = new Box<>();
For more information on diamond notation and type inference, see Type Inference.

Multiple Type Parameters
As mentioned previously, a generic class can have multiple type parameters. For example, the generic OrderedPair class, which implements the generic Pair interface:

public interface Pair<K, V> {
    public K getKey();
    public V getValue();
}

public class OrderedPair<K, V> implements Pair<K, V> {

    private K key;
    private V value;

    public OrderedPair(K key, V value) {
	this.key = key;
	this.value = value;
    }

    public K getKey()	{ return key; }
    public V getValue() { return value; }
}
The following statements create two instantiations of the OrderedPair class:

Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8);
Pair<String, String>  p2 = new OrderedPair<String, String>("hello", "world");
The code, new OrderedPair<String, Integer>, instantiates K as a String and V as an Integer. Therefore, the parameter types of OrderedPair's constructor are String and Integer, respectively. Due to autoboxing, it is valid to pass a String and an int to the class.

As mentioned in The Diamond, because a Java compiler can infer the K and V types from the declaration OrderedPair<String, Integer>, these statements can be shortened using diamond notation:

OrderedPair<String, Integer> p1 = new OrderedPair<>("Even", 8);
OrderedPair<String, String>  p2 = new OrderedPair<>("hello", "world");
To create a generic interface, follow the same conventions as for creating a generic class.

Parameterized Types
You can also substitute a type parameter (that is, K or V) with a parameterized type (that is, List<String>). For example, using the OrderedPair<K, V> example:

OrderedPair<String, Box<Integer>> p = new OrderedPair<>("primes", new Box<Integer>(...));

Defining Simple Generics
------------------------------
Generics are defined using a declaration of formal type parameters using angle brackets.

public interface List<E> {
	void add(E x);
	Iterator<E> interator();
}

--When used, the parameterized type(the contents of the angle brackets <>) specify the typr for that specific use

public class ListTest {
	
	List<String> ls; // here String replacing E placeholder
}

--the list ls should only contain Strings

Note that the declaration of a  generic is compiled once and only once.
-when a generic is invoked, the actual type is replaced by the arguments used for that specific invocation.

you can think of generics working much like a method..
-When invoked, the formal method value parameters are replaced by the actual values passed at runtime.

-----------------------
public ClassA {	
	public static void ClassB {
	}
}

static -static makes a class is independent of the class,it's embedded inside of normally. inner classes would have access to the instance data of an instance they're created inside of by making it a static class. It's independent.
-----------------------


Nested Classes :
---------------------
The Java programming language allows you to define a class within another class. Such a class is called a nested class and is illustrated here:

class OuterClass {
    ...
    class NestedClass {
        ...
    }
}

Terminology: Nested classes are divided into two categories: non-static and static. Non-static nested classes are called inner classes. 
		Nested classes that are declared static are called static nested classes.

class OuterClass {
    ...
    class InnerClass {
        ...
    }
    static class StaticNestedClass {
        ...
    }
}

Deques 	(Check https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html)
------------------------------------------------------------------------------------
A linear collection that supports element insertion and removal at both ends. The name deque is short for "double ended queue" and is usually pronounced "deck". 
Most Deque implementations place no fixed limits on the number of elements they may contain,
but this interface supports capacity-restricted deques as well as those with no fixed size limit.

public interface Deque<E> extends Queue<E> 

Type Parameters:
E - the type of elements held in this collection

All Superinterfaces:
Collection<E>, Iterable<E>, Queue<E>

All Known Subinterfaces:
BlockingDeque<E>

All Known Implementing Classes:
ArrayDeque, ConcurrentLinkedDeque, LinkedBlockingDeque, LinkedList

Generics with Sub types and without wildcards
-------------------------------------------------
List<String> ls = new ArrayList<String>();
List<object> lo = ls;	<--- COMPILE ERROR
 
-- LS is a list of strings. I should be able to add strings only

--If a class X has a subtype XSub and we make a generic declaration E<X> and E<XSub>, 
   E<X> is not a Subtype of E<X>

Ex: Stack<Car> is not Compatible with Stack<SportsCar>, even SportsCar is a child of Car.

--The Safety mechanism prevents runtime errors such as:
lo.add(new Object());
String s= ls.get(0);

Lo is the same as LS. So I would have now added non strings to what is supposed to be a list of strings. So this is one of those rules that exists to preserve type safety. And allow the compiler to check at compile time, and we don't have to check at runtime.

EXAMPLE:

Stack.java(Interface)
--------------------------
package com.lq.packages;

public interface Stack<E> {
	
	void push(E element);
	E pop();
}

StackArray.java
------------------------
package com.lq.packages;

public class StackArray<E> implements Stack<E> {
	int tos;
	E[] stack;

	public StackArray() {
		this(10);
	}

	@SuppressWarnings("unchecked")
	public StackArray(int maxdepth) {
		tos = 0;
		stack = (E[]) new Object[maxdepth];
	}

	@Override
	public void push(E element) {
		stack[tos++] = element;
	}

	@Override
	public E pop() {
		//empty stack returns null , since  we have not covered Exception handling, yet
		return tos > 0 ? stack[--tos] : null;
	}

}


GenericStackImpl.java
----------------------------
package com.lq.packages;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class GenericStackImpl<E> implements Stack<E> {
	
	Deque<E> stack;
	java.util.Stack<E> legacyStack;
	
	public GenericStackImpl() {
		switch(new java.util.Random().nextInt(5)) {
		case 0:
			stack = new LinkedList<E>();
			break;
		case 1:
			stack = new ArrayDeque<E>();
			break;
		case 2: 
			stack = new ConcurrentLinkedDeque();
			break;
		case 3:
			stack = new LinkedBlockingDeque();
			break;
		default:
			legacyStack = new java.util.Stack<E>();
			break;
		}
		
		System.out.printf("Using %s as the Stack<E> implementation \n ", (stack != null ? stack : legacyStack).getClass().getName());
	}
	
	@Override
	public void push(E element) {
		if(stack != null) 
			stack.push(element) ;
		else
			legacyStack.push(element) ;
		
	}

	@Override
	public E pop() {
		if(stack != null) 
			return stack.pop() ;
		else
			return legacyStack.pop() ;
	}

}

GenericApp.java
----------------------------
package com.lq.packages;

import com.lq.packages.GenericStackImpl;
import com.lq.packages.Stack;
import com.lq.packages.StackArray;
import com.lq.packages.transport.Car;
import com.lq.packages.transport.SportsCar;

public class GenericsApp {
	
	public static Stack<String>  makeStackString(Stack<String> strings){
		strings.push("World");
		strings.push("Hello");
		
		return strings;
	}
	
	public static Stack<Integer> makeStackInteger(Stack<Integer> ints)
	{
		ints.push(5);
		ints.push(4);
		ints.push(2);
		ints.push(1);
		ints.push(1);
		
		return ints;
	}
	
	public static Stack<SportsCar> makeStackSportsCar(Stack<SportsCar> cars){
		cars.push(new SportsCar("MACH1", 250, 21, true));
		cars.push(new SportsCar("MACH2", 250, 21, true));
		cars.push(new SportsCar("MACH3", 250, 21, true));
		cars.push(new SportsCar("MACH4", 250, 21, true));
		cars.push(new SportsCar("MACH5", 250, 21, true));
		
		return cars;
	}
	
	public static void printStackRaw(Stack stack) {
		for(Object e =stack.pop() ; e!= null ; e= stack.pop()) {
			System.out.println(e);
		}
	}
	
	public static void raceStackRaw(Stack stack) {
		for(Object e =stack.pop() ; e!= null ; e= stack.pop()) {
			((SportsCar)e).race();
		}
	}
	
	public static void printStackObject(Stack<Object> stack) {
		for(Object e =stack.pop() ; e!= null ; e= stack.pop()) {
			System.out.println(e);
		}
	}
	
	public static void printStackString(Stack<String> stack) {
		for(Object e =stack.pop() ; e!= null ; e= stack.pop()) {
			System.out.println(e);
		}
	}
	
	public static void printStackInteger(Stack<Integer> stack) {
		for(Object e =stack.pop() ; e!= null ; e= stack.pop()) {
			System.out.println(e);
		}
	}
	
	public static void printStackSportsCar(Stack<SportsCar> stack) {
		for(Object e =stack.pop() ; e!= null ; e= stack.pop()) {
			System.out.println(e);
		}
	}
	
	public static void printStackCar(Stack<Car> stack) {
		for(Object e =stack.pop() ; e!= null ; e= stack.pop()) {
			System.out.println(e);
		}
	}
	
	
	
	public static void main(String[] args) {
		//create stacks of diff types
		Stack<String> strings = new StackArray<>();
		Stack<Integer> ints = new StackArray<>();
		Stack<SportsCar> cars = new StackArray<>();
		
		//print them out raw, it works...
		printStackRaw(makeStackString(strings));
		printStackRaw(makeStackInteger(ints));
		printStackRaw(makeStackSportsCar(cars));
		
		//but this is why we use generics instead of raw types...
		//raceStackRaw(makeStackString(strings));	//runtime error
		//raceStackRaw(makeStackInteger(ints));	//runtime error
		raceStackRaw(makeStackSportsCar(cars));	//actually works
		
		//So let's switch to Generics , Since Object defines println
		//we can use Stack<Object>, right ? no
		//printStackObject(makeStackString(strings));	//Compile error, Stack<Object> is not Compitable with Stack<String>
		//printStackObject(makeStackInteger(ints));	//Compile error
		//printStackObject(makeStackSportsCar(cars));	//Compile error
		
		//THe Compiler demands that we have exact matching types
		printStackString(makeStackString(strings));
		printStackInteger(makeStackInteger(ints));
		printStackSportsCar(makeStackSportsCar(cars));
		
		//It won't let us use Car because we have SportsCar
		//printStackCar(makeStackSportsCar(cars));

		if (ints.getClass() == strings.getClass()) {
			System.out.printf("Stack<Integer> and Stack<String>  are both %s !\n", ints.getClass());
		}


	}

}



WILDCARDS
-----------------------------------------------
Generics  provide a type that can be used as a placeholder for all possible types.
--This is called a wildcard type.
-the notation used is the question mark "?".

Ex: the following example shows the use of wildcard to specify that the collection passed may contain any type of Object.
public void printCollection(Collection<?> c){
	for(Object e: c){
		System.out.println(e);
	}
}


public static void printStack(Stack<?> stack) {
		for(Object e =stack.pop() ; e!= null ; e= stack.pop()) {
			System.out.println(e);
		}
	}

Bounded WildCards
------------------------
Bounded wildcards make use of unknown type symbol and the extends keyword to specify the upper bound to the wildcard.
--Objects in the collection must be subtype of the upper bound.

public void drawAll(List<? extends Shape> shapes){
	for(Shape s: shapes){
		s.draw(this);
	}
}

public static void setSpeedStackExtendsCar(Stack<? extends Car> stack) {
		for(Car e =stack.pop() ; e!= null ; e= stack.pop()) {
			System.out.println(e);
		}
	}

--Bounded wildCard restraints
Remember that ? designates an unknown type.This means that the following code is illegal: 

public void drawAll(List<? extends Shape> shapes){
	for(Shape s: shapes){
		s.draw(this);
	}	
	shapes.add(new Rectangle());	//ERROR
}
-The reason that we dont know specifically which subclass of shape the list is supposed to hold, just that it is some shape.

Bounded WildCards with extends and super
------------------------------------------
<? extends Shape>
--extends allows us to use the references and invoke the methods, but not add and assigning

public void drawAll(List<? extends Shape> shapes){
	for(Shape s: shapes){	//s is reference
		s.draw(this);	//invoking method
	}	
	shapes.add(new Rectangle());	//ERROR
}

public static void setSpeedStackExtendsCar(Stack<? extends Car> stack) {
	for(Car e =stack.pop() ; e!= null ; e= stack.pop()) {
		System.out.println(e);
	}
}



<? super Shape>
--super allows us to add and assigning, but we cannot use the references

public void drawAll(List<? super Shape> shapes){
	for(Shape s: shapes){	
		s.draw(this);	
	}	
	shapes.add(new Rectangle());	//adding a new instance of type Rectangle
}

public static void setSpeedStackSuperCar(Stack<? super Car> stack) {
	for(Car e =stack.pop() ; e!= null ; e= stack.pop()) {  	//ERROR,we cant use the reference 
		System.out.println(e);
	}
}
here, the type can be Car and above then that and we dont what exactly the type is.

Generic Methods
----------------------
Individual methods can also declare type parameters.
Syntax:
	Access-modifiers generics-declaration return-type name(args)

Ex:	public static <T>Collection<T> unmodifiable(Collection<T>);
	public <T> T getBean(Class<T> requiredType);

>>we want to write a method that takes an array of objects and places that array into a Collection.

void fromArrayToCollection(object[] a, Collection<?> c){
	for(Object o : a){
		c.add(o);  //ERROR
	}
}
--A Solution is to use a generic method - a parameterized declaration of the arguments passed... the type wiil be derived and enforced.

<T> void fromArrayToCollection(T[] a, Collection<T> c){
	for(T o : a){
		c.add(o);  //Correct
	}
}

--Accept Only types that are needed(Car and Convertible(I)) ?

public static <T extends Car & Convertible> park(T Car) {	//we can add more interfaces using "& interface” 
	car.setSpeed(0);
	car.putTopUp();
}


Type Erasure
-------------------
Generics are implemented by the compiler using a conversion process called Type erasure.

--After the compile time there will be no generics only raw types
Ex: List<String> = new ArrayList<String>();
becomes as List = new ArrayList();

--One of the aspects of generics that people often have difficulty with is why this is not acceptable code:

public static void populate(Collection<Vehicle> vehicles) {
    vehicles.add(new SportsCar());  // ERROR -- even though SportsCar IS-A Vehicle
}

populate(new ArrayList<Vehicle>());  // OK
populate(new ArrayList<Car>());      // ERROR -- even though Car IS-A Vehicle

--Likewise, once people start to understand that issue, and come across the wildcard notation, it can take a while 
to grasp the issue here:

	public static void populate2(Collection<? extends Vehicle> vehicles) {
		vehicles.forEach(System.out::println);
	    vehicles.add(new SportsCar());  // ERROR -- even though SportsCar IS-A Vehicle
	}

After all, vehicles is a collection of some class that extends Vehicle, and SportsCar IS-A Vehicle, so why can't we add a SportsCar to it? 

Check :https://docs.oracle.com/javase/tutorial/java/generics/inheritance.html


Introduction to Collections(Check https://docs.oracle.com/javase/8/docs/technotes/guides/collections/reference.html)
------------------------------------------------------
What is Collection framework?
-The Java platform includes a collections framework. A collection is an object that represents a group of objects (such as the classic Vector class). A collections framework is a unified architecture for representing and manipulating collections, enabling collections to be manipulated independently of implementation details.

Collections offer an alternative to arrays that is more flexible and more powerful.
>One of the main limitations of an array is that its length is fixed when it is created.
> Collections will grow to hold more elements automatically.

--Collections rely on interfaces heavily to provide common behavior.
There are three major types of collections:

1. Sets  - excludes duplicates 
2. Lists - allows duplicates
3. Maps  - key value pair access

Each is intended for a diff kind of Collection.

A Collection can hold any Java object.
> Collections can NOT hold primitives or arrays. However, primitives can be passed to Collections of Wrapper classes. They will be retrieved as instances of the Wrapper, but autoboxing still hides that detail for the most part.

--With the use of generics we can specify what type of objects are being put into the collection.
>>Type safety is assured by the compiler when objects are retrieved from the collection.
>>If not for generics, java would upcast everything to object, forcing us to filter out undesired types, and downcast desired objects to their original  types.
>>Instead, we're able to specify the specific type with which we want to work.

--Before we delve into the details of Collections, we'd like to provide an example to help you see what's going on.
--We'll use the ArrayList class, which stores objects in much the same way an array does.
  >> In an ArrayList each entry is indexed by an int.
  >> We can add elements by specifying a numeric position. If we don't specify a position, Java just uses the next available number.
--Use generics to specify what type of object is being placed in the ArrayList (improves type safety).
--We'll pass the ArrayList to a method that will work with the objects, and we'll set their speeds to 50.

public class MyCars {
   public static void main(String[] args) {

	// create the ArrayList to hold types of Cars 
	ArrayList<Car> a = new ArrayList<Car>();

	// each car will go into consecutive positions
	// of the ArrayList
	a.add(new SUV ());
	a.add(new SportsCar ());
	a.add(new StationWagon ());
   }
}

--We can pass the ArrayList to the setAllSpeeds () method

private static void setAllSpeeds (ArrayList<Car> a) { 
	for (Car car: a) {
		car.setSpeed (55);
	}
}

--Notice the use a for-each style loop to access the objects in the ArrayList - easier than using a regular for loop.
>> Even easier in Java 8
>> Java 8 added a default ForEach method to the Iterable interface. We will discuss this at eh end of this unit.
	Example : a.forEach (car->setSpeed (55));
>> The use of generics guarantee all objects in the list to be of type Car.

Collection Interfaces
--------------------------
The collection interfaces are divided into two groups. The most basic interface, java.util.Collection, has the following descendants:

java.util.Set
java.util.SortedSet
java.util.NavigableSet
java.util.Queue
java.util.concurrent.BlockingQueue
java.util.concurrent.TransferQueue
java.util.Deque
java.util.concurrent.BlockingDeque


The other collection interfaces are based on java.util.Map and are not true collections. However, these interfaces contain collection-view operations, which enable them to be manipulated as collections. Map has the following offspring:

java.util.SortedMap
java.util.NavigableMap
java.util.concurrent.ConcurrentMap
java.util.concurrent.ConcurrentNavigableMap

Collection interfaces - The primary means by which collections are manipulated.
----------------------
Collection - A group of objects. No assumptions are made about the order of the collection (if any) or whether it can contain duplicate elements.

Set - 	The familiar set abstraction. No duplicate elements permitted. May or may not be ordered. Extends the Collection interface.

List -	 Ordered collection, also known as a sequence. Duplicates are generally permitted. Allows positional access. Extends the Collection interface.

Queue - A collection designed for holding elements before processing. Besides basic Collection operations, queues provide additional insertion, extraction, and inspection operations.

Deque - A double ended queue, supporting element insertion and removal at both ends. Extends the Queue interface.

Map - A mapping from keys to values. Each key can map to one value.

SortedSet - A set whose elements are automatically sorted, either in their natural ordering (see the Comparable interface) or by a Comparator object provided when a SortedSet instance is created. Extends the Set interface.

SortedMap - A map whose mappings are automatically sorted by key, either using the natural ordering of the keys or by a comparator provided when a SortedMap instance is created. Extends the Map interface.

NavigableSet - A SortedSet extended with navigation methods reporting closest matches for given search targets. A NavigableSet may be accessed and traversed in either ascending or descending order.
NavigableMap - A SortedMap extended with navigation methods returning the closest matches for given search targets. A NavigableMap can be accessed and traversed in either ascending or descending key order.
BlockingQueue - A Queue with operations that wait for the queue to become nonempty when retrieving an element and that wait for space to become available in the queue when storing an element. (This interface is part of the java.util.concurrent package.)
TransferQueue - A BlockingQueue in which producers can wait for consumers to receive elements. (This interface is part of the java.util.concurrent package.)
BlockingDeque - A Deque with operations that wait for the deque to become nonempty when retrieving an element and wait for space to become available in the deque when storing an element. Extends both the Deque and BlockingQueue interfaces. (This interface is part of the java.util.concurrent package.)
ConcurrentMap - A Map with atomic putIfAbsent, remove, and replace methods. (This interface is part of the java.util.concurrent package.)
ConcurrentNavigableMap - A ConcurrentMap that is also a NavigableMap.

Collection Implementations
----------------------------------
Classes that implement the collection interfaces typically have names in the form of <Implementation-style><Interface>. The general purpose implementations are summarized in the following table:

------------------------------------------------------------------------------------------------------------------
Interface  |	Hash Table  |	Resizable Array   |	Balanced Tree |	Linked List  |	Hash Table + Linked List
------------------------------------------------------------------------------------------------------------------
Set		HashSet	 				TreeSet	 			LinkedHashSet
List	 			ArrayList	 			LinkedList	 
Deque	 			ArrayDeque	 			LinkedList	 
Map		HashMap	 				TreeMap	 			LinkedHashMap
------------------------------------------------------------------------------------------------------------------

Concurrent Collections
-------------------------
Applications that use collections from more than one thread must be carefully programmed. In general, this is known as concurrent programming. The Java platform includes extensive support for concurrent programming. See Java Concurrency Utilities for details.

Collections are so frequently used that various concurrent friendly interfaces and implementations of collections are included in the APIs. These types go beyond the synchronization wrappers discussed previously to provide features that are frequently needed in concurrent programming.

These concurrent-aware interfaces are available:

BlockingQueue
TransferQueue
BlockingDeque
ConcurrentMap
ConcurrentNavigableMap

The following concurrent-aware implementation classes are available. See the API documentation for the correct usage of these implementations.

LinkedBlockingQueue
ArrayBlockingQueue
PriorityBlockingQueue
DelayQueue
SynchronousQueue
LinkedBlockingDeque
LinkedTransferQueue
CopyOnWriteArrayList
CopyOnWriteArraySet
ConcurrentSkipListSet
ConcurrentHashMap
ConcurrentSkipListMap


The Collection Framework
--------------------------------
Example:
public class MyCars {
	public static void main(String[] args) {
		// create the ArrayList to hold types of Cars ArrayList<Car> a = new ArrayList<Car>();
		// each car will go into consecutive positions
		// of the ArrayList

		a.add(new SUV ());
		a.add(new SportsCar ());
		a.add(new StationWagon ());
	}
}

private static void setAllSpeeds (ArrayList<Car> a) {
	for (Car car : a) {
		car.setSpeed (55);
	}
}

--The ArrayList works much the same way as an array of Cars would have, except that we use methods instead of square brackets.
--The ArrayList is more flexible because we do not have to consider the maximum number of items we'll want to store in it.
  The ArrayList manages its own internal storage transparently to us.
--Now we'll move on to the Collection interfaces.
•Speaking of interfaces, there is a poor practice exhibited in the code. The only place where the ArrayList class should have been used is with new ArrayList.
 Every other use should have been List<Car>.The practice is left here so that we can point it out, as you will often encounter this practice on live code.
•Declare references with the most abstract interface you can.


		<<interface>>
		Collection
		    ↑
	-------------------------------
	|				|
<<interface>>>> Set		<<interface>> List	<<interface>>>> Map
	↑							↑
<<interface>>> SortedSet				<<interface>>> SortedMap
--The Collections interfaces are all stored in the java.util package

<<interface>>> Comparator
<<interface>>> Iterator
--These classes and interfaces are not Collections but are often used when working with Collections

--List of classes that implement Collection:
AbstractCollection
AbstractList
AbstractSet
ArrayList
HashSet
LinkedHashSet
LinkedList
TreeSet
Vector

--Here are the sub-interfaces:
BeanContext
BeanContextServices
List
Set
SortedSet

public interface Collection<E> {

	// Basic Operations
	int size();
	boolean isEmpty();
	boolean contains (Object o);
	boolean add (E e);
	boolean remove (Object o);
	Iterator<E> iterator();

	// Bulk Operations
	boolean containsAll (Collection<?> c);
	boolean addAll (Collection<? Extends E> c);
	boolean removeAll (Collection<?> c);
	boolean retainAll (Collection<?> c);
	void clear();

	// Array Operations
	Object[] toArray();
	Object[] toArray(T[] a);
}

--Every class that implements Collection<E> must implement these methods 
Not shown is that Collections<E> extends Iterable<E>
Examine the shared capabilities of all Collection-based objects

SET Collections
----------------------------------
--A Set is a Collection which contains no duplicate elements.
--The implementing concrete classes of Set are: 
1. HashSet 
2. LinkedHashSet
3. TreeSet

--When extracting elements from a Set via a loop, there is no guarantee that you will receive them in the same order you added them to the Set
--The sub-interface SortedSet, which is implemented by TreeSet provides a way to create sets that are sorted

Example: The HashSet
------------------------------
--The HashSet allows you to store objects but does not provide any methods for ordering them.

HashSet<Car> h = new HashSet<Car>();
h.add(new SUV ());
h.add(new SportsCar());
System.out.println (h.size());

--The HashSet uses the Iterator interface, which we will discuss before continuing the example.

The Iterator Interface
--------------------------
--The Iterator interface provides simple methods for accessing the elements of a container from first to last.

Its two most important methods are:
1. next()
2. hasNext()
3. remove()
4. forEachRemaining()

next() retrieves the next element in the container
hasNext() returns true or false based on whether there is another element in the container

Example: Iterator and HashSet
----------------------------------
iterator() is used to obtain an iterator of the elements.
--The explicit use of an iterator is usually an anachronism in modern java.
--Modern java uses either the enhanced for loop or the java 8 forEach method.

HashSet<Car> h = new HashSet<Car>();
h.add(new SUV ());
h.add(new SportsCar ());
// ... add more elements

Iterator<Car> iter = h.iterator(); 
while (iter.hasNext()) {
	Car car =iter.next();
	System.out.println (car.getSpeed());
}

Problem with iterator()
----------------------------
What happens if the contents of a Collection changes after you have extracted an Iterator?

--Clearly, there will be problems if your Iterator no longer reflects the contents of the Collection.
--In this situation, Java creates a run-time error condition called an Exception. Exceptions will be covered in a later chapter.
--If you do a remove through the iterator, this problem does not occur.

Iterator and ways to iterate
-------------------------------
Although direct use of Iterator is relatively minimal since Java 5, we should look at various samples in which we could iterate through something that is iterable.

--First, there is the old way, using Iterator (Java 1.2).  Iterator provides two key methods (and two more, default, methods, were added in Java 8): hasNext() and next().  Direct use of those methods would look like this:

while loop:
------------
while (iterator.hasNext() {
    T e = iterator.next();
    ...
}
for loop:
----------
for(T e; iterator.hasNext(); ) {
	e = iterator.next();
    ...			
}

--Java 5 introduced the Enhanced For-Loop and the formal Iterable interface, which is a Functional Interface whose method is iterator(), returning an Iterator.  
This drastically reduced the need to code to iterators directly, and unified iterating over both any iterable and arrays.
Enhanced For Loop:
--------------------
for (T e: anIterableOrArrayOfT) {
    ...
}

--Java 8 added a couple of default methods, one of which we have used, "forEach", and another for dealing with "Split Iterators", which we will not cover, and is left for self-exploration
forEach:
---------
anIterableOfT.forEach(aConsumerOfT);

Sorted Sets
---------------------------------------
The core API includes one implementation of SortedSet, the TreeSet.
--Sorting can be specified by an instance of the Comparator class, which TreeSet uses or by relying on TreeSet's built in implementation of the Comparable interface.
--Our example on the next slide will sort Strings alphabetically using the built-in sort facility.

Example: TreeSet
------------------
In this example the Strings will be sorted alphabetically by the TreeSet's internal Comparator.

TreeSet<String> ts = new TreeSet<String>();
	ts.add("Zebra");
	ts.add("Elephant");
	ts.add("Aardvark");
	ts.add("Bear");
Iterator<String> i = ts.iterator(); 
while (i.hasNext()) {
	System.out.println (i.next());
}

The output will be: 
Aardvark
Bear
Elephant
Zebra

Sorting and Comparing
-----------------------------
Fundamentally, sorting in Java is performed using a "Comparator", which is a Functional Interface. 
The required method is "compare(T o1, T o2)". The behavior of the compare method is the key:

Result					Expression
-----------------------------------------------------
-1					o1 < o2
0					o1 == o2
1					o1 > o2

TreeSet<String> ts = new TreeSet<String>();	//String implements Comparable interface
	ts.add("Zebra");
	ts.add("Elephant");
	ts.add("Aardvark");
	ts.add("Bear");
Iterator<String> i = ts.iterator(); 
while (i.hasNext()) {
	System.out.println (i.next());
}
--Now that we have the compare method to sort two elements, we can build the rest.  Both "SortedMap" and "SortedSet" expect that their implementations use a Comparator.The implementations will provide a constructor that accepts a Comparator. 
As an alternative, implementations will provide their own internal Comparator that uses the "natural ordering" of their elements, which implement the "Comparable" interface.	

We can also sort other collections and arrays.  The "Collections" class provides utility methods, including for sorting, 
either via the "natural order" or an explicit comparator, as discussed above.

If we create a class, such as Employee, which can implement the Comparable interface.  
However, what are we comparing?  EmployeeID?  Birthdate?  Hiring Date?  Seniority?  Salary?  
This example demonstrates why we often need to create an explicit Comparator when sorting.  
We can create a Comparator for each comparison we want to make.  And with Java 8, we can do so by simply passing a Lambda for that purpose.

Example:Comparable and Comparator in Java
--------------------------------------------
(Check https://www.digitalocean.com/community/tutorials/comparable-and-comparator-in-java-example)
package com.journaldev.sort;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {

    private int id;
    private String name;
    private int age;
    private long salary;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getSalary() {
        return salary;
    }

    public Employee(int id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee emp) {
        //let's sort the employee based on an id in ascending order
        //returns a negative integer, zero, or a positive integer as this employee id
        //is less than, equal to, or greater than the specified object.
        return (this.id - emp.id);
    }

    @Override
    //this is required to print the user-friendly information about the Employee
    public String toString() {
        return "[id=" + this.id + ", name=" + this.name + ", age=" + this.age + ", salary=" +
                this.salary + "]";
    }

}

Output:
Default Sorting of Employees list:
[[id=1, name=Pankaj, age=32, salary=50000], [id=5, name=Lisa, age=35, salary=5000], [id=10, name=Mikey, age=25, salary=10000], [id=20, name=Arun, age=29, salary=20000]]

  /**
     * Comparator to sort employees list or array in order of Salary
     */
    public static Comparator<Employee> SalaryComparator = new Comparator<Employee>() {

        @Override
        public int compare(Employee e1, Employee e2) {
            return (int) (e1.getSalary() - e2.getSalary());
        }
    };

    /**
     * Comparator to sort employees list or array in order of Age
     */
    public static Comparator<Employee> AgeComparator = new Comparator<Employee>() {

        @Override
        public int compare(Employee e1, Employee e2) {
            return e1.getAge() - e2.getAge();
        }
    };

    /**
     * Comparator to sort employees list or array in order of Name
     */
    public static Comparator<Employee> NameComparator = new Comparator<Employee>() {

        @Override
        public int compare(Employee e1, Employee e2) {
            return e1.getName().compareTo(e2.getName());
        }
    };


/sort employees array using Comparator by Salary
Arrays.sort(empArr, Employee.SalaryComparator);
System.out.println("Employees list sorted by Salary:\n"+Arrays.toString(empArr));

//sort employees array using Comparator by Age
Arrays.sort(empArr, Employee.AgeComparator);
System.out.println("Employees list sorted by Age:\n"+Arrays.toString(empArr));

//sort employees array using Comparator by Name
Arrays.sort(empArr, Employee.NameComparator);
System.out.println("Employees list sorted by Name:\n"+Arrays.toString(empArr));

Output:

Employees list sorted by Salary:
[[id=5, name=Lisa, age=35, salary=5000], [id=10, name=Mikey, age=25, salary=10000], [id=20, name=Arun, age=29, salary=20000], [id=1, name=Pankaj, age=32, salary=50000]]
Employees list sorted by Age:
[[id=10, name=Mikey, age=25, salary=10000], [id=20, name=Arun, age=29, salary=20000], [id=1, name=Pankaj, age=32, salary=50000], [id=5, name=Lisa, age=35, salary=5000]]
Employees list sorted by Name:
[[id=20, name=Arun, age=29, salary=20000], [id=5, name=Lisa, age=35, salary=5000], [id=10, name=Mikey, age=25, salary=10000], [id=1, name=Pankaj, age=32, salary=50000]]

Here is the separate class implementation of Comparator interface that will compare two Employees object first on their id and if they are same then on the name.

package com.journaldev.sort;

import java.util.Comparator;

public class EmployeeComparatorByIdAndName implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        int flag = o1.getId() - o2.getId();
        if(flag==0) flag = o1.getName().compareTo(o2.getName());
        return flag;
    }

}

//Employees list sorted by ID and then name using Comparator class
        empArr[0] = new Employee(1, "Mikey", 25, 10000);
        Arrays.sort(empArr, new EmployeeComparatorByIdAndName());
        System.out.println("Employees list sorted by ID and Name:\n"+Arrays.toString(empArr));
Output:

Employees list sorted by ID and Name:
[[id=1, name=Mikey, age=25, salary=10000], [id=1, name=Pankaj, age=32, salary=50000], [id=5, name=Lisa, age=35, salary=5000], [id=10, name=Mikey, age=25, salary=10000]]


Comparable vs Comparator
------------------------------
--Comparable interface can be used to provide single way of sorting whereas Comparator interface is used to provide different ways of sorting.
--For using Comparable, Class needs to implement it whereas for using Comparator we don’t need to make any change in the class.
--Comparable interface is in java.lang package whereas Comparator interface is present in java.util package.
--We don’t need to make any code changes at client side for using Comparable, Arrays.sort() or Collection.sort() methods automatically uses the compareTo() method of the class. For Comparator, client needs to provide the Comparator class to use in compare() method.




The List Collections
---------------------------------------------------------------------------------
A List is a collection in which the elements have been placed in a specific order.
--The implementing classes of List are 
1. LinkedList
2. ArrayList
3. Vector 
4. Stack.

--List classes allow the user to specify the exact position of any element in the list.

ArrayList vs LinkedList
--------------------------------
consider what if I want to then insert, not assign at a particular position, but insert into a particular position that's in the middle of data I've already added. Well, in the case of an array, ArrayList or otherwise, what we have to do is shift everything over to be able to open up a hole and put in the new element, and that is computationally expensive to have to shift over that memory. Likewise, if I want to delete an element at a particular position, I have to then shift over all of the other data to fill the gap. Again, computationally expensive.

--ArrayLists, from a storage perspective, are compact and in terms of simply appending to the end or removing from the end also efficient. 
--LinkedLists are better structures when we want to do inserting into the middle or removing from the middle. 

 Vector and Stack
---------------------
--Vector in fact is a type of list
--Stack is a subclass of Vector adding the push and pop type methods. 
--As discussed in generics, there's actually another class Deque, which is the recommended replacement for Stack.

Important Methods of the List Interface
-------------------------------------------
public interface List<E> extends Collection {
	E get (int index); 
	E set (int index, E element); 	//replace at an index
	void add (int index, E element); 
	boolean remove (Object o);
	boolean addAll(int index, Collection<? extends E> c);
	
	// indexes specific elements
	int indexOf (Object o);
	int lastIndexOf (Object o);	
	
	// provides list iterator references 
	ListIterator<E> listIterator (int index);
	ListIterator<E> listIterator();		//A ListIterator will let us go in both directions, where as we can go from the front and go all the way at the back.
	
	// gets a sublist from the current list 
	List subList (int fromIndex, int toIndex);
}



The Map Collections
----------------------------------------------------------------------------------
--The Map collections use key value pairs as their elements.
--Values can be duplicated; keys can not.
--Keys and values both are Objects.

--The implementing classes of Map are :
1. HashMap
2. LinkedHashMap
3. PrinterStateReasons
4. IdentityHashMap
5. TreeMap 
6. WeakHashMap.

--Most of the time you'll use HashMap. TreeMap is used when sorting is important and weak Hashmap is worth taking a look at, it's used to implement caching behavior. So here are some of the important methods of the map interface.

Important Methods of the Map Interface
---------------------------------------
public interface Map { 
	
	Object put (Object key, Object value);
	Object get (Object key);
	Object remove (Object key);
	boolean containsKey (Object key);
	boolean containsValue (Object value);
	int size();
	boolean isEmpty();
	
	// Bulk Operations 
	void putAll (Map t); 
	void clear();
	
	public Set keySet(); 
	public Collection values (); 
		
	public Set entrySet();		//The entry set is a set of the key value pairs
}


Example: The HashMap
----------------------
HashMap h = new HashMap ();
	h.put("MySUV", new SUV ());
	h.put("MySportsCar", new SportsCar());

System.out.println(h.size());

--Because we have key/value pairs, we use put instead of add to place new elements in the Map.

--Keys and values are both upcast to Object. When we extract them we must downcast them properly.
--We can extract individual items with the get method. This method accepts a key and returns its value.

HashMap h = new HasMap ();
	h.put("MySUV", new SUV ());
	h.put("MySportsCar", new SportsCar());
Car aCar = (Car) h.get("MySUV");

It would have been better to use Map<String, Car> HashMap<>(), instead.

HashMap<String, Car> h = new HashMap<>();
	h.put("MySUV", new SUV ());
	h.put("MySportsCar", new SportsCar());

Car aCar = h.get("MySUV");
System.out.println(aCar);

Iterating over a Map
-----------------------
1. Call the keySet() method, and iterate over the set of keys
2. Call the values () method, and iterate over the collection
3. Call the entrySet() method, and iterate over the set of entries
	• Map.Entry contains a [key, value]-pair, with getKey() and getValue() methods
4. Java 8: use the new Map.forEach () method, and iterate over the entries
	• The parameter to Map<K, V>.forEach () is BiConsumer<K, V> which is a functional interface whose required method takes two parameters: the key and the value.
	• For example:
m.forEach((k, v) ->System.out.printf("%s -> %s", k, v));


Linked Collections
-----------------------------
--In addition to LinkedList and LinkedHashSet, which inherit from Collection, there is also LinkedHashMap.
--Linked Collections should be used when you primarily wish to add and remove items from the beginning or end of the collection.

You would use these when you want to be able to iterate over their contents in a defined order. Generally speaking, the order in which they were added, which otherwise known as insertion order.

We talked about LinkedList itself earlier. Its behavior should come as no surprise, and the aspect that we talked about with LinkedList was ArrayList lets us deal with insertion order as well. What LinkedList gave us was efficiency for dealing with insertions and deletions anywhere other than the end.

But the other two do something special because they not only hashed their elements for rapid access, but they also maintain the LinkedList internally so that you can not only access things quickly with a key in the case of LinkedHashMap, but you can also iterate over them in the defined order, and that's usually insertion order so that you can iterate over them in the order in which they were added. But LinkedHashMap optionally allows you to say, "No, instead of insertion order, I want to know about access order because that allows us to do things like implement least recently used maps."


Java 8 Enhancements
---------------------------------------------
Java 8 introduced many new features related to Interfaces
• Functional Interfaces
• Lambdas
• Static Methods

--Java 8 also introduced many new interfaces and methods designed to make common/complex programming tasks easier

--Iterable interface received a new default method, forEach, with a parameter of Consumer
	• Consumer is a functional interface

--The Collection interface extends Iterable, therefore all Collection classes support forEach

--The Map interface is not Iterable, but directly includes its own forEach method
Ex: m.forEach((k, v) ->System.out.printf("%s -> %s", k, v));


--The forEach method invokes its Consumer for each element

--The required method of Consumer is: 
	void accept (T t)

--There is a default method, andThen, which can be used to compose chains of consumers with a single forEach

Consumer<Vehicle> go25 = vehicle -> vehicle.setSpeed (25); 
vehicles.forEach (go25.andThen (System.out::println));		//we can add one or more andThen and this is data pipeline

--The syntax required us to create a consumer instance, to which we assigned a lambda implementation, and then chain the call off of it. Additional andThen calls can be chained.

--These enhancements led to the development of Java 8 streams as a new means to apply functional programming to Java

Streams are an exciting and powerful new technology in the Java Library
• Create processing pipelines
• Create parallel processing pipelines
• All collection classes can be turned into streams

Java Threads
-----------------------------------------------------
--Threads allows a program to operate more efficiently by doing multiple things at the same time.

--Threads can be used to perform complicated tasks in the background without interrupting the main program.

Creating a Thread
-----------------------
There are two ways to create a thread:

1. It can be created by extending the Thread class and overriding its run() method:

public class Main extends Thread {
  public void run() {
    System.out.println("This code is running in a thread");
  }
}

2. Another way to create a thread is to implement the Runnable interface:

public class Main implements Runnable {
  public void run() {
    System.out.println("This code is running in a thread");
  }
}

Running Threads
--------------------
If the class extends the Thread class, the thread can be run by creating an instance of the class and call its start() method:

Extend Example
------------------
public class Main extends Thread {
  public static void main(String[] args) {
    Main thread = new Main();
    thread.start();
    System.out.println("This code is outside of the thread");
  }
  public void run() {
    System.out.println("This code is running in a thread");
  }
}
If the class implements the Runnable interface, the thread can be run by passing an instance of the class to a Thread object's constructor and then calling the thread's start() method:

Implement Example
------------------------
public class Main implements Runnable {
  public static void main(String[] args) {
    Main obj = new Main();
    Thread thread = new Thread(obj);
    thread.start();
    System.out.println("This code is outside of the thread");
  }
  public void run() {
    System.out.println("This code is running in a thread");
  }
}	

Differences between "extending" and "implementing" Threads
-----------------------------------------------------------------
The major difference is that when a class extends the Thread class, you cannot extend any other class, but by implementing the Runnable interface, it is possible to extend from another class as well, like: class MyClass extends OtherClass implements Runnable.

Concurrency Problems
----------------------
Because threads run at the same time as other parts of the program, there is no way to know in which order the code will run. When the threads and main program are reading and writing the same variables, the values are unpredictable. The problems that result from this are called concurrency problems.

Example:
A code example where the value of the variable amount is unpredictable:

public class Main extends Thread {
  public static int amount = 0;

  public static void main(String[] args) {
    Main thread = new Main();
    thread.start();
    System.out.println(amount);
    amount++;
    System.out.println(amount);
  }

  public void run() {
    amount++;
  }
}

--To avoid concurrency problems, it is best to share as few attributes between threads as possible. If attributes need to be shared, one possible solution is to use the isAlive() method of the thread to check whether the thread has finished running before using any attributes that the thread can change.

Example:
Use isAlive() to prevent concurrency problems:

public class Main extends Thread {
  public static int amount = 0;

  public static void main(String[] args) {
    Main thread = new Main();
    thread.start();
    // Wait for the thread to finish
    while(thread.isAlive()) {
    System.out.println("Waiting...");
  }
  // Update amount and print its value
  System.out.println("Main: " + amount);
  amount++;
  System.out.println("Main: " + amount);
  }
  public void run() {
    amount++;
  }
}

Java Exceptions(check : https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html)
------------------------------------------------------------------------------------------------------
--Faults are handled by a simple class called Exception.
--In Java we can also use a try/catch block to process faults.

--When a method encounters an error, it uses the throw keyword to create a new instance of an Exception class. Then it passes this object back to the code that called the method.

Example:
---------
--Creating the SpeedException class is very simple; It just extends the Exception class.
--Your exception classes are typically kept in their own packages.

package com.1q.exceptions;
public class SpeedException extends Exception {
}

--Notice the throws clause, which has been added after the method signature.
--An exception is thrown ONLY if the calculated speed is greater than MAX_SPEED. When this happens the method returns immediately. The last line of the method is not executed.

public void setSpeed (int new_speed) throws SpeedException {
	
	int s = new_speed;
	if (speeder == true)
		ss + 20;
	if (s> MAX_SPEED) {
		throw new SpeedException();
	}
	this.speed= s;


--Here we see a method, setSpeed (), wrapped in a try/catch block. In the next slide we'll see how setSpeed() throws SpeedException on an error.

SportsCar myCar = new SportsCar();

try {
	myCar.setSpeed (220);
} catch (SpeedException e) {
	System.out.println("Car is going too fast!");
}



Exception Classes
--------------------
--You would want to log what is wrong.
--Should have constructors that allow us to provide a suitable message.
--Pass the message in where the exception occurs, or let the class generate the message.


Checked and Unchecked Exceptions and Errors
-------------------------------------------------
Different Types of Exceptions:
-------------------------------
--In addition to Exceptions, which can generally be handled in code, there are certain error conditions for which there is no real solution.
--Suppose that the computer your program is running on experiences a hardware problem like a disk failure. There's nothing your program can do to fix this.

--For these situations, Java provides the Error class. An Error object represents a fault that your code cannot recover, i.e., hardware memory error.

Runtime Problems:
------------------
The runtime problems that cause exceptions fall into four broad categories:
• Code or Data Errors
• Standard Method Exceptions
• Throwing Custom Exceptions
• Java Errors

--The Java language represents exceptions as objects, all of which belong to the java.lang.Throwable class or one of its subclasses.


Throwable Hierarchy
-----------------------
(java.lang.Throwable)

				Throwable
				   ↑
	   -------------------------------------------------------
	   |							  |
	Exception						Error
		↑						  ↑
	--------------------------				OutOfMemoryError
	|			  |	
InterruptedException	RuntimeException		
				↑
			----------------
			|	       |
	NullPointerException	DivideByZeroException



Checked Exceptions are:
	--Exception
	--InterruptedException

Unchecked Exceptions are:
	Error
	OutOfMemoryError
	RuntimeException
	NullPointerException
	DivideByZeroException


Checked and Unchecked Exceptions
-------------------------------------
--Whenever you invoke a method that could throw a checked exception, the compiler will insist that you handle the exception.
--Checked exceptions are ones you want to force your client code to address.
--Checked exceptions have to be declared in throws clauses.
--Subclasses of Exception except RuntimeException and its subclasses are checked exceptions.
--Unchecked exceptions do not carry compiler enforced constraints.


Built-in Exceptions
----------------------------
--Many of the core Java classes throw exceptions.
--The exceptions that a method throws are automatically included in the standard documentation.

--When a method declares that it throws an exception, any code which calls that method must handle the exception with a try/catch block or by throwing the exception again.
Ex:
//method declaring throws
public void setSpeed (int new_speed) throws SpeedException {
	
	int s = new_speed;
	if (speeder == true)
		ss + 20;
	if (s> MAX_SPEED) {
		throw new SpeedException();
	}
	this.speed= s;
}

//calling that method with try/catch
SportsCar myCar = new SportsCar();

try {
	myCar.setSpeed (220);
} catch (SpeedException e) {
	System.out.println("Car is going too fast!");
}

(or)

//throwing the exception again.
public SportsCar(String carName) throws SpeedException {
	super(carName);
}


--In the API, you will find many exception classes. You can use these or create your own.
Ex:
ArrayIndexOutOfBounds

IOException
(Check https://docs.oracle.com/javase/8/docs/api/java/io/IOException.html)

NullPointerException

OutOfMemoryError

SQLException
(Check https://docs.oracle.com/javase/8/docs/api/java/sql/SQLException.html)


Throwing Exceptions from main()
--------------------------------------
--The main method is the starting point for your Java programs.

For Ex:If you're just writing a simple program, and you don't have to handle everything just to write your code, 
and may perhaps exceptions that are being thrown by the standard methods, perhaps some IO exceptions that in your simple little test app, you don't care about.
How could you address that quickly, and there is a little bit if you will of a cheats? 
We can declare on Main, that it will throw the exceptions that we don't otherwise want to handle. 
In our main if we're writing some code, and we don't care about the FileNotFoundException. 
Rather than rapid at a try-block, you can do what you would have otherwise done, which is add it to main, and the compiler will accept that. 
	Then the JRE will do what it always does when an exception leaks out past main. It will print out the Stack Trace and abort the process.

--If you throw exceptions from main:
public static void main (String[] args) 
	throws FileNotFoundException {

}

--In this case, the JRE will just print out a Stack Trace and abort.
Ex:try{
	Car car1= new SportsCar();
	car1.setName(RaceCar1);
	car1.setSpeed(60);
} Catch(SpeedException e) {
	e.printStackTrace();
}

The Stack Trace
------------------
Simple stack trace:

Exception in thread "main"
com.1q.exceptions. SpeedException
at com.lq.cars.Car.setSpeed (Car.java:12)
at com.lq.cars.Car.main (Car.java:19)

--The information in a stack trace is reasonably straightforward.

In this example:
• SpeedException was thrown at line 12 of Car.java in the method setSpeed
• setSpeed was called by line 19 of the main method


public void race() { 
try {
	//setSpeed((int) (getMaxSpeed() / 1.10));
	setSpeed(getMaxSpeed());
} catch (SpeedException e) {
 	System.out.printf("Unexpected error: we tried to race, but were told that the max speed was too fast, see stack trace for details %s, car.toString());
	 e.printStackTrace();
}

Catching Exceptions
-------------------------------------
Working with try-catch
-----------------------
We can also catch exceptions that have been thrown:

try {
	myCar.setSpeed (220);
} catch (SpeedException e) {
	System.out.println("Car is going too fast!");
}

--If setSpeed throws a SpeedException, Java will skip any remaining code in the try block and execute the code in the catch block instead.
--The exception object e can be referenced inside the catch block.

Multiple catch Blocks
----------------------
--All exception classes inherit from Exception.
--Java uses this fact to decide which catch block to execute when an error is thrown.
--Java will use the first Exception type it finds which either matches the type that was thrown or is ANY of its ancestors.
--Catching Exception acts as a "catch-all" for any unhandled error.

--To handle different types of Exceptions you can arrange multiple catch blocks underneath your try block:
try {
	PrintWriter PR = new PrintWriter( new FileWriter ("myCars.txt"));
	//code deleted to save space...
	PR.close();
} catch (FileNotFoundException e) {
	System.out.println("Could not open file");
} catch (IOException e) { 
	System.out.println("Some type of I/O error");
} catch (Exception e) { 
	System.out.println("Some other problem");
}

The finally Block
---------------------------------
--If there is an error when writing the PrintWriter, it will be left open.
--After catch blocks we can include a finally block.
--A finally block can follow:
	• A single try statement without any catch blocks
	•The last catch block in a try- catch statement
--The code in the finally block will be executed whether or not there is an exception. If an exception occurs, 
the finally block is executed after the code in the catch block.
--Finally is used for recovering resources and/or cleaning up following the execution of a set of statements.
--Finally always executes!

Correcting with the finally Block
--------------------------------
--Corrected version of the code, with the call to close() moved to the finally block, so that it always runs.

PrintWriter PR = null;
try {
	PR = new PrintWriter(new FileWriter ("myCars.txt"));
	//code deleted to save space...
	// close moved to finally clause
	PR.close();
} catch (FileNotFoundException e) { 
	System.out.println("Could not open file");
} catch (IOException e) {
	System.out.println("Some type of I/O error");
} catch (Exception e) {
	System.out.println("Some other problem");
} finally {
	PR.close();
}

Java Enhancements in try/catch and finally
------------------------------------------------
The try-with-resources Statement
The try-with-resources statement is a try statement that declares one or more resources. A resource is an object that must be closed after the program is finished with it. The try-with-resources statement ensures that each resource is closed at the end of the statement. Any object that implements java.lang.AutoCloseable, which includes all objects which implement java.io.Closeable, can be used as a resource.

The following example reads the first line from a file. It uses an instance of FileReader and BufferedReader to read data from the file. FileReader and BufferedReader are resources that must be closed after the program is finished with it:

	static String readFirstLineFromFile(String path) throws IOException {
	    try (FileReader fr = new FileReader(path);
	         BufferedReader br = new BufferedReader(fr)) {
	        return br.readLine();
	    }
	}

syntax: try(resource1;resource2;){
	} catch {
	}
		
--The need for finally is so common, and so often missed, that Java 7 adopted a page from Python, and introduced the try-with-resources statement.
--The try-with-resources statement is a try statement that declares one or more resources. A resource is as an object that must be closed after the program is finished with it.
The resource must implement the AutoClosable interface

--Resources are anything that need to be cleaned up. Although the method is close (), it could be a close, a release, or any other aspect that means we're finished using it

--Let's rewrite the previous example, using try-with-resources:
try (PrintWriter pR = new PrintWriter(new FileWriter ("myCars.txt")))
{
	
	//code omitted for clarity
} catch (FileNotFoundException e) {
	// Despite its name, this is also thrown when
	// a file exists but can't be open for write 
	out.println("can't open myCars.txt for write.");
	e.printStackTrace();
} catch (IOException e) {
	e.printStackTrace();
}


--The following example uses a try-with-resources statement to automatically close a java.sql.Statement object:

public static void viewTable(Connection con) throws SQLException {

    String query = "select COF_NAME, SUP_ID, PRICE, SALES, TOTAL from COFFEES";

    try (Statement stmt = con.createStatement()) {
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            String coffeeName = rs.getString("COF_NAME");
            int supplierID = rs.getInt("SUP_ID");
            float price = rs.getFloat("PRICE");
            int sales = rs.getInt("SALES");
            int total = rs.getInt("TOTAL");

            System.out.println(coffeeName + ", " + supplierID + ", " + 
                               price + ", " + sales + ", " + total);
        }
    } catch (SQLException e) {
        JDBCTutorialUtilities.printSQLException(e);
    }
}

Multiple catches with same code using |
--------------------------------------------
--Sometimes, we want to handle the multiple exceptions in the same manner

Catch (IOException | SQLException ex) {
	logger.log (ex);
	throw ex;
}

--Rather than force us to repeat multiple catch clauses differing only by their exception type, Java 7 adopted another Python feature.
Catching Multiple Exception Types and re- throwing Exceptions with Improved Type Checking

--The catch clause specifies the types of exceptions that the block can handle, and each exception type is separated with a vertical bar (|).



Throwing Multiple Extensions
-----------------------------------------------
--A method that can throw multiple checked Exception objects must indicate each type of Exception.
--The example that follows uses multiple checked exceptions to show one way of dealing with errors coming from different Sources.

--First we see the user code that is attempting to set up a new Sports Car using a speed defined in a Properties file.

SportsCar myCar = new SportsCar();
try {
	SportsCar.setUpCar(myCar);
} catch (FileNotFoundException e) {
	System.out.println("Could not open properties file");
}
catch (SpeedException e) {
	System.out.println("Car is going too fast!");
}
System.out.println("Speed of car is set to " + myCar.getSpeed());


--The setUpCar method can potentially throw two different types of Exceptions.

public static void setUpCar (SportsCar myCar) throws SpeedException, FileNotFoundException {

	// getCarProperties () will throw a
	// FileNotFound if it can't open the file
	// We just let it flow back to the client
	Properties p = getCarProperties();
	
	// setSpeed() will throw a SpeedException
	// if the speed is too fast. Throw that
	// back to the client as well
	Integer x = Integer.valueOf((String) p.get("speed")); 
	myCar.setSpeed (x.intValue());
}

--Here setUpCar is not throwing(throw new SpeedException or throw new FileNotFoundException) anything in its own code,
the getCarProperties is going to be capable of throwing the FileNotFoundException, and  setSpeed can throw a SpeedException. 



--The getCarProperties method ignores problems opening the file but will catch an IOException if the load fails.

public static Properties getCarProperties () throws FileNotFoundException {

	FileInputStream f = new FileInputStream("abc.txt"); Properties x = new Properties();	//not in try block, if file not found throws exception
	try {
		x.load(f);
	} catch (IOException e) {
		System.out.println("Could not process properties file");
	}
	return x;
}

--setSpeed  method throws SpeedException if speed is too fast.

public void setSpeed (int new_speed) throws SpeedException {
	
	int s = new_speed;
	if (speeder == true)
		ss + 20;
	if (s> MAX_SPEED) {
		throw new SpeedException();
	}
	this.speed= s;
}




Java Input and Output(I/O) Streams and file handling
---------------------------------------------------------------------------------------------------------------------------------
Java has rich Input and Output (I/O) capabilities, which have evolved constantly over the years.
Java can handle network I/O, file I/O; blocking and non-blocking I/O and more. 
In this module we will look at an overview of I/O, and focus mostly on simple text I/O using files.

java.io.*: Input and Output
------------------------------
--Java uses the concept of input and output streams. These concepts are also used in C and are based on the structure of Unix.
--A stream is a logical connection to an external source for the purposes of input or output

Example: Reading Lines of Text
---------------------------------
We'll begin with a simple example. We'll read lines of text from a file and print them out again with line numbers pre-pended to them.

public class PrintWithLineNumbers {
	
	public static void main(String[] args) { 
		
		System.out.println("Current dir: " + system.getProperty("user.dir"));
		try (FileInputStream inFile = new FileInputStream("/home/developer/eclipse-workspace/Demos/src/com/learnquest/demos/HelloWorld.java"); 
		     InputStreamReader inStreamReader = new InputStreamReader (inFile); 
		     LineNumberReader lineReader = new LineNumberReader (instreamReader))
		{
			//Pre-Java 8:
			//string outputLine = null;
			//while ((outputLine = lineReader.readLine()) != null) { 
			//	System.out.printf("%d: %s %n", lineReader.getLineNumber(), outputLine);
			// } 

			lineReader.lines().forEach(line -> out.printf("%d: %s%n",
			lineReader.getLineNumber(), line));

		} catch (IOException e) {
			 e.printStackTrace();
	        }
	}
}

OUTPUT:
----------

Current Working Directory: /home/developer/eclipse-workspace/ClassExercises 
1.package com.learnquest.demos;
2:
3:public class HelloWorld {
3:	public static void main(String[] args) { 
4:		System.out.println("Hello World!");
5:	}
6:}


--FileInputStream will accept an actual file name in its constructor, but it won't allow us to read lines without a lot of work.
• Work with bytes, not characters

--The Reader class is abstract and one of its concrete sub-classes is InputStreamReader. InputStreamReader can be constructed from a FileInputStream.
• Work with characters

--Java has a class called LineNumberReader, which has a readLine() method - exactly what we want. 
But the constructors for LineNumberReader won't accept an actual file name. It only accepts the Reader class.


--The purpose for using LineNumberReader, as opposed to its more common superclass, BufferedReader, 
was to not only allow us to read the lines, but to track the line number for us.
--Now that we have a LineNumberReader, we could use a loop to read lines until we ran out, at which point it will return null.
--However, since we have Java 8, we use Java Streams to do it more concisely, as shown in our code.


Property files and java.io Streams
--------------------------------------------
The Properties File:
--------------------
--Java provides support for a special type of text file called a properties file.
--The properties file stores a single name/value pair on each of its lines.
--Each name and value is separated by an equal sign.
--The default property is myMessages.properties and locally as myMessages.FR_properties, myMessages.IN_properties, etc..

Ex:
user.name=John Doe		
user.dob=January 15th, 1955 
user.os=linux
|	 |
name	Value

--The properties file can be read quite easily as shown here:

import java.io.*;
import java.util.*;

public class MyCars {
	public static void main(String[] args) throws Exception {

		FileInputStream fIS= new FileInputStream("MyFile.properties.txt");

		Properties p = new Properties();
		p.load(FIS);
	
		String userName = (String) p.get("user.name");
		String carType (String) p.get("user. favorite.car");

		System.out.println("User name is " + userName);
		System.out.println("Favorite car is " + carType);
	}
}

(Check : https://docs.oracle.com/javase/tutorial/i18n/resbundle/propfile.html)

Backing a ResourceBundle with Properties Files
------------------------------------------------------------------
This section steps through a sample program named PropertiesDemo.

1. Create the Default Properties File
-----------------------------------------
A properties file is a simple text file. You can create and maintain a properties file with just about any text editor.

You should always create a default properties file. The name of this file begins with the base name of your ResourceBundle and ends with the .properties suffix. In the PropertiesDemo program the base name is LabelsBundle. Therefore the default properties file is called LabelsBundle.properties. This file contains the following lines:

# This is the default LabelsBundle.properties file
s1 = computer
s2 = disk
s3 = monitor
s4 = keyboard
Note that in the preceding file the comment lines begin with a pound sign (#). The other lines contain key-value pairs. The key is on the left side of the equal sign and the value is on the right. For instance, s2 is the key that corresponds to the value disk. The key is arbitrary. We could have called s2 something else, like msg5 or diskID. Once defined, however, the key should not change because it is referenced in the source code. The values may be changed. In fact, when your localizers create new properties files to accommodate additional languages, they will translate the values into various languages.

2. Create Additional Properties Files as Needed
----------------------------------------------------
To support an additional Locale, your localizers will create a new properties file that contains the translated values. No changes to your source code are required, because your program references the keys, not the values.

For example, to add support for the German language, your localizers would translate the values in LabelsBundle.properties and place them in a file named LabelsBundle_de.properties. Notice that the name of this file, like that of the default file, begins with the base name LabelsBundle and ends with the .properties suffix. However, since this file is intended for a specific Locale, the base name is followed by the language code (de). The contents of LabelsBundle_de.properties are as follows:

# This is the LabelsBundle_de.properties file
s1 = Computer
s2 = Platte
s3 = Monitor
s4 = Tastatur
The PropertiesDemo sample program ships with three properties files:

LabelsBundle.properties
LabelsBundle_de.properties
LabelsBundle_fr.properties

3. Specify the Locale
--------------------------
The PropertiesDemo program creates the Locale objects as follows:

Locale[] supportedLocales = {
    Locale.FRENCH,
    Locale.GERMAN,
    Locale.ENGLISH
};
These Locale objects should match the properties files created in the previous two steps. For example, the Locale.FRENCH object corresponds to the LabelsBundle_fr.properties file. The Locale.ENGLISH has no matching LabelsBundle_en.properties file, so the default file will be used.

4. Create the ResourceBundle
----------------------------------
This step shows how the Locale, the properties files, and the ResourceBundle are related. To create the ResourceBundle, invoke the getBundlemethod, specifying the base name and Locale:

ResourceBundle labels = ResourceBundle.getBundle("LabelsBundle", currentLocale);

The getBundle method first looks for a class file that matches the base name and the Locale. 
If it can't find a class file, it then checks for properties files. 
In the PropertiesDemo program we're backing the ResourceBundle with properties files instead of class files. 
When the getBundle method locates the correct properties file, it returns a PropertyResourceBundle object containing the key-value pairs from the properties file.

5. Fetch the Localized Text
-------------------------------
To retrieve the translated value from the ResourceBundle, invoke the getString method as follows:

String value = labels.getString(key);
The String returned by getString corresponds to the key specified. The String is in the proper language, provided that a properties file exists for the specified Locale.

6. Iterate through All the Keys
---------------------------------------
This step is optional. When debugging your program, you might want to fetch values for all of the keys in a ResourceBundle. The getKeys method returns an Enumeration of all the keys in a ResourceBundle. You can iterate through the Enumeration and fetch each value with the getString method. The following lines of code, which are from the PropertiesDemo program, show how this is done:

ResourceBundle labels = ResourceBundle.getBundle("LabelsBundle", currentLocale);
Enumeration bundleKeys = labels.getKeys();

while (bundleKeys.hasMoreElements()) {
    String key = (String)bundleKeys.nextElement();
    String value = labels.getString(key);
    System.out.println("key = " + key + ", " + "value = " + value);
}

7. Run the Demo Program
---------------------------
Running the PropertiesDemo program generates the following output. The first three lines show the values returned by getString for various Locale objects. The program displays the last four lines when iterating through the keys with the getKeys method.

Locale = fr, key = s2, value = Disque dur
Locale = de, key = s2, value = Platte
Locale = en, key = s2, value = disk

key = s4, value = Clavier
key = s3, value = Moniteur
key = s2, value = Disque dur
key = s1, value = Ordinateur


Stream Classes In Depth(java.io.InputStream and java.io.OutputStream)
-------------------------------------------------------------------------
--The package java.io provides two basic abstract classes that all streams are derived from:

InputStream - Base abstract class for stream input
OutputStream - Base abstract class for stream output

The OutputStream Hierarchy
---------------------------
						OutputStream
						     ↑
		-------------------------------------------------------------------------------------
		|		|		     |			|			     |
	ByteArrayOutputStream	|		PipedOutputStream	|			ObjectOutputStream
				|					|
			FileOutputStream			FilterOutputStream
									↑
					----------------------------------------------------------------
					|				|				|
				DataOutputStream		BufferedOutputStream		PrintStream

	
IO Hierarchy: Remarks
---------------------------
Remember that these classes are intended for more than reading and writing to files.

These classes support:
•Both buffered and unbuffered read/write
•Byte arrays for binary and any non-text data

Don't confuse InputStream and OutputStream with the new Java Streams.

The InputStream Class
--------------------------
public abstract class InputStream
{
	public abstract int read() throws IOException; 
	public int read (byte b[]) throws IOException;
	public long skip (long n) throws IOException;
	public int read (byte b[], int off, int len) throws IOException; public void close() throws IOException;
	public int available() throws IOException;
	public synchronized void mark (int readlimit);
	public synchronized void reset() throws IOException; 
	public boolean markSupported();
}


The OutputStream Class
------------------------
public abstract class OutputStream
{
	public abstract void write (int b) throws IOException; 
	public void write (byte b[]) throws IOException; 
	public void write (byte b[], int off, int len) throws IOException;
	public void flush() throws IOException; 
	public void close() throws IOException;
}


Buffered vs. Unbuffered IO
---------------------------------
--Buffering allows multiple reads or writes to be performed before the data is actually sent to the stream. 
Before data is read or written, it is stored in memory within the class.
--The data is only read from or written to the stream when the buffer is full.
--The Buffered IO classes :
	(BufferedInputStream, 
	 BufferedOutputStream, etc.) support these functions.



Files and Directories
----------------------------------------------------------------------------------

The File and Directory Classes
--------------------------------
--The next few slides examine the File class.
--File does not allow you to read and write from files. Instead it allows you to discover various properties of files and directories.
--Using File, you can traverse a directory structure and discover what files - and types of files - are in any directory.


File Input/Output
---------------------
• A File object represents a proxy to a file on your file system.
• It is not used to directly manipulate files.
• A File object is an abstract representation of file and directory pathnames.
• FileInputStream, FileOutputStream and RandomAccessFile are used to manipulate the contents of a file.
• File provides platform independent representations for file path separators.

File Class Methods
--------------------
--Use isFile() and isDirectory () to determine the nature of the File object.
--Use canRead() and canWrite () to determine access rights.
--Use exists() to see if there is a file system entry.
--Use length () to get the file size.
--Use delete () to delete the file.
--Use list() to see the contents of a directory.
--Use mkdir () to create a directory.


Directory Manipulation Example
-------------------------------
package com.1q;
import java.io.*;

public class DirectoryChecker
{
	public static void main(String[] args) {
	
		File aDirectory = new File (".");
		if (aDirectory.isDirectory ()) {

			String[] contents = aDirectory.list (); 
			for (int f = 0; f< contents.length; f++) { 
				System.out.println (contents [f]);
			}
		}
	}
}

Ex:
PrintWithLineNumbers.java
---------------------------------
package com.learnquest.demoapps;
import java.io.IOException; 
import java.nio.file.FileSystem:
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path; 
import java.nio.file.PathMatchers;
import java.nio.file.Paths; 
import java.util.stream.Stream;

public class FileDemo {

	public static boolean contains(Path file, String text) {
	
		try {
			return Files.isRegularFile(file) & Files.lines(file).anyMatch(line -> line.contains(text));
		} catch (IOException e) {
			return false;
		}	
	}	
	
	public static void main(String[] args) throws IOException { 

		PathMatcher javaFiles = Filesystems.getDefault().getPathMatcher("glob:**/*.java");	//what files do u want?.java files
		Path cwd = Paths.get(System.getProperty("user.dir"));					//from which directory?current Dir
		Stream<Path> javaPaths = Files.walk(cwd).filter(path -> javafiles.matches(path)); 	//walk through the dir
		javaPaths.filter(path-> FileDemo.contains(path, "System")).forEach(System.out::println);	

	}
}

Java Nio
------------
(Check https://docs.oracle.com/javase/tutorial/essential/io/index.html)

Java 8 Stream – Read a file line by line--
https://mkyong.com/java8/java-8-stream-read-a-file-line-by-line/

File IO with Java 8 Streams--
https://www.nextptr.com/tutorial/ta1321112508/file-io-with-java-8-streams



Writing Text Files
-----------------------------------------------------------------------------------------------------------------
Text Files
---------------
Having seen how to read from a file earlier in this chapter, we will close with an example of writing to a text file.
In general, there are three steps to writing text to a file:
• Connect an output stream to the file
• Write text data to the stream
• Close the stream

Writing to a Text File
----------------------------
package com.lq; 
import java.io.*;

public class MyFileWriter {
	public static void main(String[] args) {
		try {
			BufferedWriter bR = new BufferedWriter ( new FileWriter ("myCars.txt"));
			bR.write("Corvette ");
			bR.write("Escalade ");
			bR.write("Town Car ");
			bR.close();
		}catch (IOException e) { 

		}
	}
}
(Check: https://docs.oracle.com/javase/8/docs/api/java/io/BufferedWriter.html)

Writing using a PrintWriter
---------------------------------
package com.lq; 
import java.io.*;

public class MyFileWriter {

	public static void main(String[] args) {
		try {
			PrintWriter pR = new PrintWriter( new FileWriter ("myCars.txt"));
			pR.println("Corvette");
			pR.println("Escalade");
			pR.println("Town Car");
			pR.close();
		} catch (IOException e) {
		
		}
	}
}

(Check : https://docs.oracle.com/javase/8/docs/api/java/io/PrintWriter.html)


NIO.2 File Systems
--------------------------
IO and New IO
---------------
--java.nio.file package   and 	java.nio.file.attribute

•Support for file I/O and for accessing the file system
•NIO stands for non-blocking I/O

--A zip system provider is also available
•You can use the factory methods of the java.nio.file.FileSystems class to create a new zip file system or to obtain a reference to an existing zip file system.
•Create a zip file system by specifying the path of the zip or JAR file in one of the following ways:

Example
--------
URI uri = URI.create("jar: file:/code Samples/zipfs/zipfstest.zip"); 
FileSystem fs = FileSystems.newFileSystem (uri, env);

Path zipfile =Paths.get("/codeSamples/zipfs/zipfstest.zip"); 
FileSystem fs = FileSystems.newFileSystem (zipfile, env, null);


// Zip a single file 
public static void zipSingleFileNio (Path source, String zipFileName) throws IOException {
	
	if (!Files.is RegularFile(source)) { 
		System.err.println("Please provide a file."); 
		return;
	}
	
	Map<String, String> env = new HashMap<>(); 

	// Create the zip file if it doesn't exist 
	env.put("create", "true");"

	URI uri= URI.create("jar: file:/home/mkyong/"+zipFileName);
	try (FileSystem zipfs = FileSystems.newFileSystem (uri, env)) { 

		Path pathInZipfile = zipfs.getPath(source.getFileName().toString());
		// Copy a file into the zip file path 
		Files.copy(source, pathInZipfile, StandardCopyOption.REPLACE_EXISTING);
	}
}

Check : https://docs.oracle.com/javase/7/docs/technotes/guides/io/fsp/zipfilesystemprovider.html
Check: https://mkyong.com/java/how-to-compress-files-in-zip-format/


ENUMS   (Check : https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)
----------------------------------------------------------
What is an Enum?
----------------

enum Cardsuit { CLUBS, DIAMONDS, SPADES, HEARTS };

--An enum type is a type whose fields consist of a fixed set of constant values.
--The field names are identifiers that are used as constants.
--An enum always extends java.lang.Enum.
--Enums are class files with some additional capabilities, but like other classes, can have additional data and behavior.

When to use Enums?
-------------------

--You should use enum types any time you need to represent a fixed set of constants.
--That includes natural enum types such as the planets in our solar system and data sets where you know all possible values at compile time.
for example, the choices on a menu, command line flags, and so on.

Originally, enumerations were often represented as a set of int constant values.

// int Enum Pattern has severe problems! -
public static final int SEASON WINTER = 0;
public static final int SEASON SPRING = 1;
public static final int SEASON SUMMER = 2;
public static final int SEASON FALL = 3;

Problems with JDK 1.4 Enums
------------------------------

--Not type safe - Since an enum is just an int you can pass in any other int value where a the enum is required.
--No namespace - You must prefix constants of an int enum with a string to avoid collisions in the namespace.
--Brittleness - If a new constant is added between two existing constants or the order is changed, clients of the enum must be recompiled.
--Printed values are uninformative - if you print a 1.4 enum, all you get is a number, not what it represents, or what type it is.


Enum Types
------------------------------
An enum type is a special data type that enables for a variable to be a set of predefined constants. The variable must be equal to one of the values that have been predefined for it. Common examples include compass directions (values of NORTH, SOUTH, EAST, and WEST) and the days of the week.

Because they are constants, the names of an enum type's fields are in uppercase letters.

In the Java programming language, you define an enum type by using the enum keyword. For example, you would specify a days-of-the-week enum type as:


public enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY 
}
You should use enum types any time you need to represent a fixed set of constants. That includes natural enum types such as the planets in our solar system and data sets where you know all possible values at compile time—for example, the choices on a menu, command line flags, and so on.

Here is some code that shows you how to use the Day enum defined above:


public class EnumTest {
    Day day;
    
    public EnumTest(Day day) {
        this.day = day;
    }
    
    public void tellItLikeItIs() {
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;
                    
            case FRIDAY:
                System.out.println("Fridays are better.");
                break;
                         
            case SATURDAY: case SUNDAY:
                System.out.println("Weekends are best.");
                break;
                        
            default:
                System.out.println("Midweek days are so-so.");
                break;
        }
    }
    
    public static void main(String[] args) {
        EnumTest firstDay = new EnumTest(Day.MONDAY);
        firstDay.tellItLikeItIs();
        EnumTest thirdDay = new EnumTest(Day.WEDNESDAY);
        thirdDay.tellItLikeItIs();
        EnumTest fifthDay = new EnumTest(Day.FRIDAY);
        fifthDay.tellItLikeItIs();
        EnumTest sixthDay = new EnumTest(Day.SATURDAY);
        sixthDay.tellItLikeItIs();
        EnumTest seventhDay = new EnumTest(Day.SUNDAY);
        seventhDay.tellItLikeItIs();
    }
}
The output is:

Mondays are bad.
Midweek days are so-so.
Fridays are better.
Weekends are best.
Weekends are best.
Java programming language enum types are much more powerful than their counterparts in other languages. The enum declaration defines a class (called an enum type). The enum class body can include methods and other fields. The compiler automatically adds some special methods when it creates an enum. For example, they have a static values method that returns an array containing all of the values of the enum in the order they are declared. This method is commonly used in combination with the for-each construct to iterate over the values of an enum type. For example, this code from the Planet class example below iterates over all the planets in the solar system.

for (Planet p : Planet.values()) {
    System.out.printf("Your weight on %s is %f%n",
                      p, p.surfaceWeight(mass));
}
Note: All enums implicitly extend java.lang.Enum. Because a class can only extend one parent (see Declaring Classes), the Java language does not support multiple inheritance of state (see Multiple Inheritance of State, Implementation, and Type), and therefore an enum cannot extend anything else.
In the following example, Planet is an enum type that represents the planets in the solar system. They are defined with constant mass and radius properties.

Each enum constant is declared with values for the mass and radius parameters. These values are passed to the constructor when the constant is created. Java requires that the constants be defined first, prior to any fields or methods. Also, when there are fields and methods, the list of enum constants must end with a semicolon.

Note: The constructor for an enum type must be package-private or private access. It automatically creates the constants that are defined at the beginning of the enum body. You cannot invoke an enum constructor yourself.
In addition to its properties and constructor, Planet has methods that allow you to retrieve the surface gravity and weight of an object on each planet. Here is a sample program that takes your weight on earth (in any unit) and calculates and prints your weight on all of the planets (in the same unit):


public enum Planet {
    MERCURY (3.303e+23, 2.4397e6),
    VENUS   (4.869e+24, 6.0518e6),
    EARTH   (5.976e+24, 6.37814e6),
    MARS    (6.421e+23, 3.3972e6),
    JUPITER (1.9e+27,   7.1492e7),
    SATURN  (5.688e+26, 6.0268e7),
    URANUS  (8.686e+25, 2.5559e7),
    NEPTUNE (1.024e+26, 2.4746e7);

    private final double mass;   // in kilograms
    private final double radius; // in meters
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }
    private double mass() { return mass; }
    private double radius() { return radius; }

    // universal gravitational constant  (m3 kg-1 s-2)
    public static final double G = 6.67300E-11;

    double surfaceGravity() {
        return G * mass / (radius * radius);
    }
    double surfaceWeight(double otherMass) {
        return otherMass * surfaceGravity();
    }
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Planet <earth_weight>");
            System.exit(-1);
        }
        double earthWeight = Double.parseDouble(args[0]);
        double mass = earthWeight/EARTH.surfaceGravity();
        for (Planet p : Planet.values())
           System.out.printf("Your weight on %s is %f%n",
                             p, p.surfaceWeight(mass));
    }
}
If you run Planet.class from the command line with an argument of 175, you get this output:

$ java Planet 175
Your weight on MERCURY is 66.107583
Your weight on VENUS is 158.374842
Your weight on EARTH is 175.000000
Your weight on MARS is 66.279007
Your weight on JUPITER is 442.847567
Your weight on SATURN is 186.552719
Your weight on URANUS is 158.397260
Your weight on NEPTUNE is 199.207413

Enum Types
-----------
--An enumerated type is a type whose instances describe values, where the set of possible values is finite.
i.e. the four points of the compass:
enum Directions (NORTH, SOUTH, EAST, WEST};

Used when the most important information is the existence of the value.
• Classes with additional data or behavior requirements would usually not consider enumerated types though enums may have attributes.

Extending an Enum
--------------------
--Java "does not support" inheritance of an enum.

	•Enums represent a set of finite elements.
	•Derived classes would increase the size of the set.

--In Java, enum is an implementation of the Flyweight pattern. (A set of Singletons ).

Add Fields to an Enum
------------------------
--Enums are treated as classes with specialized constructors.

public enum Tire Pressures { 

	LF (30), RF (30), LR (32), RR (32); 

	int pressure;

	private Tire Pressures (int pressure) { 
		this.pressure = pressure;
	}
	public int getPressure () { 
		return pressure;
	}
}

Adding Methods to an Enum
----------------------------
--An enum may have any number of methods, but only one constructor.

public enum TirePressures { 

	LF (30), RF (30), LR (32), RR (32); 
		
	int pressure;
	
	private Tire Pressures (int pressure) { 
		this.pressure = pressure; 
	}
	public int getPressure () { 
		return pressure;
	} 
	public void overridePressure (int newPressure) { 	//new method
		this.pressure = newPressure;
	}
}

Enums in Switch/Case
--------------------------
--An enum is used as the integral value of the switch.

for (TirePressures tp : Tire Pressures.values()) {

	switch (tp) {
		case LF: tp.override Pressure (28);
		break;
		case RF: tp.overridePressure (28);
		break;
		case LR: tp.overridePressure (30);
		break;
		case RR: tp.override Pressure (30);
		break;
		default:
		break;
	}
System.out.println(tp + + tp.getPressure());

--Enums are often used to represent things that have a fixed set of values that constrain the domain of a type.
--An enum is a special type of Java class that extends the java.lang.Enum class
--Because enums are now a formal part of the Java language, many of the problems with pre-Java 5 enumeration constructs have been eliminated.
--Methods and attributes can be added to a enum.


EnumMap
----------
Check : https://docs.oracle.com/javase/8/docs/api/java/util/EnumMap.html

Annotations(Check : https://docs.oracle.com/javase/tutorial/java/annotations/index.html)
----------------------
Annotations, a form of metadata, provide data about a program that is not part of the program itself. Annotations have no direct effect on the operation of the code they annotate.

Annotations have a number of uses, among them:

Information for the compiler — Annotations can be used by the compiler to detect errors or suppress warnings.
Compile-time and deployment-time processing — Software tools can process annotation information to generate code, XML files, and so forth.
Runtime processing — Some annotations are available to be examined at runtime.
This lesson explains where annotations can be used, how to apply annotations, what predefined annotation types are available in the Java Platform, Standard Edition (Java SE API), how type annotations can be used in conjunction with pluggable type systems to write code with stronger type checking, and how to implement repeating annotations.



Annotations Basics
---------------------------
The Format of an Annotation
In its simplest form, an annotation looks like the following:

@Entity
The at sign character (@) indicates to the compiler that what follows is an annotation. In the following example, the annotation's name is Override:

@Override
void mySuperMethod() { ... }
The annotation can include elements, which can be named or unnamed, and there are values for those elements:

@Author(
   name = "Benjamin Franklin",
   date = "3/27/2003"
)
class MyClass { ... }
or

@SuppressWarnings(value = "unchecked")
void myMethod() { ... }
If there is just one element named value, then the name can be omitted, as in:

@SuppressWarnings("unchecked")
void myMethod() { ... }
If the annotation has no elements, then the parentheses can be omitted, as shown in the previous @Override example.

It is also possible to use multiple annotations on the same declaration:

@Author(name = "Jane Doe")
@EBook
class MyClass { ... }
If the annotations have the same type, then this is called a repeating annotation:

@Author(name = "Jane Doe")
@Author(name = "John Smith")
class MyClass { ... }
Repeating annotations are supported as of the Java SE 8 release. For more information, see Repeating Annotations.

The annotation type can be one of the types that are defined in the java.lang or java.lang.annotation packages of the Java SE API. In the previous examples, Override and SuppressWarnings are predefined Java annotations. It is also possible to define your own annotation type. The Author and Ebook annotations in the previous example are custom annotation types.

Where Annotations Can Be Used
Annotations can be applied to declarations: declarations of classes, fields, methods, and other program elements. When used on a declaration, each annotation often appears, by convention, on its own line.

As of the Java SE 8 release, annotations can also be applied to the use of types. Here are some examples:

Class instance creation expression:
    new @Interned MyObject();
Type cast:
    myString = (@NonNull String) str;
implements clause:
    class UnmodifiableList<T> implements
        @Readonly List<@Readonly T> { ... }
Thrown exception declaration:
    void monitorTemperature() throws
        @Critical TemperatureException { ... }


Declaring an Annotation Type
-----------------------------------
Many annotations replace comments in code.

Suppose that a software group traditionally starts the body of every class with comments providing important information:

public class Generation3List extends Generation2List {

   // Author: John Doe
   // Date: 3/17/2002
   // Current revision: 6
   // Last modified: 4/12/2004
   // By: Jane Doe
   // Reviewers: Alice, Bill, Cindy

   // class code goes here

}
To add this same metadata with an annotation, you must first define the annotation type. The syntax for doing this is:

@interface ClassPreamble {
   String author();
   String date();
   int currentRevision() default 1;
   String lastModified() default "N/A";
   String lastModifiedBy() default "N/A";
   // Note use of array
   String[] reviewers();
}
The annotation type definition looks similar to an interface definition where the keyword interface is preceded by the at sign (@) (@ = AT, as in annotation type). Annotation types are a form of interface, which will be covered in a later lesson. For the moment, you do not need to understand interfaces.

The body of the previous annotation definition contains annotation type element declarations, which look a lot like methods. Note that they can define optional default values.

After the annotation type is defined, you can use annotations of that type, with the values filled in, like this:

@ClassPreamble (
   author = "John Doe",
   date = "3/17/2002",
   currentRevision = 6,
   lastModified = "4/12/2004",
   lastModifiedBy = "Jane Doe",
   // Note array notation
   reviewers = {"Alice", "Bob", "Cindy"}
)
public class Generation3List extends Generation2List {

// class code goes here

}
Note: To make the information in @ClassPreamble appear in Javadoc-generated documentation, you must annotate the @ClassPreamble definition with the @Documented annotation:
// import this to use @Documented
import java.lang.annotation.*;

@Documented
@interface ClassPreamble {

   // Annotation element definitions
   
}

Predefined Annotation Types
----------------------------------
A set of annotation types are predefined in the Java SE API. Some annotation types are used by the Java compiler, and some apply to other annotations.

Annotation Types Used by the Java Language
The predefined annotation types defined in java.lang are @Deprecated, @Override, and @SuppressWarnings.

@Deprecated @Deprecated annotation indicates that the marked element is deprecated and should no longer be used. The compiler generates a warning whenever a program uses a method, class, or field with the @Deprecated annotation. When an element is deprecated, it should also be documented using the Javadoc @deprecated tag, as shown in the following example. The use of the at sign (@) in both Javadoc comments and in annotations is not coincidental: they are related conceptually. Also, note that the Javadoc tag starts with a lowercase d and the annotation starts with an uppercase D.

   // Javadoc comment follows
    /**
     * @deprecated
     * explanation of why it was deprecated
     */
    @Deprecated
    static void deprecatedMethod() { }
}
@Override @Override annotation informs the compiler that the element is meant to override an element declared in a superclass. Overriding methods will be discussed in Interfaces and Inheritance.

   // mark method as a superclass method
   // that has been overridden
   @Override 
   int overriddenMethod() { }
While it is not required to use this annotation when overriding a method, it helps to prevent errors. If a method marked with @Override fails to correctly override a method in one of its superclasses, the compiler generates an error.

@SuppressWarnings @SuppressWarnings annotation tells the compiler to suppress specific warnings that it would otherwise generate. In the following example, a deprecated method is used, and the compiler usually generates a warning. In this case, however, the annotation causes the warning to be suppressed.

   // use a deprecated method and tell 
   // compiler not to generate a warning
   @SuppressWarnings("deprecation")
    void useDeprecatedMethod() {
        // deprecation warning
        // - suppressed
        objectOne.deprecatedMethod();
    }
Every compiler warning belongs to a category. The Java Language Specification lists two categories: deprecation and unchecked. The unchecked warning can occur when interfacing with legacy code written before the advent of generics. To suppress multiple categories of warnings, use the following syntax:

@SuppressWarnings({"unchecked", "deprecation"})
@SafeVarargs @SafeVarargs annotation, when applied to a method or constructor, asserts that the code does not perform potentially unsafe operations on its varargs parameter. When this annotation type is used, unchecked warnings relating to varargs usage are suppressed.

@FunctionalInterface @FunctionalInterface annotation, introduced in Java SE 8, indicates that the type declaration is intended to be a functional interface, as defined by the Java Language Specification.

Annotations That Apply to Other Annotations
Annotations that apply to other annotations are called meta-annotations. There are several meta-annotation types defined in java.lang.annotation.

@Retention @Retention annotation specifies how the marked annotation is stored:

RetentionPolicy.SOURCE – The marked annotation is retained only in the source level and is ignored by the compiler.
RetentionPolicy.CLASS – The marked annotation is retained by the compiler at compile time, but is ignored by the Java Virtual Machine (JVM).
RetentionPolicy.RUNTIME – The marked annotation is retained by the JVM so it can be used by the runtime environment.
@Documented @Documented annotation indicates that whenever the specified annotation is used those elements should be documented using the Javadoc tool. (By default, annotations are not included in Javadoc.) For more information, see the Javadoc tools page.

@Target @Target annotation marks another annotation to restrict what kind of Java elements the annotation can be applied to. A target annotation specifies one of the following element types as its value:

ElementType.ANNOTATION_TYPE can be applied to an annotation type.
ElementType.CONSTRUCTOR can be applied to a constructor.
ElementType.FIELD can be applied to a field or property.
ElementType.LOCAL_VARIABLE can be applied to a local variable.
ElementType.METHOD can be applied to a method-level annotation.
ElementType.PACKAGE can be applied to a package declaration.
ElementType.PARAMETER can be applied to the parameters of a method.
ElementType.TYPE can be applied to any element of a class.
@Inherited @Inherited annotation indicates that the annotation type can be inherited from the super class. (This is not true by default.) When the user queries the annotation type and the class has no annotation for this type, the class' superclass is queried for the annotation type. This annotation applies only to class declarations.

@Repeatable @Repeatable annotation, introduced in Java SE 8, indicates that the marked annotation can be applied more than once to the same declaration or type use. For more information, see Repeating Annotations.