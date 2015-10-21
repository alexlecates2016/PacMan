# PacMan

import java.awt.*;
import javax.swing.*;
 
public class Splash extends JWindow {
     
    private int duration;
    JFrame window;
     
    public Splash(int d) {
        duration = d; 
        window=new JFrame("PacMan");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
     
    
    public void showSplash() {
         
        JPanel content = (JPanel)getContentPane();
        content.setBackground(new Color(0,0,0)); 
        int width = 256;
        int height =512;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = 0;
        int y = 20;
        setBounds(x,y,width,height);
         
       
        JLabel label = new JLabel(new ImageIcon("pacman.png"));
        JLabel text = new JLabel
                ("Alex's PacMan", JLabel.CENTER);
        text.setForeground(Color.white);
        text.setFont(new Font("Sans-Serif", Font.BOLD, 16));
        content.add(label, BorderLayout.CENTER);
        content.add(text, BorderLayout.NORTH);
        Color oraRed = new Color(255, 255,255,  255);
        content.setBorder(BorderFactory.createLineBorder(oraRed, 16));
         
        
        setVisible(true);
         
        
        try { Thread.sleep(duration); } catch (Exception e) {}
         
        setVisible(false);
         
    }
     
    public void showSplashAndExit() {
         
        showSplash();
        new PacMan();
        //System.exit(0);

         
    }
     
    public static void main(String[] args) {
         
        
        Splash splashs = new Splash(5000);
 
        
        splashs.showSplashAndExit();
       
         
    }

}

