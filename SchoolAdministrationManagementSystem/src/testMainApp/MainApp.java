package testMainApp;

import entities.Receipt;
import entities.OrderTuple;
import entities.SchoolAdmin;
import stakeholders.FurnitureProviderApp;
import stakeholders.SchoolAdminApp;
import stakeholders.StationaryProviderApp;

public class MainApp {

	public static void main(String[] args) {
		//	test_LedgerTuple_Service();

		FurnitureProviderApp furniture = new FurnitureProviderApp();
		
		//	1. Place Order
		SchoolAdminApp school = new SchoolAdminApp();
		
		school.placeOrder();
		
		//	2. Receive Order and Display
		StationaryProviderApp stationary = new StationaryProviderApp(school.getSchoolAdmin(), school.getOrderList());
		stationary.displayOrder();
		
//			school.subscribe(stationary);
			school.subscribe(furniture);
		
		//	5. Release Receipt	
		stationary.displayRecipt();
		
		//	6. Send Receipt(Stationary Provider) and Accept(School)
		school.acceptRecipt(stationary.sendReceipt());
		
		//	3. Make Payment
		school.makePayment();
		
		//	4. Receive Payment
		stationary.getPayment(school.getOrderAmount());
		
			school.notifyAllEntities();
			
		stationary.displayInfo();
//		furniture.displayInfo();
	}
	
	
	
	
	
	public static void test_LedgerTuple_Service()	{
		OrderTuple tuple1 = new OrderTuple("NUR-COUNT WITH KITTU","",19,240);
		OrderTuple tuple2 = new OrderTuple("NUR-PATTERN WRITTING","",12,195);
		OrderTuple tuple3 = new OrderTuple("BLOSSOM-0A","",18,315);
		OrderTuple tuple4 = new OrderTuple("BLOSSOM-0B","",15,320);
		OrderTuple tuple5 = new OrderTuple("BLOSSOM-0c","",8,330);
		
		OrderTuple[] orderList = new OrderTuple[5];
		orderList[0] = tuple1;
		orderList[1] = tuple2;
		orderList[2] = tuple3;
		orderList[3] = tuple4;
		orderList[4] = tuple5;
		
		for(int i=0;i<orderList.length;i++)
			System.out.println(orderList[i]);
			
		Receipt order = new Receipt();	
		System.out.println("Total Amount : " + order.calculateTotalAmount(orderList));
	}
}