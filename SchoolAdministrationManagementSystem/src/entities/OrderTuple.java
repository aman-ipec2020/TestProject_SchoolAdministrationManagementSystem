package entities;

public class OrderTuple {

	String productName;
	String productDescription;
	int productQty;
	float productPrice;
	
	public OrderTuple()	{
		
	}
	
	public OrderTuple(String str1, String str2, int a1, float a2)	{
		this.productName = str1;
		this.productDescription  = str2;
		this.productQty = a1;
		this.productPrice = a2;
	}
	
	
	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	public int getProductQty() {
		return productQty;
	}


	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}


	public float getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "LedgerTuple [ Product Name = " + getProductName() + ", Product Description = "	+ getProductDescription() 
			+ ", Product Qty =" + getProductQty() + ", Product Price = " + getProductPrice() + " ]";
	}
/*	
	float amount;
	float taxincluded;
	float totalAmount;
	float discount;
	float payableAmount;
	
	public float amountCalculated()	{
		return this.productPrice * this.productQty;
	}
*/	
	
}
