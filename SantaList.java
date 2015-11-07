package cs_goodies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SantaList {
	Santa head;
	
	public SantaList(Santa santa) {
		head = santa;
	}
	
	public void add(Santa santa) {
		Santa current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = santa;
	}
	
	public Santa get(int i) {
		int count = 0;
		Santa current = head;
		while (current != null) {
			if (count == i) {
				return current;
			}
			current = current.next;
			count++;
		}
		return null;
	}
	
	public void shuffle() {
		List<Santa> shuffleList = new ArrayList<Santa>();
		Santa current = head;
		while (current != null) {
			shuffleList.add(current);
			current = current.next;
		}
		
		Collections.shuffle(shuffleList);
		
		for (int i = 0; i < shuffleList.size(); i++) {
			if (i == 0) {
				Santa santa = new Santa(shuffleList.get(i).name);
				head = santa;
			}
			else {
				Santa santa = new Santa(shuffleList.get(i).name);
				add(santa);
			}
		}
	}
	
	public int size() {
		Santa current = head;
		int i = 0;
		while (current != null) {
			i++;
			current = current.next;
		}
		return i;
	}
}
