import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.sql.*;

public class RekamMedis extends JFrame{
    private JFrame jf;
    private JPanel centerLeft, centerRight, center, southLogin ,northLogin ,panelLogin, panelHome, cardInsert, cardSelect, cardDelete, cardUpdate;
    private JPanel cardInsertNorth, cardInsertSouth, cardInsertLeft, cardInsertRight, cardSelectLeft, cardSelectRight, cardDeleteLeft, cardDeleteRight, cardUpdateLeft, cardUpdateRight;
    private JPanel menuHome, menuHomeNorth, menuHomeCenter, cardUpdateNorth, cardUpdateSouth, cardSelectNorth, cardSelectSouth, cardDeleteNorth, cardDeleteSouth, menuHomeSouth;
    private JScrollPane scroll;
    private JLabel title, titleinsert, titlehome, titleupdate,titledelete, titleselect, listid, listnama, listumur, listberat, listtinggi, listdes;
    private JButton tombollogin,tombollogout, tombolinsert, tombolback, tombolupdate, tomboldelete, menuInsert, menuSelect, menuDelete, menuUpdate, tombolbackselect, tombolbackupdate, tombolbackdelete;
    private JTextField textUser, textNama, textUmur, textBerat, textTinggi, textDes, upId, upNama, upUmur, upBerat, upTinggi, upDeskripsi, delId;
    private JPasswordField textPass;
    private CardLayout cards;

