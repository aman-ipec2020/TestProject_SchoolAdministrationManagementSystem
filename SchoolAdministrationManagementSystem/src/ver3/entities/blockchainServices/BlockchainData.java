package ver3.entities.blockchainServices;

import java.util.Date;

public class BlockchainData {

	private int totalQuantity;
	private float totalAmount;
	private Date DateandTime;
	
	public BlockchainData()	{
		
	}
	public BlockchainData(int totalQuantity, float totalAmount, Date DateandTime) {
		this.totalQuantity = totalQuantity;
		this.totalAmount = totalAmount;
		this.DateandTime = DateandTime;
	}
	
	
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	
	
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
	public Date getDateandTime() {
		return this.DateandTime;
	}
	public void setDateandTime(Date DateandTime) {
		this.DateandTime = DateandTime;
	}
	
	
	@Override
	public String toString() {
		return "Data [ Total_Qty = " + this.totalQuantity + ", Total_Amount=" + this.totalAmount + ", Date_&_Time" + this.DateandTime + " ]";
	}	
}