package stakeholders;

import entities.Receipt;

import java.util.ArrayList;
import java.util.List;

import entities.OrderTuple;
import entities.SchoolAdmin;
import entities.Stakeholder;

public class StationaryProviderApp{

	private Stakeholder stationary = new Stakeholder("Stationary Provider", "Aman","C1:00:11:6C:BB:AD:11");
	private float stationaryReservoir = 100000;
	private Receipt order = new Receipt();
	private OrderTuple[] list = new OrderTuple[5];
	
	private List<Stakeholder> stakeholder = new ArrayList<Stakeholder>();
	
	private float orderAmount = 0;
	
	private Stakeholder school = new Stakeholder();

	public StationaryProviderApp()	{
		
	}
	
	public StationaryProviderApp(Stakeholder obj, OrderTuple[] list)	{
		this.school = obj;
		this.list = list;
	}
	
	/*
	 *		Stationary Services - 1 (Display Order) 
	 */
	public void displayOrder()	{
		
		System.out.println(this.school);
		for(OrderTuple obj : this.list)
			System.out.println(obj.toString());	
		
		System.out.println("*********** |MESSAGE[Stationary Provider]   : ORDER ACCEPTED| ***********");
	}
	
	/*
	 *		Stationary Services - 2 (Display Receipt) 
	 */
	public void displayRecipt()	{
		
		Receipt orderReceipt = new Receipt(new Stakeholder(), school, list);
		System.out.println(orderReceipt);
		this.order = orderReceipt;
	}
	
	/*
	 *		Stationary Services - 3 (Send Receipt) 
	 */
	public Receipt sendReceipt()	{
		System.out.println("*********** |MESSAGE[Stationary Provider]   : RECEIPT SENT| ***********");
		return this.order;
	}
	
	/*
	 *		Stationary Services - 4 (Get Payment and Update Reservoir) 
	 */
	public void getPayment(float payment)	{
		this.stationaryReservoir = this.stationaryReservoir + payment;
		System.out.println("*********** |MESSAGE[Stationary Provider]   : PAYMENT RECEIVED| ***********");
		System.out.println("Stationary Reservior : " + this.stationaryReservoir);
	}
	
	
	public float getReservior()	{
		return this.stationaryReservoir;
	}
	
	
	
	
	
	
	/*
	 *		Blockchain Services  
	 */
	/*
	 *		Blockchain Services  
	 */
	public void notifyAllEntities()	{
//		for(Stakeholder obj : this.stakeholder)
//			obj.update();
	}
	
	public void update()	{
		System.out.println("Receipt is Updated...!!");
	}
	
	public void subscribe(Stakeholder stakeholder)	{
		this.stakeholder.add(stakeholder);
	}
	
	public void unSubscribe(Stakeholder stakeholder)	{
		this.stakeholder.remove(stakeholder);
	}
	
	public void displayInfo()	{
		System.out.print(this.order);
	}
}
