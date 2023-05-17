public class GenericQueue<E>{
	private java.util.ArrayList<E> list = new java.util.ArrayList<>();
	
	public void enqueue (E e){
		list.add(e);
	}
	public E dequeue(){
		return list.remove(0);
	}
	public int getSize(){
		return list.size();
	}
	@Override
	public String toString() {
		return "Queue: " + list.toString();
  }
}