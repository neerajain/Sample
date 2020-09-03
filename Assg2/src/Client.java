import java.net.*;  
import java.io.*;  

class Client{  
	public static void main(String args[])throws Exception{  
		try {
			Socket s=new Socket("localhost",6665);  
			DataInputStream din=new DataInputStream(s.getInputStream());  
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
			System.out.println("Connected...");
			String str="",str2="";  
			while(!str.equals("stop")){  
				System.out.println("Please Enter your respective question and enter stop to exit the chat -");
				System.out.print("-> ");
				str=br.readLine();  
				dout.writeUTF(str);  
				dout.flush();  
				str2=din.readUTF();  
				System.out.println("Doctor: "+str2);  
			}  
			dout.close();  
			s.close();  
		}
		catch(Exception e) {
			System.out.println("Error :" + e);
		}
	}
}  
