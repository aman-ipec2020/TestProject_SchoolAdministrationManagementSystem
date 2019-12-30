package ver2.entities;

import java.util.ArrayList;
import java.util.List;

import ver2.entities.OrderTuple;

public class Stakeholder {
	
	private String name;
	private String designation;
	private String digitalSignature;
	
	private List<Stakeholder> stakeholders = new ArrayList<Stakeholder>();
	private Receipt receipt = new Receipt();
	
	private PlaceOrder order = new PlaceOrder();

	
	public Stakeholder()	{
		
	}
	
	public Stakeholder(String str1, String str2, String str3)	{
		this.name = str1;
		this.designation = str2;
		this.digitalSignature = str3;
	}
	
	public String getDesignation()	{
		return this.designation;
	}
	public PlaceOrder getPlacedOrder()	{
		return this.order;
	}
	
	
	//	Stakeholder's Services
	public void placeOrder(PlaceOrder order)	{
		this.order = order;
		System.out.println("Order Owner: " + this.order.getStakeholder());
		
		System.out.print("Order List -> ");
		for(OrderTuple obj : this.order.getOrderList())
			System.out.print(obj + " -> ");
		System.out.println("END");
		
		System.out.println("*********** |MESSAGE["+ this.designation + "] : ORDER PLACED| ***********");	
	}
	
	public void acceptOrder(PlaceOrder order)	{
		this.order = order;
		
		System.out.println("Order Owner: " + this.order.getStakeholder());
		System.out.print("Order List -> ");
		for(OrderTuple obj : this.order.getOrderList())
			System.out.print(obj + " -> ");
		System.out.println("END");
		System.out.println("Order Receiver : " + this.designation);
		
		System.out.println("*********** |MESSAGE["+ this.designation + "] : ORDER ACCEPTED| ***********");
	}
	
	public Receipt sendReceipt()	{
		this.receipt = generateReceipt(this , this.order);
		System.out.println("RECEIPT : " + this.receipt);
		System.out.println("*********** |MESSAGE["+ this.designation + "] : RECEIPT SENT| ***********");
		return this.receipt;
	}
	
	public void acceptReceipt(Receipt receipt)	{
		System.out.println("*********** |MESSAGE["+ this.designation + "] : RECEIPT ACCEPTED| ***********");
		System.out.println("RECEIPT : " + receipt);
		this.receipt = receipt;
	}
	
	public Receipt generateReceipt(Stakeholder seller, PlaceOrder order)	{	
		System.out.println("*********** |MESSAGE["+ this.designation + "] : RECEIPT GENERATED| ***********");
		return new Receipt(seller, order.getStakeholder(), order.getOrderList());
	}
	
	
	
	
	
	//	Blockchain Services
	public void notifyAllEntities(Receipt receipt)	{
		for(Stakeholder obj : this.stakeholders)
			obj.update(receipt);
	}
	public void update(Receipt receipt)	{
		this.receipt = receipt;
		System.out.println("Entity : " + this.designation + " is Updated...!!");
	}
	public void subscribe(Stakeholder stakeholder)	{
		this.stakeholders.add(stakeholder);
	}
	public void unSubscribe(Stakeholder stakeholder)	{
		this.stakeholders.remove(stakeholder);
	}
	public void displayInfo()	{
		System.out.println("DESIGNATION : " + this.designation);
		System.out.println("SELLER   : " + this.receipt.getSeller());
		System.out.println("RECEIVER : " + this.receipt.getReceiver());
		System.out.print("Order List -> ");
		for(OrderTuple obj : this.receipt.getList())
			System.out.print(obj + " -> ");
		System.out.println("END");
		System.out.println("TOTAL AMOUNT : " + this.receipt.getTotalAmount());
	}
	
	
	@Override
	public String toString() {
		return "Stakeholder [ Designation = " + this.designation + ", Name = " + this.name + ", Digital Signature = " + this.digitalSignature + " ]";
	}
}