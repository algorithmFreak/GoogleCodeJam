import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PartElf {

	public static void main(String[] args) {
		PartElf c = new PartElf();
		try {
			FileReader fr = new FileReader(
					new File(
							"C:\\Users\\RAHUL\\workspace\\GoogleCodeJam\\src\\A-small-practice.in"));
			BufferedReader br = new BufferedReader(fr);
			PrintWriter pw = new PrintWriter(
					new FileWriter(
							"C:\\Users\\RAHUL\\workspace\\GoogleCodeJam\\src\\Output1.in"));
			String out;
			int T = Integer.parseInt(br.readLine());
			for (int t = 1; t <= T; t++) {
				String[] arr = br.readLine().split("/");
				long P = Long.parseLong(arr[0]);
				long Q = Long.parseLong(arr[1]);
				
					out = c.solution(P, Q, 0l);
				
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

	public String solution(long P, long Q, Long count) {
		long Y1;
		Y1 = ((2 * P) / Q )- 1;
		if (Y1 >= 0 && Y1 <= 1) {
			count++;
			if(count==39){
				return "impossible";
			}
			return count.toString();
		}
		return solution(2 * P, Q, count + 1);
	}
}
