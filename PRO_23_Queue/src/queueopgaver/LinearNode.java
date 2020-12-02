package queueopgaver;

public class LinearNode {

	private LinearNode next;
	private Object element;

	public LinearNode() {
		next = null;
		element = null;
	}

	public LinearNode(Object element) {
		next = null;
		this.element = element;
	}

	public LinearNode getNext() {
		return next;
	}

	public void setNext(LinearNode node) {
		next = node;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public Object getElement() {
		return element;
	}

}
