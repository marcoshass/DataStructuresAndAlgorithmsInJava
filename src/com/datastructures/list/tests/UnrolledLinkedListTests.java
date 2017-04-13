package com.datastructures.list.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.datastructures.list.UnrolledLinkedList;

public class UnrolledLinkedListTests {

	/**
	 * Default linked list used for testing.
	 */
	UnrolledLinkedList<Integer> l = new UnrolledLinkedList<>();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSizeDefault() {
		assertEquals(16, 16);
	}

	@Test
	public void testIsEmpty() {
		assertTrue(l.isEmpty());
	}

	@Test
	public void testIndexOfNull() {
		System.out.println(l.indexOf(null));
		assertEquals(0, l.indexOf(null)); 
	}

}
