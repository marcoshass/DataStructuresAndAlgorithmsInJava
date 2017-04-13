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
	public void testSize_EmptyList_ReturnsSixteen() {
		assertEquals(16, 16);
	}

	@Test
	public void testIsEmpty_EmptyList_ReturnsTrue() {
		assertTrue(l.isEmpty());
	}

	@Test
	public void testIndexOf_Null_ReturnsZero() {
		assertEquals(0, l.indexOf(null)); 
	}

}
