



import java.util.*;
class Taxibooking{
	
	public static void taxiDetails(Taxi[] taxi){
		
		System.out.println("Booking ID  CustomerID  From   To   PickupTime  DropTime   Amount");
		
			
		for(int i = 0; i<4; i++){
			
				System.out.println("Taxi number : "+(i+1)+ " at point "+taxi[i].currentpoint +" Wallet " + taxi[i].wallet);
				for(int j = 0; j<10; j++){
					try{
						System.out.println("      "+taxi[i].ride[j].bookingId+"         "+taxi[i].ride[j].customerId+"        "+taxi[i].ride[j].fromPoint+"      "+taxi[i].ride[j].toPoint+"       "+taxi[i].ride[j].pickupTime+"         "+taxi[i].ride[j].dropTime+"           "+taxi[i].ride[j].ridefare);
					}
					catch(Exception e){
						continue;
					}
				}
			
		}
		
			
		
	}
	static int bookingcount = 0;
	
	
	
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		
		
		boolean notaxiavail = true;
		Taxi[] taxi = new Taxi[4];
		taxi[0] = new Taxi(1);
		
		taxi[1] = new Taxi(2);
		taxi[2] = new Taxi(3);
		taxi[3] = new Taxi(4);
		
		
		
		
		
		System.out.println("Taxi Booking : ");
		while(true){
			System.out.println("-----MENU-----");
			System.out.println("1. Book Taxi  ");
			System.out.println("2. Display Taxi Details ");
			System.out.println("3. Exit");
			
			int choice = sc. nextInt();
			switch(choice){
				case 1:
					System.out.println("Customer ID : ");
					int customerId = sc.nextInt();
					System.out.println("PickupPoint : ");
					char pickuppoint = sc.next().charAt(0);
					System.out.println("DropPoint : ");
					char droppoint = sc.next().charAt(0);
					System.out.println("Pickup Time : ");
					int pickupTime = sc.nextInt();
					int dropTime = pickupTime+(droppoint - pickuppoint);
					for(int i = 0; i<4; i++){
						
						if(taxi[i].isAvailable(pickupTime)){
							System.out.println("Taxi " + (i+1) +" is alloted");
							taxi[i].book(++bookingcount,customerId,pickuppoint,droppoint,pickupTime,dropTime);
							break;
						}
					}
					
					break;
					
				case 2:
					taxiDetails(taxi);
					break;
				case 3:
					System.exit(0);
			}
			
		}
		
	}
}