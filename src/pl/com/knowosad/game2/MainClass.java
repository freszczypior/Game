package pl.com.knowosad.game2;


import javax.swing.*;

public class MainClass {

        public static final int WIDTH = 640;
        public static final int HEIGHT = 480;
        public static final String TITLE = "Simple Game";


    public static void main(String[] args) {

        JFrame frame = new JFrame(TITLE);
        frame.pack();
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Game());
        frame.setVisible(true);

    }
}
