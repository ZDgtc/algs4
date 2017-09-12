package chapter_1_3;
import java.util.Iterator;

// ջ������ʵ��
public class Stack<Item> implements Iterable<Item> {
	private Node first;
	private int N;
	private class Node {
		Item item;
		Node next;
	}
	// �׽��Ϊnull��Ϊ������
	public boolean isEmpty() {
		return first == null;
	}
	public int size() {
		return N;
	}
	// ��ջ�����Ԫ�أ��������ͷ������
	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	// ��ջ��ɾ��Ԫ�أ��������ͷɾ�����
	public Item pop() {
		// �ȱ������item
		Item item = first.item;
		// ɾ�����
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
