import java.io.*;
import java.util.Stack;

public class PostfixSolver 
{
   public static void main(String[] args) throws IOException 
   {
      Stack<Double> stack = new Stack<Double>();

      
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      String s;

      //Les caracteres sont lus de la ligne de commande tant que l'usager n'entre
      // pas "exit"
      System.out.println("Entrez une expression postfixe");
      
      while (!(s = in.readLine()).equals("exit")) 
      {
         //L'expression est separee en tokens selon les espaces
         for(String token : s.split("\\s")) 
         {
        	 boolean unChiffre = true;
        	 
        	 if(token.equals("+")){
        		 
        		 stack.push(stack.pop() + stack.pop());
        		 unChiffre = false;
        	 }
        	 
        	 if(token.equals("-")){
        		 
        		 stack.push((stack.pop() - stack.pop()) * -1);
        		 unChiffre = false;
        	 }
        	 
        	 if(token.equals("*")){
        		 
        		 stack.push(stack.pop() * stack.pop());
        		 unChiffre = false;
        	 }
        	 
        	 if(token.equals("/")){
        		 
        		 stack.push(Math.pow(stack.pop() / stack.pop(), -1.0));
        		 unChiffre = false;
        	 }
        	 
        	 if(unChiffre)        		 
        		 stack.push(Double.valueOf(token));
        	 
         }
         
         System.out.println("Le resultat de l'expression est: "+stack.pop());
         
      }
      // "exit" stoppe le programme
   }
}
