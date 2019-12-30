package ver2.entities;

public class PlaceOrder {

	private Stakeholder stakeholder;
	private OrderTuple[] orderList;
	
	public PlaceOrder()	{
		
	}
	
	public PlaceOrder(Stakeholder stakeholder, OrderTuple[] orderList)	{
		this.stakeholder = stakeholder;
		this.orderList = orderList;
	}

	public Stakeholder getStakeholder() {
		return stakeholder;
	}

	public void setStakeholder(Stakeholder stakeholder) {
		this.stakeholder = stakeholder;
	}

	public OrderTuple[] getOrderList() {
		return orderList;
	}

	public void setOrderList(OrderTuple[] orderList) {
		this.orderList = orderList;
	}

	@Override
	public String toString() {
		return "PlaceOrder [ stakeholder = " + this.stakeholder + ", Order List = " + this.orderList + " ]";
	}
}
