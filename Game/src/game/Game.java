/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.WindowConstants;
/**
 *
 * @author User1
 */
public class Game extends JFrame {

    private static Game game_game;
    private static long last_frame;
    private static Image papich;
    private static Image nuts;
    private static Image papich2;
    private static float drop_left = 200;
    private static float drop_top = -100;
    private static float drop_v =200;
    private static int score = 0;
    
    public static void main(String[] args) throws IOException{
        papich = ImageIO.read(Game.class.getResourceAsStream("papich.png"));
	nuts = ImageIO.read(Game.class.getResourceAsStream("nuts.png"));
        papich2 = ImageIO.read(Game.class.getResourceAsStream("papich2.png"));
	game_game = new Game();
	game_game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	game_game.setLocation(200, 50);
	game_game.setSize(900, 600);
	game_game.setResizable(false);
        last_frame = System.nanoTime();
	GameField game_field = new GameField();
	game_field.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e){
            int x = e.getX();
            int y = e.getY();
            float drop_right = drop_left + papich2.getWidth(null);
            float drop_bottom = drop_top + papich2.getHeight(null);
            boolean is_drop = x >= drop_left && x<= drop_right && y>= drop_top && y <= drop_bottom;
            if (is_drop){
            drop_top = -100;
            drop_left = (int) (Math.random() * (game_field.getWidth() - papich2.getWidth(null)));
            drop_v = drop_v + 10;
            score++;
            game_game.setTitle("Score: " + score);
            }
        }
    });
    game_game.add(game_field);
    game_game.setVisible(true);
    }
    public static void onRepaint(Graphics g) {
	long current_time = System.nanoTime();
        float delt_time = (current_time - last_frame)*0.000000001f;
        last_frame = current_time;
        drop_top = drop_top + drop_v * delt_time;
	g.drawImage(papich,0,0,null);
	g.drawImage(nuts, (int) drop_left ,(int) drop_top,null);
        if (drop_top > game_game.getHeight())g.drawImage(papich2,210,150,null);
	}
    public static class GameField extends JPanel {
	@ Override
	protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            onRepaint(g);
		repaint();
		
	}
    }
}
