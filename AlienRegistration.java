package main.application;

import java.util.Scanner;

import writer.WritePdf;
import writer.WriteText;
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
	myAlienRegistration.showMenu();									                  //show the main menu
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


public void showPrintChoice(Details detail)  //show the choice for options to print the details
{											 //you can add a choice here to add a new format
	String whatFormat = null;
	System.out.println("\n\n\n\nIn what format do you want the file to be printed ?");
	System.out.println("\ninput \"PDF\" for Portable Document Format or \"TEXT\" for simple Text \n");
	whatFormat=scanner.nextLine();
	if(whatFormat.contains("PDF")||whatFormat.contains("Pdf")||whatFormat.contains("pdf"))
	{
		WritePdf pdfWriter = new WritePdf();
		pdfWriter.writeToPdf(detail);
	}
	else if(whatFormat.contains("TEXT")||whatFormat.contains("Text")||whatFormat.contains("text"))
	{
		WriteText textWriter=new WriteText();
		textWriter.writeToText(detail);
	}
	else
	{
		System.out.println("Sorry, bad choice, program with quit now.");
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
	showPrintChoice(myAlienDetails);	
}

}
