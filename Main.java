package RRS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//get total process from user
		System.out.print("Enter total process:");
		int process = input.nextInt(); //total process
		
		int burstTime[] = new int[process]; //burst time
		int ta[] = new int[process];// turn around times
		int wt[] = new int[process];// waiting times
		int TQ = 0; //time quantities
		
		System.out.print("Enter Time Quantum:");
		TQ = input.nextInt();
		
		
		//get bust time from user
		int totalTA = 0;
		float wtAv = 0;
		for(int i = 0;i<process;i++)
		{
			System.out.print("Enter burst time for process "+(i+1)+":");
			burstTime[i] = input.nextInt();
			totalTA += burstTime[i];
			ta[i] = totalTA-0;
			
			wt[i] = totalTA-burstTime[i];
			wtAv+= wt[i];
		}
		
		
		float taT = 0;
        for(int i = 0;i<process;i++)
        {
        	taT += ta[i];
        }
        
        
        System.out.println("\n");
		System.out.println("---------------------------");
		System.out.println("P.Id\tB.T\tT.A\tW.T");
		System.out.println("---------------------------");
		for(int i = 0; i<process;i++)
		{
			System.out.println((i+1)+"\t"+burstTime[i]+"\t"+ta[i]+"\t"+wt[i]);
		}
		
		System.out.println("---------------------------");
		System.out.println("   Avarage process time");
		System.out.println("---------------------------");
		
		System.out.println("Avrg.T.A.T:"+(taT/process));
		System.out.println("Avrg.W.T:"+(wtAv/process));
		System.out.println("---------------------------");
        
        
        
       boolean flag = true; 
       
       List<String> processList = new ArrayList<String>();
       List<Integer> TqList = new ArrayList<Integer>();
       
       int totalTime = 0;
       
       while(flag)
       {
    	   for(int i = 0; i<burstTime.length; i++)
    	   {
    		   if(burstTime[i] == 0 || burstTime[i]< 0)
    			   continue;
    		   int counter = 0;
    		   while(counter<TQ)
    		   {
    			   if(burstTime[i] == 0|| burstTime[i]<0)
    				   break;
    			   
    			   counter++;
    			   burstTime[i] = burstTime[i] - 1;
        		   totalTime += 1;
    			   
    		   }
    		   
    		   processList.add("P"+(i+1));
    		   TqList.add(totalTime);
    		  
    	   }
    	   
    	   flag =  checkEmpty(burstTime);
       }
        
       System.out.print("------------------------------------------------------------------------\n");
       for(int i = 0; i<processList.size();i++)
       {
    	   System.out.print("| "+processList.get(i)+" |");
       }
       System.out.print("\n------------------------------------------------------------------------\n");
       System.out.print(0);
       
       for(int i = 0; i<TqList.size(); i++)
       {
    	   System.out.print("    "+TqList.get(i));
       }
       
       input.close();
	}
	
	public static boolean checkEmpty(int arr[])
	{	int count = 0;
	
		for(int i = 0;i<arr.length;i++)
		{
			if(arr[i] == 0 || arr[i]<0)
				count++;
		}
		
		if(count == arr.length)
			return false;
		
		return true;
	}
}
