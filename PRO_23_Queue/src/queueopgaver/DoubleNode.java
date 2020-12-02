package queueopgaver;

public class DoubleNode {
	private DoubleNode previous, next;
	private Object element;

	public DoubleNode() {
	}

	public DoubleNode(Object element) {
		this.element = element;
	}

	public DoubleNode getPrevious() {
		return previous;
	}

	public void setPrevious(DoubleNode previous) {
		previous.next = this;
		this.previous = previous;
	}

	public DoubleNode getNext() {
		return next;
	}

	public void setNext(DoubleNode next) {
		next.previous = this;
		this.next = next;
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}

}
