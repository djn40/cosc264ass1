public class BSC {
	
	private static final int overhead = 100;
	private int redundantBits, userData, T;
	private double errorRate;
	protected int packetLength;
	public BSC(int userData, int redundantBits, double errorRate) {
		this.redundantBits = redundantBits;
		this.userData = userData;
		this.errorRate = errorRate;
		this.packetLength = this.userData+this.overhead+this.redundantBits;
		this.T=NumberUtils.calcT(packetLength , this.redundantBits);
	}
	//debug
	public void getInfo(){
		System.out.println(this.T);
		System.out.println(this.packetLength);
	}
	public double simulation(int n) {
		int i=0;
		double total=0;
		double part=0;
		int xi;
		double xin;
		while (i<n) {
			xi = this.sendPacket();
			xin=xi*this.packetLength;
			part=this.userData/xin;
			total+=part;
			i++;
		}
		double avg=1/total;
		//debug
		return avg;
	}
	private int sendPacket() {
		int transmissions=0;
		int s=this.T+1;
		//Hack to make sure we transmit at least once
		while(s > this.T) {
			s=this.getS();
			transmissions++;
			//debug
			//System.out.println("trying "+ s +" against "+this.T);
		}
		return transmissions;
	}
	protected int getS() {
		return NumberUtils.binomdist(this.packetLength, this.errorRate);
	}
}
