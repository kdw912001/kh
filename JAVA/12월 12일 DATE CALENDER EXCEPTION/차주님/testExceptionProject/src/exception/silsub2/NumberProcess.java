package exception.silsub2;

public class NumberProcess {
	public NumberProcess(){}
	
	public boolean checkDouble(int a, int b) 
			throws NumberRangeException{
		boolean result = false;
		if((a >= 1 && a <= 100) && (b >= 1 && b <= 100)){
			if(a % b == 0)
				result = true;
		}else
			throw new NumberRangeException("1���� 100������ ���� �ƴմϴ�.");
	
		return result;
	}
}
