import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TheRepeater {

	public static void main(String[] args) {
		TheRepeater c = new TheRepeater();
		try {
			FileReader fr = new FileReader(
					new File(
							"C:\\Users\\RAHUL\\workspace\\GoogleCodeJam\\src\\Input.in"));
			BufferedReader br = new BufferedReader(fr);
			PrintWriter pw = new PrintWriter(
					new FileWriter(
							"C:\\Users\\RAHUL\\workspace\\GoogleCodeJam\\src\\Output.in"));
			String out;
			int T = Integer.parseInt(br.readLine());
			for (int t = 1; t <= T; t++) {
				int N = Integer.parseInt(br.readLine());
				String[] arr = new String[N];
				for (int i = 0; i < N; i++) {
					arr[i] = br.readLine();
				}
				out = c.solutionSmall(arr, N);
				System.out.println("Case #" + t + ": " + out);
				pw.write("Case #" + t + ": " + out + "\n");
			}
			br.close();
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String solutionSmall(String[] arr, int N) {
		String count;
		String str1 = arr[0];
		String str2 = arr[1];
		StringBuilder sb1,sb2;
		if (str1.equals(str2)) {
			return "0";
		} else {
			 sb1 = new StringBuilder(str1);
			 sb2 = new StringBuilder(str2);
			int i=0;
			while(i<sb1.length()-1){
				if(sb1.charAt(i)==sb1.charAt(i+1)){
					sb1.deleteCharAt(i);
				}else{
					i++;
				}
			}		
			System.out.println(sb1);
			i=0;
			while(i<sb2.length()-1){
				if(sb2.charAt(i)==sb2.charAt(i+1)){
					sb2.deleteCharAt(i);
				}else{
					i++;
				}
			}
			System.out.println(sb2);
			if(!sb1.toString().equals(sb2.toString())){ 
				return "Fegla Won";
			}
			sb1 = new StringBuilder(str1);
			sb2 = new StringBuilder(str2);
			i=0;
			while(i<sb1.length()){
				if(sb2.charAt(i)!=sb1.charAt(i)){
					sb2.insert(i, sb1.charAt(i));
				}else{
					i++;
				}
			}
			System.out.println("sb1---"+sb1);
			System.out.println("sb2---"+sb2);
			Integer diff= Math.abs(str1.length() - str2.length());
			count= diff.toString();
		}	
		return count.toString();
	}
}
