// Fig. 23.12: Productor.java
// Productor con un m�todo run que inserta los valores del 1 al 10 en el b�fer.
package Ej09;
import java.util.Random;

public class Productor implements Runnable
{
   private final static Random generador = new Random();
   private final Bufer ubicacionCompartida; // referencia al objeto compartido

   // constructor
   public Productor( Bufer compartido )
   {
       ubicacionCompartida = compartido;
   } // fin del constructor de Productor

   // almacena valores del 1 al 10 en ubicacionCompartida
   public void run()                             
   {
      int suma = 0;

      for ( int cuenta = 1; cuenta <= 10; cuenta++ )
      {
         try // permanece inactivo de 0 a 3 segundos, despu�s coloca valor en Bufer
         {
            Thread.sleep( generador.nextInt( 3000 ) ); // periodo de inactividad aleatorio
            ubicacionCompartida.establecer( cuenta ); // establece el valor en el b�fer
            suma += cuenta; // incrementa la suma de los valores
         } // fin de try
         // si las l�neas 25 o 26 se interrumpen, imprime el rastreo de la pila
         catch ( InterruptedException excepcion ) 
         {
            excepcion.printStackTrace();
         } // fin de catch
      } // fin de for

      System.out.println( 
         "Productor termino de producir\nTerminando Productor" );
   } // fin del m�todo run
} // fin de la clase Productor



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