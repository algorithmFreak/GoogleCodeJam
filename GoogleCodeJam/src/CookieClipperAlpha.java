import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CookieClipperAlpha {

	public static void main(String[] args) {
		CookieClipperAlpha c = new CookieClipperAlpha();
		try {
			FileReader fr = new FileReader(
					new File(
							"C:\\Users\\RAHUL\\workspace\\GoogleCodeJam\\src\\B-large.in"));
			BufferedReader br = new BufferedReader(fr);
			PrintWriter pw = new PrintWriter(
					new FileWriter(
							"C:\\Users\\RAHUL\\workspace\\GoogleCodeJam\\src\\Output.in"));
			double out;
			int N = Integer.parseInt(br.readLine());
			for (int t = 1; t <= N; t++) {
				String[] arr = br.readLine().split("\\ ");
				double C = Double.parseDouble(arr[0]);
				double F = Double.parseDouble(arr[1]);
				double X = Double.parseDouble(arr[2]);
				out = c.solution(C,F,X);
				//System.out.println("Case #" + t + ": " + out);
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

	public double solution(double C,double F, double X) {
	    double f =2.0;
	    List<Double> list = new ArrayList<Double>();
	    while(true){
	    	if(X/f > C/f + X/(f+F)){
	    		list.add(C/f);
	    	}else{
	    		list.add(X/f);
	    		break;
	    	}
    		f+=F;
	    }
	    double sum=0;
	    for(Double x :list){
	    	sum+=x;
	    }
	    return sum;
	}
}
