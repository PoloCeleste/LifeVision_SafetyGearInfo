import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;

public class SafetyInfo_NP extends JFrame{
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
	private String[] SafetyGear = {"सुरक्षा हेलमेट", "माथिल्लो शरीर प्रकार सुरक्षा ब्रेसेस", "बेल्ट प्रकार सुरक्षा ब्रेसेस", "धुलो मास्क", "ग्यास मास्क", "ध्वनि प्रतिरोधी उपकरण", "सुरक्षा जुत्ता"};
	private String[] name = {"Helmet", "ChestBelt", "WaistBelt", "DustMask", "GasMask", "Ear", "Shoes"};
	private JComboBox<String> strCombo = new JComboBox<String>(SafetyGear);
	private ImageIcon GearImage = new ImageIcon(getClass().getClassLoader().getResource(name[0]+"_NP.png"));
	ImageIcon Logo = new ImageIcon(getClass().getClassLoader().getResource("Logo.png"));
	Image lo = Logo.getImage();
	public SafetyInfo_NP(){
		setTitle("सुरक्षा गियर कसरी लगाउने");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		setIconImage(lo);
		JToolBar toolBar = new JToolBar("Menu");
		toolBar.setBackground(Color.LIGHT_GRAY);
		
		JLabel imgLabel = new JLabel(GearImage);
		imgLabel.setBounds(10, 80, 1245, 890);
		JButton ext = new JButton("बन्द गर्नुहोस्");
		ext.setFont(new Font("Mangal", Font.PLAIN, 30));
		
		UIManager.put("ToolTip.font", new Font("Mangal", Font.BOLD, 20));
		JButton lang = new JButton("पछाडी जाउ");
		lang.setFont(new Font("Mangal", Font.PLAIN, 30));
		strCombo.setFont(new Font("Mangal", Font.PLAIN, 30));
		strCombo.setToolTipText("कृपया सुरक्षा गियर चयन गर्नुहोस्।");
		lang.setToolTipText("भाषा चयन स्क्रिनमा फर्कनुहोस्।");
		ext.setToolTipText("प्रक्रिया बन्द गर्नुहोस्");
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
				GearImage= new ImageIcon(getClass().getClassLoader().getResource(name[index]+"_NP.png"));
				imgLabel.setIcon(GearImage);
			}
		});
		
		setSize(1280,1024);
		setVisible(true);
		loadAudio("NP.wav");
		
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