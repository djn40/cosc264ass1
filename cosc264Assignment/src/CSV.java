import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class CSV {
public void genGraph1(double p) {
	BSC bsc;
	double val;
	StringBuilder sb = new StringBuilder();
	sb.append("User Data, Efficiency Value\n");
	for(int i=100; i<=2000; i+=10) {
		bsc=new BSC(i, (i/10), p);
		val = bsc.simulation(1000);
		sb.append(i);
		sb.append(",");
		sb.append(val);
		sb.append("\n");
		System.out.println(val);
	}

	try {
		BufferedWriter br = new BufferedWriter(new FileWriter("graph1, p="+p+".csv"));
		br.write(sb.toString());
		br.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}
public void genGraph2() {
	BSC bsc;
	double val;
	StringBuilder sb = new StringBuilder();
	double []  arr= {0.01, 0.001, 0.0001};
	sb.append("Error Rate, Efficiency Value\n");
	for (double p = 0.0001; p <= 0.015; p += 0.0005) {
		System.out.println("p "+p);
		bsc=new BSC(512, 50, p);
		sb.append(p);
		val=bsc.simulation(10000);
		sb.append(",");
		sb.append(val);
		sb.append("\n");
	}

	try {
		BufferedWriter br = new BufferedWriter(new FileWriter("graph2.csv"));
		br.write(sb.toString());
		br.close();
	} catch (IOException e) {
		e.printStackTrace();
	}

}
public void genGraph3() {
	double pg=0.00001;
	double pb=0.00199;
	BSC bsc;
	int u=1024;
	double swp = 0.9;
	StringBuilder sb = new StringBuilder();
	sb.append("N-K, efficiency Value\n");
	double val;
	int i;
	for (i=0; i <=500; i+=10) {
		System.out.println(i);
		bsc=new BSC(u, i, 0.001);
		val=bsc.simulation(10000);
		sb.append(i);
		sb.append(",");
		sb.append(val);
		sb.append("\n");
	}

	try {
		BufferedWriter br = new BufferedWriter(new FileWriter("graph3B.csv"));
		br.write(sb.toString());
		br.close();
	} catch (IOException e) {
		e.printStackTrace();
	}

	
}

}
