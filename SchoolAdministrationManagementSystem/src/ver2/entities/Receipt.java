package ver2.entities;

public class Receipt {
	
	Stakeholder seller;
	Stakeholder receiver;
	OrderTuple[] list;
	float totalAmount = 0;
	
	public Receipt()		{
		
	}
	
	public Stakeholder getSeller() {
		return seller;
	}

	public void setSeller(Stakeholder seller) {
		this.seller = seller;
	}

	public Stakeholder getReceiver() {
		return receiver;
	}
	public void setReceiver(Stakeholder receiver) {
		this.receiver = receiver;
	}
	public float getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	

	public OrderTuple[] getList() {
		return list;
	}

	public void setList(OrderTuple[] list) {
		this.list = list;
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
		return "RECEIPT [ Seller-info = " + this.seller + ", Receiver-info = " + this.receiver + ", Order-List = " + this.list + ", Total Amount = " + this.totalAmount +" ]";
	}
}
