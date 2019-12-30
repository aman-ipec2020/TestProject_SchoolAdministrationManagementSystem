package entities;

public class SchoolAdmin {
	
	private String designation;
	private String name;
	private String digitalSignature;
/*	
	private String address;
	private String contact1;
	private String contact2;
	private String emailID;
*/	
	public SchoolAdmin()	{
		
	}
	
	public SchoolAdmin(String str1, String str2, String str3)	{
		this.designation = str1;
		this.name = str2;
		this.digitalSignature = str3;
	}
/*	
	public SchoolAdmin(String str1, String str2, String str3, String str4,
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
		return "School [ Designation = " + this.designation + ", Name = " + this.name + ", Digital Signature = " + this.digitalSignature + " ]";
	}
}