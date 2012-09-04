package cs271.lab.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList; 

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestIterator {

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
	public void testEmpty() {
		final Iterator<Integer> i = list.iterator();
		assertFalse(i.hasNext());
	}

	@Test
	public void testNonempty() {
		list.add(33);
		list.add(77);
		list.add(44);
		list.add(77);
		list.add(55);
		list.add(77);
		list.add(66);
		final Iterator<Integer> i = list.iterator();
		assertTrue(i.hasNext());
		//assertEquals(33, i.next());
		assertEquals((Integer) 33, i.next()); 
		// TODO fix the expected values in the assertions below
		assertTrue(i.hasNext());
		//assertEquals(0, i.next());
		assertEquals((Integer) 77, i.next()); 
		assertTrue(i.hasNext());
		//assertEquals(0, i.next());
		assertEquals((Integer) 44, i.next()); 
		assertTrue(i.hasNext());
		//assertEquals(0, i.next());
		assertEquals((Integer) 77, i.next()); 
		assertTrue(i.hasNext());
		//assertEquals(0, i.next());
		assertEquals((Integer) 55, i.next()); 
		assertTrue(i.hasNext());
		//assertEquals(0, i.next());
		assertEquals((Integer) 77, i.next()); 
		assertTrue(i.hasNext());
		//assertEquals(0, i.next());
		assertEquals((Integer) 66, i.next()); 
		assertFalse(i.hasNext());
	}

	@Test
	public void testRemove() {
		list.add(33);
		list.add(77);
		list.add(44);
		list.add(77);
		list.add(55);
		list.add(77);
		list.add(66);
		
		
		final Iterator<Integer> i = list.iterator();
		while (i.hasNext()) {
			if (i.next() == 77) {
				i.remove(); // TODO what happens if you use list.remove(77)?
			}
		}
		
		final Iterator<Integer> a = list.iterator(); 
		assertTrue(a.hasNext()); 
		assertEquals((Integer) 33, a.next()); 
		assertTrue(a.hasNext()); 
		assertEquals((Integer) 44, a.next()); 
		assertTrue(a.hasNext()); 
		assertEquals((Integer) 55, a.next()); 
		assertTrue(a.hasNext()); 
		assertEquals((Integer) 66, a.next()); 
		assertFalse(a.hasNext()); 
		//assertEquals(Arrays.asList(33,44,55,66), list);
		assertEquals(Arrays.asList(33, 44, 55, 66), list);
		
		// TODO using assertEquals and Arrays.asList (see above)
		// express which values are left in the list
		//fail("Not yet implemented"); // remove this line when done
	}

	@Test
	public void testAverageValues() {
		list.add(33);
		list.add(77);
		list.add(44);
		list.add(77);
		list.add(55);
		list.add(77);
		list.add(66);
		double sum = 0;
		int n = 0;
		double average; 
		// TODO use an iterator and a while loop to compute the average (mean) of the values
		// (defined as the sum of the items divided by the number of items)
		//assertEquals(61, sum / n);
		
		final Iterator<Integer> i = list.iterator(); 
		while(i.hasNext())
		{
			sum += i.next(); 
			n++; 
		}
		assertEquals(7, n);
		average = sum /n; 
	}
}
