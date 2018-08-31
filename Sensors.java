package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Sensor{
	int id;
	long milliseconds;
	int temp;
	Sensor(int id, long milliseconds, int temp){
		this.id = id;
		this.milliseconds = milliseconds;
		this.temp = temp;
	}
}
public class Sensors {
	private void meanCalculator(ArrayList<Sensor> arr,long min){
		long minTime = min;
		//time band to set the interval like 10000-11000
		long i=minTime+1000;
		// getting count to check the iterations count k (at worst iteration should not 
		//exceed total entries)
		int size = arr.size();
		for(int k=0;k<size;k++){
			//getting count of sensors in the specific interval to calculate avg
			int count = 0;
			double meanTemp = 0;
			for(int j=arr.size()-1;j>=0;j--){
				//checking if the current sensor is in the time range
				if(arr.get(j).milliseconds>=minTime && arr.get(j).milliseconds<i){
					count++;
					meanTemp = meanTemp+arr.get(j).temp;
					// removing the counted sensor to reduce arraylist traversal for next time interval
					arr.remove(j);
				}
			}
			// to get 2 numbers after decimal.
			double mean = Math.round((meanTemp/count)*100.0)/100.0;
			System.out.println(minTime+"-"+(i-1)+": "+mean);
			// setting the current max time level as min interval for next band
			minTime = i;
			// setting the highest interval for next band
			i = i+1000;
			if(arr.size()==0)
				break;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int totalSensors = Integer.valueOf(sc.nextLine());
		//Adding sensor data to the list so that they can be removed after summing
		ArrayList<Sensor> al = new ArrayList<Sensor>();
		while(totalSensors>0){
			String s = sc.nextLine();
			String[] sensornum = s.split(",");
			Sensor s1 = new Sensor(Integer.valueOf(sensornum[0]),Long.valueOf(sensornum[1]),Integer.valueOf(sensornum[2]));
			al.add(s1);
			totalSensors--;
		}
		
		// To determine the starting time to start count
		long minTime = al.get(0).milliseconds;
		Sensors s = new Sensors();
		s.meanCalculator(al, minTime);
	}

}
