import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class TransactionLab {
	
	final int SUNDAY = 0;
	final int MONDAY = 1;
	final int TUESDAY = 2;
	final int WEDNESDAY = 3;
	final int THURSDAY = 4;
	final int FRIDAY = 5;
	final int SATURDAY = 6;
	
	
	
	public void createTransaction(List<List<Transaction>> transaction)
	{
		
		BufferedReader br = null;
		Transaction trans = new Transaction();
		
		
		try {

            br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {

                System.out.println("Enter a day, 0 for Sunday, 1 for Monday, 2 for Tuesday, etc... : ");
                trans.setDay( br.readLine() );
                
                System.out.println("Enter the time in 24 hour format : ");
                trans.setTime( br.readLine() );
                
                System.out.println("Enter the type of transaction, 1 for Expense, 2 for Revenue : ");
                trans.setTransType( br.readLine() );
                
                System.out.println("Enter the description of the transaction : ");
                trans.setDescr( br.readLine() );
                
                System.out.println("Enter the amount of the transaction : ");
                trans.setAmount( Double.parseDouble(br.readLine()) );
                
                int transactionSize = transaction.get(Integer.parseInt(trans.getDay())).size();
                int insertIndex;
                if(transactionSize == 0)
                {
                	insertIndex = 0;
                }
                else
                {
                	insertIndex = transactionSize;
                }
                trans.setId(String.valueOf(insertIndex));
                
                
                transaction.get(Integer.parseInt(trans.getDay())).add(insertIndex, trans);;
                
                System.out.println("Transaction added");
                
                break;
                
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	public void updateTransaction(List<List<Transaction>> transaction)
	{
		BufferedReader br = null;
		Transaction trans = new Transaction();
		
		List<Transaction> updateTransaction = null;
		
		
		try {

            br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {

                System.out.println("Enter a day, 0 for Sunday, 1 for Monday, 2 for Tuesday, etc... : ");
                int getDay = Integer.parseInt(br.readLine());
                
                updateTransaction = transaction.get(getDay);
                for(int i = 0; i < updateTransaction.size(); i++)
                {
                	System.out.println("TransId:" + updateTransaction.get(i).getId());
                	System.out.println("Amount:" + updateTransaction.get(i).getAmount());
                	System.out.println("Time:" + updateTransaction.get(i).getTime());
                	System.out.println("TransType:" + getTransTypeName(Integer.parseInt(updateTransaction.get(i).getTransType())));
                	System.out.println("Description:" + updateTransaction.get(i).getDescr());
                	System.out.println("");
                }
                
                System.out.println("Enter the transaction id you want to update: ");
                int transactionId = Integer.parseInt(br.readLine());
                
                trans = updateTransaction.get(transactionId);
                
                
                
                System.out.println("Enter the time in 24 hour format : ");
                trans.setTime( br.readLine() );
                
                System.out.println("Enter the type of transaction, 1 for Expense, 2 for Revenue : ");
                trans.setTransType( br.readLine() );
                
                System.out.println("Enter the description of the transaction : ");
                trans.setDescr( br.readLine() );
                
                System.out.println("Enter the amount of the transaction : ");
                trans.setAmount( Double.parseDouble(br.readLine()) );
                
                transaction.get(getDay).set(Integer.parseInt(trans.getId()), trans);;
                
                System.out.println("Transaction updated!");
                
                
                break;
                
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void removeTransaction(List<List<Transaction>> transaction)
	{
		BufferedReader br = null;
		Transaction trans = new Transaction();
		List<Transaction> deleteTransaction = null;
		
		
		try {

            br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {

            	System.out.println("Enter a day, 0 for Sunday, 1 for Monday, 2 for Tuesday, etc... : ");
                int getDay = Integer.parseInt(br.readLine());
                
                deleteTransaction = transaction.get(getDay);
                for(int i = 0; i < deleteTransaction.size(); i++)
                {
                	System.out.println("TransId:" + deleteTransaction.get(i).getId());
                	System.out.println("Amount:" + deleteTransaction.get(i).getAmount());
                	System.out.println("Time:" + deleteTransaction.get(i).getTime());
                	System.out.println("TransType:" + getTransTypeName(Integer.parseInt(deleteTransaction.get(i).getTransType())));
                	System.out.println("Description:" + deleteTransaction.get(i).getDescr());
                	System.out.println("");
                }
                
                System.out.println("Enter the transaction id you want to delete: ");
                int transactionId = Integer.parseInt(br.readLine());
                
                trans = deleteTransaction.get(transactionId);
                
                transaction.get(getDay).remove(Integer.parseInt(trans.getId()));
                
                System.out.println("Transaction removed!");
                
                break;
                
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
	public void showTrans(List<List<Transaction>> transaction)
	{
		for(int i = 0; i < 7; i++)
		{
			int daySize = transaction.get(i).size();
			if(daySize > 0)
			{
			    List<Transaction> dayTransaction = transaction.get(i);
			    int transSize = dayTransaction.size();
			    if(transSize > 0)
			    {
		    	    for(int j = 0;j < dayTransaction.size(); j++)
		    	    {
				        System.out.println("TransId:" + dayTransaction.get(j).getId());
				        System.out.println("Day:" + getDayName(Integer.parseInt(dayTransaction.get(j).getDay())));
                    	System.out.println("Amount:" + dayTransaction.get(j).getAmount());
                    	System.out.println("Time:" + dayTransaction.get(j).getTime());
                    	System.out.println("TransType:" + getTransTypeName(Integer.parseInt(dayTransaction.get(j).getTransType())));
                    	System.out.println("Description:" + dayTransaction.get(j).getDescr());
                    	System.out.println("");
			        }
			    }
			}
		}
	}
	
	private String getTransTypeName(int transType)
	{
		String transTypeName = "";
		if(transType == 1)
		{
			transTypeName = "Expense";
		}
		else
		{
			transTypeName = "Revenue";
		}
		
		return transTypeName;
	}
	
	private String getDayName(int day)
	{
		String dayName = "";
		
		if(day == SUNDAY)
		{
			dayName = "Sunday";
		}
		else if(day == MONDAY)
		{
			dayName = "Monday";
		}
		else if(day == TUESDAY)
		{
			dayName = "Tuesday";
		}
		else if(day == WEDNESDAY)
		{
			dayName = "Wednesday";
		}
		else if(day == THURSDAY)
		{
			dayName = "Thursday";
		}
		else if(day == FRIDAY)
		{
			dayName = "Friday";
		}
		else if(day == SATURDAY)
		{
			dayName = "Saturday";
		}
		
		
		
		
		
		return dayName;
	}
	
	public void writeTransToJson(List<List<Transaction>> transaction)
	{
		try {

			File file = new File("./transactions.json");
			String json = "";
			

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(int i = 0; i < 7; i++)
			{
				int daySize = transaction.get(i).size();
				if(daySize > 0)
				{
				    List<Transaction> dayTransaction = transaction.get(i);
				    int transSize = dayTransaction.size();
				    if(transSize > 0)
				    {
			    	    for(int j = 0;j < dayTransaction.size(); j++)
			    	    {
			    	    	bw.write(("{\"transId\":" + '"' + dayTransaction.get(j).getId()) + '"');
			    	    	bw.write((",\"day\":" + '"' + getDayName(Integer.parseInt(dayTransaction.get(j).getDay()))) + '"');
			    	    	bw.write(",\"amount\":" + dayTransaction.get(j).getAmount());
			    	    	bw.write(",\"time\":" + '"' +  dayTransaction.get(j).getTime() + '"');
			    	    	bw.write(",\"transType\":" + '"' + getTransTypeName(Integer.parseInt(dayTransaction.get(j).getTransType())) + '"');
			    	    	bw.write(",\"description\":" + '"' +  dayTransaction.get(j).getDescr() + '"' + "},");
				        }
				    }
				}
			}
			
			
			
			
			bw.close();

			System.out.println("File successfully exported!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
