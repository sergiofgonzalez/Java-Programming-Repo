package org.joolzminer.examples.streams.runner;

import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.joolzminer.examples.domain.WordCounter;
import org.joolzminer.examples.spliterator.WordCounterSpliterator;

public class CountWordsRunner {
	
	private static final String SENTENCE = 
			" Nel mezzo del cammin di nostra vita " +
			"mi ritrovai in una selva oscura" +
			" ché la dritta via era smarrita ";
	
	public static void main(String[] args) {
		System.out.println("Iterative        : " + countWordsIteratively(SENTENCE) + " words found.");
		System.out.println("Functional       : " + countWordsIteratively(SENTENCE) + " words found.");
		System.out.println("Parallel (Not OK): " + countWordsIteratively(SENTENCE) + " words found.");
		System.out.println("Spliterator      : " + countWordsIteratively(SENTENCE) + " words found.");
	}
		
	public static int countWordsIteratively(String s) {
		int counter = 0;
		boolean lastSpace = true;
		for (char c : s.toCharArray()) {
			if (Character.isWhitespace(c)) {
				lastSpace = true;
			} else {
				if (lastSpace) {
					counter++;					
				}
				lastSpace = false;
			}
		}
		return counter;
	}
	
	public static int countWordsFunctional(String s) {
		Stream<Character> stream = IntStream.range(0, SENTENCE.length())
											.mapToObj(SENTENCE::charAt);
		WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
													WordCounter::accumulate,
													WordCounter::combine);
		return wordCounter.getCounter();
	}	
	
	// This method is wrong because the string may be split in the middle of the word
	// leading to words being counted twice
	public static int countWordsFunctionalParallel_NOTOK(String s) {
			Stream<Character> stream = IntStream.range(0, SENTENCE.length())
												.mapToObj(SENTENCE::charAt);
			WordCounter wordCounter = stream.parallel()
											.reduce(new WordCounter(0, true),
														WordCounter::accumulate,
														WordCounter::combine);
			return wordCounter.getCounter();		
	}
	
	public static int countWordsSpliterator(String s) {
		Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
		Stream<Character> stream = StreamSupport.stream(spliterator, true);
		WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
												WordCounter::accumulate,
												WordCounter::combine);
		return wordCounter.getCounter();		
	}
}


