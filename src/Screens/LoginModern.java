package Screens;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.sql.*;
import java.awt.Image;
import java.beans.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static Screens.ConnectionSingletonClass.connection;
import javax.swing.ImageIcon;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.System.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static Screens.ConnectionSingletonClass.connection;




public class LoginModern extends JFrame implements ActionListener  {
    MyTextField usernameTextField;
    MyPasswordTextField passwordTextField;

    MyTextField usernameTextField2;
    MyTextField eamilTextField2;
    MyPasswordTextField passwordTextField2;
    MyTextField phoneTextField2;

    JButton loginBtn;
    JButton loginBtn2;
    static int id;
    static String user;
        
         

    public LoginModern(){
        
        setUndecorated(true);
        setSize(800,500);
        setLocationRelativeTo(null);
        uiInterfaces();
        setVisible(true);
        
        

    }

    void uiInterfaces(){
        JPanel main_panel=new JPanel(new GridLayout(1,2));

        // left panel
        JPanel left_panel=new JPanel(new BorderLayout());
        left_panel.setBackground(new Color(4, 106, 108));

        JLabel logo = new JLabel(new ImageIcon(new ImageIcon("D:\\Grade 3\\Semester 1\\Projects\\home& about us\\src\\javaapplication1\\color logo.png").getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT)));
        JLabel logoo = new JLabel(new ImageIcon(new ImageIcon("D:\\Grade 3\\Semester 1\\Projects\\home& about us\\src\\javaapplication1\\loading raven.gif").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT)));

 //       logo.setIcon((Icon) logoo);
//        logo.setText("WELCOME");
//        logo.setForeground(Color.white);
//        logo.setFont(new Font(Font.DIALOG,Font.BOLD,30));
          logo.setHorizontalTextPosition(JLabel.CENTER);
          logo.setVerticalTextPosition(JLabel.BOTTOM);
          logoo.setHorizontalTextPosition(JLabel.CENTER);
          logoo.setVerticalTextPosition(JLabel.BOTTOM);
          left_panel.add(logo,BorderLayout.CENTER);
          left_panel.add(logoo,BorderLayout.SOUTH);



        //right panel
        JPanel replaceAplePane=new JPanel(new CardLayout());

        JPanel right_panel=new JPanel(new BorderLayout());
        
        JPanel xClosePanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel closeBtn = new JLabel("X");
        closeBtn.setBackground(new Color(4, 106, 108));
        closeBtn.setForeground(Color.white);
        closeBtn.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
        closeBtn.setOpaque(true);
        closeBtn.setHorizontalAlignment(JLabel.CENTER);
        closeBtn.setPreferredSize(new Dimension(30,30));

        closeBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //System.out.println("Mohamed");
                System.exit(0);
                // super.mouseClicked(e);
            }
        });

        xClosePanel.add(closeBtn);
        right_panel.add(xClosePanel,BorderLayout.NORTH);

        //====================================================================
        // for login  components :-
        JPanel signUpCompPanel = new JPanel(new BorderLayout());
        JLabel signUpLabel=new JLabel("Sign In");
        signUpLabel.setHorizontalAlignment(JLabel.CENTER);
        signUpLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,27));
        signUpLabel.setPreferredSize(new Dimension(getWidth(),80));
        signUpCompPanel.add(signUpLabel,BorderLayout.NORTH);

        //username and password
        JPanel usernamePassword=new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel usernameJLabel=new JLabel("User name");
        usernameJLabel.setPreferredSize(new Dimension(200,20));
        usernameTextField = new MyTextField();
        // User name with custom text field suffix , prefix icon and hint text
        usernameTextField=new MyTextField("Enter user name : ");
        usernameTextField.setPrefixIcon(new ImageIcon("D:\\Grade 3\\Semester 1\\Projects\\home& about us\\src\\javaapplication1\\user.png"));
        usernameTextField.setPreferredSize(new Dimension(200,30));

        usernamePassword.add(usernameJLabel);
        usernamePassword.add(usernameTextField);


        JLabel passwordJLabel=new JLabel("Password");
        passwordJLabel.setPreferredSize(new Dimension(200,20));
        passwordTextField = new MyPasswordTextField();
        // password with custom text field suffix , prefix icon and hint text
        passwordTextField= new MyPasswordTextField("Enter user passcode : ");
        passwordTextField.setPrefixIcon(new ImageIcon("D:\\Grade 3\\Semester 1\\Projects\\home& about us\\src\\javaapplication1\\pass.png"));
        ImageIcon i2=new ImageIcon("D:\\Grade 3\\Semester 1\\Projects\\home& about us\\src\\javaapplication1\\closed eye.png");
        passwordTextField.setSuffixIcon(i2);
        ImageIcon i1=new ImageIcon("D:\\Grade 3\\Semester 1\\Projects\\home& about us\\src\\javaapplication1\\eye.png");
        passwordTextField.setSuffixIcon(i1);
        passwordTextField.setPreferredSize(new Dimension(200,30));
        
        passwordTextField.addMouseListener(new MouseAdapter()  
        {   
            public void mouseClicked(MouseEvent e){  
                if (passwordTextField.getSuffixIcon()== i1){
                    passwordTextField.setSuffixIcon(i2);
                     passwordTextField.setEchoChar((char) 0);
                }
                else {
                    passwordTextField.setSuffixIcon(i1);
                    passwordTextField.setEchoChar('*');
                } 
                      
            }  
        });
        
        
        

        usernamePassword.add(passwordJLabel);
        usernamePassword.add(passwordTextField);

        signUpCompPanel.add(usernamePassword);


        right_panel.add(signUpCompPanel);



        //right panel for sign up

        JPanel right_panel2=new JPanel(new BorderLayout());

        JPanel xClosePanel2=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel closeBtn2 = new JLabel("X");
        closeBtn2.setBackground(new Color(4, 106, 108));
        closeBtn2.setForeground(Color.white);
        closeBtn2.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
        closeBtn2.setOpaque(true);
        closeBtn2.setHorizontalAlignment(JLabel.CENTER);
        closeBtn2.setPreferredSize(new Dimension(30,30));


        xClosePanel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //System.out.println("Mohamed");
                System.exit(0);
                // super.mouseClicked(e);
            }
        });


        xClosePanel2.add(closeBtn2);
        right_panel2.add(xClosePanel2,BorderLayout.NORTH);

        //====================================================================
        // for Sign up  components :-
        JPanel signUpCompPanel2 = new JPanel(new BorderLayout());
        JLabel signUpLabel2=new JLabel("Sign up");
        signUpLabel2.setHorizontalAlignment(JLabel.CENTER);
        signUpLabel2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,27));
        signUpLabel2.setPreferredSize(new Dimension(getWidth(),80));
        signUpCompPanel2.add(signUpLabel2,BorderLayout.NORTH);

        //username and password
        JPanel usernamePassword2=new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel usernameJLabel2=new JLabel("User name");
        usernameJLabel2.setPreferredSize(new Dimension(200,20));
        usernameTextField2 = new MyTextField();
