// Fig. 23.14: BuferSinSincronizacion.java
// BuferSinSincronizacion mantiene el entero compartido que utilizan los 
// subprocesos productor y consumidor mediante los m�todos establecer y obtener.
package Ej05;
public class BuferSinSincronizacion implements Bufer
{
   private int bufer = -1; // compartido por los subprocesos productor y consumidor

   // coloca el valor en el b�fer
   public void establecer( int valor ) throws InterruptedException
   {
      System.out.printf( "Productor escribe\t%2d", valor );
      bufer = valor;
   } // fin del m�todo establecer

   // devuelve el valor del b�fer
   public int obtener() throws InterruptedException
   {
      System.out.printf( "Consumidor lee\t\t%2d", bufer );
      return bufer;
   } // fin del m�todo obtener
} // fin de la clase BuferSinSincronizacion




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