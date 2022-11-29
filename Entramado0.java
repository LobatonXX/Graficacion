
package graficacion;

/**
 * @author LOBATON
 */
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.lang.Math;

public class Entramado0 extends JFrame
        implements ActionListener //PaolaNeri ClaseGraficacion 2020
{

    JMenuBar menu = new JMenuBar(); //crea una barra de menu
    JMenu menu1 = new JMenu("Entramado", true);//Submenu	
    JMenuItem it1 = new JMenuItem("Iniciar");
    JMenuItem it2 = new JMenuItem("Pausar");

    Lienzo lienzo = new Lienzo();
    Image icon;//Declara un objeto de imagen tipo icono
    int maxX, maxY;//Determina las coordenadas maximas del frame

    public static void main(String[] args) throws IOException {
        System.out.println("La practica entramado esta corriendo..");
        Entramado0  i = new Entramado0 ();//se llama al constructor del frame
    }

    public Entramado0 () throws IOException//crear el constructor del frame
    {
        super("Entramado");//Asi se llama al constructor de una clase extendida
        maxX = 1250;
        maxY = 800;
        setJMenuBar(menu);//Agrega la barra de menu al frame
        menu.add(menu1);//agrega los menus 1 y 3 a la barra de menu
        menu1.add(it1);// agrega items al menu 1 y 
        menu1.add(it2);//un submenu 2

        icon = new ImageIcon("mia.jpg").getImage();//crear un icono con el archivo de entrada 
        //organiza componentes en paneles
        JPanel p1 = new JPanel(new BorderLayout());
        p1.add(lienzo, BorderLayout.CENTER);
        getContentPane().add(p1);
        //declara los objetos que escuchara el manejador de eventos
        it1.addActionListener(this);
        it2.addActionListener(this);
        //mueve el frame a la posicion indicada y establece el tamaño
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
            dibuja(lienzo.getGraphics());
        }
        //si se elige el menu 1-2
        if (object == it2) {
        }
    }

    public void dibuja(Graphics g) {
        g.clearRect(0, 0, maxX, maxY);
        g.setColor(Color.pink);
        int xP [] = {400,100,200,300,500,600,700,400};
        int yP [] = {650,250,150,100,100,150,250,650};
        g.fillPolygon(xP, yP, 8); 
        g.setColor(Color.black);
        g.drawLine(100,250,250,300);
        g.drawLine(250,300,550,300);
        g.drawLine(550,300,700,250);
        g.drawLine(700,250,600,150);
        g.drawLine(600,150,500,100);
        g.drawLine(500,100,300,100);
        g.drawLine(300,100,200,150);
        g.drawLine(200,150,100,250);
        g.drawLine(100,250,400,650);
        g.drawLine(400,650,700,250);
        g.drawLine(200,150,300,200);
        g.drawLine(300,200,500,200);
        g.drawLine(500,200,600,150);
        
        g.drawLine(300,200,250,300);
        g.drawLine(500,200,550,300);
        g.drawLine(250,300,400,650);
        g.drawLine(550,300,400,650);
        
        
    
        
        
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

class Lienzo extends Canvas {

    public Graphics getGraphics(Graphics g) {
        return g;
    }
}