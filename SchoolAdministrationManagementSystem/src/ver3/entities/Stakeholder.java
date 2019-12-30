package ver3.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import ver3.entities.Receipt;
import ver3.entities.Stakeholder;
import ver3.entities.blockchainServices.BlockchainBlock;
import ver3.entities.blockchainServices.BlockchainData;


public class Stakeholder{
	
	private String name;
	private String designation;
	private String digitalSignature;
		
	private Map<Stakeholder,Cart> orderLog = new Hashtable<>();		//	do not maintain order of the input data
	private Set<Map.Entry<Stakeholder,Cart>> orderEntries = orderLog.entrySet();
	
	private Map<Stakeholder,Receipt> receiptLog = new Hashtable<>();		//	do not maintain order of the input data
	private Set<Map.Entry<Stakeholder,Receipt>> receiptEntries = receiptLog.entrySet();
	
	private Map<Stakeholder,BlockchainBlock> blockchainBlock = new Hashtable<>();
	private Set<Map.Entry<Stakeholder,BlockchainBlock>> blockchainBlockEntries = blockchainBlock.entrySet();
	
	private Cart cart;
	private Receipt receipt;
	private Stakeholder Buyer;
	private Stakeholder Seller;
	
	private BlockchainData blockData;
	private BlockchainBlock block;
	private List<Stakeholder> networkParticipants = new ArrayList<Stakeholder>();
	
	
	
	/******************| Constructor |*********************/
	public Stakeholder()	{
		
	}
	public Stakeholder(String str1, String str2, String str3)	{
		this.name 				= str1;
		this.designation 		= str2;
		this.digitalSignature 	= str3;
	}
	
	
	public String getDesignation()	{
		return this.designation;
	}
	
	/******************| Service-1 (Retrieve Cart/Order Details)|*********************/
	public void setCart(Cart cart)	{
		this.cart = cart;
	}
	public Cart getCart()	{
		return this.cart;
	}



	/*
	 * 		Order/Cart Transaction Services
	 */
	/******************| Service-3.1 (Make Order Log) |*********************/
	public void setOrderLog(Stakeholder stakeholder, Cart cart)	{
		System.out.println("\n\n["+this.designation+"] : Order Log Updated...!!");
		orderLog.put(stakeholder, cart);
	}
	/******************| Service-3.2 (Send Order to Participants) |*********************/
	public void sendOrder(Stakeholder stakeholder, Cart cart)	{
			setOrderLog(stakeholder, cart);
			System.out.println("\n[" + this.designation + "] : Order Send -> " + stakeholder);
			stakeholder.receiverOrder(cart);		
	}
	/******************| Service-3.3 (Receive Order)|*********************/
	public void receiverOrder(Cart cart)	{
		
		this.cart = cart;
		this.Buyer = this.cart.getBuyer();
		
		this.orderLog.put(this.Buyer, cart);
		System.out.println("\n[" + this.designation +"] : Order Received  -> " + this.cart);
	}
	/******************| Service-2 (Display Cart/Order Log) |*********************/
	public void displayOrderLog()	{
		System.out.println("\n\n\tCart/Order Log of '" + this.designation + "'");
		int i = 0;
		for(Map.Entry<Stakeholder, Cart> obj : orderEntries)
			System.out.println("Entry-" + (++i) + "[" + obj.getKey() + ", " + obj.getValue() + "]");
	}



