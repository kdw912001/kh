package exception.silsub1;

public class CharacterProcess {
	public CharacterProcess(){}
	
	public int countAlpha(String s) 
			throws CharCheckException{
		int count = 0;
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			
			/*if(Character.isUpperCase(c) || 
					Character.isLowerCase(c))*/
			if((c >= 'A' && c <= 'Z') || 
					(c >= 'a' && c <= 'z'))
				count++;
			
			if(Character.isWhitespace(c)){
				throw new CharCheckException(
				"체크할 문자열 안에 공백 포함할 수 없습니다.");
			}
		}
		
		return count;
	}
}
