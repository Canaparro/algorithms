package com.example.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

class WordDictionary {

    private final Map<Character, Node> root;

    public WordDictionary() {
        root = new HashMap<>();
    }

    public void addWord(String word) {
        addWord(0, word, root);
    }

    public boolean search(String word) {
        return search(0, word, root);
    }

    private void addWord(int index, String word, Map<Character, Node> map) {
        if (index < word.length()) {
            char currentLetter = word.charAt(index);
            if (map.containsKey(currentLetter)) {
                addWord(index + 1, word, map.get(currentLetter).children);
                if(index == word.length() - 1) {
                    map.get(currentLetter).isWord = true;
                }
            } else {
                addRemainingLetters(index, word, map);
            }
        }
    }

    private void addRemainingLetters(int index, String word, Map<Character, Node> map) {
        for (int i = index; i < word.length(); i++) {
            char letterToAdd = word.charAt(i);
            Node node = new Node(letterToAdd);
            map.put(letterToAdd, node);
            if(i == word.length() - 1){
                node.isWord = true;
            } else {
                map = node.children;
            }
        }
    }

    private boolean search(int index, String word, Map<Character, Node> nodes) {
        char currentLetter = word.charAt(index);
        if(currentLetter == '.') {
            return searchWildcardDFS(index, word, nodes);
        } else if (nodes.containsKey(currentLetter)) {
            if(index == word.length() - 1) {
                return nodes.get(currentLetter).isWord;
            } else {
                return search(index + 1, word, nodes.get(currentLetter).children);
            }
        } else {
            return false;
        }
    }

    private boolean searchWildcardDFS(int index, String word, Map<Character, Node> nodes) {
        if(index == word.length() - 1 && !nodes.isEmpty()) {
            return nodes.values().stream().anyMatch(n -> n.isWord);
        }
        for (Node node : nodes.values()) {
            if(search(index + 1, word, node.children)) {
                return true;
            }
        }
        return false;
    }

    static class Node {
        boolean isWord;
        char letter;
        Map<Character, Node> children = new HashMap<>();

        public Node(char letter) {
            this.letter = letter;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
