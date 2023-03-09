/***
 * Ahmed Alkinani
 * aaljanabi@kckcc.edu
 * The goal of this class is to generate IPv4 addresses while also ensuring that 
 * the entered address is valid. Additionally, the class determines the network 
 * IPv4 address by utilizing the first, last, and broadcast IPv4 addresses. 
 * The class also calculates the number of usable IP addresses that are available.
 * The aim of this project is to accomplish the task without utilizing any available network libraries.
 */



public class IPAddress {
	// Data members
	private String Ip;								// Entered IP address as string
	private String netIp;							// Network IP address
	private int[] IpOctet=new int[4];				// IP 4 octet
	private int prefix;								// IP prefix
	private int[] netIpOctet=new int[4]; 			// NetWork Ip address
	private int[] subnetMask=new int[4];			// subnet  address octets 
	private String subnetMaskStr;					// subnet  address mask
	private String firstIpAddress;					// 1st available Ip address
	private String lastIpAddress;					// last available Ip address
	private String boradCastIpAddress;				// BoradCast Ip Address
	private int numberOfHosts;						// # of usable Hosts
	
	
	
	public IPAddress(String ipInput) throws invalidIP { // ipInput is validated
		// Argument Constructor 
		this.setIp(ipInput); 			// set the Entered (validated) IP address
		this.setOctetsAndPrefix();		// prefix and octets of the entered IP address extraction
		this.setSubnetMask();			// determining the subnet mask in a form of string and numerical value for the octets		
		this.setNetIp();				// using the subnet mask octets, this method will determine the network IP address in form of string and numerical value for the octets
		this.setFirstIpAddress();		// this method will find the 1st available IP address
		this.setLastIpAddress();		// this method will find the Last available IP address
		this.setBoradCastIpAddress();	// this method will find the broad cast IP address
		this.setNumberOfHosts();		/// this method will find the # of available usable IP address in the network
	}
	
	public void setIp(String Ip) {
		this.Ip=Ip;
	}
	
	public void setFirstIpAddress() {
		// this method will find the 1st available IP address: 
		//  1st available IP address = netIP+1
		this.firstIpAddress="";
		for(int i=0;i<4;i++) {
			firstIpAddress+=(i!=3?String.valueOf(this.netIpOctet[i])+".":String.valueOf(this.netIpOctet[i]+1));
		}
	}

	public void setLastIpAddress() {
		// this method will find the last IP address:
		// last IP address= [netIP ~ (bitwise negation) of subnet mask] -1
		// integers are represented using two's complement notation in Java. 
		// To convert the bitwise negation of 255 back to its unsigned binary representation, 
		// we added 256 to the result
		this.lastIpAddress="";
		for(int i=0;i<4;i++) {
			lastIpAddress+=(i!=3?String.valueOf(netIpOctet[i]|(~subnetMask[i]+256))+".":String.valueOf(netIpOctet[i]|(~subnetMask[i]+256)-1));
		}
	}

	public void setBoradCastIpAddress() {
		// this method will find the broad cast IP address:
		// broad cast IP address= netIP ~ (bitwise negation) of subnet mask
		// integers are represented using two's complement notation in Java. 
		// To convert the bitwise negation of 255 back to its unsigned binary representation, 
		// we added 256 to the result
		this.boradCastIpAddress="";
		for(int i=0;i<4;i++) {
			boradCastIpAddress+=(i!=3?String.valueOf(netIpOctet[i]|(~subnetMask[i]+256))+".":String.valueOf(netIpOctet[i]|(~subnetMask[i]+256)));
		}
	}

	public void setNumberOfHosts() {
		// the size of host portion of the ip address = 32- prefix
		// # of usable hosts = 2 to the power of (32- prefix) -2
		this.numberOfHosts=(int)Math.pow(2,(32-this.prefix))-2;
	}

	public void setNetIp() { 
		// this method will find the network IP address: in a String form and numerical form of 4 octets
		//  Network IP address = Entered IP address & (bitwise AND) subnet mask
		this.netIp="";
		String temp;
		for(int i=0;i<4;i++) {
			this.netIpOctet[i]=this.IpOctet[i]&this.subnetMask[i];
			temp=String.valueOf(this.netIpOctet[i]);
			this.netIp+=(i!=3?temp+".":temp);
		}
	}
	
	public boolean isNetworkAddress() {
		// check if the entered IP address is the network IP address 
		return this.Ip.equals(this.netIp)?true:false;
	}
	
