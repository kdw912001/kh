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
			throw new NumberRangeException("1부터 100사이의 값이 아닙니다.");
	
		return result;
	}
}
