// Fig 23.9: PruebaArregloCompartido.java
// Ejecuta dos objetos Runnable para agregar elementos a un objeto ArregloSimple compartido.
package Ej03;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class PruebaArregloCompartido
{
   public static void main( String[] arg )
   {
      // construye el objeto compartido
      ArregloSimple arregloSimpleCompartido = new ArregloSimple( 6 );

      // crea dos tareas para escribir en el objeto ArregloSimple compartido
      EscritorArreglo escritor1 = new EscritorArreglo( 1, arregloSimpleCompartido );
      EscritorArreglo escritor2 = new EscritorArreglo( 11, arregloSimpleCompartido );

      // ejecuta las tareas con un objeto ExecutorService
      ExecutorService ejecutor = Executors.newCachedThreadPool();
      ejecutor.execute( escritor1 );
      ejecutor.execute( escritor2 );

      ejecutor.shutdown();

      try
      {
         // espera 1 minuto para que ambos escritores terminen de ejecutarse
         boolean tareasTerminaron = ejecutor.awaitTermination( 
            1, TimeUnit.MINUTES );

         if ( tareasTerminaron )
            System.out.println( arregloSimpleCompartido ); // imprime el contendio
         else
            System.out.println( 
               "Se agoto el tiempo esperando a que las tareas terminaran." );
      } // fin de try
      catch ( InterruptedException ex )
      {
         System.out.println( 
            "Hubo una interrupcion mientras esperaba a que terminaran las tareas." );
      } // fin de catch
   } // fin de main
} // fin de la clase PruebaArregloCompartido


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