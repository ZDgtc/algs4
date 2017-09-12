package chapter_1_3;
import java.util.Iterator;

// 栈的链表实现
public class Stack<Item> implements Iterable<Item> {
	private Node first;
	private int N;
	private class Node {
		Item item;
		Node next;
	}
	// 首结点为null即为空链表
	public boolean isEmpty() {
		return first == null;
	}
	public int size() {
		return N;
	}
	// 向栈顶添加元素，在链表表头插入结点
	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	// 从栈顶删除元素，从链表表头删除结点
	public Item pop() {
		// 先保存结点的item
		Item item = first.item;
		// 删除结点
		first = first.next;
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
			current = current.next;
			return item;
		}
	}
}
