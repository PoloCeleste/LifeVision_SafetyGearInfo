import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;

public class SafetyInfo_KR extends JFrame{
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
	private String[] SafetyGear = {"안전모", "안전그네식 안전대", "벨트식 안전대", "방진 마스크", "방독 마스크", "방음 보호구", "안전화"};
	private String[] name = {"Helmet", "ChestBelt", "WaistBelt", "DustMask", "GasMask", "Ear", "Shoes"};
	private JComboBox<String> strCombo = new JComboBox<String>(SafetyGear);
	private ImageIcon GearImage = new ImageIcon(getClass().getClassLoader().getResource(name[0]+"_KR.png"));
	ImageIcon Logo = new ImageIcon(getClass().getClassLoader().getResource("Logo.png"));
	Image lo = Logo.getImage();
	public SafetyInfo_KR(){
		setTitle("안전 장구류 착용법");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		setIconImage(lo);
		JToolBar toolBar = new JToolBar("Menu");
		toolBar.setBackground(Color.LIGHT_GRAY);
		
		JLabel imgLabel = new JLabel(GearImage);
		imgLabel.setBounds(10, 80, 1245, 890);
		JButton ext = new JButton("종료");
		ext.setFont(new Font("긱블말랑이", Font.PLAIN, 30));
		
		UIManager.put("ToolTip.font", new Font("긱블말랑이", Font.BOLD, 20));
		JButton lang = new JButton("뒤로가기");
		lang.setFont(new Font("긱블말랑이", Font.PLAIN, 30));
		strCombo.setFont(new Font("긱블말랑이", Font.PLAIN, 30));
		strCombo.setToolTipText("안전 장비를 선택해주세요.");
		lang.setToolTipText("언어 선택 화면으로 돌아갑니다.");
		ext.setToolTipText("종료합니다.");
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
				GearImage= new ImageIcon(getClass().getClassLoader().getResource(name[index]+"_KR.png"));
				imgLabel.setIcon(GearImage);
			}
		});
		
		setSize(1280,1024);
		setVisible(true);
		loadAudio("KR.wav");
		
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