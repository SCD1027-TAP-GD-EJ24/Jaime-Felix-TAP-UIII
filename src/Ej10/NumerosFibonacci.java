// Fig. 23.26: NumerosFibonacci.java
// Uso de SwingWorker para realizar un c�lculo extenso, en donde
// los resultados intermedios se muestran en una GUI.
package Ej10;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.util.concurrent.ExecutionException;

public class NumerosFibonacci extends JFrame 
{
   // componentes para calcular el valor de Fibonacci de un n�mero introducido por el usuario
   private final JPanel trabajadorJPanel =  
      new JPanel( new GridLayout( 2, 2, 5, 5 ) );
   private final JTextField numeroJTextField = new JTextField();
   private final JButton iniciarJButton = new JButton( "Iniciar" );
   private final JLabel fibonacciJLabel = new JLabel();

   // componentes y variables para obtener el siguiente n�mero de Fibonacci
   private final JPanel subprocesoEventosJPanel =  
      new JPanel( new GridLayout( 2, 2, 5, 5 ) );
   private int n1 = 0; // se inicializa con el primer n�mero de Fibonacci
   private int n2 = 1; // se inicializa con el segundo n�mero de Fibonacci
   private int cuenta = 1;
   private final JLabel nJLabel = new JLabel( "Fibonacci de 1: " );
   private final JLabel nFibonacciJLabel = 
      new JLabel( String.valueOf( n2 ) );
   private final JButton siguienteNumeroJButton = new JButton( "Siguiente numero" );

   // constructor
   public NumerosFibonacci()
   {
      super( "Numeros de Fibonacci" );
      setLayout( new GridLayout( 2, 1, 10, 10 ) );
      
      // agrega componentes de GUI al panel de SwingWorker
      trabajadorJPanel.setBorder( new TitledBorder( 
         new LineBorder( Color.BLACK ), "Con SwingWorker" ) );
      trabajadorJPanel.add( new JLabel( "Obtener Fibonacci de:" ) );
      trabajadorJPanel.add( numeroJTextField );
      iniciarJButton.addActionListener( 
         new ActionListener()
         {
            public void actionPerformed( ActionEvent evento )
            {
               int n;

               try
               {
                  // obtiene la entrada del usuario como un entero
                  n = Integer.parseInt( numeroJTextField.getText() );
               } // fin de try
               catch( NumberFormatException ex )
               {
                  // muestra un mensaje de error si el usuario no
                  // introdujo un entero
                  fibonacciJLabel.setText( "Escriba un entero." );
                  return;
               } // fin de catch
               
               // indica que ha empezado el c�lculo
               fibonacciJLabel.setText( "Calculando..." );

               // crea una tarea para realizar el c�lculo en segundo plano
               CalculadoraSegundoPlano tarea = 
                  new CalculadoraSegundoPlano( n, fibonacciJLabel );         
               tarea.execute(); // ejecuta la tarea
            } // fin del m�todo actionPerformed
         } // fin de la clase interna an�nima
      ); // fin de la llamada a addActionListener         
      trabajadorJPanel.add( iniciarJButton );
      trabajadorJPanel.add( fibonacciJLabel );
      
      // agrega componentes de GUI al panel del subproceso de despachamiento de eventos
      subprocesoEventosJPanel.setBorder( new TitledBorder( 
         new LineBorder( Color.BLACK ), "Sin SwingWorker" ) );
      subprocesoEventosJPanel.add( nJLabel );
      subprocesoEventosJPanel.add( nFibonacciJLabel ); 
      siguienteNumeroJButton.addActionListener( 
         new ActionListener()
         {
            public void actionPerformed( ActionEvent evento )
            {
               // calcula el n�mero de Fibonacci despu�s de n2
               int temp = n1 + n2;
               n1 = n2;
               n2 = temp;
               ++cuenta;

               // muestra el siguiente n�mero de Fibonacci
               nJLabel.setText( "Fibonacci de " + cuenta + ": " );
               nFibonacciJLabel.setText( String.valueOf( n2 ) );
            } // fin del m�todo actionPerformed         
         } // fin de la clase interna an�nima
      ); // fin de la llamada a addActionListener
      subprocesoEventosJPanel.add( siguienteNumeroJButton );

      add( trabajadorJPanel );
      add( subprocesoEventosJPanel );
      setSize( 275, 200 );
      setVisible( true );
   } // fin del constructor

   // el m�todo main empieza la ejecuci�n del programa
   public static void main( String[] args )
   {
      NumerosFibonacci aplicacion = new NumerosFibonacci();
      aplicacion.setDefaultCloseOperation( EXIT_ON_CLOSE );
   } // fin de main
} // fin de la clase NumerosFibonacci

/**************************************************************************
 * (C) Copyright 1992-2007 por Deitel & Associates, Inc. y                *
 * Pearson Education, Inc. Todos los derechos reservados.                 *
 *                                                                        *
 * RENUNCIA: Los autores y el editor de este libro han realizado su mejor *
 * esfuerzo para preparar este libro. Esto incluye el desarrollo, la      *
 * investigaci�n y prueba de las teor�as y programas para determinar su   *
 * efectividad. Los autores y el editor no hacen ninguna garant�a de      *
 * ning�n tipo, expresa o impl�cita, en relaci�n con estos programas o    *
 * con la documentaci�n contenida en estos libros. Los autores y el       *
 * editor no ser�n responsables en ning�n caso por los da�os consecuentes *
 * en conexi�n con, o que surjan de, el suministro, desempe�o o uso de    *
 * estos programas.                                                       *
 *************************************************************************/