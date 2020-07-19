
public class H8 {
	public static void main(String args[]) {
		int H8[][] = {
				{1,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,1,0,1,0,0,0,1,0,0,0},
				{0,1,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,1,0,1,1,0,0,1,0,0,0,1,1,0,1,0,0,1,0},
				{0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,1,0,0,0,1,0,0,0,1,1,0,0,0,1,0,1,0,0,1},
				{0,0,0,1,0,0,0,0,0,0,0,1,0,1,0,0,0,1,0,0,0,1,1,0,0,0,1,1,1,0,1,1,0,1,0,0,0,1,0,1},
				{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,1,0,0,0,1,0,0,0,1,1,0,0,1,0,0,0,1,1,0,1,0},
				{0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,1,0,0,1,0,0,0,1,0,0,1,1,1,0,1,0,0,0,1,1,0,0,1,0,1},
				{0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,1,0,0,1,1,0,1,0,1,1,0,1,0,0},
				{0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,0,0,1,0,1,1,0,0,1,0,1,0,1,1,1,0,0,0,1,1,0},
		};
		
		String send =    "1000 0110 1001 1001 1000 0110 1001 1001";
		String receive = "1000 0110 1001 1001 1000 1001 1001 1001";
		send = send.replaceAll("\\s", "");
		receive = receive.replaceAll("\\s", "");
		System.out.println(send+" "+receive);
		
		int c[] = new int[8];
		int s[] = new int[8];
		int x[] = new int[32];
		int new_x[] = new int[32];
		for(int i = 0; i < send.length();i++) {
			x[i] = (int)send.charAt(i) - 48;
			new_x[i] = (int)( receive.charAt(i) - 48);
//			System.out.print(x[i]+" "+new_x[i]);
		}
		
		c[0] = x[0]^x[3]^x[6]^x[11]^x[15]^x[22]^x[24]^x[28];
		c[1] = x[1]^x[4]^x[10]^x[14]^x[16]^x[17]^x[20]^x[24]^x[25]^x[27]^x[30];
		c[2] = x[2]^x[7]^x[12]^x[13]^x[17]^x[21]^x[22]^x[26]^x[28]^x[31];
		c[3] = x[3]^x[5]^x[9]^x[13]^x[14]^x[18]^x[19]^x[20]^x[22]^x[23]^x[25]^x[29]^x[31];
		c[4] = x[4]^x[8]^x[11]^x[15]^x[19]^x[20]^x[23]^x[27]^x[28]^x[30];
		c[5] = x[0]^x[7]^x[10]^x[14]^x[17]^x[18]^x[19]^x[21]^x[25]^x[26]^x[29]^x[31];
		c[6] = x[1]^x[6]^x[9]^x[12]^x[18]^x[21]^x[22]^x[24]^x[26]^x[27]^x[29];
		c[7] = x[2]^x[5]^x[8]^x[13]^x[15]^x[16]^x[19]^x[21]^x[23]^x[24]^x[25]^x[29]^x[30];
		
		s[0] = c[0]^new_x[0]^new_x[3]^new_x[6]^new_x[11]^new_x[15]^new_x[22]^new_x[24]^new_x[28];
		s[1] = c[1]^new_x[1]^new_x[4]^new_x[10]^new_x[14]^new_x[16]^new_x[17]^new_x[20]^new_x[24]^new_x[25]^new_x[27]^new_x[30];
		s[2] = c[2]^new_x[2]^new_x[7]^new_x[12]^new_x[13]^new_x[17]^new_x[21]^new_x[22]^new_x[26]^new_x[28]^new_x[31];
		s[3] = c[3]^new_x[3]^new_x[5]^new_x[9]^new_x[13]^new_x[14]^new_x[18]^new_x[19]^new_x[20]^new_x[22]^new_x[23]^new_x[25]^new_x[29]^new_x[31];
		s[4] = c[4]^new_x[4]^new_x[8]^new_x[11]^new_x[15]^new_x[19]^new_x[20]^new_x[23]^new_x[27]^new_x[28]^new_x[30];
		s[5] = c[5]^new_x[0]^new_x[7]^new_x[10]^new_x[14]^new_x[17]^new_x[18]^new_x[19]^new_x[21]^new_x[25]^new_x[26]^new_x[29]^new_x[31];
		s[6] = c[6]^new_x[1]^new_x[6]^new_x[9]^new_x[12]^new_x[18]^new_x[21]^new_x[22]^new_x[24]^new_x[26]^new_x[27]^new_x[29];
		s[7] = c[7]^new_x[2]^new_x[5]^new_x[8]^new_x[13]^new_x[15]^new_x[16]^new_x[19]^new_x[21]^new_x[23]^new_x[24]^new_x[25]^new_x[29]^new_x[30];
	
		for(int i = 0;i<8;i++) {
			System.out.print(s[i]+" ");
		}System.out.println();
		
		for(int j = 8;j < H8[0].length - 3;j++) {
			int arr[] = new int[8];
			for(int i=0;i<8;i++) {
				arr[i] = H8[i][j] ^ H8[i][j+1]^ H8[i][j+2]^H8[i][j+3];
			}
			int temp = 0;
			for(int i = 0;i<8;i++) {
				if(s[i] == arr[i]) {
					temp++;
				} else {
					temp = 0;
					break;
				}
				if(temp == 8) {
					System.out.println("Error detected at "+ (j - 8) + " "+ (j - 8 + 1) + " "+ (j - 8 + 2)
							 + " "+ (j - 8 + 3));
					break;
				}
			}
		}
	}
}
