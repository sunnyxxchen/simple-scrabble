package com.gmail.sunnyxxchen;

import com.googlecode.concurrenttrees.radix.node.concrete.SmartArrayBasedNodeFactory;
import com.googlecode.concurrenttrees.suffix.ConcurrentSuffixTree;
import com.googlecode.concurrenttrees.suffix.SuffixTree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * created by schen on 5/25/17.
 */
class WordMatcher {
    private SuffixTree<String> trie;
    private Character[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                    'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    // preprocesses dictionary for faster pattern matching
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

    boolean contains(String seq) {
        return wordsContaining(seq).iterator().hasNext();
    }

    Iterable<CharSequence> wordsContaining(String seq) {
        return trie.getKeysContaining(seq);
    }

    boolean isAWord(String seq) {
        return trie.getValueForExactKey(seq) != null;
    }

    /** Takes in a string and current letters
     * @param seq
     * String
     * @param letters
     * Current letters
     * @return
     * A list containing strings of playable words
     */
    Iterable<String> playableWords(String seq, List<Character> letters) {
        return playableWords(seq, letters, new HashSet<>(), seq);
    }

    private Iterable<String> playableWords(String seq, List<Character> letters, Set<String> playables, String orig) {
        if (letters.size() == 0) {
            if (isAWord(seq) && !seq.equals(orig)) {
                playables.add(seq);
            }
            return playables;
        }
        for (Character letter : letters) {
            if (letter.equals('*')) {
                for (Character character: alphabet) {
                    List<Character> wildcardRemoved = new ArrayList<>();
                    for (Character let : letters) {
                        if (!let.equals(letter)) {
                            wildcardRemoved.add(let);
                        } else {
                            wildcardRemoved.add(character);
                        }
                        for (String playable : playableWords(seq, wildcardRemoved, playables, orig)) {
                            playables.add(playable);
                        }
                    }
                }
            } else {
                String addedToBack = seq + letter;
                String addedToFront = letter + seq;
                List<Character> backRemoved = new ArrayList<>();
                List<Character> frontRemoved = new ArrayList<>();
                for (Character let : letters) {
                    if (!let.equals(letter)) {
                        backRemoved.add(let);
                        frontRemoved.add(let);
                    }
                }
                if (contains(addedToBack)) {
                    if (isAWord(addedToBack)) {
                        playables.add(addedToBack);
                    }
                    for (String playable : playableWords(addedToBack, backRemoved, playables, orig)) {
                        playables.add(playable);
                    }
                }
                if (contains(addedToFront)) {
                    if (isAWord(addedToFront)) {
                        playables.add(addedToFront);
                    }
                    for (String playable : playableWords(addedToFront, frontRemoved, playables, orig)) {
                        playables.add(playable);
                    }
                }
            }
        }
        return playables;
    }
}
