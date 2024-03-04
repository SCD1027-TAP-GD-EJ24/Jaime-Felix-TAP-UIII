// Fig. 23.13: Consumidor.java
// Consumidor con un m�todo run que itera y lee 10 valores del b�fer.
package Ej09;
import java.util.Random;

public class Consumidor implements Runnable
{ 
   private final static Random generador = new Random();
   private final Bufer ubicacionCompartida; // referencia al objeto compartido

   // constructor
   public Consumidor( Bufer compartido )
   {
      ubicacionCompartida = compartido;
   } // fin del constructor de Consumidor

   // lee el valor de ubicacionCompartida 10 veces y suma los valores
   public void run()                                           
   {
      int suma = 0;

      for ( int cuenta = 1; cuenta <= 10; cuenta++ ) 
      {
         // permanece inactivo de 0 a 3 segundos, lee un valor del b�fer y lo agrega a suma
         try 
         {
            Thread.sleep( generador.nextInt( 3000 ) );
            suma += ubicacionCompartida.obtener();
         } // fin de try
         // si las l�neas 26 o 27 se interrumpen, imprime el rastreo de la pila
         catch ( InterruptedException excepcion ) 
         {
            excepcion.printStackTrace();
         } // fin de catch
      } // fin de for

      System.out.printf( "\n%s %d\n%s\n", 
         "Consumidor leyo valores, el total es", suma, "Terminando Consumidor" );
   } // fin del m�todo run
} // fin de la clase Consumidor


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