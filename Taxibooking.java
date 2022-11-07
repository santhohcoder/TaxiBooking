import java.util.*;
class TaxiBooking
{
	static Scanner s=new Scanner(System.in);
	public static void main(String[]args)
	{
		Taxi taxi[]=new Taxi[4];
		taxi[0]=new Taxi();
		taxi[1]=new Taxi();
		taxi[2]=new Taxi();
		taxi[3]=new Taxi();
		int total_Taxi=4;
		Book book[]=new Book[10];
		boolean res=true;
		do{
			System.out.println("\nWelcome To Taxi Booking Site");
			System.out.println("****************************");
			System.out.println("\nPlease Enter anyone option in below");
			System.out.println("\n1. Book Taxi\n2. Taxi-Trip Details\n3.Taxi Fare\n4.Exit");
			System.out.println("****************************");
			int option=s.nextInt();
			switch(option){
				case 1:
				{
					System.out.println("Your Booking is"+addToBook(book,taxi,total_Taxi));
					break;
				}
				case 2:
				{
					System.out.println("Booking Id  CustomerId  TaxiNo  PickupPoint  DropPoint  PickupTime  DropTime  Earnings     TaxiTotalAmount");
					System.out.println("-----------------------------------------------------------------------------------------------------------");
					for(int i=0;i<total_Taxi;i++)
					{
						for(int j=0;j<book_id;j++)
						{
							if(book[j].taxi_no==i)
							{
								System.out.println((j+1)+"            "+(book[j].cust_id)+"          "+((book[j].taxi_no)+1)+"           "+(book[j].pickup_point)+"           "+(book[j].drop_point)+"           "+(book[j].pickup_time)+"           "+(book[j].drop_time)+"           "+(book[j].travel_amount));
							}	
						}
					}	
					break;
				}
				case 3:
				{
					System.out.println("Taxi Total Amount");
					System.out.println("-----------------");
					for(int i=0;i<total_Taxi;i++)
						System.out.println((i+1)+" "+(taxi[i].taxi_earnings));
					break; 
				}
				case 4:
				{
					System.out.println("Thank you for Visiting...Visit Again!");
					res=false;
					break;
				}
				default:{
					System.out.println("Your input is Wrong. Please Enter Correct Input");
				}
			}
		}while(res);
		
	}
	
	
	static int cust_id=1;
	static int book_id=0;
	
	
	public static String addToBook(Book book[],Taxi taxi[],int total_Taxi)
	{
		char pickup_point,drop_point;
		int pickup_time=0,check;
		System.out.println("\nEnter PickUp and Drop Point A To F");
		System.out.println("Customer ID: "+(cust_id++));
		System.out.println("Enter Pickup Point");
		pickup_point=s.next().charAt(0);
		System.out.println("Enter Drop Point");
		drop_point=s.next().charAt(0);
		System.out.println("Enter Pickup Timing");
		pickup_time=s.nextInt();
		book[book_id]=new Book(cust_id,pickup_point,drop_point,pickup_time);
		check=book[book_id].bookTaxi(taxi,total_Taxi);
		if(check!=-1)
		{
			book[book_id].dropTime();
			calcEarning(book,book_id,taxi,check,book[book_id].pickup_point,book[book_id].drop_point);
			book_id++;
			return(" Succesfull with Taxi No: "+(check+1));
		}
		else
			return("Not Succesfull...No Taxi is Free for Your Pickup Time\nPlease Try Again with change of Pickup Time");
	}
	
	public static void calcEarning(Book[] book,int book_id,Taxi[] taxi,int taxi_no,int pickup_point,int drop_point)
	{
		int earning;
		earning=((((Math.abs(drop_point-pickup_point)*15)-5)*10)+100);
		book[book_id].travel_amount=earning;
		taxi[taxi_no].taxi_earnings+=earning;
	}
}
