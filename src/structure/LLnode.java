package structure;


public class LLnode<T> {
	private LLnode<T> link;
	private T info;
	public LLnode(T info){
		this.info=info;
		link=null;
	}
	public void setInfo(T info){
		this.info=info;
	}
	public T getInfo(){
		return info;
	}
	public void setLink(LLnode lk){
		link=lk;
	}
	public LLnode getLink(){
		return link;
	}
}
