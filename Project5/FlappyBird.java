package Project5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Float;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.Random;

public class FlappyBird implements ActionListener, MouseListener {
    public Renderer renderer;
    //JPanel panel = new JPanel();
    public static FlappyBird flappyBird;
    public Ellipse2D.Float bird;
    public ArrayList<Rectangle> columns;

    public int ticks = 0,yMotion =0, score;
    public boolean gameOver = false, started = true;

    public Random rand;
    public FlappyBird(){
        JFrame frame = new JFrame("Flappy Bird");
        Timer timer = new Timer(20,this);
        frame.setSize(800,800);
        //frame.getContentPane().setBackground(Color.cyan);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon logo = new ImageIcon("Project5/logo.png");
        frame.setIconImage(logo.getImage());
        frame.setVisible(true);

        renderer = new Renderer();
        rand = new Random();
        frame.add(renderer);
        frame.addMouseListener(this);
        bird = new Ellipse2D.Float(400-10,400-10,20,20);
        columns = new ArrayList<Rectangle>();
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);

        timer.start();
    }
    public void addColumn(boolean start){
        int space = 300;
        int width = 100;
        int height = 50 + rand.nextInt(300);
        if (start) {
            columns.add(new Rectangle(800 + width + columns.size() * 300, 800 - height - 120, width, height));
            columns.add(new Rectangle(800 + width + (columns.size() - 1) * 300, 0, width, 800-height - space));
        }
        else{
            columns.add(new Rectangle((columns.get(columns.size()-1)).x + 600,800-height-120,width,height));
            columns.add(new Rectangle(columns.get(columns.size()-1).x,0,width,800-height-space));
        }
    }
    public void paintColumn(Graphics g, Rectangle column){
        g.setColor(Color.green.darker().darker());
        g.fillRect(column.x,column.y,column.width,column.height);

    }
    public void jump(){
        if(gameOver){
            bird = new Ellipse2D.Float(400-10,400-10,20,20);
            columns.clear();
            yMotion = 0;
            score = 0;
            addColumn(true);
            addColumn(true);
            addColumn(true);
            addColumn(true);
            gameOver=false;
        }
        if(!started){
            started = true;
        }else if(!gameOver){
            if (yMotion > 0){
                yMotion = 0;
            }
            yMotion -= 10;
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        int speed = 10;

        ticks++;

        if (started) {
            for (int i = 0; i < columns.size(); i++) {
                Rectangle column = columns.get(i);
                column.x -= speed;
            }

            if (ticks % 2 == 0 && yMotion < 150) {
                yMotion += 2;
            }

            for (int i = 0; i < columns.size(); i++) {
                Rectangle column = columns.get(i);
                if (column.x + column.width < 0) {
                    columns.remove(column);
                    if (column.y == 0) {
                        addColumn(false);
                    }
                }
            }


            bird.y += yMotion;

            for (Rectangle column : columns) {
                if (column.intersects(bird.x, bird.y, bird.width, bird.height)) {
                    gameOver = true;
                    //bird.x = column.x - bird.width; //doesn't work...
                }
            }


            if (bird.y > 800 - 120 || bird.y < 0) {
                gameOver = true;
            }
            if (gameOver){
                bird.y = 800-120 - bird.height;

            }
        }
        renderer.repaint();

    }



    public void repaint(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect(0,0,800,800);
        g.setColor(Color.green);
        g.fillRect(0,800-120,800,150);

        g.setColor(Color.red);
        g.fillOval((int) bird.getX(), (int) bird.getY(), (int) bird.getWidth(), (int) bird.getHeight());

        for (Rectangle column : columns){
            paintColumn(g,column);
        }

        g.setColor(Color.white);
        g.setFont(new Font("Arial", 1, 100));

        if (!started){
            g.drawString("Click to Start!", 75,800/2-50);
        }

        if (gameOver) {
            g.drawString("Game Over!", 75,800/2-50);
        }
    }


    public static void main(String [] args){
        flappyBird = new FlappyBird();

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        jump();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
