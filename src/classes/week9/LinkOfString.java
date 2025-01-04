package classes.week9;
/** * a Link with String as its data, for a LinkedList of Strings.
	 * @author boaz.benmoshe
	 *
	 */
public class LinkOfString {
	private String _data;
	private LinkOfString _next;
		
	public LinkOfString(String s) {
		this(s,null);
	}
	public LinkOfString(String a, LinkOfString f) {
		_data = a;
		_next = f;
	}
	public String getData() {return this._data;}
	public LinkOfString getNext() {return this._next;}
	public boolean isLast() {return this.getNext() == null;}
	public void setNext(LinkOfString ll) {
			this._next = ll;
	}
}
