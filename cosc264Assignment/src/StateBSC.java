import java.util.Random;

public class StateBSC extends BSC {
	double pb, pg, swb, swg;
	int lastState;

	public StateBSC(int userData, int redundantBits, double pb, double pg, double swb, double swg) {
		super(userData, redundantBits, 0);
		this.pb = pb;
		this.pg = pg;
		this.swb = swb;
		this.swg=swg;
		this.lastState=0;
	}
	@Override
	protected int getS() {
		double p;
		Random rand = new Random();
		float q = rand.nextFloat();
		if (this.lastState==0) {
			p=this.pg;
			if (q > this.swg) {
				p=this.pb;
				this.lastState=1;
			}
		}
		else {
			p=this.pb;
			if (q > this.swb) {
				p=this.pg;
				this.lastState=0;
			}
		}
		return NumberUtils.binomdist(this.packetLength, p);
	}
}
