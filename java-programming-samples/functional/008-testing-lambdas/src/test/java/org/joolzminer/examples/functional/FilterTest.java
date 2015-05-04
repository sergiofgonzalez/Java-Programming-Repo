package org.joolzminer.examples.functional;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.joolzminer.examples.functional.FilterHelper.*;

public class FilterTest {
	@Test
	public void testFilter() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
		List<Integer> even = filter(numbers, i -> i % 2 == 0);
		List<Integer> smallerThanThree = filter(numbers, i -> i < 3);
		
		assertEquals(Arrays.asList(2, 4), even);
		assertEquals(Arrays.asList(1, 2), smallerThanThree);
	}
}
