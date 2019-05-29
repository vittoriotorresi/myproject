import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main { //client

    public static void main(String[] args) {
        if(args.length!=2){
            System.out.println("Usage: java Main <address> <port>");
            exit(-1);
        }
        String address=args[0];
	int port=Integer.parseInt(args[1]);
	try{
        System.out.println("Trying to connect to "+address+" "+port);
        Socket socket=new Socket(address, port);
        System.out.println("OK connected to "+address+" "+port);
        PrintWriter pw=new PrintWriter(socket.getOutputStream());
        Scanner scan=new Scanner(System.in);
        while(scan.hasNextLine()){
            String message=scan.nextLine();
            System.out.println("Sending message "+message+" to "+socket.getRemoteSocketAddress());
            pw.println(message);
            pw.flush();
        }
      } catch (IOException e) {
        e.printStackTrace();
    }
    }
}
