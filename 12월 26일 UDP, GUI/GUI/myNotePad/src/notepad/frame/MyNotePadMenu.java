package notepad.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;

import notepad.event.EditMenuEventHandler;
import notepad.event.FileMenuEventHandler;

public class MyNotePadMenu implements ActionListener{
	// Field
	private JMenuBar menuBar;
	private JPopupMenu popupMenu;
	
	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenu formatMenu;
	private JMenu viewMenu;
	private JMenu helpMenu;

	// 파일메뉴
	private JMenuItem fileNew;
	private JMenuItem fileOpen;
	private JMenuItem fileSave;
	private JMenuItem fileSaveAs;
	private JMenuItem filePageSetup;
	private JMenuItem filePrint;
	private JMenuItem fileExit;

	// 보기메뉴
	private JCheckBoxMenuItem viewStatus;

	// 서식메뉴
	private JMenuItem formatWhiteSpace;
	private JMenuItem formatFont;

	// 도움말 메뉴
	private JMenuItem helpView;
	private JMenuItem helpAbout;

	// 편집메뉴
	private JMenuItem editUndo;
	private JMenuItem editCopy;
	private JMenuItem editCut;
	private JMenuItem editPaste;
	private JMenuItem editDel;
	private JMenuItem editFind;
	private JMenuItem editFindNext;
	private JMenuItem editReplace;
	private JMenuItem editMove;
	private JMenuItem editSelectAll;
	private JMenuItem editDateTime;
	
	private JFrame mainFrame;
	
	public MyNotePadMenu() {
		menuBar = new JMenuBar();

		makeFileMenu();
		makeEditMenu();
		makeFormatMenu();
		makeViewMenu();
		makeHelpMenu();
		
		// 메뉴바에 메뉴 추가
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(formatMenu);
		menuBar.add(viewMenu);
		menuBar.add(helpMenu);
	}

	public MyNotePadMenu(JFrame mainFrame) {
		this();
		this.mainFrame = mainFrame;
	}

	

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	private void makeFileMenu() {
		// 파일메뉴 아이템 생성
		fileNew = new JMenuItem("새로 만들기(N)", KeyEvent.VK_N);
		fileNew.setMnemonic(KeyEvent.VK_N);
		fileNew.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		fileNew.addActionListener(new FileMenuEventHandler(this, mainFrame));
		
		fileOpen = new JMenuItem("열기(O)...");
		fileOpen.setMnemonic(KeyEvent.VK_O);
		fileOpen.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		fileOpen.addActionListener(new FileMenuEventHandler(this, mainFrame));
		
		fileSave = new JMenuItem("저장(S)");
		fileSave.setMnemonic(KeyEvent.VK_S);
		fileSave.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		fileSave.addActionListener(new FileMenuEventHandler(this, mainFrame));
		
		fileSaveAs = new JMenuItem("다른 이름으로 저장(A)...");
		fileSaveAs.setMnemonic(KeyEvent.VK_A);
		fileSaveAs.addActionListener(new FileMenuEventHandler(this, mainFrame));
		
		filePageSetup = new JMenuItem("페이지 설정(U)...");
		filePageSetup.setMnemonic(KeyEvent.VK_U);
		filePageSetup.addActionListener(new FileMenuEventHandler(this, mainFrame));
		
		filePrint = new JMenuItem("인쇄(P)...");
		filePrint.setMnemonic(KeyEvent.VK_P);
		filePrint.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		filePrint.addActionListener(new FileMenuEventHandler(this, mainFrame));
		
		fileExit = new JMenuItem("끝내기(X)");
		fileExit.setMnemonic(KeyEvent.VK_X);
		fileExit.addActionListener(new FileMenuEventHandler(this, mainFrame));

		fileMenu = new JMenu("파일(F)");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		
		fileMenu.add(fileNew);
		fileMenu.add(fileOpen);
		fileMenu.add(fileSave);
		fileMenu.add(fileSaveAs);
		fileMenu.addSeparator(); // 구분선 넣기
		fileMenu.add(filePageSetup);
		fileMenu.add(filePrint);
		fileMenu.addSeparator();
		fileMenu.add(fileExit);
	}

