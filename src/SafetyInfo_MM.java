import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;

public class SafetyInfo_MM extends JFrame{
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
	private String[] SafetyGear = {"လုံခြုံရေးဦးထုပ်", "ကိုယ်ထည်အပေါ်ပိုင်း အမျိုးအစား ဘေးကင်းရေး ကြိုးများ", "ခါးပတ်အမျိုးအစား ဘေးကင်းရေး ကြိုးများ", "ဖုန်မှုန့်မျက်နှာဖုံး", "ဓာတ်ငွေ့မျက်နှာဖုံး", "အသံလုံကိရိယာ", "အကာအကွယ်ဖိနပ်"};
	private String[] name = {"Helmet", "ChestBelt", "WaistBelt", "DustMask", "GasMask", "Ear", "Shoes"};
	private JComboBox<String> strCombo = new JComboBox<String>(SafetyGear);
	private ImageIcon GearImage = new ImageIcon(getClass().getClassLoader().getResource(name[0]+"_MM.png"));
	ImageIcon Logo = new ImageIcon(getClass().getClassLoader().getResource("Logo.png"));
	Image lo = Logo.getImage();
	public SafetyInfo_MM(){
		setTitle("ဘေးကင်းရေး ကိရိယာ ဝတ်ဆင်နည်း");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		setIconImage(lo);
		JToolBar toolBar = new JToolBar("Menu");
		toolBar.setBackground(Color.LIGHT_GRAY);
		
		JLabel imgLabel = new JLabel(GearImage);
		imgLabel.setBounds(10, 80, 1245, 890);
		JButton ext = new JButton("ထွက်ပေါက်");
		ext.setFont(new Font("Pyidaungsu", Font.PLAIN, 24));
		
		UIManager.put("ToolTip.font", new Font("Pyidaungsu", Font.BOLD, 20));
		JButton lang = new JButton("ပြန်သွားသည်");
		lang.setFont(new Font("Pyidaungsu", Font.PLAIN, 24));
		strCombo.setFont(new Font("Pyidaungsu", Font.PLAIN, 24));
		strCombo.setToolTipText("ကျေးဇူးပြု၍ ဘေးကင်းရေး ကိရိယာကို ရွေးချယ်ပါ။");
		lang.setToolTipText("ဘာသာစကားရွေးချယ်မှု မျက်နှာပြင်သို့ ပြန်သွားပါ။");
		ext.setToolTipText("လုပ်ငန်းစဉ်ကိုပိတ်ပါ။");
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
				GearImage= new ImageIcon(getClass().getClassLoader().getResource(name[index]+"_MM.png"));
				imgLabel.setIcon(GearImage);
			}
		});
		
		setSize(1280,1024);
		setVisible(true);
		loadAudio("MM.wav");
		
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