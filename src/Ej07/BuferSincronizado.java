// Fig. 23.18: BuferSincronizado.java
// Sincronizaci�n del acceso a datos compartidos, usando los  
// m�todos wait y notify de Object.
package Ej07;
public class BuferSincronizado implements Bufer
{
   private int bufer = -1; // compartido por los subprocesos productor y consumidor
   private boolean ocupado = false;// indica si el b�fer est� ocupado o no
   
   // coloca el valor en el b�fer
   public synchronized void establecer( int valor ) throws InterruptedException
   {
      // mientras no haya ubicaciones vac�as, coloca el subproceso en espera
      while ( ocupado ) 
      {
         // imprime informaci�n del subproceso e informaci�n del b�fer, despu�s espera
         System.out.println( "Productor trata de escribir." );
         mostrarEstado( "Bufer lleno. Productor espera." );
         wait();
      } // fin de while
        
      bufer = valor; // establece el nuevo valor del b�fer
        
      // indica que el productor no puede almacenar otro valor
      // hasta que el consumidor obtenga el valor actual del b�fer
      ocupado = true;
        
      mostrarEstado( "Productor escribe " + bufer );
      
      notifyAll(); // indica al (los) subproceso(s) en espera que entren al estado runnable
   } // fin del m�todo establecer; libera el bloqueo sobre BuferSincronizado 
    
   // devuelve el valor del b�fer
   public synchronized int obtener() throws InterruptedException
   {
      // mientras no haya datos para leer, coloca el subproceso en el estado en espera
      while ( !ocupado )
      {
         // imprime la informaci�n del subproceso y la informaci�n del b�fer, despu�s espera
         System.out.println( "Consumidor trata de leer." );
         mostrarEstado( "Bufer vacio. Consumidor espera." );
         wait();
      } // fin de while

      // indica que el productor puede almacenar otro valor
      // debido a que el consumidor acaba de obtener el valor del b�fer
      ocupado = false;

      mostrarEstado( "Consumidor lee " + bufer );
      
      notifyAll(); // indica al (los) subproceso(s) en espera que entren al estado runnable

      return bufer;
   } // fin del m�todo obtener; libera el bloqueo sobre BuferSincronizado 
    
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