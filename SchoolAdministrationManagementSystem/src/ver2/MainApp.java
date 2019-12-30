package ver2;

import ver2.entities.OrderTuple;
import ver2.entities.PlaceOrder;
import ver2.entities.Receipt;
import ver2.entities.Stakeholder;

public class MainApp {

	public static void main(String[] args) {
		
		Stakeholder stationary = new Stakeholder("Aman", "Stationary Provider", "C1:00:11:6C:BB:AD:11");
		Stakeholder furniture = new Stakeholder("Ravi", "Furniture Provider", "A1:32:51:DC:AB:DE:21");
		
		Stakeholder school = new Stakeholder("Jhuma Pradhan", "Teacher", "A1:99:BB:9C:DD:ED:89");
			school.subscribe(stationary);
			school.subscribe(furniture);
			
			//	1. [RECEIVER-SIDE] : Make Order
			OrderTuple[] orderList = new OrderTuple[5];
				orderList[0] = new OrderTuple("NUR-COUNT WITH KITTU","Book",19,240);
				orderList[1] = new OrderTuple("NUR-PATTERN WRITTING","Book",12,195);
				orderList[2] = new OrderTuple("BLOSSOM-0A","Book",18,315);
				orderList[3] = new OrderTuple("BLOSSOM-0B","Book",15,320);
				orderList[4] = new OrderTuple("BLOSSOM-0c","Book",8,330);
				
			for(OrderTuple obj : orderList)
				System.out.println(obj);
			System.out.println("*********** |MESSAGE["+ school.getDesignation() + "] : ORDER GENERATED| ***********");
			
				System.out.println();
			
			//	2. [RECEIVER-SIDE] : Place Order
			PlaceOrder order1 = new PlaceOrder(school, orderList);
			
				System.out.println();
			
			school.placeOrder(order1);
			
				System.out.println();
			
			//	3. [SELLER-SIDE] : Accept Order
			stationary.acceptOrder(school.getPlacedOrder());
			
				System.out.println();
			
			//	4. [SELLER-SIDE] : Send Receipt
			Receipt receipt = stationary.sendReceipt();
			
				System.out.println();
			
			//	5. [RECEIVER-SIDE] : Receipt received and Display
			school.acceptReceipt(receipt);

				System.out.println();
			
			school.displayInfo();
			
				System.out.println();
			
			school.notifyAllEntities(receipt);
			
				System.out.println();
			
		school.displayInfo();
			System.out.println();
		stationary.displayInfo();
			System.out.println();
		furniture.displayInfo();
	}
}
