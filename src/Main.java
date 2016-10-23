
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedReader br = null;
		List<List<Transaction>> transactions = new ArrayList<List<Transaction>>();
		
		//add monday
		transactions.add(new ArrayList<Transaction>());
		transactions.add(new ArrayList<Transaction>());
		transactions.add(new ArrayList<Transaction>());
		transactions.add(new ArrayList<Transaction>());
		transactions.add(new ArrayList<Transaction>());
		transactions.add(new ArrayList<Transaction>());
		transactions.add(new ArrayList<Transaction>());
		
		
		//System.out.println("transNum" + transactions.size());
		
		try {

            br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {

                System.out.println("Make a choice Tracy! : ");
                System.out.println("1 - Create a transaction");
                System.out.println("2 - Update a transaction");
                System.out.println("3 - Delete a transaction");
                System.out.println("4 - Show all transactions");
                System.out.println("5 - Export all transactions");
                System.out.println("q - Quit");
                String input = br.readLine();
                
                TransactionLab lab = new TransactionLab();
               
                if(input.equals("1"))
                {
                	lab.createTransaction(transactions);
                }
                else if(input.equals("2"))
                {
                	lab.updateTransaction(transactions);
                }
                else if(input.equals("3"))
                {
                	lab.removeTransaction(transactions);
                }
                else if(input.equals("4"))
                {
                	lab.showTrans(transactions);
                }
                else if(input.equals("5"))
                {
                	lab.writeTransToJson(transactions);
                }
                else if (input.equals("q")) {
                    System.out.println("Exit!");
                    System.exit(0);
                }
                else
                {
                	System.out.println("Enter a valid command!");
                }

               System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

	}

}
