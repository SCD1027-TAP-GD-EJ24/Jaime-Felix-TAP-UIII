// Fig. 23.16: BuferBloqueo.java
// Crea un b�fer sincronizado, usando la clase ArrayBlockingQueue.
package Ej06;
import java.util.concurrent.ArrayBlockingQueue;

public class BuferBloqueo implements Bufer
{
   private final ArrayBlockingQueue<Integer> bufer; // bufer compartido

   public BuferBloqueo()
   {
      bufer = new ArrayBlockingQueue<Integer>( 3 );
   } // fin del constructor de BuferBloqueo
   
   // coloca un valor en el b�fer
   public void establecer( int valor ) throws InterruptedException
   {
      bufer.put( valor ); // coloca el valor en el b�fer
      System.out.printf( "%s%2d\t%s%d\n", "Productor escribe ", valor,
         "Celdas de Bufer ocupadas: ", bufer.size() );
   } // fin del m�todo establecer

   // devuelve el valor del b�fer
   public int obtener() throws InterruptedException
   {
      int valorLeido = 0; // inicializa el valor le�do del b�fer

      valorLeido = bufer.take(); // elimina el valor del b�fer
      System.out.printf( "%s   %2d\t%s%d\n", "Consumidor lee ", 
         valorLeido, "Celdas de Bufer ocupadas: ", bufer.size() );

      return valorLeido;
   } // fin del m�todo obtener
} // fin de la clase BuferBloqueo


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