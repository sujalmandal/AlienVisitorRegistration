package main.application;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Scanner;

import formatHelper.ClassEnumerator;
import alien.details.Details;

/*
 * 
 * @author Sujal Mandal
 * @Email ss6sujal@gmail.com
 * Solution for multunus test
 *	
 *	Download the API: http://sourceforge.net/projects/itext/files/latest/download
 *	Unzip the file and get the jar file "itext-pdfa-5.5.1.jar"
 *	If you are you using eclipse, copy the jar file in your project workspace, then right click on it,
 *  click on "add to build path", that should register the external jar file which is needed to print the pdf
 */

public class AlienRegistration
{	
static String input;							   //the input string to store the user input
Scanner scanner = new Scanner(System.in); 		   //scanner object to take input from user

public static void main(String... args)
{
	AlienRegistration myAlienRegistration=new AlienRegistration();    //Create the object of the main class to run the system
	myAlienRegistration.showMenu();									  //show the main menu
}


/*********************the method which shows the menu*********************/
public void showMenu()
{
	 
	System.out.println("\n\n********************Welcome to the System*********************");
	System.out.println("\nEnter [Register]--------------------------to Register a New Alien Visitor");
	System.out.println("\nEnter [Exit]----------------- to Exit the Alien Visit Registration System\n");
	
	input=scanner.nextLine();
	
	if(input.contains("register")||input.contains("Register"))
	{
		getAlienData();	//get the data from user once the input "Register" is obtained
	}
	else if(input.contains("exit")||input.contains("Exit"))
	{
		System.out.println("\nGood Bye! :-)");	//Exit..!
		System.exit(0);
	}
	else
	{
		System.out.println("\nYou have not entered a proper command, try again!");
		showMenu();
	}
}

private void showPrintChoice(Details myAlienDetails)
{
	int counter=0;
	int size=0;
	boolean validFormat=false;	//flag to reflect if user choice was a valid and existing format
	String desiredFormat=null;	//variable to store user's choice of format
	Class<?> formatClass = null; //variable to store the Class object
	
	/*Get all the classes (formats) available under the package "formatsToPrint"*/
	List<Class<?>> classes = ClassEnumerator.getClassesForPackage("formatsToPrint");
	size=classes.size();
	
	System.out.print("Input the formats in the console to print your details out [");
	
	for (Class<?> tempClassList : classes ) //iterate through the number of classes present
	{
	counter++;		//increment the counter
	System.out.print(tempClassList.getSimpleName());	//print the names of the classes
	if(!(size==counter))
		System.out.print(",");
	}
	System.out.println("]");
	
	desiredFormat=scanner.nextLine(); //take the name of the desired format from the user
	
	
	for (Class<?> tempClassList : classes ) //iterate through the number of classes present again
	{
	if(tempClassList.getSimpleName().equals(desiredFormat))	//iterate all the present formats available and see if they match
	validFormat=true;										// the user input, if it does then set validFormat to true
	}
	
	if(validFormat==false)		//if the flag is still false, exit the app
	{
		System.out.println("Sorry, you have selected a invalid format, cannot proceed. System will exit !");
		System.exit(0);
	}
	else		//if the flag is true, it means there was a match and we can proceed to the printing part !
	{
		try
		{
			formatClass = Class.forName("formatsToPrint."+desiredFormat);  //try and get the "Class" type object of the format
		}
		
		catch (ClassNotFoundException e)
		{
			System.out.println("The class "+desiredFormat+" was not found !");	//class not found, hence exit
			System.exit(0);
		}
		
		try
		{
			Object obj=formatClass.getConstructor().newInstance();		//with the "Class" type object make a instance of the format class
			try
			{
				
				final Method printer=formatClass.getMethod("printToFormat", Details.class);	//make a Method Object (the method which has printing logic)
				printer.invoke(obj, myAlienDetails);		//invoke the method using the instance of the format class and Details object(as parameter containing data to print)
			}
			
			catch (SecurityException | NoSuchMethodException e)
			{
				System.out.println("Bad format class! Replace your format class and try with a proper one.");
				System.exit(0); //quit
				//e.printStackTrace();
			}
			
		}
		
		/*******************various exceptions which may occur while getting a instance from the class name*******************/
		catch (IllegalArgumentException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0); //quit
		}
		catch (SecurityException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0); //quit
		}
		catch (InstantiationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0); //quit
		}
		catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0); //quit
		}
		catch (InvocationTargetException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0); //quit
		}
		catch (NoSuchMethodException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0); //quit
		}
	}	
}

public void getAlienData()
{
	boolean validData=false;
	String codeName = null;
	String bloodColor = null;
	String noAntennas = null;				   // variables to hold the strings from user
	String noLegs = null;
	String homePlanet = null;
	Details myAlienDetails=new Details();      //new Details object to store the values

	
	/********************************get the inputs from the user as well as validates them*************************/
	
	System.out.println("\n\n\nEnter the Code Name of the Alien.");
	while(validData==false)								//initiate the loop if the flag is false
	{
	codeName=scanner.nextLine();						//take input from the user
	validData=myAlienDetails.setCodeName(codeName);     //get the flag
	}
	validData=false;									//reset the flag back to false and continue the similar operations
	
	System.out.println("\nEnter the Blood Color of the Alien.");
	while(validData==false)
	{
	bloodColor=scanner.nextLine();
	validData=myAlienDetails.setBloodColor(bloodColor);
	}
	validData=false;									//reset flag
	
	System.out.println("\nEnter the No. of Antennas of the Alien.");
	while(validData==false)
	{
	noAntennas=scanner.nextLine();
	validData=myAlienDetails.setNoOfAntennas(noAntennas);
	}
	validData=false;									//reset flag
	
	System.out.println("\nEnter the No. of Legs of the Alien.");
	while(validData==false)
	{
	noLegs=scanner.nextLine();
	validData=myAlienDetails.setNoOfLegs(noLegs);
	}
	validData=false;									//reset flag
	
	System.out.println("\nEnter the Home Planet Name of the Alien.");
	while(validData==false)
	{
	homePlanet=scanner.nextLine();
	validData=myAlienDetails.setHomePlanet(homePlanet);
	}
	validData=false;									//reset flag
	
	/*******************************Finally ask the user to choose the format****************************/
	//showPrintChoice(myAlienDetails);	
	showPrintChoice(myAlienDetails);		// call the method which asks user to choose the format to print 
}

}
