import java.io.*;
import java.net.*;

public class Clint {
    Socket socket;
    BufferedReader br;
    PrintWriter out;


    public Clint(){
        try {
            socket = new Socket("127.0.0.1", 5000);
            System.out.println("connection done");

            br= new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());

            startReading();
            strartWritting();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
    }
    public void startReading(){
        Runnable r1 =()-> {
            
         try {
            while (true) {
                String msg = br.readLine();
                if (msg.equals("exit")) {
                    System.out.println("system treminate the chat"); 
                    break; 
                }
               System.out.println("Server  :"+msg);
            }
         } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
         }
        };
        new Thread(r1).start();
    }
    public void strartWritting(){
        Runnable r2 =()->{
            while (true) {
                try {
                    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
                    String contant = br1.readLine();
                    out.println(contant);
                    out.flush(); 

                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }

        };
        new Thread(r2).start();
    }
  
    public static void main(String[] args) {
    System.out.println("this is clint");
    new Clint();
    }
    
}
