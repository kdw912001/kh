package test.calc;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyCalc extends JFrame 
	implements ActionListener{
	private JTextField numberTF;
	private JButton btn0, btn1, btn2, btn3, btn4,
		btn5, btn6, btn7, btn8, btn9;
	private JButton btnPlus, btnMinus, btnMul, btnDiv, 
		btnEqual, btnCls;
	private JPanel btnPan;
	
	private ArrayList<Integer> numberList;
	private ArrayList<Character> opList;
	private String inputValue;
		
	public MyCalc(){
		super("간단 계산기");
		this.setBounds(300, 100, 300, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.setLayout(new BorderLayout(0, 30));
		
		numberList = new ArrayList<Integer>();
		opList = new ArrayList<Character>();
		
		numberTF = new JTextField(20);
		numberTF.setFont(new Font("Arial", Font.BOLD, 36));
		btnPan = new JPanel();
		btnPan.setLayout(new GridLayout(4, 4, 10, 10));
		
		btn0 = new JButton("0");
		btn1 = new JButton("1");
		btn2 = new JButton("2");
		btn3 = new JButton("3");
		btn4 = new JButton("4");
		btn5 = new JButton("5");
		btn6 = new JButton("6");
		btn7 = new JButton("7");
		btn8 = new JButton("8");
		btn9 = new JButton("9");
		btnPlus = new JButton("+");
		btnMinus = new JButton("-");
		btnMul = new JButton("*");
		btnDiv = new JButton("/");
		btnEqual = new JButton("=");
		btnCls = new JButton("cls");
		
		btnPan.add(btn7);
		btnPan.add(btn8);
		btnPan.add(btn9);
		btnPan.add(btnDiv);
		btnPan.add(btn4);
		btnPan.add(btn5);
		btnPan.add(btn6);
		btnPan.add(btnMul);
		btnPan.add(btn1);
		btnPan.add(btn2);
		btnPan.add(btn3);
		btnPan.add(btnMinus);
		btnPan.add(btnCls);
		btnPan.add(btn0);
		btnPan.add(btnEqual);
		btnPan.add(btnPlus);
		
		//컴포넌트에 이벤트감지센서 붙이기
		//컴포넌트레퍼런스.add이벤트Listener(구동할 이벤트클래스 레퍼런스);
		btn0.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		btnPlus.addActionListener(this);
		btnMinus.addActionListener(this);
		btnMul.addActionListener(this);
		btnDiv.addActionListener(this);
		btnEqual.addActionListener(this);
		
		this.add(new JPanel().add(numberTF), BorderLayout.NORTH);
		this.add(btnPan, BorderLayout.CENTER);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// 버튼이 클릭되었을 때의 이벤트를 처리할 메소드임
		String value = numberTF.getText();
		String btnValue = ((JButton)event.getSource()).getText();
				
		value += btnValue;
		numberTF.setText(value);
		
		switch(btnValue){
		case "+":	case "-": 	case "*": 
		case "/": 	numberList.add(Integer.parseInt(inputValue));
				inputValue = null;
				opList.add(btnValue.charAt(0));
				break;
		case "cls": numberList.clear();
				 opList.clear();		
				 inputValue = null;
				 numberTF.setText("");  break;
		case "=": numberList.add(Integer.parseInt(inputValue));
				calculator(); break;
		default: 	if(inputValue == null)
					inputValue = btnValue;
				else
					inputValue += btnValue;
		}
				
	}

	private void calculator() {
		// = 버튼이 눌러졌을 때 계산 처리
		int total = numberList.get(0);
		
		/*System.out.println(numberList);
		System.out.println(opList);*/
		
		for(int i = 0; i < opList.size(); i++){
			if(i + 1 == numberList.size())
				break;
			
			switch(opList.get(i)){
			case '+': total += numberList.get(i + 1);
					break;
			case '-':	total -= numberList.get(i + 1);
					break;
			case '*':	total *= numberList.get(i + 1);
					break;
			case '/': 	total /= numberList.get(i + 1);
					break;
			}
		}
		
		numberTF.setText(numberTF.getText() + total);
		
	}
}






