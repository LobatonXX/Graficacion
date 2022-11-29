package graficacion;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.lang.Math;

public class BSpline extends JFrame
        implements ActionListener //PaolaNeri ClaseGraficacion 2020
{

    JMenuBar menu = new JMenuBar(); //crea una barra de menu
    JMenu menu1 = new JMenu("Entramado", true);//Submenu	
    JMenuItem it1 = new JMenuItem("Iniciar");
    JMenuItem it2 = new JMenuItem("Pausar");

    lienzoBSpline lienzoBSpline = new lienzoBSpline();
    Image icon;//Declara un objeto de imagen tipo icono
    int maxX, maxY;//Determina las coordenadas maximas del frame

    public static void main(String[] args) throws IOException {
        System.out.println("La practica entramado esta corriendo..");
        BSpline i = new BSpline();//se llama al constructor del frame
    }

    public BSpline() throws IOException//crear el constructor del frame
    {
        super("BSpline");//Asi se llama al constructor de una clase extendida
        maxX = 1200;
        maxY = 900;
        setJMenuBar(menu);//Agrega la barra de menu al frame
        menu.add(menu1);//agrega los menus 1 y 3 a la barra de menu
        menu1.add(it1);// agrega items al menu 1 y 
        menu1.add(it2);//un submenu 2

        icon = new ImageIcon("mia.jpg").getImage();//crear un icono con el archivo de entrada 
        //organiza componentes en paneles
        JPanel p1 = new JPanel(new BorderLayout());
        p1.add(lienzoBSpline, BorderLayout.CENTER);
        getContentPane().add(p1);
        //declara los objetos que escuchara el manejador de eventos
        it1.addActionListener(this);
        it2.addActionListener(this);
        //mueve el frame a la posicion indicada y establece el tama�o
        setBounds(100, 100, maxX, maxY);
        setIconImage(icon);//Agrega icono a la barra de menu
        setVisible(true);//Hace visible al frame
    }

    //manejador de eventos
    public void actionPerformed(ActionEvent event) {
        Object object = event.getSource();
        //si se elige el menu 1-1
        if (object == it1) {
            dibuja(lienzoBSpline.getGraphics());
        }
        //si se elige el menu 1-2
        if (object == it2) {
        }
    }

    public void dibuja(Graphics g) {
        //g.clearRect(0,0,maxX,maxY);
        //Color c=new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));  
        g.clearRect(0, 0, maxX, maxY);

        for (int i = 650, j = 100; i > 50; i -= 50, j += 50) {
            g.setColor(Color.pink);
            g.drawLine(100, i, j, 100);
            g.setColor(Color.blue);
            g.drawLine(100, 100, 100, 650);
            g.drawLine(100, 100, 650, 100);
        }

    }

    //manejador de eventos de ventanas windows
    public boolean handleEvent(Event e) {	//en caso de dar clic en el tache de la ventana 	
        //finaliza la aplicacion	
        if (e.id == Event.WINDOW_DESTROY) {
            System.exit(0);
        }
        return super.handleEvent(e);

    }
};

class lienzoBSpline extends Canvas {

    public Graphics getGraphics(Graphics g) {
        return g;
    }
}
