package intStack;


public class IntStack {
	
	private int max; // ���� �뷮
	private int ptr; // ���� ������ 
	private int[] stk; // ���� ��ü
	// ����ó��: ������ �������
	public class EmptyIntStackException extends RuntimeException{
		public EmptyIntStackException() {
			
		}
	}
	// ����ó�� : ������ ������
	public class OverflowIntStackException extends RuntimeException{
		public OverflowIntStackException() {
			
		}
	}
	
	public IntStack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = new int[max]; //���� ��ü�� �迭 ����
		}catch(OutOfMemoryError e){
			max= 0;
		}
	}
	public int push(int x) throws OverflowIntStackException{
		if(ptr>max)
			throw new OverflowIntStackException();
		return stk[ptr++] = x;
	}
	public int pop() throws EmptyIntStackException{
		if(ptr<=0)
			throw new EmptyIntStackException();
		return stk[--ptr];
	}
	public int peek() throws EmptyIntStackException{
		if(ptr<=0)
			throw new EmptyIntStackException();
		return stk[ptr-1];
	}
	public int indexOf(int x) { //���ÿ��� x�� ã�� �ε���(������ -1) ��ȯ
		for(int i = ptr-1; i>=0; i--) {
			if(stk[i]==x)
				return i;
		}
		return -1;
	}
	public void clear() {
		ptr = 0;
	}
	public int capacity() {
		return max;
	}
	public int size() {
		return ptr;
	}
	public boolean isEmpty() {
		return ptr<=0;
	}
	public boolean isFull() {
		return ptr>=max;
	}
	public void dump() {
		if(ptr<=0) {
			System.out.println("������ ����ֽ��ϴ�.");
		}else{
			for(int i = 0 ; i<ptr; i++) {
				System.out.println(stk[i] + "");
			}
			System.out.println();
		}
	}

}
