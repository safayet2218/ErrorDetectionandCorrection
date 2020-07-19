
public class H7 {
	public static void main(String args[]) {
		int H7[][] = {
				  { 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1},
		 		  { 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0},
		 		  { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0},
		 		  { 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
		 		  { 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0}, 
		 		  { 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1},
		          { 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1} 
				};
		String send =    "1000 0110 1001 1001";
		String receive = "0111 0110 1001 1001";
		send = send.replaceAll("\\s", "");
		receive = receive.replaceAll("\\s", "");
		System.out.println(send+" "+receive);
		
		int c[] = new int[7];
		int s[] = new int[7];
		int x[] = new int[16];
		int new_x[] = new int[16];
		for(int i = 0; i < send.length();i++) {
			x[i] = (int)send.charAt(i) - 48;
			new_x[i] = (int)( receive.charAt(i) - 48);
//			System.out.print(x[i]+" "+new_x[i]);
		}
		c[0] = x[0] ^ x[2] ^ x[3] ^ x[4] ^ x[5] ^ x[9] ^ x[12] ^ x[15];
		c[1] = x[1] ^ x[4] ^ x[6] ^ x[7] ^ x[8] ^ x[11] ^ x[13];
		c[2] = x[3] ^ x[4] ^ x[7] ^ x[10] ^ x[13] ^ x[14];
		c[3] = x[0] ^ x[3] ^ x[6] ^ x[9];
		c[4] = x[0] ^ x[2] ^ x[3] ^ x[5] ^ x[6] ^ x[11] ^ x[14];
		c[5] = x[1] ^ x[5] ^ x[7] ^ x[10] ^ x[12] ^ x[14] ^ x[15];
		c[6] = x[2] ^ x[4] ^ x[5] ^ x[7] ^ x[8] ^ x[10] ^ x[13] ^ x[15];
		
		s[0] = c[0] ^ new_x[0] ^ new_x[2] ^ new_x[3] ^ new_x[4] ^ new_x[5] ^ new_x[9] ^ new_x[12] ^ new_x[15];
		s[1] = c[1] ^ new_x[1] ^ new_x[4] ^ new_x[6] ^ new_x[7] ^ new_x[8] ^ new_x[11] ^ new_x[13];
		s[2] = c[2] ^ new_x[3] ^ new_x[4] ^ new_x[7] ^ new_x[10] ^ new_x[13] ^ new_x[14];
		s[3] = c[3] ^ new_x[0] ^ new_x[3] ^ new_x[6] ^ new_x[9];
		s[4] = c[4] ^ new_x[0] ^ new_x[2] ^ new_x[3] ^ new_x[5] ^ new_x[6] ^ new_x[11] ^ new_x[14];
		s[5] = c[5] ^ new_x[1] ^ new_x[5] ^ new_x[7] ^ new_x[10] ^ new_x[12] ^ new_x[14] ^ new_x[15];
		s[6] = c[6] ^ new_x[2] ^ new_x[4] ^ new_x[5] ^ new_x[7] ^ new_x[8] ^ new_x[10] ^ new_x[13] ^ new_x[15];
		
		for(int i = 0;i<7;i++) {
			System.out.print(s[i]+" ");
		}System.out.println();
		
		for(int j = 7;j < H7[0].length - 3;j++) {
			int arr[] = new int[7];
			for(int i=0;i<7;i++) {
				arr[i] = H7[i][j] ^ H7[i][j+1]^ H7[i][j+2]^H7[i][j+3];
			}
			int temp = 0;
			for(int i = 0;i<7;i++) {
				if(s[i] == arr[i]) {
					temp++;
				} else {
					temp = 0;
					break;
				}
				if(temp == 7) {
					System.out.println("Error detected at "+ (j - 7) + " "+ (j - 7 + 1) + " "+ (j - 7 + 2)
							 + " "+ (j - 7 + 3));
					break;
				}
			}
		}
	}
}