	public void setSubnetMask() {
		// determining the subnet mask in a form of string and numerical value for the octets		
		this.subnetMaskStr="";
		// generating a sequence of 32 ones and shifting them to the left by (32-prefix)
		// example: if prefix is 24, the 32 of the ones will be shifted to the left by 8 and we will end up with 24 ones
		// whic will be assigned to mask
		int mask = 0xFFFFFFFF << (32 - prefix);
		// the following procedure is to break down the mask into 4 octets of the subnet mask and to generat the string form of the subnet mask
		int stepSize=24;
		for(int i=0;i<4;i++) {
			// for each iteration, the mask will be shifted to the right by a step size (adapted) and a
			// bitwise AND operation will be performed with 0xFF (11111111) to find the octets 
			this.subnetMask[i]=mask>>>stepSize & 0xFF;
			stepSize-=8;
			this.subnetMaskStr+=(i!=3?Integer.toString(subnetMask[i])+".":Integer.toString(subnetMask[i]));
		}
	}
	
	public void setOctetsAndPrefix() {
		// extract the Octets and prefix from the IP address
		String[] IpPrefix=Ip.split("/");
		String[] Oct=IpPrefix[0].split("\\.");
		this.prefix=Integer.parseInt(IpPrefix[1]); 
		for(int i=0;i<4;i++) {
			this.IpOctet[i]=Integer.parseInt(Oct[i]);	
		}	
	}

	public int getPrefix() { // returns the entered prefix
		return this.prefix;
	}
	
	public int[] getOctet() { // returns the Octets of the entered IP address
		return this.IpOctet;
	}
	
	public String getIp() { // returns the the entered IP address
		return this.Ip;
	}
	
	public String getNetIp() { // returns the the network IP address
		return this.netIp;
	}

	public int[] getNetIpOctet() { // returns the Octets of the network IP address
		return this.netIpOctet;
	}

	public int[] getSubnetMask() { // returns the Octets of the subnet mask 
		return this.subnetMask;
	}

	public String getSubnetMaskStr() { // returns the subnet mask address
		return this.subnetMaskStr;
	}
	
	public int getNumberOfHosts() { // returns the Number Of usable IP address for Hosts
		return numberOfHosts;
	}
	public String getLastIpAddress() { // returns the last available Ip address
		return this.lastIpAddress;
	}
	public String getBoradCastIpAddress() { // returns the Broad Cast Ip address
		return this.boradCastIpAddress;
	}
	public String getFirstIpAddress() { // returns the first available Ip address
		return this.firstIpAddress;
	}
	
	public String toString() {
		// returns a string representation of an object (IP address) 
		String str="Entered IP address: "+this.Ip;
		str+="\nNetwork Ip address :"+this.netIp+"/"+this.prefix;
		str+="\nSubnet mask: "+this.subnetMaskStr;
		str+="\nNumber of Hosts :"+this.numberOfHosts;
		str+="\nBorad Cast Ip Address :"+this.boradCastIpAddress;
		str+="\nFirst Ip Address :"+this.firstIpAddress;
		str+="\nLast Ip Address :"+this.lastIpAddress;
		return str;
	}
	
	public static boolean validateIp(String ipInput) throws invalidIP {
		// check for the format of the Entered IP address: aa.bb.cc.dd\ee
		try {
			String[] IpPrefix=ipInput.split("/");  // using'/' to split IP address
			// 2 elements should be produced if the format was correct
			//aa.bb.cc.dd & ee
			
			if(IpPrefix.length!=2)
				throw new invalidIP("Invalid Entery for the IP address");
			// checking if the prefix is acceptable
			int pfx=Integer.parseInt(IpPrefix[1]); // if the entered prefix is nut numerical, NumberFormatException exception will be thrown 
			if(pfx <0 || pfx >32) // checking of invalid numerical value
				throw new invalidIP("Invalid Entery for the Prefix");
			
			
			String[] Oct=IpPrefix[0].split("\\."); // using'.' to split IP address octets
			// 4 elements should be produced if the format was correct 
			// aa, bb, cc, & dd
			
			if(Oct.length!=4)
				throw new invalidIP("Invalid Entery for the IP address");
			int ipOct;
			for(int i=0;i<4;i++) {
				ipOct=Integer.parseInt(Oct[i]);
				if(ipOct <0 || ipOct >255)
					throw new invalidIP("Invalid Entery for the octet "+ipOct);
			}	
			// if no exceptions are thrown, valid IP address
			return true;	
			
		}catch(invalidIP e) {
			System.out.println("An error occurred: " + e.getMessage());
			return false;
		}catch(NumberFormatException e) {
			System.out.println("An error occurred: " + e.getMessage());
			return false;
		}	
	}
		
}