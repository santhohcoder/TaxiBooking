import java.util.*;



class Taxi{
	static int ridecount = 0;
	int wallet;
	char currentpoint;
	int Id;
	int freeingTime;
	Rides[] ride = new Rides[10];
	
	
	boolean isAvailable(int pickupTime){
		if(freeingTime<=pickupTime){
			return true;
		}
		return false;
	}
	
	Taxi(int Id){
		wallet = 0;
		currentpoint = 'a';
		this.Id = Id;
		this.freeingTime = 0;
	}
	
	void book(int bookingId,int customerId,char fromPoint,char toPoint,int pickupTime,int dropTime){
		this.currentpoint = toPoint;
		this.freeingTime = dropTime;
		ride[ridecount] = new Rides(bookingId,customerId,fromPoint,toPoint,pickupTime,dropTime, calculatewallet(fromPoint,toPoint));
		ridecount++;
	}
	
	int calculatewallet(char fromPoint, char toPoint){
		int distance = Math.abs(toPoint - fromPoint)*15;
		int fare = 0;
		fare += 100;
		distance -= 5;
		fare += (distance*10);
		this.wallet += fare;
		return fare;
	}
}


