AlienVisitorRegistration
========================
1)What is it? A small program to display how to implement pluggability feature in java, using the inbuilt "reflection" api.

There are two compiled classes in the formatsToPrint package, remove one of them, enter your details and take a printout in the available formats. If you put the pdf.class file in the package the program automatically detects the class and shows a option to print a pdf file of your entry, if you remove the pdf.class the program will not show the print to pdf format. All this dynamically without ever changing a single line of code in the application!

2)How it is done? Read on, download understand. Yes its heavily documented.



3)How to add your own plugin formats? Lets suppose you want to print in a format called "foobar" just like "txt" and "pdf" or "doc" or whatever, follow the instructions below.

a)Simply make a class "foobar" and put it in the package "formatsToPrint".
b)Implement the interface "printFormatHelper"
c)Override the abstract method "printToFormat(Details detail)" and add your format logic here.
  where, the detail object is where the information about the registration is stored.

*The program will auto detect the format file and if your class is present there and the logic is correct it will print*

How to test this?
Simple, remove the "pdf.java" or "txt.java", the option to print in these formats will get removed without making any change in the main application code. To add these format back, put the "xxx.java" file back in the package "formatsToPrint".





 	Note: to run this project in your system, first you need the PDF API i have used in the project.
 	Download the API: http://sourceforge.net/projects/itext/files/latest/download
 	Unzip the file and get the jar file "itext-pdfa-5.5.1.jar"
 	If you are you using eclipse, copy the jar file in your project workspace, then right click on it,
   click on "add to build path", that should register the external jar file which is needed to print the pdf.
   
   
Author- Sujal Mandal
Email- ss6sujal@gmail.com 
