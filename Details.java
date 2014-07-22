package alien.details;

public class Details
{
	
private String codeName,bloodColor,noOfLegs,noOfAntennas,homePlanet;	//the global variables holding attributes of the registration

/*****************below are the individual setters***********************/

public boolean setCodeName(String codeName)
{
	if(codeName.isEmpty())
		return false;
	else
	{
		this.codeName = codeName;
		return true;
	}
	
}

public boolean setBloodColor(String bloodColor)
{
	if(bloodColor.isEmpty())
		return false;
	else
	{
		this.bloodColor = bloodColor;
		return true;
	}
}

public boolean setNoOfLegs(String noOfLegs)
{
	if(noOfLegs.isEmpty())
		return false;
	else
	{
		try
		 { 
		        Integer.parseInt(noOfLegs);   //check if the user did enter a non integer value
		 }
		 catch(NumberFormatException e) 				//if yes, then utilize the numberFormatException to return false
		 { 
			 System.out.println("No of legs should be a number.");
		     return false; 
		 }
		this.noOfLegs = noOfLegs;
		return true;
	}
}

public boolean setNoOfAntennas(String noOfAntennas)
{
	if(noOfAntennas.isEmpty())
		return false;
	else
	{
		try
		 { 
		        Integer.parseInt(noOfAntennas);   //check if the user did enter a non integer value
		 }
		 catch(NumberFormatException e) 				//if yes, then utilize the numberFormatException to return false
		 { 
			 System.out.println("No of antennas should be a number.");
		        return false; 
		 }
		this.noOfAntennas = noOfAntennas;
		return true;
	}
}

public boolean setHomePlanet(String homePlanet)
{
	if(homePlanet.isEmpty())
		return false;
	else
	{
		this.homePlanet = homePlanet;
		return true;
	}
}
	

/*****************below are the individual getters***********************/
public  String getCodeName()
{
	return codeName;
}
public  String getBloodColor()
{
	return bloodColor;
}
public  String getHomePlanet()
{
	return homePlanet;
}
public String getNoOfLegs()
{
	return noOfLegs;
}
public String getNoOfAntennas()
{
	return noOfAntennas;
}}
