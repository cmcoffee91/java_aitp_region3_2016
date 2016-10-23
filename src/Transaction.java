
public class Transaction {
	
	private String day;
	private String transactionID;
	private String transactionType;
	private String time;
	private String description;
	private double amount;
	
	public void setDay(String day)
	{
		this.day = day;
	}
	
	public String getDay()
	{
		return day;
	}
	
	
	public void setId(String id)
	{
		transactionID = id;
		
	}
	
	public String getId()
	{
		return transactionID;
	}
	
	
	public void setTransType(String transType)
	{
		transactionType = transType;
	}
	
	public String getTransType()
	{
		return transactionType;
	}
	
	public void setTime(String timeOfDay)
	{
		time = timeOfDay;
	}
	
	public String getTime()
	{
		return time;
	}

	public void setDescr(String description)
	{
		this.description = description;
	}
	
	public String getDescr()
	{
		return description;
	}
	
	public void setAmount(double amount)
	{
		this.amount = amount;
	}
	
	public double getAmount()
	{
		return amount;
	}
	
}
