package classes.week9;

public class ListOfStrings {
	private LinkOfString _first;
	
	public ListOfStrings() {_first = null;}
	private ListOfStrings(LinkOfString f) {
		_first = f;
	}
	public ListOfStrings(ListOfStrings l) {
		this();
		for(int i=0;i<l.size();i=i+1) {
			this.add(l.get(i));
		}
	}
	public void add(String a) {
		LinkOfString f = new LinkOfString(a,_first);
		_first = f;
	}

	public void addAt(String a, int ind) {
		if(ind<0 | ind>size()) { throw new RuntimeException("Err: the ind: ["+ind+"] is out of range");}
		if(ind==0) {	
			_first = new LinkOfString(a,_first);}
		else {
			LinkOfString curr = getLink(ind-1);
			curr.setNext(new LinkOfString(a,curr.getNext()));
		}
	}
	public void removeElementAt(int i) {
		if(i<0 | i>=size()) {throw new RuntimeException("Err: got wrong index to remove: "+i);}
		if(i==0) {_first = _first.getNext();}
		else {
			LinkOfString cr = this.getLink(i-1);
			cr.setNext(cr.getNext().getNext());
		}
	}
/**
 * Note: O(n^2) complexity - inefficient!
 * @param a
 * @return
 */
	public boolean contains(String a) {
		boolean ans = false;
		for(int i=0;i<size() && !ans;i=i+1) {
			if(this.get(i).equals(a)) {ans=true;}
		}
		return ans;
	}/**
	Simple example for tail recursion on linked list
	*/
	public boolean contains2(String a) {
		if(this.isEmpty()) {return false;}
		if(_first.getData().equals(a)) { return true;}
		ListOfStrings f2 = new ListOfStrings(this._first.getNext());
		return f2.contains2(a);
	}

	public String get(int i) {
		String ans = null;
		if(i>=0 && size()>i) {
			LinkOfString t = _first;
			for(int a=0;a<i;a=a+1) {t=t.getNext();}
			ans = t.getData();
		}
		return ans;
	}

	public boolean isEmpty() {
		return this.size()==0;
	}
	
	public int size() {
		int ans = 0;
		LinkOfString t = _first;
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
///////////////****** Private ****** ///////////////
	private LinkOfString getLink(int i) {
		LinkOfString ans = null;
		if(size()>i) {
			LinkOfString t = _first;
			for(int a=0;a<i;a=a+1) {t=t.getNext();}
			ans = t;
		}
		return ans;
	}
}

