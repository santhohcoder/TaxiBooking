import java.util.*;
class Book
{
	int cust_id;
	char pickup_point;
	char drop_point;
	int pickup_time;
	int drop_time;
	int travel_amount;
	int taxi_no;
	Book(int cust_id,char pickup_point,char drop_point,int pickup_time)
	{
		this.cust_id=cust_id;
		this.pickup_point=pickup_point;
		this.drop_point=drop_point;
		this.pickup_time=pickup_time;
	}
	public void dropTime()
	{
		this.drop_time=pickup_time+(Math.abs(drop_point-pickup_point));
	}
	public int bookTaxi(Taxi taxi[],int total_taxi)
	{
		int taxi_id=0;
		int nearest_distance=6;
		for(int i=0;i<total_taxi;i++)
		{
			if(taxi[i].isTaxiFree(pickup_time))
			{
				if(Math.abs(taxi[i].current_point-pickup_point)<nearest_distance)
				{
					nearest_distance=(Math.abs(taxi[i].current_point-pickup_point));
					taxi_id=i;
				}
				if(Math.abs(taxi[i].current_point-pickup_point)==nearest_distance){
					if(taxi[i].taxi_earnings<taxi[taxi_id].taxi_earnings)
						taxi_id=i;
				}
			}
		}
		if(nearest_distance!=6)
		{
			taxi[taxi_id].freeTime(pickup_point,drop_point,pickup_time);
			taxi[taxi_id].current_point=drop_point;
			taxi_no=taxi_id;
			return taxi_no;
		}
		return -1;
	}
}

