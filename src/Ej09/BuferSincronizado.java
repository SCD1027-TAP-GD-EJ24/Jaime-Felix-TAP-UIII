// Fig. 23.22: BuferSincronizado.java
// Sincroniza el acceso a un entero compartido, usando las interfaces
// Lock y Condition
package Ej09;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class BuferSincronizado implements Bufer
{
   // Bloqueo para controlar la sincronizaci�n con este b�fer
   private final Lock bloqueoAcceso = new ReentrantLock();

   // condiciones para controlar la lectura y escritura
   private final Condition puedeEscribir = bloqueoAcceso.newCondition();
   private final Condition puedeLeer = bloqueoAcceso.newCondition();

   private int bufer = -1; // compartido por los subprocesos productor y consumidor
   private boolean ocupado = false; // indica si el b�fer est� ocupado
   
   // coloca un valor int en el b�fer
   public void establecer( int valor ) throws InterruptedException
   {
      bloqueoAcceso.lock(); // bloquea este objeto
               
      // imprime informaci�n del subproceso y del b�fer, despu�s espera
      try
      {
         // mientras bufer no est� vac�o, coloca el subproceso en espera
         while ( ocupado ) 
         {
            System.out.println( "Productor trata de escribir." );
            mostrarEstado( "Bufer lleno. Productor espera." );
            puedeEscribir.await();// espera hasta que bufer est� vac�o
         } // fin de while

         bufer = valor; // establece el nuevo valor de bufer

         // indica que el productor no puede almacenar otro valor
         // hasta que el consumidor obtenga el valor actual del b�fer
         ocupado = true;
        
         mostrarEstado( "Productor escribe " + bufer );

         // indica al subproceso en espera que lea del b�fer
         puedeLeer.signal(); 
      } // fin de try
      finally
      {
         bloqueoAcceso.unlock(); // desbloquea este objeto
      } // fin de finally
   } // fin del m�todo establecer
    
   // devuelve el valor del b�fer
   public int obtener() throws InterruptedException
   {
      int valorLeido = 0; // inicializa el valor que se ley� del b�fer
      bloqueoAcceso.lock(); // bloquea este objeto

      // imprime informaci�n del subproceso y del b�fer, despu�s espera
      try
      {
         // mientras no haya datos qu� leer, coloca el subproceso en espera
         while ( !ocupado ) 
         {
            System.out.println( "Consumidor trata de leer." );
            mostrarEstado( "Bufer vacio. Consumidor espera." );
            puedeLeer.await(); // espera hasta que bufer est� lleno
         } // fin de while

         // indica que el productor puede almacenar otro valor
         // porque el consumidor acaba de obtener el valor del b�fer
         ocupado = false;

         valorLeido = bufer; // obtiene el valor del b�fer
         mostrarEstado( "Consumidor lee " + valorLeido );

         // indica al subproceso que espera a que el b�fer est� vac�o
         puedeEscribir.signal();
      } // fin de try
      finally
      {
         bloqueoAcceso.unlock(); // desbloquea este objeto
      } // fin de finally

      return valorLeido;
   } // fin del m�todo obtener
    
   // muestra la operaci�n actual y el estado del b�fer
   public void mostrarEstado( String operacion )
   {
      System.out.printf( "%-40s%d\t\t%b\n\n", operacion, bufer, 
         ocupado );
   } // fin del m�todo mostrarEstado
} // fin de la clase BuferSincronizado


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