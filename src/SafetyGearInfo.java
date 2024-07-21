import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SafetyGearInfo extends JFrame{
	private JLabel Lbl = new JLabel("Language Select");
	ImageIcon Logo = new ImageIcon(getClass().getClassLoader().getResource("Logo.png"));
	ImageIcon exit = new ImageIcon(getClass().getClassLoader().getResource("power.png"));
	Image lo = Logo.getImage();
	ImageIcon CNicon = new ImageIcon(getClass().getClassLoader().getResource("CN.png"));ImageIcon CN_Picon = new ImageIcon(getClass().getClassLoader().getResource("CN_Pr.png"));
	ImageIcon ENicon = new ImageIcon(getClass().getClassLoader().getResource("EN.png"));ImageIcon EN_Picon = new ImageIcon(getClass().getClassLoader().getResource("EN_Pr.png"));
	ImageIcon IDicon = new ImageIcon(getClass().getClassLoader().getResource("ID.png"));ImageIcon ID_Picon = new ImageIcon(getClass().getClassLoader().getResource("ID_Pr.png"));
	ImageIcon KHicon = new ImageIcon(getClass().getClassLoader().getResource("KH.png"));ImageIcon KH_Picon = new ImageIcon(getClass().getClassLoader().getResource("KH_Pr.png"));
	ImageIcon KRicon = new ImageIcon(getClass().getClassLoader().getResource("KR.png"));ImageIcon KR_Picon = new ImageIcon(getClass().getClassLoader().getResource("KR_Pr.png"));
	ImageIcon MMicon = new ImageIcon(getClass().getClassLoader().getResource("MM.png"));ImageIcon MM_Picon = new ImageIcon(getClass().getClassLoader().getResource("MM_Pr.png"));
	ImageIcon NPicon = new ImageIcon(getClass().getClassLoader().getResource("NP.png"));ImageIcon NP_Picon = new ImageIcon(getClass().getClassLoader().getResource("NP_Pr.png"));
	ImageIcon THicon = new ImageIcon(getClass().getClassLoader().getResource("TH_L.png"));ImageIcon TH_Picon = new ImageIcon(getClass().getClassLoader().getResource("TH_L_Pr.png"));
	
	public SafetyGearInfo(){
		setTitle("안전 장구류 착용법 가이드");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		setIconImage(lo);
		
		UIManager.put("ToolTip.font", new Font("긱블말랑이", Font.BOLD, 20));
		JButton ext = new JButton(exit);
		ext.setFont(new Font("Airal", Font.PLAIN, 10));
		ext.setBounds(1180, 30, 50, 53);
		ext.setContentAreaFilled(false);
		ext.setBorderPainted(false);
		ext.setToolTipText("EXIT");
		
		Lbl.setFont(new Font("긱블말랑이", Font.PLAIN, 40));
		Lbl.setBounds(470, 40, 380, 60);
		
		JButton btn_EN = new JButton(ENicon);
		btn_EN.setPressedIcon(EN_Picon);
		btn_EN.setBorderPainted(false);
		btn_EN.setContentAreaFilled(false);
		btn_EN.setBounds(15, 160, 300, 196);
		JButton btn_ID = new JButton(IDicon);
		btn_ID.setPressedIcon(ID_Picon);
		btn_ID.setBorderPainted(false);
		btn_ID.setContentAreaFilled(false);
		btn_ID.setBounds(325, 160, 300, 196);		
		JButton btn_KH = new JButton(KHicon);
		btn_KH.setPressedIcon(KH_Picon);
		btn_KH.setBorderPainted(false);
		btn_KH.setContentAreaFilled(false);
		btn_KH.setBounds(635, 160, 300, 196);
		JButton btn_KR = new JButton(KRicon);
		btn_KR.setPressedIcon(KR_Picon);
		btn_KR.setBorderPainted(false);
		btn_KR.setContentAreaFilled(false);
		btn_KR.setBounds(945, 160, 300, 196);
		JButton btn_MM = new JButton(MMicon);
		btn_MM.setPressedIcon(MM_Picon);
		btn_MM.setBorderPainted(false);
		btn_MM.setContentAreaFilled(false);
		btn_MM.setBounds(15, 380, 300, 196);
		JButton btn_NP = new JButton(NPicon);
		btn_NP.setPressedIcon(NP_Picon);
		btn_NP.setBorderPainted(false);
		btn_NP.setContentAreaFilled(false);
		btn_NP.setBounds(325, 380, 300, 196);
		JButton btn_TH = new JButton(THicon);
		btn_TH.setPressedIcon(TH_Picon);
		btn_TH.setBorderPainted(false);
		btn_TH.setContentAreaFilled(false);
		btn_TH.setBounds(635, 380, 300, 196);
		JButton btn_CN = new JButton(CNicon);
		btn_CN.setPressedIcon(CN_Picon);
		btn_CN.setBorderPainted(false);
		btn_CN.setContentAreaFilled(false);
		btn_CN.setBounds(945, 380, 300, 196);
		
		c.add(Lbl);c.add(ext);
		c.add(btn_CN);c.add(btn_EN);
		c.add(btn_ID);c.add(btn_KH);
		c.add(btn_KR);c.add(btn_MM);
		c.add(btn_NP);c.add(btn_TH);
		
		setSize(1280, 720);
		setVisible(true);
		
		btn_CN.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        new SafetyInfo_CN();
		        setVisible(false);
		    }
		});
		btn_EN.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        new SafetyInfo_EN();
		        setVisible(false);
		    }
		});
		btn_ID.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        new SafetyInfo_ID();
		        setVisible(false);
		    }
		});
		btn_KH.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        new SafetyInfo_KH();
		        setVisible(false);
		    }
		});
		btn_KR.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        new SafetyInfo_KR();
		        setVisible(false);
		    }
		});
		btn_MM.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        new SafetyInfo_MM();
		        setVisible(false);
		    }
		});
		btn_NP.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        new SafetyInfo_NP();
		        setVisible(false);
		    }
		});
		btn_TH.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        new SafetyInfo_TH();
		        setVisible(false);
		    }	
		});
		ext.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	System.exit(0);
		    }
		});
	}
	public static void main(String[] args) {
		new SafetyGearInfo();
	}
}
