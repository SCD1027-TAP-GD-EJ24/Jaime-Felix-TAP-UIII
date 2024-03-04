// Fig. 23.25: CalculadoraSegundoPlano.java
// Subclase de SwingWorker para calcular n�meros de Fibonacci
// en un subproceso en segundo plano.
package Ej10;
import javax.swing.SwingWorker;
import javax.swing.JLabel;
import java.util.concurrent.ExecutionException;

public class CalculadoraSegundoPlano extends SwingWorker< String, Object >
{
   private final int n; // n�mero de Fibonacci a calcular
   private final JLabel resultadoJLabel; // JLabel para mostrar el resultado

   // constructor
   public CalculadoraSegundoPlano( int numero, JLabel etiqueta )
   {
      n = numero;
      resultadoJLabel = etiqueta;
   } // fin del constructor de CalculadoraSegundoPlano

   // c�digo que tarda mucho en ejecutarse, para ejecutarlo en un subproceso trabajador
   public String doInBackground()
   {
      long nesimoFib = fibonacci( n );
      return String.valueOf( nesimoFib );
   } // fin del m�todo doInBackground

   // c�digo para ejecutar en el subproceso de despachamiento de eventos cuando regresa doInBackground
   protected void done()
   {
      try
      {
         // obtiene el resultado de doInBackground y lo muestra
         resultadoJLabel.setText( get() );
      } // fin de try
      catch ( InterruptedException ex ) 
      {
         resultadoJLabel.setText( "Se interrumpio mientras esperaba los resultados." );
      } // fin de catch
      catch ( ExecutionException ex ) 
      {
         resultadoJLabel.setText( 
            "Se encontro un error al realizar el calculo." );
      } // fin de catch
   } // fin del m�todo done

   // m�todo recursivo fibonacci; calcula el n-�simo n�mero de Fibonacci
   public long fibonacci( long numero )
   {
      if ( numero == 0 || numero == 1 )
         return numero;
      else 
         return fibonacci( numero - 1 ) + fibonacci( numero - 2 );
   } // fin del m�todo fibonacci
} // fin de la clase CalculadoraSegundoPlano

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