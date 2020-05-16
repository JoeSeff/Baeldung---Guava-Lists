package com.joeseff;

import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * @author Joeseff
 * @created 16/05/2020 17:55
 *
 * @link https://www.baeldung.com/guava-lists
 */
public class GuavaListsTest {

	/**
	 * Reverse list
	 */
	@Test
	public void whenReverseListThenReversed() {
		List<String> names = Lists.newArrayList("John", "Adam", "Jane");
		List<String> reversed = Lists.reverse(names);

		assertThat(reversed, contains("Jane", "Adam", "John"));
	}

	/**
	 * Generate Character List from a String
	 */
	@Test
	public void whenCreateCharacterListFromStringThenCreated() {
		List<Character> chars = Lists.charactersOf("John");

		assertThat(chars, hasSize(4));
		assertThat(chars, contains('J', 'o', 'h', 'n'));
	}

	/**
	 * Partition a list
	 */
	@Test
	public void whenPartitionListThenPartitioned() {
		List<String> names = Lists.newArrayList("John","Jane","Adam","Tom","Viki","Tyler");
		List<List<String>> result = Lists.partition(names, 2);

		assertThat(result, hasSize(3));
		assertThat(result.get(0), contains("John", "Jane"));
		assertThat(result.get(1), contains("Adam", "Tom"));
		assertThat(result.get(2), contains("Viki", "Tyler"));
	}

	/**
	 * Remove duplicates from list
	 */
	@Test
	public void whenRemoveDuplicatesFromListThenRemoved() {
		List<Character> chars = Lists.newArrayList('h','e','l','l','o');;
		assertThat(chars, hasSize(5));

		List<Character> result = ImmutableSet.copyOf(chars).asList();
		assertThat(result, contains('h', 'e', 'l', 'o'));
	}

	/**
	 * Remove null values from List
	 */
	@Test
	public void whenRemoveNullFromListThenRemoved() {
		List<String> names = Lists.newArrayList("John", null, "Adam", null, "Jane");
		Iterables.removeIf(names, Predicates.isNull());

		assertThat(names, hasSize(3));
		assertThat(names, contains("John", "Adam", "Jane"));
	}

	/**
	 * Convert List into an Immutable List
	 */
	@Test
	public void whenCreateImmutableListThenCreated() {
		List<String> names = Lists.newArrayList("John", "Adam", "Jane");

		names.add("Tom");
		assertThat(names, hasSize(4));

		ImmutableList<String> immutableList = ImmutableList.copyOf(names);
		assertThat(immutableList, contains("John", "Adam", "Jane", "Tom"));
	}
}
