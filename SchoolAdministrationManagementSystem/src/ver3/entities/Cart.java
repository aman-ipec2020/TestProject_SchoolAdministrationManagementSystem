package ver3.entities;

import java.util.ArrayList;
import java.util.Date;

import ver3.entities.OrderTuple;

public class Cart {

		private String cartID;
		private Stakeholder Buyer;
		private ArrayList<OrderTuple> orderList = new ArrayList<OrderTuple>();
		private float totalAmount = 0;
		private int totalQuantity = 0;
		private Date dateAndTime;
		
		
		/******************| Constructors |*********************/
		public Cart()	{
			
		}
		public Cart(String str, Stakeholder obj, ArrayList<OrderTuple> list)	{
			this.cartID = str;
			this.Buyer = obj;
			this.orderList = list;
		}
		
		
		/******************| Service-1 : Set/Get Cart-ID |*********************/
		public void setCartID(String str1)	{
			this.cartID = str1;
		}
		public String getCartID()	{
			return this.cartID;
		}

		/******************| Service-2 : Set/Get Buyer Info. |*********************/
		public void setBuyer(Stakeholder buyer) {
			this.Buyer = buyer;
		}
		public Stakeholder getBuyer() {
			return this.Buyer;
		}
		
		/******************| Service-3 : Retrieve Total Quantity |*********************/
		public int getTotalQuantity()	{
			return this.totalQuantity;
		}
		/******************| Service-5 : Calculate Total Quantity Amount |*********************/
		public int calculateTotalQuantity()	{
			int qty = 0;
			for(OrderTuple obj:orderList)
				qty = qty + obj.getProductQty();
			this.totalQuantity = qty;
			
			return this.totalQuantity;
		}
		
		/******************| Service-4 : Retrieve Total Amount |*********************/		
		public float getTotalAmount()	{
			return this.totalQuantity;
		}
		/******************| Service-6 : Calculate Total Cart Amount |*********************/
		public float calculateTotalAmount()	{
			float amt = 0;
			for(OrderTuple obj:orderList)
				amt = amt + (obj.getProductQty() * obj.getProductPrice());
			this.totalAmount = amt;
			
			return this.totalAmount;
		}
		
		/******************| Service-5 : Set/Get Order List |*********************/
		public ArrayList<OrderTuple> getOrderList() {
			return orderList;
		}
		public void setOrderList(ArrayList<OrderTuple> orderList) {
			this.orderList = orderList;
		}
		
		/******************| Service-6 : Set/Get Order Date And Time |*********************/
		public Date getOrderDateAndTime() {
			return dateAndTime;
		}
		public void setOrderDateAndTime(Date dateAndTime) {
			this.dateAndTime = dateAndTime;
		}



		@Override
		public String toString() {
			return "Cart [ Date_&_Time = " + getOrderDateAndTime() + ", Cart-ID = " + getCartID() + ", Order List = " + this.orderList + ", Total Quantity = " + calculateTotalQuantity() + ", Total Amount = " + calculateTotalAmount() + " ]";
		}
}