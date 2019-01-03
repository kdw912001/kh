package logic.home.view;
import logic.home.model.*;
import java.util.*;

public class Menu {
	static Scanner sc = new Scanner(System.in);
	public static void mainMenu() {
		int no; //�޴���ȣ
		 // ���� Ȯ�� ���� y/n
		do {
			System.out.printf("***** ���α׷��� �⺻ ��� �׽�Ʈ ���α׷� *****\r\n" + 
					"\r\n" + 
					"		1. ���� �׽�Ʈ\r\n" + 
					"		2. �⺻ �ڷ��� �׽�Ʈ\r\n" + 
					"		3. if�� �׽�Ʈ\r\n" + 
					"		4. switch�� �׽�Ʈ\r\n" + 
					"		5. for�� �׽�Ʈ\r\n" + 
					"		6. while�� �׽�Ʈ\r\n" + 
					"		7. do~while�� �׽�Ʈ\r\n" + 
					"		8. break�� �׽�Ʈ\r\n" + 
					"		9. continue�� �׽�Ʈ\r\n" + 
					"		10. static �޼ҵ� ��� �׽�Ʈ\r\n" + 
					"		11. non-static �޼ҵ� ��� �׽�Ʈ\r\n" + 
					"		12. ���α׷� ����\r\n" + 
					"		�޴� ��ȣ �Է� : ");
			no = sc.nextInt();
			switch(no)
			{
			case 1: subVarMenu(); break;
			case 2: subPTypeMenu(); break;
			case 3: subIfMenu(); break;
			case 4: subSwitchMenu(); break;
			case 5: subForMenu(); break;
			case 6: subWhileMenu(); break;
			case 7: subDoWhileMenu(); break;
			case 8: subBreakMenu(); break;
			case 9: subContinueMenu(); break;
			case 10: subStaticMethodMenu(); break;
			case 11: subNonStaticMethodMenu(); break;
			case 12: 
				System.out.print("������ �����Ͻðڽ��ϱ�? (��:y/�ƴϿ�:n:) "); 
				char ch = sc.next().toUpperCase().charAt(0);
				if(ch =='Y') 
					break;
				else 
					mainMenu();
			default:System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է¹ٶ��ϴ�.");
			}
							
				 //���α׷� ����
			/*case 1:	subVarMenu();	break;
			....... ���� ����
			case 12: ���α׷� ���ῡ ���� ó����
			default: �߸��� ��ȣ�� �ԷµǾ��� �� �޴� �ٽ� ��µǰ� ��*/
						
		}while(true);
	}
	public static void subVarMenu() {
		int no;
		
		do {
			System.out.printf("*** ���� �׽�Ʈ �θ޴� ***\r\n" + 
					"\r\n" + 
					"	1. �� �Ż����� ������ ��� ����ϱ�\r\n" + 
					"	2. ��������� Ű����� �Է¹޾� ����ϱ�\r\n" + 
					"	3. �⺻ �ڷ��� ������ �ʱⰪ Ȯ���ϱ�\r\n" + 
					"	4. ���� �޴��� ����\r\n" + 
					"	�޴� ���� : ");
			no = sc.nextInt();
			VariableSample samp = new VariableSample();
			switch(no)
			{
			
			case 1:  samp.myProfile(); break;
			case 2: samp.emplnformation(); break;
			case 3: samp.defaultValue(); break;
			case 4: System.out.println("���� �޴��� ���ư��ϴ�.");
						return;// �����޴��� �ǵ��ư�.
			default:System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է¹ٶ��ϴ�.");
			}
			/*switch(no)
			{
			case 1:	VariableSample Ŭ������ myProfile() ����; break;
			case 2:	VariableSample Ŭ������ empInformation() ����; break;
			case 3:	VariableSample Ŭ������ defaultValue() ����; break;
			case 4:	System.out.println("���� �޴��� ���ư��ϴ�.");
				return;	//���� �޴��� �ǵ��ư�.
			default:	�߸��� �� �Է½� �޴� �ٽ� ��µǰ� ó��
			}*/
		}while(no!=4);
	}
	
