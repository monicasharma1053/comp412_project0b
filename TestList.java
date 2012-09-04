package cs271.lab.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse; 
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator; 
import java.util.LinkedList; 

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestList {

	private List<Integer> list;

	@Before
	public void setUp() throws Exception {
		list = new ArrayList<Integer>();
		// TODO also try with a LinkedList - does it make any difference?
		//list = new LinkedList<Integer>(); 
	}

	@After
	public void tearDown() throws Exception {
		list = null;
	}

	@Test
	public void testSizeEmpty() {
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
		try {
			list.get(0);
			fail("there should not be any items in the list");
		} catch (Exception ex) {
		}
	}

	@Test
	public void testSizeNonEmpty() {
		// TODO fix the expected values in the assertions below
		list.add(77);
		assertEquals(false, list.isEmpty());
		assertEquals(1, list.size());
		assertEquals((Integer) 77, list.get(0));
	}

	@Test
	public void testContains() {
		
		assertEquals(list.contains((Integer) 77), false); 
		//assertFalse(list.contains((Integer)77));
		list.add(77); 
		assertTrue(list.contains((Integer) 77)); 
		// TODO write assertions using
		// list.contains(77)
		// that hold before and after adding 77 to the list
		//fail("Not yet implemented"); // remove this line when done
	}

	@Test
	public void testAddMultiple() {
		list.add(77);
		list.add(77);
		list.add(77);
		// TODO fix the expected values in the assertions below
		assertEquals(3, list.size());
		assertEquals(0, list.indexOf(77));
		assertEquals((Integer) 77, list.get(1));
		assertEquals(2, list.lastIndexOf(77));
	}

	@Test
	public void testAddMultiple2() {
		list.add(33);
		list.add(77);
		list.add(44);
		list.add(77);
		list.add(55);
		list.add(77);
		list.add(66);
		// TODO fix the expected values in the assertions below
		assertEquals(7, list.size());
		assertEquals(1, list.indexOf(77));
		assertEquals(5, list.lastIndexOf(77));
		assertEquals((Integer) 44, list.get(2));
		assertEquals((Integer) 77, list.get(3));
		assertEquals(Arrays.asList(33, 77, 44, 77, 55, 77, 66), list);
	}

	@Test
	public void testRemoveObject() {
		list.add(3);
		list.add(77);
		list.add(4);
		list.add(77);
		list.add(5);
		list.add(77);
		list.add(6);
		list.remove(5); // what does this method do?
		// TODO fix the expected values in the assertions below
		assertEquals(6, list.size());
		assertEquals(1, list.indexOf(77));
		assertEquals(3, list.lastIndexOf(77));
		assertEquals((Integer) 4, list.get(2));
		assertEquals((Integer) 77, list.get(3));
		list.remove(Integer.valueOf(5)); // what does this one do?
		assertEquals(5, list.size());
		assertEquals(1, list.indexOf(77));
		assertEquals(3, list.lastIndexOf(77));
		assertEquals((Integer) 4, list.get(2));
		assertEquals((Integer) 77, list.get(3));
	}

	@Test
	public void testContainsAll() {
		list.add(33);
		list.add(77);
		list.add(44);
		list.add(77);
		list.add(55);
		list.add(77);
		list.add(66);
		assertTrue(list.containsAll(Arrays.asList(33, 44, 55, 66, 77))); 
		assertEquals(list.containsAll(Arrays.asList(11, 22, 33)), false);
		// TODO using containsAll and Arrays.asList (see above),
		// 1) assert that list contains all five different numbers added
		// 2) assert that list does not contain all of 11, 22, and 33
		//fail("Not yet implemented"); // remove this line when done
	}

	@Test
	public void testAddAll() {
		// TODO in a single statement using addAll and Arrays.asList,
		// add items to the list to make the following assertions pass
		// (without touching the assertions themselves)
		list.addAll(Arrays.asList(33, 77, 44, 77, 55, 77, 66)); 
		assertEquals(7, list.size());
		assertEquals((Integer) 33, list.get(0));
		assertEquals((Integer) 77, list.get(1));
		assertEquals((Integer) 44, list.get(2));
		assertEquals((Integer) 77, list.get(3));
		assertEquals((Integer) 55, list.get(4));
		assertEquals((Integer) 77, list.get(5));
		assertEquals((Integer) 66, list.get(6));
	}

	@Test
	public void testRemoveAll() {
		list.add(33);
		list.add(77);
		list.add(44);
		list.add(77);
		list.add(55);
		list.add(77);
		list.add(66);
		// TODO in a single statement using removeAll and Arrays.asList,
		// remove items from the list to make the following assertions pass
		// (without touching the assertions themselves)
		list.removeAll(Arrays.asList(33, 44, 55, 66)); 
		assertEquals(3, list.size());
		assertEquals(Arrays.asList(77, 77, 77), list);
	}

	@Test
	public void testRetainAll() {
		list.add(33);
		list.add(77);
		list.add(44);
		list.add(77);
		list.add(55);
		list.add(77);
		list.add(66);
		// TODO in a single statement using retainAll and Arrays.asList,
		// remove items from the list to make the following assertions pass
		// (without touching the assertions themselves)
		list.retainAll(Arrays.asList(77, 77, 77)); 
		assertEquals(3, list.size());
		assertEquals(Arrays.asList(77, 77, 77), list);
	}

	@Test
	public void testSet() {
		list.add(33);
		list.add(77);
		list.add(44);
		list.add(77);
		list.add(55);
		list.add(77);
		list.add(66);
		// TODO use the set method to change specific elements in the list
		// such that the following assertions pass
		// (without touching the assertions themselves)

		list.set(1, 99); 
		list.set(3, 99); 
		list.set(5, 99); 
		
		assertEquals(7, list.size());
		assertEquals((Integer) 33, list.get(0));
		assertEquals((Integer) 99, list.get(1));
		assertEquals((Integer) 44, list.get(2));
		assertEquals((Integer) 99, list.get(3));
		assertEquals((Integer) 55, list.get(4));
		assertEquals((Integer) 99, list.get(5));
		assertEquals((Integer) 66, list.get(6));
	}

	@Test
	public void testSubList() {
		list.add(33);
		list.add(77);
		list.add(44);
		list.add(77);
		list.add(55);
		list.add(77);
		list.add(66);
		// TODO fix the arguments in the subList method so that the assertion
		// passes
		assertEquals(Arrays.asList(44, 77, 55), list.subList(2, 5));
	}

}