    public RekamMedis() {
        jf = new JFrame();
        panelLogin = new JPanel();
        panelHome = new JPanel();
        textUser = new JTextField();
        textNama = new JTextField();
        textUmur = new JTextField();
        textBerat = new JTextField();
        textTinggi = new JTextField();
        textDes = new JTextField();
        delId = new JTextField();
        upId = new JTextField();
        upNama = new JTextField();
        upUmur = new JTextField();
        upBerat = new JTextField();
        upTinggi = new JTextField();
        upDeskripsi = new JTextField();
        textPass = new JPasswordField();
        tombollogin = new JButton("Login");
        tombollogout = new JButton("Logout");
        tombolinsert = new JButton("Insert");
        tomboldelete = new JButton("Delete");
        tombolback = new JButton("Back");
        tombolbackdelete = new JButton("Back");
        tombolbackselect = new JButton("Back");
        tombolbackupdate = new JButton("Back");
        tombolupdate = new JButton("Update");
        menuInsert = new JButton("Menu Insert");
        menuSelect = new JButton("Menu Select");
        menuDelete = new JButton("Menu Delete");
        menuUpdate = new JButton("Menu Update");
        listid = new JLabel();
        listnama = new JLabel();
        listumur = new JLabel();
        listberat = new JLabel();
        listtinggi = new JLabel();
        listdes = new JLabel();
        cards = new CardLayout();

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setTitle("Rekam Medis");
        jf.setSize(new Dimension(500,150));
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

        southLogin = new JPanel(new FlowLayout());
        southLogin.add(tombollogin);

        title = new JLabel("Silahkan Login...");
        northLogin = new JPanel(new FlowLayout());
        northLogin.add(title);

        panelLogin.setLayout(new BorderLayout());
        panelLogin.add(northLogin, BorderLayout.NORTH);
        panelLogin.add(center, BorderLayout.CENTER);
        panelLogin.add(southLogin, BorderLayout.SOUTH);

        panelHome.setLayout(cards);
        cards.show(panelHome, "Home");

        titlehome = new JLabel("Menu Home");
        menuHomeNorth = new JPanel(new FlowLayout());
        menuHomeNorth.add(titlehome);

        menuHomeCenter = new JPanel(new FlowLayout());
        menuHomeCenter.add(menuInsert);
        menuHomeCenter.add(menuSelect);
        menuHomeCenter.add(menuUpdate);
        menuHomeCenter.add(menuDelete);

        menuHomeSouth = new JPanel(new FlowLayout());
        menuHomeSouth.add(tombollogout);

        menuHome = new JPanel();
        menuHome.setLayout(new BorderLayout());
        menuHome.setBackground(Color.orange);
        menuHome.add(menuHomeNorth, BorderLayout.NORTH);
        menuHome.add(menuHomeCenter, BorderLayout.CENTER);
        menuHome.add(menuHomeSouth, BorderLayout.SOUTH);

        cardInsert = new JPanel();
        cardInsert.setLayout(new BorderLayout());
        cardInsert.setBackground(Color.blue);

        titleinsert = new JLabel("Silahkan Masukkan Data Pasien...");
        cardInsertNorth = new JPanel(new FlowLayout());
        cardInsertNorth.add(titleinsert);

        cardInsertSouth = new JPanel(new FlowLayout());
        cardInsertSouth.add(tombolinsert);
        cardInsertSouth.add(tombolback);

        cardInsertLeft = new JPanel(new GridLayout(5,1));
        cardInsertLeft.add(new JLabel("Nama Pasien: "));
        cardInsertLeft.add(new JLabel("Umur Pasien: "));
        cardInsertLeft.add(new JLabel("Berat Pasien: "));
        cardInsertLeft.add(new JLabel("Tinggi Pasien: "));
        cardInsertLeft.add(new JLabel("Deskripsi: "));

        cardInsertRight = new JPanel(new GridLayout(5,1 ));
        cardInsertRight.add(textNama);
        cardInsertRight.add(textUmur);
        cardInsertRight.add(textBerat);
        cardInsertRight.add(textTinggi);
        cardInsertRight.add(textDes);

        cardInsert.add(cardInsertLeft, BorderLayout.WEST);
        cardInsert.add(cardInsertRight, BorderLayout.CENTER);
        cardInsert.add(cardInsertNorth, BorderLayout.NORTH);
        cardInsert.add(cardInsertSouth, BorderLayout.SOUTH);

        cardSelect = new JPanel();
        cardSelect.setLayout(new BorderLayout());
        cardSelect.setForeground(Color.red);

        titleselect = new JLabel("Tampilan Data Pasien");
        cardSelectNorth = new JPanel(new FlowLayout());
        cardSelectNorth.add(titleselect);

        cardSelectLeft = new JPanel(new GridLayout(6,1));
        cardSelectLeft.add(new JLabel("Id = "));
        cardSelectLeft.add(new JLabel("Nama = "));
        cardSelectLeft.add(new JLabel("Umur = "));
        cardSelectLeft.add(new JLabel("Berat = "));
        cardSelectLeft.add(new JLabel("Tinggi = "));
        cardSelectLeft.add(new JLabel("Deskripsi = "));

        cardSelectRight = new JPanel(new GridLayout(6,1));
        scroll = new JScrollPane();
        scroll.setSize(100,100);
        scroll.getViewport().add(cardSelectRight);
        scroll.setPreferredSize(new Dimension(150,100));
        scroll.setBackground(Color.cyan);
        cardSelectRight.add(listid);
        cardSelectRight.add(listnama);
        cardSelectRight.add(listumur);
        cardSelectRight.add(listberat);
        cardSelectRight.add(listtinggi);
        cardSelectRight.add(listdes);

        cardSelectSouth = new JPanel(new FlowLayout());
        cardSelectSouth.add(tombolbackselect);

        cardSelect.add(cardSelectLeft, BorderLayout.WEST);
        cardSelect.add(scroll, BorderLayout.CENTER);
        cardSelect.add(cardSelectNorth, BorderLayout.NORTH);
        cardSelect.add(cardSelectSouth, BorderLayout.SOUTH);

        cardDelete = new JPanel();
        cardDelete.setLayout(new BorderLayout());
        cardDelete.setForeground(Color.yellow);

        titledelete = new JLabel("Silahkan Hapus Data Pasien...");
        cardDeleteNorth = new JPanel(new FlowLayout());
        cardDeleteNorth.add(titledelete);

        cardDeleteLeft = new JPanel(new GridLayout(1,1));
        cardDeleteLeft.add(new JLabel("Id = "));

        cardDeleteRight = new JPanel(new GridLayout(1,1));
        cardDeleteRight.add(delId);

        cardDeleteSouth = new JPanel(new FlowLayout());
        cardDeleteSouth.add(tomboldelete);
        cardDeleteSouth.add(tombolbackdelete);

        cardDelete.add(cardDeleteNorth, BorderLayout.NORTH);
        cardDelete.add(cardDeleteLeft, BorderLayout.WEST);
        cardDelete.add(cardDeleteRight, BorderLayout.CENTER);
        cardDelete.add(cardDeleteSouth, BorderLayout.SOUTH);

        cardUpdate = new JPanel();
        cardUpdate.setLayout(new BorderLayout());
        cardUpdate.setForeground(Color.green);

        cardUpdateLeft = new JPanel(new GridLayout(6,1));
        cardUpdateLeft.add(new JLabel("Id = "));
        cardUpdateLeft.add(new JLabel("Nama = "));
        cardUpdateLeft.add(new JLabel("Umur = "));
        cardUpdateLeft.add(new JLabel("Berat = "));
        cardUpdateLeft.add(new JLabel("Tinggi = "));
        cardUpdateLeft.add(new JLabel("Deskripsi = "));

        cardUpdateRight = new JPanel(new GridLayout(6,1));
        cardUpdateRight.add(upId);
        cardUpdateRight.add(upNama);
        cardUpdateRight.add(upUmur);
        cardUpdateRight.add(upBerat);
        cardUpdateRight.add(upTinggi);
        cardUpdateRight.add(upDeskripsi);

        titleupdate = new JLabel("Silahkan Mengubah Data Pasien...");
        cardUpdateNorth = new JPanel(new FlowLayout());
        cardUpdateNorth.add(titleupdate);

        cardUpdateSouth = new JPanel(new FlowLayout());
        cardUpdateSouth.add(tombolupdate);
        cardUpdateSouth.add(tombolbackupdate);

        cardUpdate.add(cardUpdateNorth, BorderLayout.NORTH);
        cardUpdate.add(cardUpdateLeft, BorderLayout.WEST);
        cardUpdate.add(cardUpdateRight, BorderLayout.CENTER);
        cardUpdate.add(cardUpdateSouth, BorderLayout.SOUTH);

        panelHome.add(menuHome,"Menu");
        panelHome.add(cardInsert, "Insert");
        panelHome.add(cardSelect, "Select");
        panelHome.add(cardDelete, "Delete");
        panelHome.add(cardUpdate, "Update");

        jf.add(panelHome, BorderLayout.CENTER);
        jf.add(panelLogin, BorderLayout.NORTH);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        panelHome.setVisible(false);

        tombollogin.addActionListener(e -> {
            try{
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rekammedis", "root", "");
                String a = textUser.getText();
                String b = textPass.getText();
                String query = "SELECT * FROM login";
                Statement sta = connection.createStatement();
                ResultSet rs = sta.executeQuery(query);

                while(rs.next())
                {
                    if(rs.getString(1).equals(a) && rs.getString(2).equals(b)){
                        panelLogin.setVisible(false);
                        jf.setSize(500,250);
                        panelHome.setVisible(true);
                    }
                }
                connection.close();
            }
            catch (Exception err) {
                System.out.println("ERROR: " + err);
            }
            }
        );

        tombolinsert.addActionListener(e -> {
            Connection connection = Connector.getConnection();
            String nama = textNama.getText();
            String umur = textUmur.getText();
            String berat = textBerat.getText();
            String tinggi = textTinggi.getText();
            String deskripsi = textDes.getText();

            try {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO datapasien (nama,umur,berat,tinggi,deskripsi) VALUES (?,?,?,?,?)");
                ps.setString(1, nama);
                ps.setString(2, umur);
                ps.setString(3, berat);
                ps.setString(4, tinggi);
                ps.setString(5, deskripsi);

                ps.executeUpdate();
                connection.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });

        tombolback.addActionListener(e -> {
            cardInsert.setVisible(false);
            menuHome.setVisible(true);
            jf.setSize(500, 250);
        });

        menuInsert.addActionListener(e -> {
            menuHome.setVisible(false);
            cardInsert.setVisible(true);
            jf.setSize(500, 500);
        });

        menuSelect.addActionListener(e -> {
            menuHome.setVisible(false);
            cardSelect.setVisible(true);
            jf.setSize(500, 500);

            Connection connection = Connector.getConnection();
            String query = "SELECT * FROM datapasien";
            try {
                Statement sta = connection.createStatement();
                ResultSet rse = sta.executeQuery(query);
            while(rse.next()) {
                String id = rse.getString(1);
                String nama = rse.getString(2);
                String umur = rse.getString(3);
                String berat = rse.getString(4);
                String tinggi = rse.getString(5);
                String deskripsi = rse.getString(6);

                listid.setText(id);
                listnama.setText(nama);
                listumur.setText(umur);
                listberat.setText(berat);
                listtinggi.setText(tinggi);
                listdes.setText(deskripsi);
            }
                listid.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                listid.setMaximumSize(new Dimension(100, listid.getMinimumSize().height + 5));
                listnama.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                listnama.setMaximumSize(new Dimension(100, listnama.getMinimumSize().height + 5));
                listumur.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                listumur.setMaximumSize(new Dimension(100, listumur.getMinimumSize().height + 5));
                listberat.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                listberat.setMaximumSize(new Dimension(100, listberat.getMinimumSize().height + 5));
                listtinggi.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                listtinggi.setMaximumSize(new Dimension(100, listtinggi.getMinimumSize().height + 5));
                listdes.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                listdes.setMaximumSize(new Dimension(100, listdes.getMinimumSize().height + 5));

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });

        menuUpdate.addActionListener(e -> {
            menuHome.setVisible(false);
            cardUpdate.setVisible(true);
            jf.setSize(500, 500);
        });

        tombolbackselect.addActionListener(e -> {
            cardSelect.setVisible(false);
            menuHome.setVisible(true);
            jf.setSize(500,250);
        });

        tombolbackupdate.addActionListener(e -> {
            cardUpdate.setVisible(false);
            menuHome.setVisible(true);
            jf.setSize(500,250);
        });

        tombolupdate.addActionListener(e -> {
            String id = upId.getText();
            String nama = upNama.getText();
            String umur = upUmur.getText();
            String berat = upBerat.getText();
            String tinggi = upTinggi.getText();
            String deskripsi = upDeskripsi.getText();

            Connection connection = Connector.getConnection();
            String query = "SELECT * FROM datapasien";

            try {
                Statement sta = connection.createStatement();
                ResultSet rs = sta.executeQuery(query);
                PreparedStatement ps = connection.prepareStatement("UPDATE datapasien SET nama=?, umur=?, berat=?, tinggi=?, deskripsi=? WHERE id=?");
                ps.setString(1, nama);
                ps.setString(2, umur);
                ps.setString(3, berat);
                ps.setString(4, tinggi);
                ps.setString(5, deskripsi);
                ps.setString(6, id);

                while(rs.next()) {
                    if (rs.getString(1).equals(id)) {

                        ps.executeUpdate();
                    }
                };
                connection.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });

        menuDelete.addActionListener(e -> {
            menuHome.setVisible(false);
            cardDelete.setVisible(true);
            jf.setSize(500,200);
        });

        tombolbackdelete.addActionListener(e -> {
            cardDelete.setVisible(false);
            menuHome.setVisible(true);
            jf.setSize(500,250);
        });

        tomboldelete.addActionListener(e -> {
            String id = delId.getText();

            Connection connection = Connector.getConnection();
            String query = "SELECT * FROM datapasien";

            Statement sta = null;
            try {
                sta = connection.createStatement();
                ResultSet rs = sta.executeQuery(query);

                PreparedStatement ps = connection.prepareStatement("DELETE FROM datapasien WHERE id=?");
                ps.setString(1,id);

                while(rs.next()){
                 if(rs.getString(1).equals(id)){
                     ps.executeUpdate();
                 }
                }
                connection.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        });

        tombollogout.addActionListener(e -> {
            menuHome.setVisible(false);
            panelLogin.setVisible(true);
            jf.setSize(500,150);
        });
    }

    public static void main(String[] args) {
        new RekamMedis();
    }
}