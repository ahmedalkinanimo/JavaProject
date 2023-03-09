import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws invalidIP {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		String readIp;
		
		while(true) {
			System.out.print("Enter the IP address: ");
			readIp=in.next();
			if(IPAddress.validateIp(readIp))
				break;
		}
		IPAddress IP1=new IPAddress(readIp);
		System.out.println(IP1);
			
		in.close();
	}
}
