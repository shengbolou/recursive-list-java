package structure;

public class List<T> implements ListInterface<T>{

	private int size;
	private LLnode<T> head,temp,t;
	private T l;



	public List(){
		size=0;
		head=null;
		temp=null;
		t=null;
		l=null;

	}
	public int size() {
		return size;
	}

	@Override
	public ListInterface<T> insertFirst(T elem) {
		if(elem==null) throw new NullPointerException();
		LLnode<T> newnode=new LLnode<T>(elem);
		if(head==null){
			head=newnode;
			temp=head;
			size++;
		}
		else{
			newnode.setLink(head);
			head=newnode;
			temp=head;
			size++;
		}
		return this;
	}

	@Override
	public ListInterface<T> insertLast(T elem) {
		if(elem==null) throw new NullPointerException();
		LLnode<T> newnode=new LLnode<T>(elem);

		if(head==null){
			head=newnode;

			size++;
		}

		else if(temp.getLink()==null){
			temp.setLink(newnode);
			size++;
		}

		else{
			temp=temp.getLink();
			return insertLast(elem);
		}


		temp=head;
		return this;
	}

	@Override
	public ListInterface<T> insertAt(int index, T elem) {
		if(elem==null) throw new NullPointerException();
		if(index>size||index<0) throw new IndexOutOfBoundsException();

		LLnode<T> newnode=new LLnode<T>(elem);
		if(index==0){
			return insertFirst(elem);

		}
		if(index==size()){
			return insertLast(elem);
		}

		if(index==1){
			newnode.setLink(temp.getLink());
			temp.setLink(newnode);
			size++;
		}
		else{
			temp=temp.getLink();
			return insertAt(index-1,elem);
		}
		temp=head;
		return this;
	}

	@Override
	public T removeFirst() {
		T f=null;

		if(isEmpty()) throw new IllegalStateException();
		else{
			f=head.getInfo();
			head=head.getLink();
			temp=head;;
			size--;
		}
		return f;
	}

	@Override
	public T removeLast() {


		if(isEmpty()) throw new IllegalStateException();
		if(size()==1){
			t=head;
			head=null;
			temp=head;
			size--;
		}
		else if(temp.getLink().getLink()==null){
			t=temp.getLink();
			temp.setLink(null);
			size--;
		}

		else{
			temp=temp.getLink();
			return removeLast();

		}
		temp=head;
		return t.getInfo();
	}

	@Override
	public T removeAt(int i) {
		if(i<0||i>=size()) throw new IndexOutOfBoundsException();
		if(i==0){
			return removeFirst();
		}
		if(i==size()-1){
			return removeLast();
		}
		if(i==1){
			t=temp.getLink();
			temp.setLink(temp.getLink().getLink());
			size--;
		}
		else{
			temp=temp.getLink();
			return removeAt(i-1);
		}
		temp=head;

		return t.getInfo();
	}

	@Override
	public T getFirst() {
		if(isEmpty()) throw new IllegalStateException();


		else return head.getInfo();
	}

	@Override
	public T getLast() {

		if(isEmpty()) throw new IllegalStateException();
		else if(temp.getLink()==null){

			l=temp.getInfo();
		}

		else{
			temp=temp.getLink();
			return getLast();
		}

		temp=head;
		return l;
	}

	@Override
	public T get(int i) {
		if(i<0||i>=size()) throw new IndexOutOfBoundsException();


		if(i==0){
			return getFirst();
		}
		if(i==size()-1){
			return getLast();
		}
		if(i==1){
			t=temp.getLink();

		}
		else{
			temp=temp.getLink();
			return get(i-1);
		}
		temp=head;
		return t.getInfo();
	}

	@Override
	public boolean remove(T elem) {
		boolean has=false;
		if(contains(elem)>-1){
			removeAt(contains(elem));
			has=true;
		}	
		return has;
	}


	public int contain(T elem,int num) {


		if(temp.getInfo()==elem) num++;
		else if(temp.getLink()==null) num=-1;

		else{
			num++;
			temp=temp.getLink();
			return contain(elem,num);
		}

		temp=head;
		return num;


	}
	@Override
	public int contains(T elem) {

		return contain(elem,-1);

	}

	@Override
	public boolean isEmpty() {

		return head==null;
	}


}
