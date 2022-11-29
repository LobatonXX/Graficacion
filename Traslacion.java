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

public class Traslacion extends JFrame
        implements ActionListener //PaolaNeri ClaseGraficacion 2020
{

    JMenuBar menu = new JMenuBar(); //crea una barra de menu
    JMenu menu1 = new JMenu("Entramado", true);//Submenu	
    JMenuItem it1 = new JMenuItem("Iniciar");
    JMenuItem it2 = new JMenuItem("Pausar");

    Lienzoo lienzoo = new Lienzoo();
    Image icon;//Declara un objeto de imagen tipo icono
    int maxX, maxY;//Determina las coordenadas maximas del frame

    public static void main(String[] args) throws IOException {
        System.out.println("La practica entramado esta corriendo..");
        Traslacion i = new Traslacion();//se llama al constructor del frame
    }

    public Traslacion() throws IOException//crear el constructor del frame
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
        p1.add(lienzoo, BorderLayout.CENTER);
        getContentPane().add(p1);
        //declara los objetos que escuchara el manejador de eventos
        it1.addActionListener(this);
        it2.addActionListener(this);
        //mueve el frame a la posicion indicada y establece el tamaÃ±o
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
            dibuja(lienzoo.getGraphics());
        }
        //si se elige el menu 1-2
        if (object == it2) {
        }
    }

    public void dibuja(Graphics g) {
        Thread t = new Thread();
        g.clearRect(0, 0, maxX, maxY);
        g.setColor(Color.pink);
        try {
            t.start();
            int x = 0;
            int y = 0;

            for (int i = 0; i < 1000; i++) {
                g.clearRect(0, 0, 1000, 500);
                g.fillRect(x, y - i, 50, 50);
                t.sleep(50);
            }
     
    }
    catch (Exception e

    
        ) 
                        {
            System.out.println(e);
    }

}

//manejador de eventos de ventanas windows
@Override
        public boolean handleEvent
            (Event e
        
            
                ) {	//en caso de dar clic en el tache de la ventana 	
        //finaliza la aplicacion	
        if (e.id == Event.WINDOW_DESTROY) {
                    System.exit(0);
                }
                return super.handleEvent(e);
            

}
        }
        ;

        class Lienzoo extends Canvas {

    public Graphics getGraphics(Graphics g) {
        return g;
    }
}
