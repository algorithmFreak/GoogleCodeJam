import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeceitfulWar {

	public static void main(String[] args) {
		DeceitfulWar c = new DeceitfulWar();
		try {
			FileReader fr = new FileReader(
					new File(
							"C:\\Users\\RAHUL\\workspace\\GoogleCodeJam\\src\\D-large.in"));
			BufferedReader br = new BufferedReader(fr);
			PrintWriter pw = new PrintWriter(
					new FileWriter(
							"C:\\Users\\RAHUL\\workspace\\GoogleCodeJam\\src\\Output.in"));
			int outWar, outDWar;
			int T = Integer.parseInt(br.readLine());
			for (int t = 1; t <= T; t++) {
				int N = Integer.parseInt(br.readLine());
				List<Float> Naomi = new ArrayList<Float>();
				List<Float> Ken = new ArrayList<Float>();
				String[] arr = br.readLine().split("\\ ");
				for (int i = 0; i < N; i++) {
					Naomi.add(Float.parseFloat(arr[i]));
				}
				arr = br.readLine().split("\\ ");
				for (int i = 0; i < N; i++) {
					Ken.add(Float.parseFloat(arr[i]));
				}
				Collections.sort(Naomi);
				Collections.sort(Ken);
				List<Float> Naomi1 = new ArrayList<Float>();
				Naomi1.addAll(Naomi);
				List<Float> Ken1 = new ArrayList<Float>();
				Ken1.addAll(Ken);
				 outWar = c.solutionWar(Naomi, Ken);
				outDWar = c.solutionDWar(Naomi1, Ken1);
				System.out.println("Case #" + t + ": " + outDWar +" "+ outWar);
				pw.write("Case #" + t + ": " + outDWar +" "+ outWar + "\n");
			}
			br.close();
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int solutionWar(List<Float> Naomi, List<Float> Ken) {
		int count = 0;
		while (Naomi.size() > 0) {
			boolean naomiWon = true;
			Float n = Naomi.get(0);
			for (int j = 0; j < Ken.size(); j++) {
				Float k = Ken.get(j);
				if (k > n) {
					naomiWon = false;
					Naomi.remove(n);
					Ken.remove(k);
					break;
				}
			}
			if (naomiWon) {
				Naomi.remove(n);
				Ken.remove(Ken.get(0));
				count++;
			}
		}
		return count;
	}

	public int solutionDWar(List<Float> Naomi, List<Float> Ken) {
		int count = 0;
		while (Naomi.size() > 0 && Ken.size() > 0) {
			boolean naomiWon = true;
			Float n = Naomi.get(0);
			Float kinit = Ken.get(0);
			Float kend = Ken.get(Ken.size() - 1);
			if (n < kend && n < kinit) {
				naomiWon = false;
				Naomi.remove(n);
				Ken.remove(kend);
			} else if ( n > kinit) {
				naomiWon = true;
				Naomi.remove(n);
				Ken.remove(kinit);
				count++;
			}
		}
		return count;
	}
}
