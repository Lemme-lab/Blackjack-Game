package htl;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.io.IOException;
import java.util.logging.Level;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class Blackjack extends JFrame {

    private JPanel contentPane;
    private JButton btnHit;
    private JButton btnStay;
    private JPanel panel;
    private JPanel panel_1;
    private BufferedImage image;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JTextField textField;
    private JTextField textField_1;
    static int counter = 0;
    int first_hand;
    int first_hand_dealer;
    int second_hand;
    JLabel label4 = new JLabel();
    JLabel label3 = new JLabel();
    JLabel label2 = new JLabel();
    JLabel label1 = new JLabel();

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Blackjack frame = new Blackjack();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 478, 592);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        btnHit = new JButton("HIT");
        btnHit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    btnHitMouseClicked(e);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnHit.setBounds(76, 520, 117, 29);
        contentPane.add(btnHit);

        btnStay = new JButton("Stay");
        btnStay.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    btnStayMouseClicked(e);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnStay.setBounds(291, 520, 117, 29);
        contentPane.add(btnStay);

        textField = new JTextField();
        textField.setBounds(76, 231, 333, 26);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(73, 488, 336, 26);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblDealer = new JLabel("Dealer:");
        lblDealer.setBounds(76, 11, 46, 14);
        contentPane.add(lblDealer);

        JLabel lblPlayer = new JLabel("Player:");
        lblPlayer.setBounds(76, 269, 46, 14);
        contentPane.add(lblPlayer);

    }

    public Blackjack() throws IOException{

        initComponents();

        int first_hand =  player_hand();
        int second_hand = player_hand();

        int first_hand_dealer =  dealer_hand();
        int second_hand_dealer = dealer_hand();

        int wert_Player = first_hand + second_hand;
        int wert_Dealer = first_hand_dealer + second_hand_dealer;



        display(first_hand_dealer, second_hand_dealer,first_hand, second_hand);

        textField.setText(wert_Dealer+"");
        textField_1.setText(wert_Player+"");

        textField.setText(wert_Dealer+"");
        textField_1.setText(wert_Player+"");

        System.out.println(wert_Dealer);
        System.out.println(wert_Player);
    }

    public void display(int first_hand, int second_hand, int first_hand_dealer, int second_hand_dealer) throws IOException {

        initComponents();
        BufferedImage Ass = ImageIO.read(new File("src/Ass.png"));
        BufferedImage Zwei = ImageIO.read(new File("src/Zwei.png"));
        BufferedImage Drei = ImageIO.read(new File("src/Drei.png"));
        BufferedImage Vier = ImageIO.read(new File("src/Vier.png"));
        BufferedImage Fünf = ImageIO.read(new File("src/Fünf.png"));
        BufferedImage Sex = ImageIO.read(new File("src/Sex.png"));
        BufferedImage Sieben = ImageIO.read(new File("src/Sieben.png"));
        BufferedImage Acht = ImageIO.read(new File("src/Acht.png"));
        BufferedImage Neun = ImageIO.read(new File("src/Neun.png"));
        BufferedImage King = ImageIO.read(new File("src/King.png"));


        JPanel panel2 = new JPanel();
        panel2.setBounds(244, 36, 165, 193);
        contentPane.add(panel2);


        switch(first_hand_dealer){
            case 2:
                label2 = new JLabel(new ImageIcon(Zwei.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 3:
                label2 = new JLabel(new ImageIcon(Drei.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 4:
                label2 = new JLabel(new ImageIcon(Vier.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 5:
                label2 = new JLabel(new ImageIcon(Fünf.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 6:
                label2 = new JLabel(new ImageIcon(Sex.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 7:
                label2 = new JLabel(new ImageIcon(Sieben.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 8:
                label2 = new JLabel(new ImageIcon(Acht.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 9:
                label2 = new JLabel(new ImageIcon(Neun.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 10:
                label2 = new JLabel(new ImageIcon(King.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 11:
                label2 = new JLabel(new ImageIcon(Ass.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;

        }

        JPanel panel1 = new JPanel();
        panel1.setBounds(76, 36, 165, 193);
        contentPane.add(panel1);


        switch(second_hand_dealer){
            case 2:
                label1 = new JLabel(new ImageIcon(Zwei.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 3:
                label1 = new JLabel(new ImageIcon(Drei.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 4:
                label1 = new JLabel(new ImageIcon(Vier.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 5:
                label1 = new JLabel(new ImageIcon(Fünf.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 6:
                label1 = new JLabel(new ImageIcon(Sex.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 7:
                label1 = new JLabel(new ImageIcon(Sieben.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 8:
                label1 = new JLabel(new ImageIcon(Acht.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 9:
                label1 = new JLabel(new ImageIcon(Neun.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 10:
                label1 = new JLabel(new ImageIcon(King.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 11:
                label1 = new JLabel(new ImageIcon(Ass.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;

        }

        JPanel panel3 = new JPanel();
        panel3.setBounds(76, 295, 165, 193);
        contentPane.add(panel3);



        switch(first_hand){
            case 2:
                label3 = new JLabel(new ImageIcon(Zwei.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 3:
                label3 = new JLabel(new ImageIcon(Drei.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 4:
                label3 = new JLabel(new ImageIcon(Vier.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 5:
                label3 = new JLabel(new ImageIcon(Fünf.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 6:
                label3 = new JLabel(new ImageIcon(Sex.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 7:
                label3 = new JLabel(new ImageIcon(Sieben.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 8:
                label3 = new JLabel(new ImageIcon(Acht.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 9:
                label3 = new JLabel(new ImageIcon(Neun.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 10:
                label3 = new JLabel(new ImageIcon(King.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 11:
                label3 = new JLabel(new ImageIcon(Ass.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
        }



        JPanel panel4 = new JPanel();
        panel4.setBounds(244, 295, 165, 193);
        contentPane.add(panel4);

        switch(second_hand){
            case 2:
                label4 = new JLabel(new ImageIcon(Zwei.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 3:
                label4 = new JLabel(new ImageIcon(Drei.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 4:
                label4 = new JLabel(new ImageIcon(Vier.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 5:
                label4 = new JLabel(new ImageIcon(Fünf.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 6:
                label4 = new JLabel(new ImageIcon(Sex.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 7:
                label4 = new JLabel(new ImageIcon(Sieben.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 8:
                label4 = new JLabel(new ImageIcon(Acht.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 9:
                label4 = new JLabel(new ImageIcon(Neun.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 10:
                label4 = new JLabel(new ImageIcon(King.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 11:
                label4 = new JLabel(new ImageIcon(Ass.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
        }

        panel1.add(label1);
        panel2.add(label2);
        panel3.add(label3);
        panel4.add(label4);
    }

    public void redisplay(int first_hand, int second_hand, int position) throws IOException {
        BufferedImage Ass = ImageIO.read(new File("src/Ass.png"));
        BufferedImage Zwei = ImageIO.read(new File("src/Zwei.png"));
        BufferedImage Drei = ImageIO.read(new File("src/Drei.png"));
        BufferedImage Vier = ImageIO.read(new File("src/Vier.png"));
        BufferedImage Fünf = ImageIO.read(new File("src/Fünf.png"));
        BufferedImage Sex = ImageIO.read(new File("src/Sex.png"));
        BufferedImage Sieben = ImageIO.read(new File("src/Sieben.png"));
        BufferedImage Acht = ImageIO.read(new File("src/Acht.png"));
        BufferedImage Neun = ImageIO.read(new File("src/Neun.png"));
        BufferedImage King = ImageIO.read(new File("src/King.png"));

        if(position == 1){
        switch(first_hand){
            case 2:
                label2 = new JLabel(new ImageIcon(Zwei.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 3:
                label2 = new JLabel(new ImageIcon(Drei.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 4:
                label2 = new JLabel(new ImageIcon(Vier.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 5:
                label2 = new JLabel(new ImageIcon(Fünf.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 6:
                label2 = new JLabel(new ImageIcon(Sex.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 7:
                label2 = new JLabel(new ImageIcon(Sieben.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 8:
                label2 = new JLabel(new ImageIcon(Acht.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 9:
                label2 = new JLabel(new ImageIcon(Neun.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 10:
                label2 = new JLabel(new ImageIcon(King.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 11:
                label2 = new JLabel(new ImageIcon(Ass.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;

        }
        }
        if(position == 1){
        switch(second_hand){
            case 2:
                label1 = new JLabel(new ImageIcon(Zwei.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 3:
                label1 = new JLabel(new ImageIcon(Drei.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 4:
                label1 = new JLabel(new ImageIcon(Vier.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 5:
                label1 = new JLabel(new ImageIcon(Fünf.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 6:
                label1 = new JLabel(new ImageIcon(Sex.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 7:
                label1 = new JLabel(new ImageIcon(Sieben.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 8:
                label1 = new JLabel(new ImageIcon(Acht.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 9:
                label1 = new JLabel(new ImageIcon(Neun.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 10:
                label1 = new JLabel(new ImageIcon(King.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 11:
                label1 = new JLabel(new ImageIcon(Ass.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;

        }
        }

        if(position == 2){
        switch(first_hand){
            case 2:
                label3 = new JLabel(new ImageIcon(Zwei.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 3:
                label3 = new JLabel(new ImageIcon(Drei.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 4:
                label3 = new JLabel(new ImageIcon(Vier.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 5:
                label3 = new JLabel(new ImageIcon(Fünf.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 6:
                label3 = new JLabel(new ImageIcon(Sex.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 7:
                label3 = new JLabel(new ImageIcon(Sieben.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 8:
                label3 = new JLabel(new ImageIcon(Acht.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 9:
                label3 = new JLabel(new ImageIcon(Neun.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 10:
                label3 = new JLabel(new ImageIcon(King.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 11:
                label3 = new JLabel(new ImageIcon(Ass.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
        }
        }

        if(position == 2){
        switch(second_hand){
            case 2:
                label4 = new JLabel(new ImageIcon(Zwei.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 3:
                label4 = new JLabel(new ImageIcon(Drei.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 4:
                label4 = new JLabel(new ImageIcon(Vier.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 5:
                label4 = new JLabel(new ImageIcon(Fünf.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 6:
                label4 = new JLabel(new ImageIcon(Sex.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 7:
                label4 = new JLabel(new ImageIcon(Sieben.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 8:
                label4 = new JLabel(new ImageIcon(Acht.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 9:
                label4 = new JLabel(new ImageIcon(Neun.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 10:
                label4 = new JLabel(new ImageIcon(King.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 11:
                label4 = new JLabel(new ImageIcon(Ass.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
        }
        }

    }

    public static int player_hand(){
        Random rnd = new Random();
        int low = 2;
        int high = 11;
        int result = rnd.nextInt(high-low) + low;
        return result;
    }

    public static int dealer_hand(){
        Random rnd = new Random();
        int low = 2;
        int high = 11;
        int result = rnd.nextInt(high-low) + low;
        return result;
    }

    protected void btnHitMouseClicked(MouseEvent e) throws IOException {
        int wert_Player = Integer.parseInt(textField_1.getText());
        int wert_Dealer = Integer.parseInt(textField.getText());

        int player_hand = player_hand();
        int dealer_hand = dealer_hand();

        if(wert_Player < 21) {

            wert_Player = Integer.parseInt(textField_1.getText())+player_hand;
            textField_1.setText(wert_Player+"");
        }


        if(wert_Player > 21) {

            textField.setText(wert_Dealer+" " + "'WIN");
            textField_1.setText(wert_Player+" " + "'BUST");

        }
        else {

            if(Integer.parseInt(textField.getText()) >= 17) {
                wert_Dealer = Integer.parseInt(textField.getText());
                textField.setText(wert_Dealer+"");
            }
            else {
                wert_Dealer = Integer.parseInt(textField.getText())+dealer_hand;
                textField.setText(wert_Dealer+"");
                if(wert_Dealer > 21) {
                    textField.setText(wert_Dealer+" " + "'Bust");
                    textField_1.setText(wert_Player+" " + "'WIN");
                }
            }
        }




    }

    protected void btnStayMouseClicked(MouseEvent e) throws IOException {
        int wert_Player = Integer.parseInt(textField_1.getText());
        int wert_Dealer = Integer.parseInt(textField.getText());
        int dealer_hand = dealer_hand();

        if(wert_Dealer<17){
            wert_Dealer += dealer_hand;
        }



        if(wert_Player > wert_Dealer) {
            textField_1.setText(wert_Player + " 'WIN'");
        }
        else if(wert_Player < wert_Dealer) {
            textField_1.setText(wert_Player + " 'LOSE'");
        }
        else if(wert_Player == wert_Dealer) {
            textField_1.setText(wert_Player + " 'DRAW'");
        }



    }
}