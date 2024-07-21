import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;

public class SafetyInfo_CN extends JFrame{
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
	private String[] SafetyGear = {"安全帽", "鞦韆式安全带", "繫帶式安全带", "防尘口炸", "防毒面具", "隔音護具", "安全鞋"};
	private String[] name = {"Helmet", "ChestBelt", "WaistBelt", "DustMask", "GasMask", "Ear", "Shoes"};
	private JComboBox<String> strCombo = new JComboBox<String>(SafetyGear);
	private ImageIcon GearImage = new ImageIcon(getClass().getClassLoader().getResource(name[0]+"_CN.png"));
	ImageIcon Logo = new ImageIcon(getClass().getClassLoader().getResource("Logo.png"));
	Image lo = Logo.getImage();
	public SafetyInfo_CN(){
		setTitle("安全裝備類佩戴法");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		setIconImage(lo);
		JToolBar toolBar = new JToolBar("Menu");
		toolBar.setBackground(Color.LIGHT_GRAY);
		
		JLabel imgLabel = new JLabel(GearImage);
		imgLabel.setBounds(10, 80, 1245, 890);
		JButton ext = new JButton("結束");
		ext.setFont(new Font("Arial unicode MS", Font.PLAIN, 30));
		
		UIManager.put("ToolTip.font", new Font("Arial unicode MS", Font.BOLD, 20));
		JButton lang = new JButton("後退");
		lang.setFont(new Font("Arial unicode MS", Font.PLAIN, 30));
		strCombo.setFont(new Font("Arial unicode MS", Font.PLAIN, 30));
		strCombo.setToolTipText("請選擇安全設備。");
		lang.setToolTipText("返回語言選擇屏幕。");
		ext.setToolTipText("進程結束");
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
				GearImage= new ImageIcon(getClass().getClassLoader().getResource(name[index]+"_CN.png"));
				imgLabel.setIcon(GearImage);
			}
		});
		
		setSize(1280,1024);
		setVisible(true);
		loadAudio("CN.wav");
		
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