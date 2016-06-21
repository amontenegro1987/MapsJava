package demos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
public class ComparatorTest {
 public static void main(String[] args){
	 ArrayList<String> originalList = new ArrayList<String>();
	 originalList.add("Two");
	 originalList.add("One");
	 originalList.add("Three");
	 originalList.add("Four");
	 Collections.sort(originalList, new StringSort());
	 System.out.println(originalList);
 }
}
