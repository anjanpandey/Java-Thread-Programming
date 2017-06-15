import java.io.*;
import java.util.*;

public class Pandey_Anjan_MyThread extends Thread {

   private String id;
   private int idCount;

   public Pandey_Anjan_MyThread(String newId, int newIdCount) {
      id = newId;
      idCount = newIdCount; 
   }

   public void run() {
   	
      try {
      
         String tobeWritten="";
         File writeFile = new File("t" + idCount + "_out.txt");
         PrintWriter output = new PrintWriter(writeFile);
         Scanner newFile = new Scanner(new File(id));
          
         int line = 1;
         do {
            tobeWritten += "MyThread[" + idCount + "]: Line[" + line + "]: " + newFile.nextLine() + "\n";
            line++;		
         } while ((newFile.hasNextLine()));
      	
         output.println(tobeWritten);
         output.close();
      }
       
      catch (IOException e) {
         System.out.println("Error Reading File.");
      }
      
   
   }

}