	/*
	 * 		Receipt Transaction Services
	 */
	/******************| Service-4.1 (Generate Order's Receipt) |*********************/
	public Receipt generateReceipt()	{
		System.out.println("\n\n");
		
		this.receipt = new Receipt(this.cart.getBuyer(), this, this.cart.getOrderList(), this.cart.getTotalQuantity(), new Date());		

		System.out.println("\n["+this.designation+"] : Order's Receipt is Generated");
		return receipt;
	}
	/******************| Service-4.2 (Send Order's Receipt) |*********************/	
	public void sendReceipt(Stakeholder stakeholder)	{
		System.out.println("\n\n["+this.designation+"] : Order's Receipt is Sent -> " + this.cart.getBuyer());
		
		this.cart.getBuyer().receiverReceipt(this.receipt);
		
		this.receiptLog.put(this.Buyer, this.receipt);
	}
	/******************| Service-4.3 (Receive Order's Receipt) |*********************/
	public void receiverReceipt(Receipt receipt)	{
		
		this.receipt = receipt;
		this.Seller = receipt.getSeller();
		
		this.receiptLog.put(this.Seller,this.receipt);
		
		System.out.print("\n["+this.designation+"] : Order's Receipt is Received -> " + this.getReceipt());
	}
	/******************| Service-4.4 (Display Order's Receipt) |*********************/
	public void displayReceipt()	{
		System.out.println("\n[" + this.designation + "] : " + this.getReceipt());
	}
	public Receipt getReceipt()	{
		return this.receipt;
	}
	/******************| Service-4.4 (Display Receipt Log) |*********************/
	public void displayReceiptLog()		{
		System.out.println("\n\n\tRecipt Log of '" + this.designation + "'");
		int i = 0;
		for(Entry<Stakeholder, Receipt> obj : receiptEntries)
			System.out.println("Entry-" + (++i) + "[" + obj.getKey() + ", " + obj.getValue() + "]");
	}



	/*
	 * 		Blockchain's Services
	 */
	/******************| Service-5.1 (Generate Blockchain's Data) |*********************/
	public BlockchainData generateBlockchainData()	{
		
		System.out.println("\n["+this.designation+"] : Block Data is Generated");
		this.blockData = new BlockchainData(receipt.getTotalQuantity(), receipt.getTotalAmount(), receipt.getDateandTime());
		return this.blockData;
	}
	/******************| Service-5.2 (Generate Blockchain's Block) |*********************/
	public void generateBlock()	{
		System.out.println("\n["+this.designation+"] : Block is Generated");
		this.block = new BlockchainBlock(this, this.Buyer, generateBlockchainData(), new Date());
		System.out.println("Block ["+this.designation+"] -> " + this.block);
	}
	public BlockchainBlock getBlock()	{
		return this.block;
	}
	/******************| Service-5.3 (Display Blockchain's Block) |*********************/
	public void displayBlockchainBlock()	{
		System.out.println("\n\n\tBlockchain Block of '" + this.designation + "'");
		int i = 0;
		for(Entry<Stakeholder, BlockchainBlock> obj : blockchainBlock.entrySet())
			System.out.println("Entry-" + (++i) + " : [" + obj.getKey() + ", " + obj.getValue() + "]");
	}
	
	
	/******************| Service-5.4 (Broadcast Blockchain's Block) |*********************/
	public void broadcastTransaction(BlockchainBlock block)	{
		System.out.println("Block Broadcasted....");
		this.blockchainBlock.put(this, block);
		notifyAllEntities(this,block);
		System.out.println("Block Broadcasted....");
	}
	/******************| Service-5.5 (Notify All Blockchain's Participants) |*********************/
	public void notifyAllEntities(Stakeholder stakeolder, BlockchainBlock block)	{
		for(Stakeholder obj : this.networkParticipants)		{
			System.out.println("\n["+obj.designation+"] : BlockData is Received");
			obj.blockchainBlock.put(stakeolder, block);
			System.out.println("[" + obj.designation +"] : Updated...!!");
		}
	}
	/******************| Service-5.7 (Add Participants to the Blockchain's Network) |*********************/
	public void subscribe(Stakeholder stakeholder)	{
		this.networkParticipants.add(stakeholder);
	}
	/******************| Service-5.8 (Remove Participants to the Blockchain's Network) |*********************/
	public void unSubscribe(Stakeholder stakeholder)	{
		this.networkParticipants.remove(stakeholder);
	}
	/******************| Service-5.9 (Display all the Blockchain's Participants) |*********************/
	public void displaySubscribers()	{
		System.out.println("\tNetwork Participants of " + this.designation);
		for(Stakeholder obj : this.networkParticipants)
			System.out.println(obj);
	}
	
	
	
	@Override
	public String toString() {
		return "Stakeholder [name=" + name + ", designation=" + designation + ", digitalSignature=" + digitalSignature
				+ "]";
	}
}
