package htl;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
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
        setBounds(100, 100, 478, 236);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        btnHit = new JButton("HIT");
        btnHit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnHitMouseClicked(e);
            }
        });
        btnHit.setBounds(76, 147, 117, 29);
        contentPane.add(btnHit);

        btnStay = new JButton("Stay");
        btnStay.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnStayMouseClicked(e);
            }
        });
        btnStay.setBounds(292, 147, 117, 29);
        contentPane.add(btnStay);

        textField = new JTextField();
        textField.setBounds(76, 38, 333, 26);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(73, 87, 336, 26);
        contentPane.add(textField_1);
        textField_1.setColumns(10);



    }



    public Blackjack() {
        initComponents();
        int wert_Dealer = player_hand()+player_hand();
        textField.setText(wert_Dealer+"");
        textField_1.setText(dealer_hand()+"");
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

    public static int dealer_bust(){
        Random rnd = new Random();
        int low = 2;
        int high = 11;
        int result = rnd.nextInt(high-low) + low;
        return result;
    }
    public static int player_bust(){
        Random rnd = new Random();
        int low = 2;
        int high = 11;
        int result = rnd.nextInt(high-low) + low;
        return result;
    }





    protected void btnHitMouseClicked(MouseEvent e) {
        int wert_Player = Integer.parseInt(textField_1.getText());
        int wert_Dealer = Integer.parseInt(textField.getText());



        if(wert_Player < 21) {

            wert_Player = Integer.parseInt(textField_1.getText())+player_hand();
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
                wert_Dealer = Integer.parseInt(textField.getText())+dealer_hand();
                textField.setText(wert_Dealer+"");
                if(wert_Dealer > 21) {
                    textField.setText(wert_Dealer+" " + "'Bust");
                    textField_1.setText(wert_Player+" " + "'WIN");
                }
            }
        }
    }






    protected void btnStayMouseClicked(MouseEvent e) {
        int wert_Player = Integer.parseInt(textField_1.getText());
        int wert_Dealer = Integer.parseInt(textField.getText());

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
