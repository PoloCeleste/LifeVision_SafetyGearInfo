import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;

public class SafetyInfo_TH extends JFrame{
	private Clip clip;
	private void loadAudio(String pathName) { 
		try {
			clip = AudioSystem.getClip();
			InputStream is = ClassLoader.getSystemResourceAsStream(pathName);
			InputStream bufferedIn = new BufferedInputStream(is);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn); 
			clip.open(audioStream);
			clip.start();
		}
		catch (LineUnavailableException e) { e.printStackTrace(); }
		catch (UnsupportedAudioFileException e) { e.printStackTrace(); }
		catch (IOException e) { e.printStackTrace(); } 
	}
	private String[] SafetyGear = {"หมวกกันน็อค", "สายรัดนิรภัยประเภทตัวบน", "ประเภทเข็มขัดนิรภัย", "หน้ากากกันฝุ่น", "หน้ากากป้องกันแก๊สพิษ", "อุปกรณ์กันเสียง", "รองเท้าเซฟตี้"};
	private String[] name = {"Helmet", "ChestBelt", "WaistBelt", "DustMask", "GasMask", "Ear", "Shoes"};
	private JComboBox<String> strCombo = new JComboBox<String>(SafetyGear);
	private ImageIcon GearImage = new ImageIcon(getClass().getClassLoader().getResource(name[0]+"_TH.png"));
	ImageIcon Logo = new ImageIcon(getClass().getClassLoader().getResource("Logo.png"));
	Image lo = Logo.getImage();
	public SafetyInfo_TH(){
		setTitle("วิธีการสวมใส่อุปกรณ์ความปลอดภัย");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		setIconImage(lo);
		JToolBar toolBar = new JToolBar("Menu");
		toolBar.setBackground(Color.LIGHT_GRAY);
		
		JLabel imgLabel = new JLabel(GearImage);
		imgLabel.setBounds(10, 80, 1245, 890);
		JButton ext = new JButton("ทางออก");
		ext.setFont(new Font("Angsana New", Font.BOLD, 34));
		
		UIManager.put("ToolTip.font", new Font("Angsana New", Font.BOLD, 24));
		JButton lang = new JButton("กลับ");
		lang.setFont(new Font("Angsana New", Font.BOLD, 34));
		strCombo.setFont(new Font("Angsana New", Font.BOLD, 34));
		strCombo.setToolTipText("กรุณาเลือกอุปกรณ์นิรภัย");
		lang.setToolTipText("กลับไปที่หน้าจอการเลือกภาษา");
		ext.setToolTipText("ปิดกระบวนการ");
		toolBar.addSeparator();toolBar.addSeparator();
		toolBar.add(strCombo);
		toolBar.addSeparator();toolBar.addSeparator();
		toolBar.add(lang);
		toolBar.addSeparator();
		toolBar.add(ext);
		toolBar.addSeparator();
		
		toolBar.setFloatable(false);
		toolBar.setBounds(0,0,1265,70);
		c.add(toolBar);
		c.add(imgLabel);
		
		strCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>)e.getSource();
				int index = cb.getSelectedIndex();
				GearImage= new ImageIcon(getClass().getClassLoader().getResource(name[index]+"_TH.png"));
				imgLabel.setIcon(GearImage);
			}
		});
		
		setSize(1280,1024);
		setVisible(true);
		loadAudio("TH.wav");
		
		ext.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	clip.stop();
		    	System.exit(0);
		    }
		});
		
		lang.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	clip.stop();
		        new SafetyGearInfo();
		        setVisible(false);
		    }
		});
	}
}
