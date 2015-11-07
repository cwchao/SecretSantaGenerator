package cs_goodies;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SecretSanta {
	
	private static PrintWriter pw;

	public static SantaList create(SantaList list, String [] names) {
		// create Santas
		for (String name : names){
			if (list == null) {
				Santa santa = new Santa(name);
				list = new SantaList(santa);
			}
			else {
				Santa santa = new Santa(name);
				list.add(santa);
			}
		}
		return list;
				
	}
	
	public static void assign(SantaList list) {
		Santa current = list.head;
		while (current.next != null) {
			current.secret = current.next;
			current = current.next;
		}
		current.secret = list.head; // assign last santa's to be the head
		
	}
	
	public static void main(String [] a) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter Secret Santa participants: ");
		String input = scanner.nextLine();
		String [] names = input.toString().split(",");
		
		SantaList list = null;
		list = create(list, names);
		
		// shuffle names
		list.shuffle();
		
		// everybody's assignment is their "next" except last person in list will point to head
		assign(list);
		
		// print out assignments
		for (int k = 0; k < list.size(); k++) {
			String person = list.get(k).name + ".txt";
			try {
				pw = new PrintWriter(person, "UTF-8");
				pw.write("You are the secret santa for " + list.get(k).secret.name);
				pw.close();
			} catch (IOException err) {
				System.out.println("Error!");
			}
			
			//System.out.println(list.get(k).name + " is the secret santa for " + list.get(k).secret.name);
		}
		
	}
}
