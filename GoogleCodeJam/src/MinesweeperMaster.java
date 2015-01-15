import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MinesweeperMaster {
	public static void main(String[] args) {
		try {
			String x = "-1000000000";
			System.out.println(Math.pow(8, 0.5)); 
			FileReader fr = new FileReader(
					new File(
							"C:\\Users\\RAHUL\\workspace\\GoogleCodeJam\\src\\Input.in"));
			BufferedReader br = new BufferedReader(fr);
			PrintWriter pw = new PrintWriter(
					new FileWriter(
							"C:\\Users\\RAHUL\\workspace\\GoogleCodeJam\\src\\Output.in"));
			
			int T = Integer.parseInt(br.readLine());
			for (int t = 1; t <= T; t++) {
				String[] arr = br.readLine().split("\\ ");
				int R = Integer.parseInt(arr[0]);
				int C = Integer.parseInt(arr[1]);
				int M = Integer.parseInt(arr[2]);
				
			
				// game grid is [1..M][1..N], border is used to handle boundary
				// cases
				boolean[][] bombs = new boolean[R + 2][C + 2];
				char[][] charBombs = new char[R + 2][C + 2];
				for (int i = 1; i <= R; i++)
					for (int j = 1; j <= C; j++)
						charBombs[i][j] = 'a';
				int count = 0;
				while (count < M) {
					int r = (int) ((Math.random()) * (R + 1));
					int c = (int) ((Math.random()) * (C + 1));
					if (charBombs[r][c] == 'a') {
						count++;
						charBombs[r][c]='b';
						bombs[r][c]=true;
					}else
						continue;
				}

				// print game
				for (int i = 1; i <= R; i++) {
					for (int j = 1; j <= C; j++)
						if (bombs[i][j])
							System.out.print("* ");
						else
							System.out.print(". ");
					System.out.println();
				}

				// sol[i][j] = # bombs adjacent to cell (i, j)
				int[][] sol = new int[R + 2][C + 2];
				for (int i = 1; i <= R; i++)
					for (int j = 1; j <= C; j++)
						// (ii, jj) indexes neighboring cells
						for (int ii = i - 1; ii <= i + 1; ii++)
							for (int jj = j - 1; jj <= j + 1; jj++)
								if (bombs[ii][jj])
									sol[i][j]++;

				// print solution
				System.out.println();
				for (int i = 1; i <= R; i++) {
					for (int j = 1; j <= C; j++)
						if (bombs[i][j])
							System.out.print("* ");
						else
							System.out.print(sol[i][j] + " ");
					System.out.println();
				}
				System.out.println("----------------------------");
				// pw.write("Case #" + t + ": " + out + "\n");
			}
			br.close();
			pw.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
