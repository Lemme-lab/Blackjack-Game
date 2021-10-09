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

public class Blackjack extends JFrame {

    private JPanel contentPane;
    private JButton btnHit;
    private JButton btnStay;
    private JPanel panel;
    private JPanel panel_1;
    private BufferedImage image;

    /**
     * Launch the application.
     */
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

    /**
     * Create the frame.
     */



    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 642, 439);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        btnHit = new JButton("HIT");
        btnHit.setBounds(148, 345, 117, 29);
        contentPane.add(btnHit);

        btnStay = new JButton("Stay");
        btnStay.setBounds(403, 345, 117, 29);
        contentPane.add(btnStay);

        panel = new JPanel();
        panel.setBounds(92, 184, 460, 148);
        contentPane.add(panel);

        panel_1 = new JPanel();
        panel_1.setBounds(92, 16, 460, 148);
        contentPane.add(panel_1);
    }



    public Blackjack() {
        initComponents();
        player_hand();
        dealer_hand();



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






}