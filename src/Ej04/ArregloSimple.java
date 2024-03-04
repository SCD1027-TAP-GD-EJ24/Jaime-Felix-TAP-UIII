// Fig. 23.10: ArregloSimple.java
// Clase que administra un arreglo simple para compartirlo entre varios subprocesos.
package Ej04;
import java.util.Random;

public class ArregloSimple 
{
   private final int arreglo[]; // el arreglo entero compartido
   private int indiceEscritura = 0; // �ndice del siguiente elemento a escribir
   private final static Random generador = new Random();

   // construye un objeto ArregloSimple de un tama�o dado
   public ArregloSimple( int tamanio )
   {
      arreglo = new int[ tamanio ];
   } // fin del constructor

   // agrega un valor al arreglo compartido
   public synchronized void agregar( int valor )
   {
      int posicion = indiceEscritura; // almacena el �ndice de escritura

      try
      {
         // pone el subproceso en inactivudad de 0 a 499 milisegundos
         Thread.sleep( generador.nextInt( 500 ) ); 
      } // fin de try
      catch ( InterruptedException ex )
      {
         ex.printStackTrace();
      } // fin de catch

      // coloca el valor en el elemento apropiado
      arreglo[ posicion ] = valor;
      System.out.printf( "%s escribio %2d en el elemento %d.\n", 
         Thread.currentThread().getName(), valor, posicion );

      ++indiceEscritura; // incrementa el �ndice del siguiente elemento a escribir
      System.out.printf( "Siguiente indice de escritura: %d\n", indiceEscritura );
   } // fin del m�todo agregar
   
   // se utiliza para imprimir el contenido del arreglo entero compartido
   public String toString()
   {
      String cadenaArreglo = "\nContenido de ArregloSimple:\n";
   
      for ( int i = 0; i < arreglo.length; i++ )
         cadenaArreglo += arreglo[ i ] + " ";
   
      return cadenaArreglo;
   } // fin del m�todo toString
} // fin de la clase ArregloSimple


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