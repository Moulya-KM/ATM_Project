import java.util.*;
import java.lang.*;

class Atm{
	static HashMap<String,String> hp=new HashMap<String,String>();
	String name;
	int age;
	String address;
	long phno;
	static int key=1;
	long balance=150;
	
	int Check(String usernm,String password)
	{
		if(hp.get(usernm).equals(password))
		{
			
			return 1;
			
		}
		else {
			
			return 0;
		}
	}
	
	void Create()
	{
		String password;
		System.out.println("Plz enter the your name");
		Scanner sc=new Scanner(System.in);
		this.name=sc.next();
		

		System.out.println("Plz enter the your address");
		this.address=sc.next();
		sc.nextLine();
		System.out.println("Enter the password");
		password=sc.next();
		
		System.out.println("Plz enter the your age");
		this.age=sc.nextInt();
		System.out.println("Plz enter your phone number");
		this.phno=sc.nextLong();
		
		String usernm=name;
		
		hp.put(usernm, password);
		
		System.out.println("Account created successfully");
	}
	
	void deposit(String usernm,String password,long amount)
	{
		if(Check(usernm,password)==1)
		{
			this.balance=balance+amount;
			System.out.println(amount+" "+"deposited Successfully!");
		}
		else {
			System.out.println("Password or Username is incorrect");
		}
		
	}
	
	void Withdraw(String usernm,String password,long amount)
	{
		if(Check(usernm,password)==1)
		{
			if(amount>balance)
			{
				System.out.println("Sorry your account balance is low");
			}
			else {
				this.balance=balance-amount;
				System.out.println("Balance updated Successfully");
			}
		}
		else {
			System.out.println("Password or username is incorrect");
		}
		
	}
	
	void checkBalance(String usernm,String password)
	{
		if(Check(usernm,password)==1) {
			System.out.println(balance);
		}
		else {
			System.out.println("Password or username is incorrect");
		}
		
	}
}

public class Main {
	static String usernm="";
	static String password="";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Atm a=new Atm();
		Scanner sc=new Scanner(System.in);
		//int ch=sc.nextInt();
		System.out.println("Welocme to Bank of Baroda");
		while(true) {
		
		
		System.out.println("Do you want to create an new accouunt or an exiting user");
		System.out.println("Type 'Y' to create an new acoount or N");
		char c = sc.next().charAt(0); 
		if(c=='Y')
		{
			a.Create();
		}
		else {
			System.out.println("Enter the username and password");
			usernm=sc.next();
			password=sc.next();
			if(a.Check(usernm,password)==0)
			{
				System.out.println("Your username or password is incorect..plz try again");
			}else {
			    while(true){
			System.out.println("Please press");
			System.out.println("1:Check Balance");
			System.out.println("2:Deposit amount");
			System.out.println("3:Withdral");
			System.out.println("4:Exit");
			
			System.out.println("Enter your choice");
			int ch=sc.nextInt();
			
			switch(ch)
			{
			case 1:a.checkBalance(usernm, password);
				break;
			case 2:System.out.println("Enter the amount to be deposited");
				a.deposit(usernm, password, sc.nextLong());
				break;
				
			case 3:System.out.println("Enter the amount to be Withdrwan");
					a.Withdraw(usernm, password, sc.nextLong());
					break;
			case 4:System.out.println("Thanking you for visiting...Have a nice day");
					return ;
					
					
			}
			
				
			}
			
			}
			
		}
		
		}
	}


}