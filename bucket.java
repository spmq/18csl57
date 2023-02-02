import java.util.Scanner;
public class bucket {
	public static void Leaky_bucket(int bucket_size, int flow_rate, int numpackets, int packets[]) {
		int bucket_input=0, packets_drop=0, bucket_packets=0, packets_sent=0, packets_left=0;
		for(int i=0; i<numpackets;i++) {
			bucket_input = packets_left + packets[i];
			if(bucket_input <= bucket_size) {
				packets_drop = 0;
				bucket_packets = bucket_input;
			} else {
				bucket_packets = bucket_size;
				packets_drop = bucket_input - bucket_packets;
			}
	
			if(bucket_packets <= flow_rate) {
				packets_left = 0;
				packets_sent = bucket_packets;
			} else {
				packets_sent = flow_rate;
				packets_left = bucket_packets - packets_sent;
			}

			System.out.println(bucket_input+"\t\t" +bucket_packets+"\t\t" +packets_sent+"\t\t" +packets_left+"\t\t" +packets_drop);
		}

		while(packets_left > 0) {
			packets_drop = 0;
			if(packets_left <= flow_rate) {
				bucket_packets = packets_left;
				packets_sent=packets_left;
				packets_left = 0;
			} else { 
				bucket_packets = packets_left;
				packets_sent = flow_rate;
				packets_left = bucket_packets - flow_rate;
			}
		
			System.out.println("\t\t"+bucket_packets+"\t\t" +packets_sent+"\t\t" +packets_left+"\t\t" +packets_drop);
		}
	}

	public static void main(String[] args) {
		Scanner scanner  = new Scanner(System.in);
		System.out.print("Enter the bucket size: ");
		int bucket_size = scanner.nextInt();
		
		System.out.print("Enter the flow rate: ");	
		int flow_rate = scanner.nextInt();	

		System.out.print("Enter the number of packets: ");
		int numpackets = scanner.nextInt();

		int packets[] = new int[numpackets];
		if(numpackets > 0) {
			for(int i=0; i<numpackets; i++) {
				System.out.print("Enter the packet " + (i+1) + " size: ");
				packets[i] = scanner.nextInt();
			}

			System.out.printf("Bucket input \tBucket packets \tPacket sent \tPacket left \tPacket dropped");
			System.out.println();	
			Leaky_bucket(bucket_size, flow_rate, numpackets, packets);
		}
	}
}