//        // User name with custom text field suffix , prefix icon and hint text
        usernameTextField2=new MyTextField("Enter user name : ");
        usernameTextField2.setPrefixIcon(new ImageIcon("D:\\Grade 3\\Semester 1\\Projects\\home& about us\\src\\javaapplication1\\user.png"));
        usernameTextField2.setPreferredSize(new Dimension(200,25));

        usernamePassword2.add(usernameJLabel2);
        usernamePassword2.add(usernameTextField2);
        
        
        
        

        //usernamePassword2.(new ImageIcon(getClass().getResource("")));

        JLabel passwordJLabel2=new JLabel("Password");
        passwordJLabel2.setPreferredSize(new Dimension(200,20));
        passwordTextField2 = new MyPasswordTextField();
        // password with custom text field suffix , prefix icon and hint text
        passwordTextField2= new MyPasswordTextField("Enter user passcode : ");
        passwordTextField2.setPrefixIcon(new ImageIcon("D:\\Grade 3\\Semester 1\\Projects\\home& about us\\src\\javaapplication1\\pass.png"));        
        passwordTextField2.setSuffixIcon(i2);
        passwordTextField2.setSuffixIcon(i1);
        passwordTextField2.setPreferredSize(new Dimension(200,25));
        passwordTextField2.addMouseListener(new MouseAdapter()  
        {   
            public void mouseClicked(MouseEvent e){  
                if (passwordTextField2.getSuffixIcon()== i1){
                    passwordTextField2.setSuffixIcon(i2);
                     passwordTextField2.setEchoChar((char) 0);
                }
                else {
                    passwordTextField2.setSuffixIcon(i1);
                    passwordTextField2.setEchoChar('*');
                }    
            }  
        });
        
        
        usernamePassword2.add(passwordJLabel2);
        usernamePassword2.add(passwordTextField2);
        
        
        

 //       signUpCompPanel2.add(usernamePassword2);

        JLabel eamilJLabel2=new JLabel("Email");
        eamilJLabel2.setPreferredSize(new Dimension(200,20));
        eamilTextField2 = new MyTextField();
        // User Email with custom text field suffix , prefix icon and hint text
        eamilTextField2=new MyTextField("Enter your Email : ");
        eamilTextField2.setPrefixIcon(new ImageIcon("D:\\Grade 3\\Semester 1\\Projects\\home& about us\\src\\javaapplication1\\mail.png"));
        eamilTextField2.setPreferredSize(new Dimension(200,25));

        usernamePassword2.add(eamilJLabel2);
        usernamePassword2.add(eamilTextField2);

        JLabel phoneJLabel2=new JLabel("Phone");
        phoneJLabel2.setPreferredSize(new Dimension(200,20));
        phoneTextField2 = new MyTextField();
        // User Email with custom text field suffix , prefix icon and hint text
        phoneTextField2=new MyTextField("Enter your phone number : ");
        phoneTextField2.setPrefixIcon(new ImageIcon("D:\\Grade 3\\Semester 1\\Projects\\home& about us\\src\\javaapplication1\\phone 1.png"));
        phoneTextField2.setPreferredSize(new Dimension(200,25));

        usernamePassword2.add(phoneJLabel2);
        usernamePassword2.add(phoneTextField2);

        signUpCompPanel2.add(usernamePassword2);

        right_panel2.add(signUpCompPanel2);


        // login button
