package graficacion;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.lang.Math;

public class Entramado1 extends JFrame
        implements ActionListener 
{

    JMenuBar menu = new JMenuBar(); //crea una barra de menu
    JMenu menu1 = new JMenu("Entramado", true);//Submenu	
    JMenuItem it1 = new JMenuItem("Diseño 1");
    JMenuItem it2 = new JMenuItem("Diseño 2");
    JMenuItem it3 = new JMenuItem("Diseño 3");
    JMenuItem it4 = new JMenuItem("Diseño 4");
    JMenuItem it5 = new JMenuItem("Diseño 5");

    Lienzos lienzos = new Lienzos();
    Image icon;//Declara un objeto de imagen tipo icono
    int maxX, maxY;//Determina las coordenadas maximas del frame

    public static void main(String[] args) throws IOException {
        System.out.println("La practica entramado esta corriendo..");
        Entramado1 i = new Entramado1();//se llama al constructor del frame
    }

    public Entramado1() throws IOException//crear el constructor del frame
    {
        super("Entramado");//Asi se llama al constructor de una clase extendida
        maxX = 1000;
        maxY = 500;
        setJMenuBar(menu);//Agrega la barra de menu al frame
        menu.add(menu1);//agrega los menus 1 y 3 a la barra de menu
        menu1.add(it1);// agrega items al menu 1 y 
        menu1.add(it2);//un submenu 2
        menu1.add(it3);// agrega items al menu 1 y 
        menu1.add(it4);
        menu1.add(it5);// agrega items al menu 1 y 

        icon = new ImageIcon("mia.jpg").getImage();//crear un icono con el archivo de entrada 
        //organiza componentes en paneles
        JPanel p1 = new JPanel(new BorderLayout());
        p1.add(lienzos, BorderLayout.CENTER);
        getContentPane().add(p1);
        //declara los objetos que escuchara el manejador de eventos
        it1.addActionListener(this);
        it2.addActionListener(this);
        it3.addActionListener(this);
        it4.addActionListener(this);
        it5.addActionListener(this);

        //mueve el frame a la posicion indicada y establece el tama�o
        setBounds(100, 100, maxX + 100, maxY + 100);
        setIconImage(icon);//Agrega icono a la barra de menu
        setVisible(true);//Hace visible al frame
    }

    //manejador de eventos
    public void actionPerformed(ActionEvent event) {
        Object object = event.getSource();
        //si se elige el menu 1-1
        if (object == it1) {
            dibuja1(lienzos.getGraphics());
        }
        if (object == it2) {
            dibuja2(lienzos.getGraphics());
        }
        if (object == it3) {
            dibuja3(lienzos.getGraphics());
        }
        if (object == it4) {
            dibuja4(lienzos.getGraphics());
        }
        if (object == it5) {
            dibuja5(lienzos.getGraphics());
        }
    }

    public void dibuja1(Graphics g) {
                g.clearRect(0, 0, maxX, maxY + 100);
        for (int i = 0; i < maxX; i += 100) {
            for (int j = 0; j < maxY; j += 25) {
                int r = (int) (Math.random() * 255);
                int gr = (int) (Math.random() * 255);
                int b = (int) (Math.random() * 255);
                Color c = new Color(r, gr, b);
                g.setColor(c);
                g.drawOval(i,j,50,50);

            }
        }

        for (int i = 0; i < maxX; i += 25) {
            for (int j = 100; j < maxY; j += 100) {
                int r = (int) (Math.random() * 255);
                int gr = (int) (Math.random() * 255);
                int b = (int) (Math.random() * 255);
                Color c = new Color(r, gr, b);
                g.setColor(c);
                g.drawOval(i,j,50,50);
            }
        }
    }
    
    public void dibuja2(Graphics g) {
        g.clearRect(0, 0, maxX, maxY + 100);
        for (int i = 0; i < maxX; i += 5) {
            for (int j = 0; j < maxY; j += 100) {
                int r = (int) (Math.random() * 255);
                int gr = (int) (Math.random() * 255);
                int b = (int) (Math.random() * 255);
                Color c = new Color(r, gr, b);
                g.setColor(c);
                g.drawLine(i, j, j, i);

            }
        }
       
    }
    
   public void dibuja3(Graphics g) {
        g.clearRect(0, 0, maxX, maxY+100);
        for (int i = 0; i < maxX; i += 100) {
            for (int j = 0; j < maxY; j += 100) {
                int r = (int) (Math.random() * 255);
                int gr = (int) (Math.random() * 255);
                int b = (int) (Math.random() * 255);
                Color c = new Color(r, gr, b);
                g.setColor(c);
                g.drawOval(i, j, 50, 50);
            }
        }
        for (int i = 0; i < maxX; i += 50) {
            for (int j = 0; j < maxY; j += 50) {
                int r = (int) (Math.random() * 255);
                int gr = (int) (Math.random() * 255);
                int b = (int) (Math.random() * 255);
                Color c = new Color(r, gr, b);
                g.setColor(c);
                g.drawRect(i, j, 50, 50);
            }
        }
    }
   public void dibuja4(Graphics g) {
        g.clearRect(0, 0, maxX, maxY+100);
        
        for (int i = 0; i < maxX; i += 100) {
            for (int j = 0; j < maxY; j += 100) {
                int r = (int) (Math.random() * 255);
                int gr = (int) (Math.random() * 255);
                int b = (int) (Math.random() * 255);
                Color c = new Color(r, gr, b);
                g.setColor(c);
                g.drawLine(i, j, j, i);
            }
        }
         for (int i = 0; i < maxX; i += 100) {
            for (int j = 50; j < maxY; j += 100) {
                int r = (int) (Math.random() * 255);
                int gr = (int) (Math.random() * 255);
                int b = (int) (Math.random() * 255);
                Color c = new Color(r, gr, b);
                g.setColor(c);
                g.fillOval(i, j, 50, 50);
        }
    }
   }
    public void dibuja5(Graphics g) {
        g.clearRect(0, 0, maxX, maxY+100);
        for (int i = 0; i < maxX; i += 50) {
            for (int j = 0; j < maxY; j += 50) {
                int r = (int) (Math.random() * 255);
                int gr = (int) (Math.random() * 255);
                int b = (int) (Math.random() * 255);
                Color c = new Color(r, gr, b);
                g.setColor(c);
                g.drawRect(i, j, j, i);
            }
        }
        for (int i = 0; i < maxX; i += 100) {
            for (int j = 0; j < maxY; j += 100) {
                int r = (int) (Math.random() * 255);
                int gr = (int) (Math.random() * 255);
                int b = (int) (Math.random() * 255);
                Color c = new Color(r, gr, b);
                g.setColor(c);
                g.drawOval(i, j, 100, 100);
            }
        }
    }

    public boolean handleEvent(Event e) {	//en caso de dar clic en el tache de la ventana 	
        //finaliza la aplicacion	
        if (e.id == Event.WINDOW_DESTROY) {
            System.exit(0);
        }
        return super.handleEvent(e);
    }
};

class Lienzos extends Canvas {

    public Graphics getGraphics(Graphics g) {
        return g;
    }
}
