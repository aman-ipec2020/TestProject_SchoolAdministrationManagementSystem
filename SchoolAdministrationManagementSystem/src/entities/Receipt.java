package entities;

public class Receipt {
/*
	String ownerName;
	String ownerAddress;
	String ownerSignature;
	String address = "*******";
	String contact1 = "0123456789";
	String contact2 = "0123456789";
	String emailID = "xyz@abc.com";
	
	LedgerTuple list;
	
	String receiverName;
	String receiverAddress;
	String receiverSignature;
	String address = "*******";
	String contact1 = "0123456789";
	String contact2 = "0123456789";
	String emailID = "xyz@abc.com";
*/
	Stakeholder seller;
	Stakeholder receiver;
	OrderTuple[] list;
	float totalAmount = 0;
	
	public Receipt()		{
		
	}
	
	public float getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Receipt(Stakeholder seller, Stakeholder receiver, OrderTuple[] list)	{
		this.seller = seller;
		this.receiver = receiver;
		this.list = list;
		this.totalAmount = calculateTotalAmount(list);
	}
	
	public float calculateTotalAmount(OrderTuple[] list)		{
		float totalAmount = 0; 
		for(OrderTuple obj : list)
			totalAmount = totalAmount + obj.getProductQty() * obj.getProductPrice();
		return totalAmount;
	}
	
	@Override
	public String toString() {
		return "RECEIPT [ Seller-info = " + this.seller + ", Receiver-info = " + this.receiver + ", Order-List = " + this.list.toString() + ", Total Amount = " + this.totalAmount +" ]";
	}
}
