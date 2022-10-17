import java.util.*;




class Rides{
	
	int bookingId;
	int customerId;
	char fromPoint;
	char toPoint;
	int pickupTime;
	int dropTime;
	int ridefare;
	
	Rides(int bookingId,int customerId,char fromPoint,char toPoint,int pickupTime,int dropTime, int ridefare){
		this.bookingId = bookingId;
		this.customerId = customerId;
		this.fromPoint = fromPoint;
		this.toPoint = toPoint;
		this.pickupTime = pickupTime;
		this.dropTime = dropTime;
		this.ridefare = ridefare;
	}
	
		
}
