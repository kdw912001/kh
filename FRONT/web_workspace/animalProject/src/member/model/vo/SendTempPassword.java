package member.model.vo;

import java.util.UUID;

public class SendTempPassword {
private UUID uuid = UUID.randomUUID();
	
	public SendTempPassword() {}
	
	public String sendtempPassword() {
		String tempNum = null;
		
		for(int i = 0; i < 5; i ++) {
			tempNum = uuid.toString().replaceAll("-", "").substring(0, 10);
		}
		
		return tempNum;
	}
}
