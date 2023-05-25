package Screens;

import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JFrame {
    private JProgressBar jProgressBar;
    private JLabel percentageLabel;
    SplashScreen(){
        setSize(800,500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        uiDesign();
        setVisible(true);
    }

    private void uiDesign() {
        JPanel mainPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanel.setBackground(new Color(4, 106, 100));


        // name of the app label
        JLabel appName=new JLabel("Welcome to Resume Builder App");
        appName.setFont(new Font("serif",Font.PLAIN,40));
        appName.setForeground(new Color(245, 248, 248));
 //       mainPanel.add(appName);

        //circle image
        CircleImage circleImage = new CircleImage();
        circleImage.setPreferredSize(new Dimension(250,200));
        circleImage.setImage(new ImageIcon("D:\\Grade 3\\Semester 1\\Projects\\home& about us\\src\\javaapplication1\\Color logo.png"));


        //gif image
//        JLabel loadlogo = new JLabel(new ImageIcon(new ImageIcon("images/loadingraven.gif").getImage()
//                                 .getScaledInstance(250,200,Image.SCALE_DEFAULT)));



        //percentage label
        JPanel prcentagePanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
        prcentagePanel.setBackground(new Color(4, 106, 100));
        percentageLabel=new JLabel("   100 %");
        percentageLabel.setFont(new Font("sans serif",Font.PLAIN,24));
        percentageLabel.setForeground(Color.white);
        percentageLabel.setPreferredSize(new Dimension(100,100));
        prcentagePanel.add(percentageLabel);

        // JprogressBar
         jProgressBar=new JProgressBar();
         jProgressBar.setForeground(new Color(217, 163, 68, 229));
 //       UIDefaults defaults = new UIDefaults();
        jProgressBar.setPreferredSize(new Dimension(80,40));




        Box verticalBox=Box.createVerticalBox();
        verticalBox.setAlignmentX(Box.CENTER_ALIGNMENT);
        verticalBox.setAlignmentY(Box.CENTER_ALIGNMENT);
        verticalBox.add(Box.createRigidArea(new Dimension(0, 20)));
        verticalBox.add(appName);
        verticalBox.add(Box.createRigidArea(new Dimension(0, 20)));
        verticalBox.add(circleImage);
//        verticalBox.add(loadlogo);
        verticalBox.add(prcentagePanel);
        verticalBox.add(jProgressBar);

        mainPanel.add(verticalBox);

        add(mainPanel,BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        
        
        SplashScreen splashScreen=new SplashScreen();
        splashScreen.jProgressBar.setStringPainted(false);

 //       ConnectionSingletonClass.getConnection();

        try{

            for(int i=0;i<=100;i++){
                Thread.sleep(40);
                splashScreen.percentageLabel.setText("   "+Integer.toString(i)+" %");
                splashScreen.jProgressBar.setValue(i);
            }

            // close current frame and goto loginpage
               splashScreen.dispose();
               
               LoginModern login = new LoginModern();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

}
