package exception.silsub1;

public class CharacterProcess {
	public CharacterProcess() {}
	
	public int countAlpha(String s) throws CharCheckException{
		int count=0;
		
		for(int i=0; i<s.length();i++) {
			if(Character.isWhitespace(s.charAt(i))) { //isWhitespace ���鹮������
				throw new CharCheckException("üũ�� ���ڿ� �ȿ� ���� ������ �� �����ϴ�.");
			}//new ������ ����

			else if(Character.isAlphabetic((int)(s.charAt(i))))
					count++;
			/*else if(s.charAt(i)>='a'&&s.charAt(i)<='z' || s.charAt(i)>='A'&&s.charAt(i)<='Z') {
				count++;}
			 * char c = s.charAt(i);
			 * if(Character.isUpperCase(c) || Character.isLowerCase(c))
			if((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) */
		}
		return count;
	}
}
