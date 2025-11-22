
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagementSystem extends JFrame implements ActionListener{
    private JLabel titleLabel, nameLabel, cityLabel, DOBLabel, emailLabel, AdharLabel, genderLabel, roomTypeLabel, roomNumberLabel, checkInLabel, checkOutLabel,totalDayLabel;
    private JRadioButton maleRadio,femaleRadio;
    private ButtonGroup bg1;
    private JTextField nameField, cityField, DOBField, emailField, AdharField, checkInField, checkOutField,totalDayField;
    private JComboBox<String> roomTypeComboBox, roomNumberComboBox;
    private JButton bookButton, cancleButton;

  private JButton saveButton;



    public HotelManagementSystem() {
        setTitle("Hotel Reservation System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        Color sky=new Color(135,206,235); 
        getContentPane().setBackground(sky);

        Font MyFont = new Font("Times New Roman", Font.BOLD, 20);
        Font FontForTitle = new Font("Bodoni MT Black", Font.BOLD, 35);
        Font FontForButton = new Font("Bodoni MT Black", Font.BOLD | Font.ITALIC, 22);     
        

        titleLabel = new JLabel("Hotel Management System");
        nameLabel = new JLabel("Guest Name:");
        nameField = new JTextField();
        cityLabel = new JLabel("Guest City:");
        cityField = new JTextField();
        DOBLabel = new JLabel("DOB:");
        DOBField = new JTextField();
        emailLabel = new JLabel("Email:");
        emailField = new JTextField();   
        AdharLabel = new JLabel("Adhar No:");
        AdharField = new JTextField();
        genderLabel=new JLabel("Gender :");
        maleRadio=new JRadioButton("Male");
        femaleRadio=new JRadioButton("Female");
        bg1=new ButtonGroup();
        roomTypeLabel = new JLabel("Room Type:");
        String[] roomTypes = {"","Single", "Double", "Suite", "Family" };
        roomTypeComboBox = new JComboBox<>(roomTypes);
        roomNumberLabel = new JLabel("Room Number :");
        String[] roomNumber = { "","101", "102", "103", "104", "105" };
        roomNumberComboBox = new JComboBox(roomNumber);
        checkInLabel = new JLabel("Check-In Date:");
        checkInField = new JTextField();
        checkOutLabel = new JLabel("Check-Out Date:");
        checkOutField = new JTextField();
        totalDayLabel=new JLabel("Total Days :");
        totalDayField=new JTextField();
        bookButton = new JButton("Book");
        cancleButton = new JButton("Cancle");
        saveButton = new JButton("Save");

               
        
        titleLabel.setFont(FontForTitle);
        nameLabel.setFont(MyFont);
        nameField.setFont(MyFont);
        cityLabel.setFont(MyFont);
        cityField.setFont(MyFont);
        DOBLabel.setFont(MyFont);
        DOBField.setFont(MyFont);
        emailLabel.setFont(MyFont);
        emailField.setFont(MyFont);
        AdharLabel.setFont(MyFont);
        AdharField.setFont(MyFont);
        genderLabel.setFont(MyFont);
        maleRadio.setFont(MyFont);
        femaleRadio.setFont(MyFont);
        checkInLabel.setFont(MyFont);
        checkInField.setFont(MyFont);
        checkOutLabel.setFont(MyFont);
        checkOutField.setFont(MyFont);
        totalDayLabel.setFont(MyFont);
        totalDayField.setFont(MyFont);
        roomTypeLabel.setFont(MyFont);
        roomTypeComboBox.setFont(MyFont);
        roomNumberLabel.setFont(MyFont);
        roomNumberComboBox.setFont(MyFont);
        bookButton.setFont(FontForButton);
        cancleButton.setFont(FontForButton);
        saveButton.setFont(FontForButton);

        nameField.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        cityField.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        DOBField.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        emailField.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        AdharField.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        maleRadio.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        femaleRadio.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        roomNumberComboBox.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        roomTypeComboBox.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        checkInField.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        checkOutField.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        totalDayField.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        bookButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        cancleButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        saveButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        maleRadio.setOpaque(false);
        femaleRadio.setOpaque(false);
 
        

        bookButton.setBackground(Color.pink);
        cancleButton.setBackground(Color.pink);
        saveButton.setBackground(Color.pink);

        titleLabel.setBounds(600, 60, 700, 40);
        nameLabel.setBounds(650, 160, 150, 30);
        nameField.setBounds(810, 160, 200, 30);
        cityLabel.setBounds(650, 210, 150, 30);
        cityField.setBounds(810, 210, 200, 30);
        DOBLabel.setBounds(650, 260, 150, 30);
        DOBField.setBounds(810, 260, 200, 30);
        emailLabel.setBounds(650, 310, 150, 30);
        emailField.setBounds(810, 310, 200, 30);
        AdharLabel.setBounds(650, 360, 150, 30);
        AdharField.setBounds(810, 360, 200, 30);
        genderLabel.setBounds(650, 410, 150, 30);
        maleRadio.setBounds(810, 410, 90, 30);
        femaleRadio.setBounds(920, 410, 90, 30);
        checkInLabel.setBounds(650, 460, 150, 30);
        checkInField.setBounds(810, 460, 200, 30);
        checkOutLabel.setBounds(650, 510, 150, 30);
        checkOutField.setBounds(810, 510, 200, 30);
        totalDayLabel.setBounds(650, 560, 150, 30);
        totalDayField.setBounds(810, 560, 200, 30);
        roomTypeLabel.setBounds(650, 610, 150, 30);
        roomTypeComboBox.setBounds(810, 610, 200, 30);
        roomNumberLabel.setBounds(650, 660, 150, 30);
        roomNumberComboBox.setBounds(810, 660, 200, 30);
        bookButton.setBounds(670, 740, 150, 30);
        cancleButton.setBounds(840, 740, 150, 30);
        saveButton.setBounds(1000, 740, 150, 30);

        bookButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {

                String name = nameField.getText();
                String City = cityField.getText();
                String DOB = DOBField.getText();
                String email = emailField.getText();
                String adhar = AdharField.getText();
                String Gender=maleRadio.isSelected()?"Male":"Female";
                String checkInDate = checkInField.getText();
                String checkOutDate = checkOutField.getText();
                String totalDays = totalDayField.getText();
                String roomType = (String) roomTypeComboBox.getSelectedItem();            
                String roomNumber = (String) roomNumberComboBox.getSelectedItem();

                JOptionPane.showMessageDialog(null,
                        "========================\n" +
                        "   Hotel Management System   " + "\n" +                       
                        "========================\n" +
                        "   Booking Successful...!    \n" +
                        "------------------------------------------\n" +                       
                                "Name: " + name + "\n" +
                                "City: " + City + "\n" +
                                "DOB: " + DOB + "\n" +
                                "Email: " + email + "\n" +
                                "Adhar: " + adhar + "\n" +
                                "Gender: " + Gender + "\n" +
                                "Check-In Date: " + checkInDate + "\n" +
                                "Check-Out Date: " + checkOutDate + "\n" +
                                "Total days : " + totalDays + "\n" +
                                "Room Type: " + roomType + "\n" +
                                "Room Number: " + roomNumber + "\n" +
                                "...................................................\n" +
                                ".........   Have a nice day!   ........\n" +
                                "...................................................\n");

            }
        });

      cancleButton.addActionListener(new ActionListener() {
       
            public void actionPerformed(ActionEvent e){

                nameField.setText("");
                cityField.setText("");
                DOBField.setText("");
                emailField.setText("");
                AdharField.setText("");
                bg1.clearSelection();
                checkInField.setText("");
                checkOutField.setText("");
                totalDayField.setText("");
                roomTypeComboBox.setSelectedIndex(0);
                roomNumberComboBox.setSelectedIndex(0);
                
            }
        }); 

           
      
           

            
        add(titleLabel);
        add(nameLabel);
        add(nameField);
        add(cityLabel);
        add(cityField);
        add(DOBLabel);
        add(DOBField);
        add(emailLabel);
        add(emailField);
        add(AdharLabel);
        add(AdharField);
        add(genderLabel);
        add(maleRadio);
        add(femaleRadio);
        bg1.add(maleRadio);
        bg1.add(femaleRadio);
        add(roomTypeLabel);
        add(roomTypeComboBox);
        add(roomNumberLabel);
        add(roomNumberComboBox);
        add(checkInLabel);
        add(checkInField);
        add(checkOutLabel);
        add(checkOutField);
        add(totalDayLabel);
        add(totalDayField);
        add(bookButton);
        add(cancleButton);
        add(saveButton);

        saveButton.addActionListener(this);

        setVisible(true);
    }
     public void actionPerformed(ActionEvent e)
            {
                String s1=nameField.getText();
                String s2=cityField.getText();
                String s3=DOBField.getText();
                String s4=emailField.getText();
                String s5=AdharField.getText();
                String s6=maleRadio.isSelected()?"Male":"Female";
                String s7=checkInField.getText();
                String s8=checkOutField.getText();
                String s9=totalDayField.getText();
                String s10=(String) roomTypeComboBox.getSelectedItem(); 
                String s11=(String) roomNumberComboBox.getSelectedItem(); 

        try
        {
		
            Class.forName("com.mysql.jdbc.Driver");         
            String db_name = "aman"; 
            String username = "root";
            String password = "";
            String jdbc_with_sql = "jdbc:mysql://localhost:3306/"+db_name;
             
            Connection con=DriverManager.getConnection(jdbc_with_sql,username,password);
		    System.out.println("connection established");
		    try {
		    String sql = "insert into hotel(name,city,dob,email,adhar,gender,checkin,checkout,totaldays,roomtype,roomnumber) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, s1);
            pst.setString(2, s2);
            pst.setString(3, s3);
            pst.setString(4, s4);
            pst.setString(5, s5);
            pst.setString(6,s6);
            pst.setString(7, s7);
            pst.setString(8, s8);
            pst.setString(9, s9);
            pst.setString(10, s10);
            pst.setString(11, s11);
            

            pst.execute();
            
            

          JOptionPane.showMessageDialog(null, "Inserted successfully!");
        }
        catch(Exception ex)
        { 
            System.out.println(ex);
        }
          }
        catch(Exception ae)
        {
          JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HotelManagementSystem();
            }
        });
    }
}