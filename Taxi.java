import java.util.*;
class Taxi
{
	int taxi_earnings,free_time=0;
	char current_point;
	char pickup_point;
	char drop_point;
	Taxi()
	{
		current_point='A';
	}
	public void freeTime(char pickup_point,char drop_point,int pickup_time)
	{
		free_time=pickup_time+Math.abs(drop_point-pickup_point);
	}
	public boolean isTaxiFree(int pickup_time)
	{
		if(free_time<pickup_time)
			return true;
		return false;
	}
}
