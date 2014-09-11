
package tp1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularTable implements Iterable<Integer>
{
	//Taille de la file.
   private int size=0;
   //Premier element de la file
   private int startindex=0;
   private int[] table=new int[5];
   
    //Constructeur de la classe
   public CircularTable() 
   {
      //A completer
	  
	  
   }


   // File vide?
   public boolean isEmpty() 
   { 
      return size==0; 
   }

   // Taille de la file
   public int size() 
   { 
      return size; 
   }

   //Retourne l'element a l'index "index" s'il existe
   public int get(int index) 
   {
	
      if (index >= size() || index < 0) 
         throw new IndexOutOfBoundsException();
         
      //A completer
      
      return table[(startindex + index) % table.length]; 
	  
   }
   
   //Double la taille de la file et replace les elements de la file au debut du tableau
   public void doubleSize(){
	
		//A completer
	   
	   int[] temp = new int[table.length];
	   
	   for(int i = 0; i < size; i++){
		   
		  temp[i] =  table[(startindex + i) % table.length];
	   }
	   
	   table = new int[table.length * 2];
	   
	   for(int i = 0; i < size; i++){
		   
			  table[i] =  temp[i];
		   }
	   
	   startindex = 0;
		
		
   }

 
   //Ajout d'un element a la fin de la file
   public void append(int item) 
   {
	   table[(startindex + size) % table.length] = item;
	  
	   size++;
      
	   if(size == table.length)
		   doubleSize();
   }

   //Ajoute un element a la position "index" dans la file
   public void insert(int item, int index) 
   {
	  
	   
	   
	   
	   if (index > size() || index < 0) 
		 throw new IndexOutOfBoundsException();
	  
	// Decalage vers la droite
	  if(index >= size/2){
		  
		  for(int i = size; i > index; i--){
		  
		  table[(startindex + i) % table.length] =  table[(startindex + i - 1) % table.length];
		  
		  }
	  }
	   
	   //Decalage vers la gauche
	   if(index < size/2){
		   for(int i = 0; i < index; i++){
		   
			   table[(startindex + i -1 + table.length) % table.length] = table[(startindex + i ) % table.length];
		   
		   }
	   
	   		startindex = (startindex -1 + table.length) % table.length;
	   }
	  
	  table[(startindex + index) % table.length] = item;
	  
	  size++;
	  
	  if(size == table.length)
		   doubleSize();
	  
	  
   }

   //Elimine un element a une position donnee dans la file
   public void remove(int index) 
   {
      if (index >= size() || index < 0) 
         throw new IndexOutOfBoundsException();
      
      //A completer
	   for(int k=index; k<size()-1;k++){
			table[(startindex+k)%table.length]=get(k+1);
	   }
	   size--;
   }

   // Methode requise par l'interface Iterable
   public Iterator<Integer> iterator() 
   { 
      return new CircularTableIterator(); 
   }

   // L'iterateur retourne par la methode iterator()
   private class CircularTableIterator implements Iterator<Integer> 
   {
      private int currentindex = startindex;
      private int i = 0;

      public boolean hasNext() 
      { 
         return i < size();
      }

      public void remove() 
      { 
         throw new UnsupportedOperationException();  
      }

      public Integer next() 
      {
         if (!hasNext()) 
            throw new NoSuchElementException();
         //A completer
         
        int  valeur =  table[(i + currentindex) % table.length ];
        i++;
        return valeur;
        
        		 
      }
   }



   /* ******************************
      Expected output:

      Forward list: 
	0 1 2 3 4 5 6 7 8 9 

	Forward list after edition: 
	3 4 5 6 7 8 9 0 1 2 

	Reverse list: 
	9 8 7 6 5 4 3 2 1 0 

	Mod3 list: 
	9 6 7 8 3 4 5 0 1 2 

	Forward list after edition and removal: 
	2 


	  
	  Les impressions a completer dans le main utilisent le format d'iteration foreach permis par l'interface iterable.
      
   ********************************* */

   public static void main(String[] args) 
   {
      CircularTable circularListForward = new CircularTable();
      CircularTable circularListReverse = new CircularTable();
      CircularTable circularListMod3 = new CircularTable();

      for (int i=0; i<10; i++) 
      {
         circularListForward.append(i);
         circularListReverse.insert(i,0);
         circularListMod3.insert(i,i%3);

      }
      
      System.out.println("Forward list: ");
      
      for(int item : circularListForward){
    	  System.out.print(String.valueOf(item));
          System.out.print(" ");
      }
	  //A completer, impression des elements de circularListForward
      
      
      System.out.println("\n");

	  System.out.println("Forward list after edition: ");
      circularListForward.remove(0);
      circularListForward.remove(0);
      circularListForward.remove(0);
      circularListForward.append(0);
      circularListForward.append(1);
      circularListForward.append(2);

      
      //A completer, impression des elements de circularListForward après edition
	  
    
	  
    
      
      for(int item : circularListForward){
    	  System.out.print(String.valueOf(item));
          System.out.print(" ");
      }
      
	   //A completer, impression des elements de circularListReverse
      System.out.println("\n");
     
      
      System.out.println("Reverse list: ");
      
      for(int item : circularListReverse){
    	  System.out.print(String.valueOf(item));
          System.out.print(" ");
      }
      
      
      System.out.println("\n");

      System.out.println("Mod3 list: ");
      
      for(int item : circularListMod3){
    	  System.out.print(String.valueOf(item));
          System.out.print(" ");
      }
      
	  //A completer, impression des elements de circularListMod3
    
      
      System.out.println("\n");

      for (int i=0; i<9; i++)
         circularListForward.remove(0);
      
      System.out.println("Forward list after edition and removal: ");
      
      //A completer, impression des elements de circularListForward      
      
      
      for(int item : circularListForward){
    	  System.out.print(String.valueOf(item));
          System.out.print(" ");
      }
   }
   
}

