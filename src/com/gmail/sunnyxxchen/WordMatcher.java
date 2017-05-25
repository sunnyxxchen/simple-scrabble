package com.gmail.sunnyxxchen;

import com.googlecode.concurrenttrees.radix.node.concrete.SmartArrayBasedNodeFactory;
import com.googlecode.concurrenttrees.suffix.ConcurrentSuffixTree;
import com.googlecode.concurrenttrees.suffix.SuffixTree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * created by schen on 5/25/17.
 */
class WordMatcher {
    // preprocesses dictionary for faster pattern matching
    private SuffixTree<String> trie;

    WordMatcher() {
        trie =  new ConcurrentSuffixTree<>(new SmartArrayBasedNodeFactory());
        try (BufferedReader br = new BufferedReader(new FileReader("/home/schen/compsci/simple-scrabble/src/com/gmail/sunnyxxchen/words_alpha.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                String val = line;
                trie.put(line, val);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int size() {
        return trie.size();
    }
}
