import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RekamMedis extends JFrame{
    private JFrame jf;
    private JPanel centerLeft, centerRight, center, south, panelHome;
    private JButton tombollogin;
    private JTextField textUser;
    private JPasswordField textPass;

    public RekamMedis() {
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setTitle("Login Admin");
        jf.setSize(new Dimension(300,200));
        jf.setLayout(new BorderLayout());

        centerLeft = new JPanel(new GridLayout(2,1));
        centerLeft.add(new JLabel("Username: "));
        centerLeft.add(new JLabel("Password: "));

        centerRight = new JPanel(new GridLayout(2,1));
        centerRight.add(textUser);
        centerRight.add(textPass);

        center = new JPanel(new BorderLayout());
        center.add(centerLeft, BorderLayout.WEST);
        center.add(centerRight, BorderLayout.CENTER);

        south = new JPanel(new FlowLayout());
        south.add(tombollogin);

        jf.add(center, BorderLayout.CENTER);
        jf.add(south, BorderLayout.SOUTH);

        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);

        tombollogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rekammedis", "root", "");
                    String a = textUser.getText();
                    char[] b = textPass.getPassword();
                    String query = "SELECT * FROM login WHERE username = ? AND password = ?";
                    PreparedStatement ps = connection.prepareStatement(query);
                    ps.setString(1, a);
                    ps.setString(2, String.valueOf(b));
                    ResultSet rs = ps.executeQuery();

                    String checkUser = rs.getString(1);
                    String checkPass = rs.getString(2);

                    if(rs.next())

                    connection.close();
                }

                catch (Exception err) {
                    System.out.println("ERROR: " + err);
                }
                }
            }
        );
    }
}