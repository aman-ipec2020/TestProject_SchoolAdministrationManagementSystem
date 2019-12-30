package ver3.entities.blockchainServices;

import java.util.Date;

import ver3.entities.Stakeholder;

public class BlockchainBlock {

	private Stakeholder sender;
	private Stakeholder receiver;
	private BlockchainData data;
	private Date TxDateandTime;
	
	public BlockchainBlock()	{
		
	}
	public BlockchainBlock(Stakeholder sender, Stakeholder receiver, BlockchainData data, Date txDateandTime) {
		this.sender = sender;
		this.receiver = receiver;
		this.data = data;
		TxDateandTime = txDateandTime;
	}
	
	
	public Stakeholder getSender() {
		return sender;
	}
	public void setSender(Stakeholder sender) {
		this.sender = sender;
	}
	
	
	public Stakeholder getReceiver() {
		return receiver;
	}
	public void setReceiver(Stakeholder receiver) {
		this.receiver = receiver;
	}
	
	
	public BlockchainData getData() {
		return data;
	}
	public void setData(BlockchainData data) {
		this.data = data;
	}
	
	
	public Date getTxDateandTime() {
		return TxDateandTime;
	}
	public void setTxDateandTime(Date txDateandTime) {
		TxDateandTime = txDateandTime;
	}
	
	
	@Override
	public String toString() {
		return "Block [sender=" + sender + ", receiver=" + receiver + ", data=" + data + ", TxDateandTime="
				+ TxDateandTime + "]";
	}
}
