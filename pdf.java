package formatsToPrint;

import java.io.FileOutputStream;

import alien.details.Details;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import formatHelper.*;

/**********************************This class uses a API to write PDF files********************************
*********************************visit http://sourceforge.net/projects/itext/*****************************/
public class pdf implements printFormatHelper
{
  private static Document document;
  private static PdfPCell cell; 				//Global declarations here
  private static String file =null; 
  private static Font bigFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD);	//bigFont defined here
 
  
  public void printToFormat(Details detail)
  {
	  try
	    {
		  file="c:/"+detail.getCodeName()+".pdf";
	      document = new Document();	//create a new document object
	      PdfWriter.getInstance(document, new FileOutputStream(file));
	      document.open();		        //open the document
	      addMetaData(document);        // add all metadata to the pdf file.
	      addContents(document, detail);// add the registration page
	      document.close();	         	//close the document after writing
	      System.out.println("The details have been printed successfully :-) !");
	      System.out.println("\nFind the file in your \"C:/\" drive, Thank you!");	//tell the location of the file
	    } 
	  
	  	catch (Exception e) 
	    {
	  	  System.out.println("Some errors occured :( ,is the pdf being used by other application ?!");
	     // e.printStackTrace();
	    }
  }
  
  /*************************helper methods below************************************/
  
  private static void addMetaData(Document document)   //Add metadata to the pdf file to be written
  {
    document.addTitle("Alien Registration");
    document.addSubject("Multunus Test");
    document.addKeywords("Java, PDF, iText,Multunus");
    document.addAuthor("Sujal Mandal");
  }

  private static void addContents(Document document,Details alienDetail) throws DocumentException 
  {
    Paragraph myParagraph = new Paragraph(); 	//create a paragraph object
    addEmptyLine(myParagraph, 1); 				//add one empty line
    myParagraph.add(new Paragraph("Alien Registration Details.", bigFont));    // add the header to the paragraph
    addEmptyLine(myParagraph, 1);				//add one empty line 
    document.add(myParagraph);					// write the paragraph
    createTable(document,alienDetail);			    //create the detail tables
  }

  private static void createTable(Document doc,Details alienDetail) throws BadElementException 
  {
    PdfPTable table = new PdfPTable(5); 	//create a new table object with 5 fields 
    
    /*****************Add the table headers**********************/
    addTableCell(table, "Code Name");
    addTableCell(table, "Blood Color");
    addTableCell(table, "No. of Antennas"); //set the cells representing the header one by one
    addTableCell(table, "No. of Legs");
    addTableCell(table, "Home Planet");
    table.setHeaderRows(1);					//finally set the Above cells as header cells
       
    /*****************Add the values to the fields while fetching data from the details class**********************/
    addTableCell(table, alienDetail.getCodeName());		
    addTableCell(table, alienDetail.getBloodColor());
    addTableCell(table, alienDetail.getNoOfAntennas());
    addTableCell(table, alienDetail.getNoOfLegs());
    addTableCell(table, alienDetail.getHomePlanet());
   
    try
	{
		doc.add(table);	// add the table to the document finally 
	}
	catch (DocumentException e)  //check if the document is not being used by some other application
	{
		e.printStackTrace();
	}
  }

  private static void addTableCell(PdfPTable table,String content )  ///method to write cells to the table
  {
	  cell = new PdfPCell(new Phrase(content));					//cell object
	  cell.setHorizontalAlignment(Element.ALIGN_CENTER);		//alignment options
	  table.addCell(cell);										//add the cell to the table
  }
  
  private static void addEmptyLine(Paragraph paragraph, int number) 
  {
    for (int i = 0; i < number; i++) 
    {
      paragraph.add(new Paragraph(" ")); // add blank paragraphs to create a newline
    }
  }
} 
