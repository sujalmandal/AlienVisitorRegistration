package writer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import alien.details.Details;

public class WriteText
{
    FileOutputStream fileoutput; 
    PrintWriter printWrite;
    public void writeToText(Details detail)
    {
    	try
		{
			fileoutput = new FileOutputStream("c:/"+detail.getCodeName()+".txt");		//create a new File
			printWrite = new PrintWriter(fileoutput);
			
			/*********************Print the headers first************************/
			printWrite.println("|    Code Name       |   Blood Color     | No.of Antennas    |   No. of Legs     |    Home Planet   |");
			
			for(int i=0;i<100;i++)
			{
				printWrite.write("_"); 		//print 100 "_" to draw a line below the header
			}
			
			printWrite.println();			//add a new line
			printWrite.write("|");			//add a separator
			
			writeCenterAlign(detail.getCodeName(), printWrite);
			writeCenterAlign(detail.getBloodColor(), printWrite);
			writeCenterAlign(detail.getNoOfAntennas(), printWrite);
			writeCenterAlign(detail.getNoOfLegs(), printWrite);
			writeCenterAlign(detail.getHomePlanet(), printWrite);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Sorry! the file is being accessed by some application, the system with exit now.");
			System.exit(0);
			//e.printStackTrace();
		}
    	
    	System.out.println("Your file has been printed successfully :-)");			//end
    	System.out.println("\nFind the file in your \"C:/\" drive, Thank you!");	//tell the location of the file
    	
    	for(int i=0;i<100;i++)
		{
			printWrite.write("_");  //print 100 "_" to draw a line below the data line
		}
        printWrite.close();
    }
    
    public void writeCenterAlign(String str,PrintWriter printWrite) //custom logic which writes the data in the center as per the fields in the text file
    {
    	int len=str.length();			//the length of the user input
    	int constantLen=20;				//the average length of the headers in the text file
    	int extraLen=constantLen-len;   //find out the extra space left
    	int margin=extraLen/2; 			//the amount of space to be left on both sides so that the data appears to be on the center
    	
    	
    	
    	for(int i=0;i<margin;i++)		//add spaces to the left side
    	{
    		printWrite.write(" ");
    	}
    	printWrite.write(str);			//print the data in the middle
    	
    	for(int i=0;i<margin;i++)		//add spaces to the right side
    	{
    		printWrite.write(" ");
    	}
    	
    	printWrite.write("|");			//add a separator
    }
    
}
