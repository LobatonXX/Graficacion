package graficacion;

/**
 *
 * @author EQUIPO
 */
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.lang.Math;

public class Traslacion2 extends JFrame
        implements ActionListener //PaolaNeri ClaseGraficacion 2020
{

    JMenuBar menu = new JMenuBar(); //crea una barra de menu
    JMenu menu1 = new JMenu("Entramado", true);//Submenu	
    JMenuItem it1 = new JMenuItem("Iniciar");
    JMenuItem it2 = new JMenuItem("Pausar");

    JMenu menu2 = new JMenu("Mover", true);
    JMenuItem it4 = new JMenuItem("X");
    JMenuItem it5 = new JMenuItem("Y");
    JMenuItem it6 = new JMenuItem("XY");

    Lienzo1 lienzo1 = new Lienzo1();
    Image icon;//Declara un objeto de imagen tipo icono
    int maxX, maxY;//Determina las coordenadas maximas del frame

    public static void main(String[] args) throws IOException {
        System.out.println("La practica entramado esta corriendo..");
        Traslacion2 i = new Traslacion2();//se llama al constructor del frame
    }

    public Traslacion2() throws IOException//crear el constructor del frame
    {
        super("Entramado");//Asi se llama al constructor de una clase extendida
        maxX = 1300;
        maxY = 760;
        setJMenuBar(menu);//Agrega la barra de menu al frame
        menu.add(menu1);//agrega los menus 1 y 3 a la barra de menu
        menu1.add(it1);// agrega items al menu 1 y 
        menu1.add(it2);//un submenu 2
        setJMenuBar(menu);//Agrega la barra de menu al frame
        menu.add(menu2);
        menu2.add(it4);
        menu2.add(it5);
        menu2.add(it6);
        icon = new ImageIcon("mia.jpg").getImage();//crear un icono con el archivo de entrada 
        //organiza componentes en paneles
        JPanel p1 = new JPanel(new BorderLayout());
        p1.add(lienzo1, BorderLayout.CENTER);
        getContentPane().add(p1);
        //declara los objetos que escuchara el manejador de eventos
        it1.addActionListener(this);
        it2.addActionListener(this);
        it4.addActionListener(this);
        it5.addActionListener(this);
        it6.addActionListener(this);
        //mueve el frame a la posicion indicada y establece el tamaÃƒÂ±o
        setBounds(100, 100, maxX, maxY);
        setIconImage(icon);//Agrega icono a la barra de menu
        setVisible(true);//Hace visible al frame
    }

    //manejador de eventos
    @Override
    public void actionPerformed(ActionEvent event) {
        Object object = event.getSource();
        //si se elige el menu 1-1
        if (object == it1) {
            dibuja(lienzo1.getGraphics());
        }
        //si se elige el menu 1-2
        if (object == it2) {
        }
        if (object == it4) {
            moverX(lienzo1.getGraphics());
        }
        if (object == it5) {
            moverY(lienzo1.getGraphics());
        }
        if (object == it6) {
            moverXY(lienzo1.getGraphics());
        }
    }

    public void dibuja(Graphics g) {
        int xp[] = {400, 100, 200, 300, 500, 600, 700, 400};
        int yp[] = {650, 250, 150, 100, 100, 150, 250, 650};
        int xU[] = {200, 300, 500, 600, 700, 550, 250, 100, 200};
        int yU[] = {150, 200, 200, 150, 250, 300, 300, 250, 150};
        int xI[] = {300, 500, 550, 400, 250, 300};
        int yI[] = {200, 200, 300, 650, 300, 200};
        g.clearRect(0, 0, maxX, maxY);
        g.setColor(Color.pink);
        g.fillPolygon(xp, yp, 8);
        //CONTORNO 
        g.setColor(Color.black);
        g.drawPolygon(xp, yp, 8);
        //INTERIOR
        g.drawPolygon(xU, yU, 9);
        g.drawPolygon(xI, yI, 6);

    }

    public void moverX(Graphics g) {
        g.clearRect(0, 0, maxX, maxY);
        Thread t = new Thread();

        try {
            t.start();
            for (int i = 0; i < (maxX - 800); i += 5) {
                g.clearRect(0, 0, maxX, maxY);
                int xp[] = {400 + i, 100 + i, 200 + i, 300 + i, 500 + i, 600 + i, 700 + i, 400 + i};
                int yp[] = {650, 250, 150, 100, 100, 150, 250, 650};
                int xU[] = {200 + i, 300 + i, 500 + i, 600 + i, 700 + i, 550 + i, 250 + i, 100 + i, 200 + i};
                int yU[] = {150, 200, 200, 150, 250, 300, 300, 250, 150};
                int xI[] = {300 + i, 500 + i, 550 + i, 400 + i, 250 + i, 300 + i};
                int yI[] = {200, 200, 300, 650, 300, 200};

                g.setColor(Color.pink);
                g.fillPolygon(xp, yp, 8);
                g.setColor(Color.black);
                g.drawPolygon(xp, yp, 8);
                g.drawPolygon(xU, yU, 9);
                g.drawPolygon(xI, yI, 6);

                t.sleep(10);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void moverY(Graphics g) {
        g.clearRect(0, 0, maxX, maxY);
        Thread t = new Thread();

        try {
            for (int i = 0; i < (maxY - 700); i += 5) {
                g.clearRect(0, 0, maxX, maxY);
                int xp[] = {400, 100, 200, 300, 500, 600, 700, 400};
                int yp[] = {650+i, 250+i, 150+i, 100+i, 100+i, 150+i, 250+i, 650+i};
                int xU[] = {200, 300, 500, 600, 700, 550, 250, 100, 200};
                int yU[] = {150+i, 200+i, 200+i, 150+i, 250+i, 300+i, 300+i, 250+i, 150+i};
                int xI[] = {300, 500, 550, 400, 250, 300};
                int yI[] = {200+i, 200+i, 300+i, 650+i, 300+i, 200+i};
                g.setColor(Color.pink);
                g.fillPolygon(xp, yp, 8);
                g.setColor(Color.black);
                g.drawPolygon(xp, yp, 8);
                g.drawPolygon(xU, yU, 9);
                g.drawPolygon(xI, yI, 6);

                t.sleep(50);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void moverXY(Graphics g) {
        g.clearRect(0, 0, maxX, maxY);
        Thread t = new Thread();
        try {
            for (int i = 0; i < (maxX - 900); i += 5) {
                g.clearRect(0, 0, maxX, maxY);
                 int xp[] = {400 + i, 100 + i, 200 + i, 300 + i, 500 + i, 600 + i, 700 + i, 400 + i};
                int yp[] = {650+i, 250+i, 150+i, 100+i, 100+i, 150+i, 250+i, 650+i};
                int xU[] = {200 + i, 300 + i, 500 + i, 600 + i, 700 + i, 550 + i, 250 + i, 100 + i, 200 + i};
                int yU[] = {150+i, 200+i, 200+i, 150+i, 250+i, 300+i, 300+i, 250+i, 150+i};
                int xI[] = {300 + i, 500 + i, 550 + i, 400 + i, 250 + i, 300 + i};
                int yI[] = {200+i, 200+i, 300+i, 650+i, 300+i, 200+i};
                g.setColor(Color.pink);
                g.fillPolygon(xp, yp, 8);
                g.setColor(Color.black);
                g.drawPolygon(xp, yp, 8);
                g.drawPolygon(xU, yU, 9);
                g.drawPolygon(xI, yI, 6);

                t.sleep(50);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    //manejador de eventos de ventanas windows
    @Override
    public boolean handleEvent(Event e) {	//en caso de dar clic en el tache de la ventana 	
        //finaliza la aplicacion	
        if (e.id == Event.WINDOW_DESTROY) {
            System.exit(0);
        }
        return super.handleEvent(e);

    }
};

class Lienzo1 extends Canvas {

    public Graphics getGraphics(Graphics g) {
        return g;
    }
}
