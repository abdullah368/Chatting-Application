
import java.io.*;
import java.net.*;

class Server {

   
    ServerSocket server;
    Socket socket;

        PrintWriter out;
        BufferedReader br;


    public Server()
    {
       try {
        server = new ServerSocket(5000);
        System.out.println("server is ready to ACEPT connecton");
        System.out.println("waiting");
        socket = server.accept();

        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream());

        startReading();
        strartWritting();


       } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
       } 
    }

    public void startReading(){
    
        Runnable r1 =()->{
        System.out.println("Start Reading");
        
            while (true) {
                try {
                  String msg = br.readLine();  
                if (msg.equals("exit")) {
                    System.out.println("clint terminste the break");
                    break;
                }
                System.out.println("Clint :"+msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }

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
        new Server();
    }
}
