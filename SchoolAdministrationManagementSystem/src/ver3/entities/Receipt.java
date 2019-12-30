package ver3.entities;

import java.util.ArrayList;
import java.util.Date;

import ver3.entities.OrderTuple;
import ver3.entities.Stakeholder;

public class Receipt {
	
	private Stakeholder seller;
	private Stakeholder buyer;
	private ArrayList<OrderTuple> list;
	private float totalAmount = 0;
	private int totalQty = 0;
	private Date DateandTime;


	/******************| Constructor |*********************/
	public Receipt()		{
		
	}
	public Receipt(Stakeholder buyer,Stakeholder seller, ArrayList<OrderTuple> list, int qty, Date dateandTime) {
		this.seller = seller;
		this.buyer = buyer;
		this.list = list;
		this.totalQty = qty;
		this.totalAmount = calculateTotalAmount();
		this.DateandTime = dateandTime;
	}


	/******************| Service-1 : Set/Get Seller Name |*********************/	
	public void setSeller(Stakeholder seller) {
		this.seller = seller;
	}
	public Stakeholder getSeller() {
		return seller;
	}

	
	/******************| Service-2 : Set/Get Buyer Name |*********************/
	public void setBuyer(Stakeholder buyer) {
		this.buyer = buyer;
	}
	public Stakeholder getBuyer() {
		return buyer;
	}
	
	
	/******************| Service-3 : Set/Get Date and Time |*********************/
	public void setDateandTime(Date t) {
		this.DateandTime = t;
	}
	public Date getDateandTime() {
		return this.DateandTime;
	}
	

	/******************| Service-4 : Set/Get Order List |*********************/
	public ArrayList<OrderTuple> getList() {
		return list;
	}
	public void setList(ArrayList<OrderTuple> list) {
		this.list = list;
	}
	
	
	/******************| Service-5 : Set/Get Total Quantity |*********************/
	public void setTotalQuantity(int totalQty) {
		this.totalQty = totalQty;
	}
	public int getTotalQuantity() {
		return this.totalQty;
	}
	
	
	/******************| Service-6 : Set/Get Total Amount |*********************/
	public void setTotalAmount() {
		this.totalAmount = calculateTotalAmount();
	}
	public float getTotalAmount() {
		return this.totalAmount;
	}
	
	
	/******************| Service-7 : Calculate Total Amount |*********************/
	public float calculateTotalAmount()		{
		float amt = 0;
		for(OrderTuple obj : this.list)
			amt = amt + (obj.getProductQty() * obj.getProductPrice());
		return amt;
	}
	
	
	
	@Override
	public String toString() {
		return "RECEIPT [ Date & Time : " +this.getDateandTime()+ ", Seller-info = " + this.seller + ", buyer-info = " + this.buyer + ", Order-List = " + this.list + ", Total Quantity = " + this.getTotalQuantity() + ", Total Amount = " + this.getTotalAmount() +" ]";
	}
}