	public static void subPTypeMenu(){
		 int no;
		 do {
			 System.out.printf("*** �⺻�ڷ��� �׽�Ʈ �θ޴� ***\r\n" + 
			 		"\r\n" + 
			 		"	1. �⺻�ڷ��� �޸� �Ҵ�ũ�� Ȯ���ϱ�\r\n" + 
			 		"	2. �⺻�ڷ��� ���� �ּҰ�, �ִ밪 ����ϱ�\r\n" + 
			 		"	3. �⺻�ڷ��� ��Ʈ���� Ȯ���ϱ�\r\n" + 
			 		"	4. ���� �޴��� ����\r\n" + 
			 		"	�޴� ���� : ");
			 no=sc.nextInt();
			 PrimitiveTypeSample samp = new PrimitiveTypeSample();
			 switch(no)
				{
				case 1:	samp.typeSize(); break;
				case 2:	samp.minMaxValue(); break;
				case 3:	samp.bitSize(); break;
				case 4:	System.out.println("���� �޴��� ���ư��ϴ�.");
					return;	//���� �޴��� �ǵ��ư�.
				default:System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է¹ٶ��ϴ�.");	
				}
		 }while(no!=4);
	}
	public static void subIfMenu(){
		int no;
		do {
			System.out.print("*** if�� �׽�Ʈ �θ޴� ***\r\n" + 
					"\r\n" + 
					"	1. �� ���� ������ �Է¹޾�, �� ���� ū �� ����ϱ�\r\n" + 
					"	2. �� ���� ������ �Է¹޾�, �� ���� ���� �� ����ϱ�\r\n" + 
					"	3. �� ���� ������ �Է¹޾�, �� ���� ���� ū���� ���� ������ ����ϱ�\r\n" + 
					"	4. �� ���� ������ �Է¹޾�, ¦������ Ȧ������ ����ϱ�\r\n" + 
					"	5. ��,��,�� �� ������ ������ �Է¹޾�, �հ�/���հ� Ȯ���ϱ�\r\n" + 
					"	6. ������ �Է¹޾�, ���� Ȯ���ϱ�\r\n" + 
					"	7. �� ���� ������ �Է¹޾�, ������� 0���� �������� Ȯ���ϱ�\r\n" + 
					"	8. ���� �ϳ��� �Է¹޾�, ����빮������ �ҹ������� ���ڹ������� ��Ÿ�������� Ȯ���ϱ�\r\n" + 
					"	9. ���� �޴��� ����\r\n" + 
					"	�޴� ���� : ");
			no=sc.nextInt();
			IfSample samp = new IfSample();
			
			switch(no)
			{
			case 1:	samp.maxNumber(); break;
			case 2:	samp.minNumber(); break;
			case 3:	samp.ThreeMaxMin(); break;
			case 4:	samp.checkEven(); break;
			case 5:	samp.isPassFail(); break;
			case 6:	samp.scoreGrade(); break;
			case 7:	samp.checkPlusMinusZero(); break;
			case 8:	samp.whatCaracter(); break;
			case 9:	System.out.println("���� �޴��� ���ư��ϴ�.");
				return;	//���� �޴��� �ǵ��ư�.
			default:System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է¹ٶ��ϴ�.");
			}
			
		}while(no!=9);
	}
	public static void subSwitchMenu(){
		int no;
		do {
			System.out.printf("*** switch�� �׽�Ʈ �θ޴� ***\r\n" + 
					"\r\n" + 
					"	1. �� ���� ������ �� ���� ���깮�ڸ� �Է¹޾� ����� ��� Ȯ���ϱ�\r\n" + 
					"	2. �����̸��� ���ڿ��� �Է¹޾�, �� ������ ���� ����ϱ�\r\n" + 
					"	3. ���� �޴��� ����\r\n" + 
					"	�޴� ���� : ");
			no = sc.nextInt();
			SwitchSample samp = new SwitchSample();
			
			switch(no)
			{
			case 1:	samp.calculator(); break;
			case 2:	samp.fruitPrice(); break;
			case 3:	System.out.println("���� �޴��� ���ư��ϴ�.");
				return;	//���� �޴��� �ǵ��ư�.
			default:System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է¹ٶ��ϴ�.");
			}
		}while(no!=3);
				
	}
	public static void subForMenu(){
		int no;
		do {
			System.out.print("*** for�� �׽�Ʈ �θ޴� ***\r\n" + 
					"\r\n" + 
					"	1. 1~10���� �������� �հ� ���ϱ�\r\n" + 
					"	2. 1~100������ ¦������ �հ� ���ϱ�\r\n" + 
					"	3. ���� �ϳ� �Է¹޾�, �� ���� ������ ����ϱ�\r\n" + 
					"	4. �� ���� ������ �Է¹޾�, �� ���� ���� ������ ū �������� �հ� ���ϱ�\r\n" + 
					"	5. �ټ��� ĭ�� �Է¹޾�, �Էµ� �ټ�/ĭ����ŭ ��ǥ���� ����ϱ�\r\n" + 
					"	6. 7�ٿ� 7ĭ�� ��ǥ���� ����ϵ�, �� �ٿ� �ٹ�ȣ�� ���� ĭ�� ���� ����ϱ�\r\n" + 
					"	7. �ټ��� �Է¹޾�, �ﰢ�� ������� ��ǥ���� ����ϱ�(���:�����ﰢ��, ����:���ﰢ��)\r\n" + 
					"	8. ������ 2�ܺ��� 9�ܱ��� ����ϱ�\r\n" + 
					"	9. ���� �޴��� ����\r\n" + 
					"	�޴� ���� : ");
			no = sc.nextInt();
			ForSample fsamp = new ForSample();
			switch(no){
			case 1:	fsamp.sum1To10(); break;
			case 2:	fsamp.sumEven1To100(); break;
			case 3:	fsamp.oneGugudan(); break;
			case 4:	fsamp.sumMinToMax(); break;
			case 5:	fsamp.printStar(); break;
			case 6:	fsamp.printNumberStar(); break;
			case 7:	fsamp.printTriangleStar(); break;
			case 8:	fsamp.guguDan(); break;
			case 9:	System.out.println("���� �޴��� ���ư��ϴ�.");
				return;	//���� �޴��� �ǵ��ư�.
			default:System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է¹ٶ��ϴ�.");
			}
		}while(no!=9);
	}
	public static void subWhileMenu(){
		int no;
		do {
			System.out.printf("");
			no = sc.nextInt();
		}while(no!=);
	}
	public static void subDoWhileMenu(){
		int no;
		do {
			System.out.printf("*** while�� �׽�Ʈ �θ޴� ***\r\n" + 
					"\r\n" + 
					"	1. ���� �ϳ� �Է¹޾�, �� ������ �����ڵ� ��� �ݺ�('0' �ԷµǸ� �ݺ�����)\r\n" + 
					"	2. 1~100���� �������� �հ� ����ϱ�(while ������ �ۼ�)\r\n" + 
					"	3. 1~100������ ������ ������ �߻�����, ���� �˾Ƹ��߱�\r\n" + 
					"	4. ���ڿ��� �Է¹޾�, ���� ���� �˾Ƴ��� ����ϱ�\r\n" + 
					"	5. ���ڿ����� ���� �ϳ��� �Է¹޾�, ���ڿ��� ���ڰ� �� �� �ִ��� Ȯ���ϱ�\r\n" + 
					"	6. ���� �޴��� ����\r\n" + 
					"	�޴� ���� : ");
			no = sc.nextInt();
			switch(no)
			{
			case 1:	WhileSample Ŭ������ printUniCode() ����; break;
			case 2:	WhileSample Ŭ������ sum1To100() ����; break;
			case 3:	WhileSample Ŭ������ numberGame() ����; break;
			case 4:	WhileSample Ŭ������ countCharacter() ����; break;
			case 5:	WhileSample Ŭ������ countInChar() ����; break;
			case 6:	System.out.println("���� �޴��� ���ư��ϴ�.");
				return;	//���� �޴��� �ǵ��ư�.
			default:	�߸��� �� �Է½� �޴� �ٽ� ��µǰ� ó��
			}
		}while(no!=6);
	}
	public static void subBreakMenu(){
		int no;
		do {
			System.out.printf("");
			no = sc.nextInt();
		}while(no!=);
	}
	public static void subContinueMenu(){
		int no;
		do {
			System.out.printf("");
			no = sc.nextInt();
		}while(no!=);
	}
	public static void subStaticMethodMenu(){
		int no;
		do {
			System.out.printf("");
			no = sc.nextInt();
		}while(no!=);
	}
	public static void subNonStaticMethodMenu(){
		int no;
		do {
			System.out.printf("");
			no = sc.nextInt();
		}while(no!=);
	}
}
