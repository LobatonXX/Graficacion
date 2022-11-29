package graficacion;

/**
 *
 * @author LOBATON PAEZ BRENDA CITLALI
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class JuegoColision extends JDialog
        implements KeyListener {

    int maxX = 1000, maxY = 800;//frame size
    LienzoC lienzo = new LienzoC();//game control and canvas
    JLabel l1 = new JLabel();//state label
    JLabel l2 = new JLabel();//score label
    int posX, posY, w, h, objx, objy, objwh, objx2, objy2, objwh2, objx3, objy3, objwh3;
    int score = 0;

    public static void main(String[] args) throws IOException {
        JuegoColision i = new JuegoColision();
    }//calling frame

    public JuegoColision() {
        super();
        setTitle("Juego Base");//title 
        //main container
        JPanel pan1 = new JPanel(new BorderLayout());
        pan1.add(l1, BorderLayout.NORTH);
        pan1.add(lienzo, BorderLayout.CENTER);
        pan1.add(l2, BorderLayout.SOUTH);
        getContentPane().add(pan1);
        //add keyListener
        addKeyListener(this);
        //showing frame
        setBounds(0, 0, maxX, maxY);
        setVisible(true);
        newGame();
    }

    void newGame() {
        //lienzo.init();
        l1.setText("PRESIONA a-izq,d-der, w-arriba, s-abajo");
        l2.setText("PUNTUACIÓN: 0");
        posX = maxX / 2;
        posY = maxY / 2;
        w = 50;
        h = 50;
        objx = 600;
        objy = 100;
        objwh = 200;

        objx2 = 200;
        objy2 = 300;
        objwh2 = 100;

        objx3 = 400;
        objy3 = 500;
        objwh3 = 150;
        //use a thread like a time control
        Thread t = new Thread();//time control
        t = new Thread();
        t.start();
        boolean Fin = false;
        while (!(Fin)) {
            dibujaPersonaje(lienzo.getGraphics());
            l2.setText("PUNTUACIÓN: " + getScore());
            try {
                t.sleep(800);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        l1.setText("FIN DEL JUEGO");
        t.yield();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //catch a key stroke
        switch (e.getKeyChar()) {
            case 'a':
                moveLeft();
                break;
            case 'd':
                moveRight();
                break;
            case 'w':
                moveUp();
                break;
            case 's':
                moveDown();
                break;
        }
        dibujaPersonaje(lienzo.getGraphics());
    }

    public void moveLeft() {
        posX -= 10;
    }

    public void moveRight() {
        posX += 10;
    }

    public void moveUp() {
        posY -= 10;
    }

    public void moveDown() {
        posY += 10;
    }

    public int getScore() {
        return 1;
    }

    public void dibujaPersonaje(Graphics g) {
        //dibuja el escenario
        g.clearRect(0, 0, maxX, maxY);
        g.setColor(Color.blue);
        g.fillRect(objx, objy, objwh, objwh);
        g.fillRect(objx2, objy2, objwh2, objwh2);
        g.fillRect(objx3, objy3, objwh3, objwh3);
        //Revisa si hay colisiones
        
        if (posX > objx - w && posY > objy && (posX < objx + objwh) && (posY < objy + objwh)) {
            g.setColor(Color.pink);
            g.fillRect(objx, objy, objwh, objwh);
        }
      
        if (posX > objx2 - w && posY > objy2 && posX < objx2 + objwh2 && posY < objy2 + objwh2) {
            g.setColor(Color.pink);
            g.fillRect(objx2, objy2, objwh2, objwh2);
        }
       
        if (posX > objx3 - w && posY > objy3 && posX < objx3 + objwh3 && posY < objy3 + objwh3) {
            g.setColor(Color.pink);
            g.fillRect(objx3, objy3, objwh3, objwh3);
        }
        //dibuja el personaje(bola)
        g.setColor(Color.black);
        g.fillOval(posX, posY, w, w);
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

class LienzoC extends Canvas {

    public Graphics getGraphics(Graphics g) {
        return g;
    }
}