	private void makeEditMenu() {
		// 편집 메뉴 아이템 구성
		editUndo = new JMenuItem("실행 취소(U)");
		editUndo.setMnemonic(KeyEvent.VK_U);
		editUndo.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		editUndo.setEnabled(false);
		editUndo.addActionListener(new EditMenuEventHandler(this, mainFrame));
		
		editCut = new JMenuItem("잘라내기(T)");
		editCut.setMnemonic(KeyEvent.VK_T);
		editCut.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		editCut.setEnabled(false);
		editCut.addActionListener(new EditMenuEventHandler(this, mainFrame));
		
		editCopy = new JMenuItem("복사(C)");
		editCopy.setMnemonic(KeyEvent.VK_C);
		editCopy.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		editCopy.setEnabled(false);
		editCopy.addActionListener(new EditMenuEventHandler(this, mainFrame));
		
		editPaste = new JMenuItem("붙여넣기(P)");
		editPaste.setMnemonic(KeyEvent.VK_P);
		editPaste.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		editPaste.addActionListener(new EditMenuEventHandler(this, mainFrame));
		
		editDel = new JMenuItem("삭제(L)");
		editDel.setMnemonic(KeyEvent.VK_L);
		editDel.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
		editDel.addActionListener(new EditMenuEventHandler(this, mainFrame));
		editDel.setEnabled(false);
		
		editFind = new JMenuItem("찾기(F)...");
		editFind.setMnemonic(KeyEvent.VK_F);
		editFind.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
		editFind.addActionListener(new EditMenuEventHandler(this, mainFrame));
		
		editFindNext = new JMenuItem("다음 찾기(N)");
		editFindNext.setMnemonic(KeyEvent.VK_N);
		editFindNext.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		editFindNext.addActionListener(new EditMenuEventHandler(this, mainFrame));
		
		editReplace = new JMenuItem("바꾸기(R)...");
		editReplace.setMnemonic(KeyEvent.VK_R);		
		editReplace.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		editReplace.addActionListener(new EditMenuEventHandler(this, mainFrame));
				
		editMove = new JMenuItem("이동(G)...");
		editMove.setMnemonic(KeyEvent.VK_G);
		editMove.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
		editMove.addActionListener(new EditMenuEventHandler(this, mainFrame));
		
		editDateTime = new JMenuItem("시간/날짜");
		editDateTime.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		editDateTime.addActionListener(new EditMenuEventHandler(this, mainFrame));
		
		editSelectAll = new JMenuItem("모두 선택(A)");
		editSelectAll.setMnemonic(KeyEvent.VK_A);
		editSelectAll.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		editSelectAll.addActionListener(new EditMenuEventHandler(this, mainFrame));

		editMenu = new JMenu("편집(E)");
		editMenu.setMnemonic(KeyEvent.VK_E);
		
		editMenu.add(editUndo);
		editMenu.addSeparator();
		editMenu.add(editCut);
		editMenu.add(editCopy);
		editMenu.add(editPaste);
		editMenu.add(editDel);
		editMenu.addSeparator();
		editMenu.add(editFind);
		editMenu.add(editFindNext);
		editMenu.add(editReplace);
		editMenu.add(editMove);
		editMenu.addSeparator();
		editMenu.add(editSelectAll);
		editMenu.add(editDateTime);
	}

	private void makeFormatMenu() {
		// 서식 메뉴 아이템 구성
		formatWhiteSpace = new JMenuItem("자동 줄바꿈(W)");
		formatWhiteSpace.setMnemonic(KeyEvent.VK_W);
		formatWhiteSpace.addActionListener(this);
		
		formatFont = new JMenuItem("글꼴(F)...");
		formatFont.setMnemonic(KeyEvent.VK_F);
		formatFont.addActionListener(this);
		
		formatMenu = new JMenu("서식(O)");
		formatMenu.setMnemonic(KeyEvent.VK_O);
		
		formatMenu.add(formatWhiteSpace);
		formatMenu.add(formatFont);
	}

	private void makeViewMenu() {
		// 보기 메뉴 아이템 구성
		viewStatus = new JCheckBoxMenuItem("상태표시줄(S)", false);
		viewStatus.setMnemonic(KeyEvent.VK_S);
		viewStatus.addActionListener(this);
		
		viewMenu = new JMenu("보기(V)");
		viewMenu.setMnemonic(KeyEvent.VK_V);
		
		viewMenu.add(viewStatus);
	}

	private void makeHelpMenu() {
		// 도움말 메뉴 아이템 구성
		helpView = new JMenuItem("도움말 보기(H)");
		helpView.setMnemonic(KeyEvent.VK_H);
		helpView.addActionListener(this);
		
		helpAbout = new JMenuItem("내 메모장 정보(A)");
		helpAbout.setMnemonic(KeyEvent.VK_A);
		helpAbout.addActionListener(this);
		
		helpMenu = new JMenu("도움말(H)");
		helpAbout.setMnemonic(KeyEvent.VK_H);
		
		helpMenu.add(helpView);
		helpMenu.add(helpAbout);
	}
		

