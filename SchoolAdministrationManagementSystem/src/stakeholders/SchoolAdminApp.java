package stakeholders;

import java.util.ArrayList;
import java.util.List;

import entities.OrderTuple;
import entities.Receipt;
import entities.Stakeholder;

public class SchoolAdminApp {
	
	private Stakeholder schoolAdmin = new Stakeholder("Teacher","Jhuma Pradhan","A1:99:BB:9C:DD:ED:89");
	private List<Stakeholder> stakeholder = new ArrayList<Stakeholder>();
	private float SchoolReservoir = 100000;
	
	private OrderTuple[] orderList = new OrderTuple[5];
	private float orderAmount = 0;
	
	private Receipt receipt = new Receipt();

	//	Setter Getter for Entity - SchoolAdmin
	public Stakeholder getSchoolAdmin() {
		return schoolAdmin;
	}
	public void setSchoolAdmin(Stakeholder schoolAdmin) {
		this.schoolAdmin = schoolAdmin;
	}
	
	//	Setter Getter for Entity - OrderTuple
	public void setReservior(float amount)	{
		this.SchoolReservoir = this.SchoolReservoir + amount;
	}
	public float getReservior()	{
		return this.SchoolReservoir;
	}
	
	//	Setter Getter for Entity - OrderTuple
	public OrderTuple[] getOrderList() {
		return orderList;
	}
	public void setOrderList(OrderTuple[] orderList) {
		this.orderList = orderList;
	}
	
	//	Setter Getter for Entity - OrderAmount
	public void setOrderAmount(float amount)	{
		this.orderAmount = this.orderAmount + amount;
	}
	public float getOrderAmount()	{
		return this.orderAmount;
	}


	
	/*
	 *		School Services - 1 (Placed Order)  
	 */
	public void placeOrder()	{
		
		System.out.println(schoolAdmin);
		orderList[0] = new OrderTuple("NUR-COUNT WITH KITTU","",19,240);
		orderList[1] = new OrderTuple("NUR-PATTERN WRITTING","",12,195);
		orderList[2] = new OrderTuple("BLOSSOM-0A","",18,315);
		orderList[3] = new OrderTuple("BLOSSOM-0B","",15,320);
		orderList[4] = new OrderTuple("BLOSSOM-0c","",8,330);
		
		System.out.println("*********** |MESSAGE[School Administration] : ORDER PLACED| ***********");
	}
	
	/*
	 *		School Services - 2 (Accept Receipt)  
	 */
	public void acceptRecipt(Receipt receipt)	{
		
		this.receipt = receipt;
		System.out.println(this.receipt);
		this.orderAmount = this.receipt.getTotalAmount();
		
		System.out.println("*********** |MESSAGE[School Administration] : RECEIPT RECEIVED| ***********");
	}
	
	/*
	 *		School Service - 3 (Make Payment)
	 */
	public void makePayment()	{
		this.SchoolReservoir = this.SchoolReservoir - this.orderAmount;
		System.out.println("*********** |MESSAGE[School Administration] : PAYMENT DONE| ***********");
		System.out.println("School Reservior     : " + this.SchoolReservoir);
	}
	
	
	
	
	
	

	/*
	 *		Blockchain Services  
	 */
	public void notifyAllEntities()	{
//		for(Stakeholder obj : this.stakeholder)
//			obj.update(this.receipt);
	}
	
	public void update(Receipt receipt)	{
		System.out.println("Receipt is Updated...!!");
	}
	
	public void subscribe(Stakeholder stakeholder)	{
		this.stakeholder.add(stakeholder);
	}
	
	public void unSubscribe(Stakeholder stakeholder)	{
		this.stakeholder.remove(stakeholder);
	}
	
	public void displayInfo()	{
		System.out.print(this.receipt);
	}
}
