// Fig. 23.4: TareaImprimir.java
// La clase TareaImprimir permanece inactiva durante un tiempo aleatorio entre 0 y 5 segundos
package Ej02;
import java.util.Random;

public class TareaImprimir implements Runnable 
{
   private final int tiempoInactividad; // tiempo de inactividad aleatorio para el subproceso
   private final String nombreTarea; // nombre de la tarea
   private final static Random generador = new Random();
    
   public TareaImprimir( String nombre )
   {
      nombreTarea = nombre; // establece el nombre de la tarea
        
      // elige un tiempo de inactividad aleatorio entre 0 y 5 segundos
      tiempoInactividad = generador.nextInt( 5000 ); // milisegundos
   } // fin el constructor de TareaImprimir

   // el m�todo run contiene el c�digo que ejecutar� un subproceso
   public void run()
   {
      try // deja el subproceso inactivo durante tiempoInactividad segundos 
      {
         System.out.printf( "%s va a estar inactivo durante %d milisegundos.\n", 
            nombreTarea, tiempoInactividad );
         Thread.sleep( tiempoInactividad ); // deja el subproceso inactivo
      } // fin de try        
      catch ( InterruptedException excepcion )
      {
         System.out.printf( "%s %s\n", nombreTarea,
            "termino en forma prematura, debido a la interrupcion" );
      } // fin de catch
        
      // imprime el nombre de la tarea
      System.out.printf( "%s termino su inactividad\n", nombreTarea ); 
   } // fin del m�todo run
} // fin de la clase TareaImprimir


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