	private void makePopupMenu(){
		popupMenu = new JPopupMenu();
		
		popupMenu.add(editUndo);
		popupMenu.addSeparator();
		popupMenu.add(editCopy);
		popupMenu.add(editCut);
		popupMenu.add(editPaste);
		popupMenu.add(editSelectAll);
		
		//popupMenu.addPopupMenuListener(l);
	}
	
	//파일 메뉴 아이템에 대한 getters and setters
	public JMenu getFileMenu() {
		return fileMenu;
	}

	public void setFileMenu(JMenu fileMenu) {
		this.fileMenu = fileMenu;
	}

	public JMenuItem getFileNew() {
		return fileNew;
	}

	public void setFileNew(JMenuItem fileNew) {
		this.fileNew = fileNew;
	}

	public JMenuItem getFileOpen() {
		return fileOpen;
	}

	public void setFileOpen(JMenuItem fileOpen) {
		this.fileOpen = fileOpen;
	}

	public JMenuItem getFileSave() {
		return fileSave;
	}

	public void setFileSave(JMenuItem fileSave) {
		this.fileSave = fileSave;
	}

	public JMenuItem getFileSaveAs() {
		return fileSaveAs;
	}

	public void setFileSaveAs(JMenuItem fileSaveAs) {
		this.fileSaveAs = fileSaveAs;
	}

	public JMenuItem getFilePageSetup() {
		return filePageSetup;
	}

	public void setFilePageSetup(JMenuItem filePageSetup) {
		this.filePageSetup = filePageSetup;
	}

	public JMenuItem getFilePrint() {
		return filePrint;
	}

	public void setFilePrint(JMenuItem filePrint) {
		this.filePrint = filePrint;
	}

	public JMenuItem getFileExit() {
		return fileExit;
	}

	public void setFileExit(JMenuItem fileExit) {
		this.fileExit = fileExit;
	}
	
	public JMenu getEditMenu() {
		return editMenu;
	}

	public void setEditMenu(JMenu editMenu) {
		this.editMenu = editMenu;
	}

	public JMenu getFormatMenu() {
		return formatMenu;
	}

	public void setFormatMenu(JMenu formatMenu) {
		this.formatMenu = formatMenu;
	}

	public JMenuItem getFormatWhiteSpace() {
		return formatWhiteSpace;
	}

	public void setFormatWhiteSpace(JMenuItem formatWhiteSpace) {
		this.formatWhiteSpace = formatWhiteSpace;
	}

	public JMenuItem getFormatFont() {
		return formatFont;
	}

	public void setFormatFont(JMenuItem formatFont) {
		this.formatFont = formatFont;
	}

	public JMenuItem getEditUndo() {
		return editUndo;
	}

	public void setEditUndo(JMenuItem editUndo) {
		this.editUndo = editUndo;
	}

	public JMenuItem getEditCopy() {
		return editCopy;
	}

	public void setEditCopy(JMenuItem editCopy) {
		this.editCopy = editCopy;
	}

	public JMenuItem getEditCut() {
		return editCut;
	}

	public void setEditCut(JMenuItem editCut) {
		this.editCut = editCut;
	}

	public JMenuItem getEditPaste() {
		return editPaste;
	}

	public void setEditPaste(JMenuItem editPaste) {
		this.editPaste = editPaste;
	}

	public JMenuItem getEditDel() {
		return editDel;
	}

	public void setEditDel(JMenuItem editDel) {
		this.editDel = editDel;
	}

	public JMenuItem getEditFind() {
		return editFind;
	}

	public void setEditFind(JMenuItem editFind) {
		this.editFind = editFind;
	}

	public JMenuItem getEditFindNext() {
		return editFindNext;
	}

	public void setEditFindNext(JMenuItem editFindNext) {
		this.editFindNext = editFindNext;
	}

	public JMenuItem getEditReplace() {
		return editReplace;
	}

	public void setEditReplace(JMenuItem editReplace) {
		this.editReplace = editReplace;
	}

	public JMenuItem getEditMove() {
		return editMove;
	}

	public void setEditMove(JMenuItem editMove) {
		this.editMove = editMove;
	}

	public JMenuItem getEditSelectAll() {
		return editSelectAll;
	}

	public void setEditSelectAll(JMenuItem editSelectAll) {
		this.editSelectAll = editSelectAll;
	}

	public JMenuItem getEditDateTime() {
		return editDateTime;
	}

	public void setEditDateTime(JMenuItem editDateTime) {
		this.editDateTime = editDateTime;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 각 메뉴 아이템을 클릭했을 때의 동작 처리 구현
		JMenuItem selectItem = (JMenuItem)e.getSource();
				
		if(selectItem == helpAbout){
			JOptionPane.showMessageDialog(mainFrame, "내 메모장 V.1.0");
		}
	}
}
