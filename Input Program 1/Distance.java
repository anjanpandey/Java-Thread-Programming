import java.util.*;
import java.io.*;

public class Distance
{
   public static void main(String[] args) throws IOException 
   {
      
      String filename="";
      double speed = 0.0;
      double hours = 0.0; 
      double distance = 0.0;
      double distanceTraveled = speed*hours;
      
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter the speed of your vehicle: ");
      speed = scan.nextDouble();
      
      while(speed < 0.0)
      {
         System.out.println("You speed can not be negative. Please enter a positive number.");
         System.out.println("Enter the speed of your vehicle again: ");
         speed = scan.nextDouble();
      }
      
      System.out.println("How many hours did you drive?");
      hours = scan.nextDouble();
      
      while (hours < 1)
      {
         System.out.println("Time cannot be negative or 0.");
         System.out.println("Enter the number of hours again: ");
         hours = scan.nextDouble();
      }
      
      scan.nextLine();
      System.out.println("Enter the filename: ");
      filename = scan.nextLine();
      PrintWriter outputFile = new PrintWriter(filename); 
      
      outputFile.println("Hour               Distance Traveled");
      outputFile.println("-------------------------------------");
      
      
      for(int i = 1; i <= hours; i++)
      {  
         distance = i *speed;
         outputFile.println(i+"                     "+distance); 
      }
        
      outputFile.close();
      System.out.println("Data written to a file.");
   }
}