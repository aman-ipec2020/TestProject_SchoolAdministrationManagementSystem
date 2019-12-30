package entities;

import java.util.ArrayList;
import java.util.List;

public class Stakeholder {
	
	private String designation = "stationary provider";
	private String name = "*******";
	private String digitalSignature = "*******";
	
	private List<Stakeholder> stakeholder = new ArrayList<Stakeholder>();
	private Receipt receipt = new Receipt();
	
	public Stakeholder()	{
		
	}
	
	public Stakeholder(String str1, String str2, String str3)	{
		this.designation = str1;
		this.name = str2;
		this.digitalSignature = str3;
	}
	
/*	
	String address = "*******";
	String contact1 = "0123456789";
	String contact2 = "0123456789";
	String emailID = "xyz@abc.com";
	
	public Stakeholder(String str1, String str2, String str3, String str4,
						String str5, String str6, String str7)	{
		
		this.name = str2;
		this.designation = str1;
		this.address = str4;
		this.contact1 = str5;
		this.contact2 = str6;
		this.emailID = str7;
		this.digitalSignature = str3;
	}
*/	
	
	
	@Override
	public String toString() {
		return "Stakeholder [ Designation = " + this.designation + ", Name = " + this.name + ", Digital Signature = " + this.digitalSignature + " ]";
	}
}