/*
        JPanel loginBtnPane=new JPanel(new FlowLayout(FlowLayout.CENTER));
        loginBtnPane.setPreferredSize(new Dimension(getWidth(),100));
        JButton loginBtn = new JButton("Login");

        loginBtn.setPreferredSize(new Dimension(130,30));
        loginBtnPane.add(loginBtn);
        loginBtn.setForeground(new Color(2, 85, 246));
        loginBtn.setContentAreaFilled(false);
        loginBtn.setBorder(BorderFactory.createLineBorder(new Color(2, 85, 246),1,true));
*/

        JPanel loginBtnPane=new JPanel(new FlowLayout(FlowLayout.CENTER,100,20));
        loginBtnPane.setPreferredSize(new Dimension(getWidth(),150));
        loginBtn = new JButton("Login");

        loginBtn.setPreferredSize(new Dimension(130,30));
        loginBtnPane.add(loginBtn);
        loginBtn.setForeground(new Color(4, 106, 108));
        loginBtn.setBackground(new Color(4, 106, 108));
        loginBtn.setContentAreaFilled(false);
        loginBtn.setBorder(BorderFactory.createLineBorder(new Color(4, 106, 108),1,true));
        //add jLablelFor signup
        JLabel haveAnAccoutn = new JLabel(" creat new Account ");
        haveAnAccoutn.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,12));
        haveAnAccoutn.setForeground(new Color(4, 106, 108));

        haveAnAccoutn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("new Account clicked");
                right_panel2.setVisible(true);
                right_panel.setVisible(false);


            }
        });

        loginBtnPane.add(haveAnAccoutn);

        right_panel.add(loginBtnPane,BorderLayout.SOUTH);

        //for sign up account

        JPanel loginBtnPane2=new JPanel(new FlowLayout(FlowLayout.CENTER,100,20));
        loginBtnPane2.setPreferredSize(new Dimension(getWidth(),150));
        loginBtn2 = new JButton("Sign Up");

        loginBtn2.setPreferredSize(new Dimension(130,30));
        loginBtnPane2.add(loginBtn2);
        loginBtn2.setForeground(new Color(4, 106, 108));
        loginBtn2.setContentAreaFilled(false);
        loginBtn2.setBorder(BorderFactory.createLineBorder(new Color(4, 106, 108),1,true));
        //add jLablelFor signup
        JLabel haveAnAccoutn2 = new JLabel(" already have an account, Login In ? ");
        haveAnAccoutn2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,12));
        haveAnAccoutn2.setForeground(new Color(4, 106, 108));



        haveAnAccoutn2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("new Account clicked");
                right_panel.setVisible(true);
                right_panel2.setVisible(false);


            }
        });

        loginBtnPane2.add(haveAnAccoutn2);

        right_panel2.add(loginBtnPane2,BorderLayout.SOUTH);

        replaceAplePane.add(right_panel2);
        replaceAplePane.add(right_panel);

        main_panel.add(left_panel);
        main_panel.add(replaceAplePane);
        /*main_panel.add(right_panel);
        main_panel.add(right_panel2);*/
        add(main_panel);
        loginBtn2.addActionListener(this);
        loginBtn.addActionListener(this);
    }
    public static boolean validate_email(String email) {
        Pattern Epattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher res = Epattern.matcher(email);
        return res.find();
    }
    public static boolean isValidMobileNo(String str) {
        Pattern ptrn = Pattern.compile("\\d{3}\\d{8}");
        Matcher match = ptrn.matcher(str);
        return (match.find() && match.group().equals(str));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() ==loginBtn2){
         try {
            ConnectionSingletonClass.getConnection();
            
            PreparedStatement stst = connection.prepareStatement("insert into  Userr ( UserName, Email, Passwordd) values(?,?,?)");
            
            if(validate_email(eamilTextField2.getText())){
                
            stst.setString(1,usernameTextField2.getText());
            stst.setString(2,eamilTextField2.getText());
            String pw=new String(passwordTextField2.getPassword());
            stst.setString(3,pw);
            } else {
                 
                ImageIcon icon = new ImageIcon("D:\\Grade 3\\Semester 1\\Projects\\home& about us\\src\\javaapplication1\\errorr.png");
                JOptionPane.showMessageDialog(null, "Invalid Email", 
                "ERROR!", JOptionPane.INFORMATION_MESSAGE, icon);
                 
             }
            
            if(!isValidMobileNo(phoneTextField2.getText())){
                ImageIcon icon = new ImageIcon("D:\\Grade 3\\Semester 1\\Projects\\home& about us\\src\\javaapplication1\\errorr.png");
                JOptionPane.showMessageDialog(null, "Invalid Phone number", 
                "ERROR!", JOptionPane.INFORMATION_MESSAGE, icon);
                
            }
            
            
            
            stst.executeUpdate();
            
          
            
            
            
            
            //PreparedStatement stst2 = connection.prepareStatement("insert into  User_Phone ( Phone) values(?)  ");
            //stst2.setInt(1,12);
            //stst2.setString(1,phoneTextField2.getText());
            //stst2.executeUpdate();
            
            
            //PreparedStatement stst5 = connection.prepareStatement("select UserID from User_Phone where phone=? " );
            ////"select UserID from Userr where UserName = ? "
            //stst5.setString(1,phoneTextField2.getText());
            //stst5.setInt(2,12);
            
            //ResultSet rs= stst5.executeQuery();
            //System.out.println(rs.getString(1));
            //while(rs.next()){
              //  System.out.println(rs.getInt(1));
            
            //}
            //System.out.print(HomePage.R_id);

            
            
        } catch (SQLException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        if(e.getSource() ==loginBtn) {
           
            //"insert into product (product, user_id) select product, u.user_id from user u where u.user_id = 2");
            
            try {
            ConnectionSingletonClass.getConnection();
            
            PreparedStatement stst3 = connection.prepareStatement("select UserName,Passwordd from Userr WHERE UserName =? AND Passwordd =?");
     
            stst3.setString(1, usernameTextField.getText());
            user = usernameTextField.getText();
           // System.out.print(user);
            String pw2=new String(passwordTextField.getPassword());
            char[] pass= passwordTextField.getPassword();
            stst3.setString(2, pw2);
            ResultSet r= stst3.executeQuery();
            
            
            //ResultSet rs= stst.executeQuery();
            //id=rs.getInt(1);
            
            
             
            PreparedStatement stst4 = connection.prepareStatement("select UserID from Userr where UserName = ? " );
            
            stst4.setString(1, usernameTextField.getText());
            
            ResultSet rs= stst4.executeQuery();
            //System.out.println(rs.getString(1));
            while(rs.next()){
                
                System.out.println(rs.getInt(1));
                id= rs.getInt(1);
            }
            
            
            
            // PreparedStatement stst3 = connection.prepareStatement("insert into Loginn (UserName,Passwordd,UserID) "
             //       + "values(user,pass,id) ");
                                                
            
            
             if(r.next())
            {
                
                new HomePage().setVisible(true);
            }
             else {
                 
                ImageIcon icon = new ImageIcon("D:\\Grade 3\\Semester 1\\Projects\\home& about us\\src\\javaapplication1\\errorr.png");
                JOptionPane.showMessageDialog(null, "Incorrect username or passweod", 
                "ERROR!", JOptionPane.INFORMATION_MESSAGE, icon);
                 
             }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        }
        
        
    }

    }

