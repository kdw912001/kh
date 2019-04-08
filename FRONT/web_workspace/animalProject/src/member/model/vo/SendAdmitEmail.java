package member.model.vo;

import java.util.Random;

public class SendAdmitEmail {
	private int numLength = 6;
	
	public SendAdmitEmail() {}
	
	public SendAdmitEmail(int numLength) {
		super();
		this.numLength = numLength;
	}

	public int getNumLength() {
		return numLength;
	}

	public void setNumLength(int numLength) {
		this.numLength = numLength;
	}

	public String sendAdmitNumber() {
		Random random = new Random(System.currentTimeMillis());
		
		int range = (int)Math.pow(10, numLength);
		int trim = (int)Math.pow(10, numLength);
		
		int result = random.nextInt(range) + trim;
		
		if(result > range) {
			result = result - trim;
		}
		
		return String.valueOf(result);
	}
	

}
