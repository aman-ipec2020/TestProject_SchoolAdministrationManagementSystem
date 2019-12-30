package ver3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import ver3.entities.OrderTuple;
import ver3.entities.Stakeholder;
import ver3.entities.Cart;

public class MainApp {

	private static Stakeholder stationary = new Stakeholder("Aman", "Stationary Provider", "C1:00:11:6C:BB:AD:11");
	private static Stakeholder furniture = new Stakeholder("Ravi", "Furniture Provider", "A1:32:51:DC:AB:DE:21");
	
	private static Stakeholder school = new Stakeholder("Jhuma Pradhan", "School Admin", "A1:99:BB:9C:DD:ED:89");
	
		public static void main(String[] args) throws NoSuchAlgorithmException {

				schoolNetwork();
				
				stationaryNetwork();
				
//				school.displayReceiptLog();
				school.displayBlockchainBlock();
				furniture.displayBlockchainBlock();
//				furnitureNetwork();
				
		}
		
		public static void schoolNetwork()	{
				
			Stakeholder stk1 = stationary;		//	Object stationary App. is broadcast into the Blockchain Network
			Stakeholder stk2 = furniture;		//	Object furniture App. is broadcast into the Blockchain Network
			school.subscribe(stk1);
			school.subscribe(stk2);
			
			school.displaySubscribers();			
			System.out.println();
			
			//	STEP-1. [Buyer-SIDE] : Fill Cart/Order
			school.setCart(myCart2(school));
//			System.out.print("\n\n[Buyer] : Cart Prepared  -> " + school.getCart());
			
			//	STEP-2. [Buyer-SIDE] : Send cart -> Stakeholder ['stationary']
			school.sendOrder(stationary,school.getCart());

			//	STEP-6. [Buyer-SIDE] : Receipt Receive and Displayed
			school.displayReceipt();
			
			school.displayOrderLog();
			
//			school.displayReceiptLog();

		}
		
		
		public static void stationaryNetwork()	{
			
			stationary.subscribe(furniture);
			stationary.subscribe(school);
			
			System.out.print("\n");
			stationary.displaySubscribers();
			
			//	STEP-3.	[SELLER-SIDE] : Receive Cart
			stationary.receiverOrder(school.getCart());
			
			//	STEP-4.	[SELLER-Side] : Receipt Generated
			System.out.print("\n\n["+ stationary.getDesignation() +"] : Receipt Generated -> " + stationary.generateReceipt());
			
			//	STEP-5.	[SELLER-Side] : Send Receipt to Buyer
			stationary.sendReceipt(school);
//			stationary.displayBlockchainBlock();		

//			stationary.displayOrderLog();
//			stationary.displayReceiptLog();
			
			stationary.generateBlock();		
			stationary.broadcastTransaction(stationary.getBlock());
			stationary.displayBlockchainBlock();
		}

		
		
		
		
		public static void furnitureNetwork()	{
			
			furniture.subscribe(stationary);
			furniture.subscribe(school);
			
			furniture.displaySubscribers();

		}

		public static Cart myCart2(Stakeholder person)	{
		
				Cart cart = new Cart();
			String cartID = "1001";
			
			//	1. [Buyer-SIDE] : Make Order
			ArrayList<OrderTuple> orderList = new ArrayList<OrderTuple>();
				orderList.add(new OrderTuple("NUR-COUNT WITH KITTU","Book",19,240));
				orderList.add(new OrderTuple("NUR-PATTERN WRITTING","Book",12,195));
				orderList.add(new OrderTuple("BLOSSOM-0A","Book",18,315));
				orderList.add(new OrderTuple("BLOSSOM-0B","Book",15,320));
				orderList.add(new OrderTuple("BLOSSOM-0C","Book",8,330));

			cart.setOrderDateAndTime(new Date());
			cart.setBuyer(person);
			cart.setCartID(cartID);
			cart.setOrderList(orderList);
				
			return cart;
		}
		
		@SuppressWarnings("resource")
		public static Cart myCart1()	{
			
			Cart cart = new Cart();
			String cartID = new String();
			StringBuffer hexString = new StringBuffer();
			
			ArrayList<OrderTuple> orderList = new ArrayList<OrderTuple>();
			
			int ch = 0;

			try	{
				do {
						Scanner sc = new Scanner(System.in);
						OrderTuple order = new OrderTuple();
							
						System.out.print("Enter Product Name          : ");
						String productName = sc.nextLine();
						order.setProductName(productName);
							
						System.out.print("Enter Product Description   : ");
						String productDesc = sc.nextLine();
						order.setProductDescription(productDesc);
							
						System.out.print("Enter Product Quantity      : ");
						int qty = sc.nextInt();
						order.setProductQty(qty);
		
						System.out.print("Enter Product Price         : ");
						float productPrice = sc.nextFloat();
						order.setProductPrice(productPrice);
							
						cartID = cartID + productName + productDesc + qty + productPrice + productPrice;
							
						orderList.add(order);
							
						System.out.println("Want to add more...");
						System.out.println("1. Yes\n2. No");
						System.out.print("Enter Choice	: ");
						ch = sc.nextInt();
			}	while(ch == 1);

				//		Generate CartID
				MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
				messageDigest.update(cartID.getBytes());
				byte[] digest = messageDigest.digest();
				
				for(int i=0;i<digest.length;i++)
					hexString.append(Integer.toHexString(0xFF & digest[i]));
				
			}	catch(NoSuchAlgorithmException ex)	{	System.out.println("Error : " + ex);	}
							
			cart.setCartID(new String(hexString));
			cart.setOrderList(orderList);
			
			return cart;
		}
}