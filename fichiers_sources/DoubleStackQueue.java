import java.util.Stack;
import java.util.EmptyStackException;

public class DoubleStackQueue<Elem> implements myQueue<Elem>
{

	private Stack<Elem> reverse = new Stack<Elem>();
	private Stack<Elem> forward = new Stack<Elem>();
	
	public void offer(Elem element) {
		// TODO Auto-generated method stub
		if(!forward.empty())
			QueueToStack();
		
		reverse.push(element);
		
		
	}

	public Elem peek() {
		// TODO Auto-generated method stub
		if(forward.empty())
			StackToQueue();
		
		
		return forward.peek();
		
	}

	public Elem poll() {
		// TODO Auto-generated method stub
		
	if(forward.empty())
		StackToQueue();
	
	return forward.pop();
		
	}
	
	
   //A completer
	
	public void StackToQueue(){
		
		while(!reverse.empty())			
			forward.push(reverse.pop());
		
		
	}
	
	public void QueueToStack(){
		
			
		while(!forward.empty())			
			reverse.push(forward.pop());
	
	}
	
	
	public static void main(String[] args) {
		
		DoubleStackQueue<Integer> maFile = new DoubleStackQueue();
		
		maFile.offer(6);
		maFile.offer(7);
		maFile.offer(8);
		maFile.offer(9);
		
		System.out.println(String.valueOf(maFile.peek()));
		System.out.println(String.valueOf(maFile.poll()));
		System.out.println(String.valueOf(maFile.poll()));
		
		maFile.offer(10);
		maFile.offer(11);
		maFile.offer(12);
		
		System.out.println(String.valueOf(maFile.peek()));
		System.out.println(String.valueOf(maFile.poll()));
		System.out.println(String.valueOf(maFile.poll()));
		System.out.println(String.valueOf(maFile.poll()));
		System.out.println(String.valueOf(maFile.peek()));
		System.out.println(String.valueOf(-1%4));
		
		
	}
}
