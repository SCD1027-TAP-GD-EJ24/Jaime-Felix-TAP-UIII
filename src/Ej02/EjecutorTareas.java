// Fig. 23.6: EjecutorTareas.java
// Uso de un objeto ExecutorService para ejecutar objetos Runnable.
package Ej02;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class EjecutorTareas
{
   public static void main( String[] args )
   {
      // crea y nombra cada objeto Runnable
      TareaImprimir tarea1 = new TareaImprimir( "tarea1" );
      TareaImprimir tarea2 = new TareaImprimir( "tarea2" );
      TareaImprimir tarea3 = new TareaImprimir( "tarea3" );
        
      System.out.println( "Iniciando Executor" );

      // crea objeto ExecutorService para administrar los subprocesos
      ExecutorService ejecutorSubprocesos = Executors.newCachedThreadPool();

      // inicia los subprocesos y los coloca en el estado ejecutable
      ejecutorSubprocesos.execute( tarea1 ); // inicia tarea1	
      ejecutorSubprocesos.execute( tarea2 ); // inicia tarea2
      ejecutorSubprocesos.execute( tarea3 ); // inicia tarea3

      // cierra los subprocesos trabajadores cuando terminan sus tareas
      ejecutorSubprocesos.shutdown(); 

      System.out.println( "Tareas iniciadas, main termina.\n" );
   } // fin de main
} // fin de la clase EjecutorTareas


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