// Fig. 23.15: PruebaBuferCompartido.java
// Aplicaci�n con dos subprocesos que manipulan un b�fer sin sincronizaci�n.
package Ej05;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

public class PruebaBuferCompartido
{
   public static void main( String[] args )
   {
      // crea nueva reserva de subprocesos con dos subprocesos
      ExecutorService aplicacion = Executors.newCachedThreadPool();

      // crea objeto BuferSinSincronizacion para almacenar valores int       
      Bufer ubicacionCompartida = new BuferSinSincronizacion();

      System.out.println( 
         "Accion\t\t\tValor\tSuma producidos\tSuma consumidos" );
      System.out.println( 
         "------\t\t\t-----\t---------------\t---------------\n" );

      // ejecuta el Productor y el Consumidor; a cada uno de ellos
      // le proporciona acceso a ubicacionCompartida
      aplicacion.execute( new Productor( ubicacionCompartida ) );
      aplicacion.execute( new Consumidor( ubicacionCompartida ) );

      aplicacion.shutdown(); // termina la aplicaci�n cuando se completan las tareas
   } // fin de main
} // fin de la clase PruebaBuferCompartido




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