package CrackingCodingInterview;

import java.util.HashSet;

public class DetectCycle {

	class Node {
		int data;
		Node next;
	}

	boolean processNextNode(Node head, HashSet<Node> visited) {
		if(head == null) {
			return true;
		}
			
		if(visited.contains(head)) {
			return false;
		}
		
		visited.add(head);
		return  processNextNode(head.next, visited);
	}
	
	boolean has_cycle(Node head) {
		return processNextNode(head, new HashSet<Node>());
	}

}
