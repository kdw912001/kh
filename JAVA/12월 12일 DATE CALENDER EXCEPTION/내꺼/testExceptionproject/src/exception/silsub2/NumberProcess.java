package exception.silsub2;

public class NumberProcess {
	public NumberProcess() {}
	
	public boolean checkDouble(int a, int b) throws NumberRangeException{
		if(!((a>=1&&a<=100)&&(b>=1&&b<=100)))
			throw new NumberRangeException("1���� 100������ ���� �ƴմϴ�");
		
		if(a%b==0)
			return true;
		else
			return false;
	}
	
}
