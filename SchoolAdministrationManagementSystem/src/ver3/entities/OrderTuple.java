package ver3.entities;

public class OrderTuple {
	
	private String productName;
	private String productDescription;
	private int productQty;
	private float productPrice;


	/******************| Constructor |*********************/
	public OrderTuple()	{
		
	}	
	public OrderTuple(String str1, String str2, int a1, float a2)	{
		this.productName 		= str1;
		this.productDescription = str2;
		this.productQty 		= a1;
		this.productPrice 		= a2;
	}

	
	/******************| Service-1 : Set/Get Product Name |*********************/
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}


	/******************| Service-2 : Set/Get Product Description |*********************/
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	/******************| Service-3 : Set/Get Product Quantity |*********************/
	public int getProductQty() {
		return productQty;
	}
	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}

	/******************| Service-4 : Set/Get Product Price |*********************/
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	
	
	@Override
	public String toString() {
		return "OrderTuple [ Product Name = " + getProductName() + ", Product Description = "	+ getProductDescription() 
			+ ", Product Qty =" + getProductQty() + ", Product Price = " + getProductPrice() + " ]";
	}
}