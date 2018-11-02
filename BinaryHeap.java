public class BinaryHeap {

	private int a[] = new int [10];
	private int size = 0;
	
	public int remove() {
		int pri = a[0];
		a[0] = a[size - 1];
		-- size;
		shiftdown(0);
		return pri;
	}
	
	private void growarray() {
		int newArray[] = new int[a.length*2];
		for(int i = 0; i < size; i++) {
			newArray[i] = a[i];
		}
		a = newArray;
	}
	
	public void add(int pri){
		if  (a.length == size)
		{
			growarray();
		}
		a[size] = pri;
		++size;
		int index = size - 1;
		int parent = (index-1)/2;
		while(index > 0 && a[index] < a[parent]){
		swap(a,index,parent);
		index = parent;
		parent = (index - 1)/2;
		}
	}
	
	public void swap(int []a, int index, int child) {
		int temp = a[index];
		a[index] = a[child];
		a[child] = temp;
		
	}

	public void shiftdown(int parent){
		
		int child = parent *2+1;
		if(child >= size) // base case
		{
			return;
		}
		if(a[child+1] < a[child])
		child++;
		if(a[parent] > a[child]){
		swap(a,child,parent);
		shiftdown(child);
		}
		}


}
