import com.struct.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		SortedLinkedList l = new SortedLinkedList();
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new Item( 2, "chocos", 14 ));
		items.add(new Item( 2, "chocos 2", 32 ));
		items.add(new Item( 1, "boost", 3 ));
		items.add(new Item( 3, "random", 1 ));
		for( Item it: items )
			l.add(it);
		System.out.println( "\n\n" );
		l.printAll();
		l.gotoend();
		l.next();
	}

}
