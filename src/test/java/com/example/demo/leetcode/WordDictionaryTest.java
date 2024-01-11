package com.example.demo.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WordDictionaryTest {

    private WordDictionary wordDictionary = new WordDictionary();
    
    @Test
    void test1() {
    	// Given
        wordDictionary.addWord("bad");

        // When
        boolean search = wordDictionary.search("bad");

        // Should
        assertTrue(search);
    }

    @Test
    void test2() {
        // Given
        wordDictionary.addWord("bad");

        // When
        boolean search = wordDictionary.search("bas");

        // Should
        assertFalse(search);
    }

    @Test
    void test3() {
        // Given
        wordDictionary.addWord("bad");

        // When
        boolean search = wordDictionary.search("ba.");

        // Should
        assertTrue(search);
    }

    @Test
    void test4() {
        // Given
        wordDictionary.addWord("a");

        // When
        boolean search = wordDictionary.search("a.");

        // Should
        assertFalse(search);
    }

    @Test
    void test5() {
        // Given
        wordDictionary.addWord("add");

        // When
        boolean search = wordDictionary.search("a.d");

        // Should
        assertTrue(search);
    }

    @Test
    void test6() {
        // Given
        wordDictionary.addWord("add");

        // When
        boolean search = wordDictionary.search(".");

        // Should
        assertFalse(search);
    }

}