import java.io.*;
import java.util.*;

public class Pandey_Anjan_Driver {

   public static void main(String[] args) throws FileNotFoundException {
      try {
         Reader();
      } 
      catch (IOException e) {
         System.out.println("Error Reading File.");
      }
      
      
   }

   public static void Reader() throws FileNotFoundException {
   
      String mainInput = "in.txt";
   
      File file = new File(mainInput);
      Scanner scan = new Scanner(file);
      String firstLine = scan.nextLine();
      String lastLine = scan.nextLine();
      Scanner reader, finalScan;
   
      if (firstLine.charAt(0) == 't' || firstLine.charAt(0) == 'T') {
      
         String thread = firstLine.substring(2, 3);
         int threadNum = Integer.parseInt(thread);
         String[] nFile = new String[threadNum];
         String required = lastLine.substring(2);
         reader = new Scanner(required).useDelimiter(" ");
         PrintWriter output = new PrintWriter("out.txt"); 
      
         if (lastLine.charAt(0) == 'f' || lastLine.charAt(0) == 'F') {
            for (int i = 0; i < threadNum; i++) {
               nFile[i] = reader.next();
               Pandey_Anjan_MyThread threadCount = new Pandey_Anjan_MyThread(nFile[i],i);
               threadCount.start();
               System.out.println("status = " + threadCount.isAlive());
               try {
               
                  threadCount.join();
               } 
               catch (InterruptedException e){
               }
               String outline="";
               finalScan = new Scanner(new File("t"+i+"_out.txt"));
                      
               do
               {  
                  outline = finalScan.nextLine(); 
                  output.println(outline);  
               }while (finalScan.hasNextLine());
   
            }
               
         }
         output.close();
      }  
   }
}

