import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;


public class CSV {
	private void writeList(String filename, ArrayList list, int nCols) {
		StringBuilder sb = new StringBuilder();
		int i=0;
		for (Object obj : list) {
			sb.append(obj);
			i+=1;
			if (i == nCols) {
				sb.append("\n");
				i=0;
			}
			else {
				sb.append(",");
			}
		}

		try {
			BufferedWriter br = new BufferedWriter(new FileWriter(filename));
			br.write(sb.toString());
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
public void genGraph1(double p) {
	BSC bsc;
	double val;
	ArrayList sb = new ArrayList();
	sb.add("User Data");
	sb.add("Efficiency Value");
	for(int i=100; i<=2000; i+=10) {
		bsc=new BSC(i, (i/10), p);
		val = bsc.simulation(1000);
		sb.add(i);
		sb.add(val);
		System.out.println(val);
	}

	writeList("graph13.csv", sb, 2);
}
public void genGraph2() {
	BSC bsc;
	double val;
	ArrayList sb = new ArrayList();
	double []  arr= {0.01, 0.001, 0.0001};
	sb.add("Error Rate");
	sb.add("Efficiency Value");
	for (double p = 0.0001; p <= 0.015; p += 0.0005) {
		System.out.println("p "+p);
		bsc=new BSC(512, 50, p);
		sb.add(p);
		val=bsc.simulation(10000);
		sb.add(val);
	}
	writeList("graph2.csv", sb, 2);


}
public void genGraph3() {
	double pg=0.00001;
	double pb=0.00199;
	BSC bsc;
	int u=1024;
	double swp = 0.9;
	ArrayList sb = new ArrayList();
	sb.add("N-K");
	sb.add("efficiency Value");
	double val;
	int i;
	for (i=0; i <=500; i+=10) {
		System.out.println(i);
		bsc=new BSC(u, i, 0.001);
		val=bsc.simulation(10000);
		sb.add(i);
		sb.add(val);
	}
	writeList("graph3.csv", sb, 2);



	
}

}
