AlienVisitorRegistration
========================

*UPDATE*

Now updated to allow plugin formats.

1)Simply make a class "foobar" and put it in the package "formatsToPrint".
2)Implement the interface "printFormatHelper"
3)Override the abstract method "printToFormat(Details detail)" and add your format logic here.
  where, the detail object is where the information about the registration is stored.

*The program will auto detect the format file and if your class is present there and the logic is correct it will print*

How to test this?
Simple, remove the "pdf.java" or "txt.java", the option to print in these formats will get removed without making any change in the main application code. To add these format back, put the "xxx.java" file back in the package "formatsToPrint".



Solution for multunus

   Author Sujal Mandal
   Email ss6sujal@gmail.com
   Solution for multunus test
 	
 	Download the API: http://sourceforge.net/projects/itext/files/latest/download
 	Unzip the file and get the jar file "itext-pdfa-5.5.1.jar"
 	If you are you using eclipse, copy the jar file in your project workspace, then right click on it,
   click on "add to build path", that should register the external jar file which is needed to print the pdf.
