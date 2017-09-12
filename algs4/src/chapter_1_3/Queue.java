package chapter_1_3;
import java.util.Iterator;

// 队列的链表实现
public class Queue<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int N;
	private class Node {
		Item item;
		Node next;
	}
	public boolean isEmpty() {
		return first == null;
	}
	public int size() {
		return N;
	}
	// 向表尾添加元素
	public void enqueue(Item item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		// 插入前链表为空，则first与last指向同一结点
		if (isEmpty()) first = last;
		else oldlast.next = last;
		N++;
	}
	// 从表头删除元素
	public Item dequeue() {
		Item item = first.item;
		first = first.next;
		if (isEmpty()) last = null;
		N--;
		return item;
	}
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		public boolean hasNext() {
			return current != null;
		}
		public void remove() {}
		public Item next() {
			Item item = current.item;
			// 实现迭代链表结点
			current = current.next;
			return item;
		}
	}
}
