package com.bridgelabz.datastructures.programs;

public class  Node<InfoE extends Comparable<InfoE>> {

	private InfoE info;
	private Node<InfoE> next;

	public Node() {
		// ZERO ARGUMENT CONSTRUCTOR
		super();
		this.next = null;
		this.info = null;

	}

	public Node(Node<InfoE> firstNode) {

		this.next = firstNode.getNext();
		this.info = firstNode.getInfo();

	}

	@Override
	public String toString() {
		return "Node [info=" + info + ", next=" + next + "]";
	}

	public InfoE getInfo() {
		return info;
	}

	public void setInfo(InfoE info) {
		this.info = info;
	}

	public Node<InfoE> getNext() {
		return next;
	}

	public void setNext(Node<InfoE> next) {
		this.next = next;
	}

}
