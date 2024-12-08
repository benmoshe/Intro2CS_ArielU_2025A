package classes.week9;
/**
 * Class 10 improvement example, to be completed as a "self - homework"
 * @author boaz.benmoshe
 *
 */
public class MyList<T> implements MyListInterface<T>{

	private Link<T> _first;
	public MyList() {_first = null;}
	public MyList(MyListInterface<T> l) {
		this();
		for(int i=0;i<l.size();i=i+1) {
			this.add(l.get(i));
		}
	}
	public MyList(T t) {
		this();
		this.add(t);
	}
	@Override
	public void add(T a) {
		Link<T> f = new Link<T>(a,_first);
		_first = f;
	}

	@Override
	public void addAt(T a, int ind) {
		if(ind<0 | ind>size()) { throw new RuntimeException("Err: the ind: ["+ind+"] is out of range");}
		if(ind==0) {	
			_first = new Link<T>(a,_first);}
		else {
			Link<T> curr = getLink(ind-1);
			curr.setNext(new Link<T>(a,curr.getNext()));
		}
	}
	@Override
	public void removeElementAt(int i) {
		if(i<0 | i>=size()) {throw new RuntimeException("Err: got wrong index to remove: "+i);}
		if(i==0) {_first = _first.getNext();}
		else {
			Link<T> cr = this.getLink(i-1);
			cr.setNext(cr.getNext().getNext());
		}
	}

	@Override
	public boolean contains(T a) {
		boolean ans = false;
		for(int i=0;i<size() && !ans;i=i+1) {
			if(this.get(i).equals(a)) {ans=true;}
		}
		return ans;
	}

	@Override
	public T get(int i) {
		T ans = null;
		if(size()>i) {
			Link<T> t = _first;
			for(int a=0;a<i;a=a+1) {t=t.getNext();}
			ans = t.getData();
		}
		return ans;
	}

	@Override
	public boolean isEmpty() {
		return this.size()==0;
	}
	
	public int size() {
		int ans = 0;
		Link<T> t = _first;
		while(t!=null) {
			ans=ans+1;
			t = t.getNext();
		}
		return ans;
	}
	public String toString() {
		String ans = "LinkList: ";
		for(int i=0;i<size();i=i+1) {
			ans +=get(i)+",";
		}
		return ans;
	}
	public void connect(MyList<T> l) {
		if(this.isEmpty()) {_first =l._first;}
		else {
			Link<T> t = getLink(this.size()-1);
			t.setNext(l._first);
		}
	}
///////////////****** Private ****** ///////////////
	private Link<T> getLink(int i) {
		Link<T> ans = null;
		if(size()>i) {
			Link<T> t = _first;
			for(int a=0;a<i;a=a+1) {t=t.getNext();}
			ans = t;
		}
		return ans;
	}
	///////////////////////////////////////////
	/**
	 * a Link in a LinkedList using generics (aka <T>).
	 * @author boaz.benmoshe
	 *
	 */
	private class Link <T>{
		private T _data;
		private Link<T> _next;
		
		public Link(T s) {
			this(s,null);
		}
		public Link(T a, Link<T> f) {
			_data = a;
			_next = f;
		}
		public T getData() {return this._data;}
		public Link<T> getNext() {return this._next;}
		public boolean isLast() {return this.getNext() == null;}
		public void setNext(Link<T> ll) {
			this._next = ll;
		}
	}
}
