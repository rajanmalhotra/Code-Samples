package com.rajan.tries;

/*
 * Implement Trie Class 
 * supports insertions/searching/deletion/prefix_count of k length word in O(k) time.
 */

class TrieNode{
	TrieNode[] child;
	boolean isEnd;
	int prefix_count;
	
	public TrieNode(){
		/* generic array creation is not allowed */
		child = new TrieNode[26];
		isEnd = false;
		prefix_count = 0;
	}
}

public class Trie {
	
	private TrieNode head;
	
	public Trie(){
		head = new TrieNode();
		head.prefix_count = 0;
		head.isEnd = false;
	}
	
	public void insert(String word){
		TrieNode current = head;
		current.prefix_count++;
		for(int i=0; i < word.length(); i++){
			int index = word.charAt(i) - 'a';			
			if(current.child[index]==null){
				current.child[index] = new TrieNode();				
			}
			current = current.child[index];
			current.prefix_count++;
		}
		current.isEnd = true;
	}
	
	public boolean search(String word){
		TrieNode current = head;
		for(int i=0; i < word.length(); i++){
			int index = word.charAt(i) - 'a';
			if(current.child[index]==null){
				return false;
			}
			current = current.child[index];
		}
		return current.isEnd;
	}
	
	private static boolean foundFlag = false; 
	private boolean deleteRec(TrieNode node, String word, int pos){		
		if(pos==word.length()){
			if(node.isEnd){
				foundFlag = true;
				node.isEnd = false;
				node.prefix_count--;
				return isEmptyNode(node);
			}
			return false;
		}
		
		int index = word.charAt(pos) - 'a';		
		if(node.child[index]==null){
			return false;
		}
		
		if(deleteRec(node.child[index], word, pos+1)){
			node.prefix_count--;
			node.child[index] = null;
			return (!node.isEnd && isEmptyNode(node));
		}
		if(foundFlag){
			node.prefix_count--;
		}
		return false;
	}
	
	private boolean isEmptyNode(TrieNode node){
		for(int i=0; i < 26; i++){
			if(node.child[i]!=null){
				return false;
			}
		}
		return true;
	}
	
	public void delete(String word){
		foundFlag = false;
		deleteRec(head, word, 0);
		if(!foundFlag){
			System.out.println("Word is not there. Nothing to delete!!");			
		}
	}
	
	/* count of words with this prefix */
	public int words_with_prefix(String prefix){
		TrieNode current = head;
		for(int i=0; i < prefix.length(); i++){
			int index = prefix.charAt(i) - 'a';
			if(current.child[index]==null){
				return 0;
			}
			current = current.child[index];
		}
		return current.prefix_count;
	}
	
	public static void main(String[] args){
		Trie trie = new Trie();
		String[] wordsForInsert =  {"she", "sells", "sea", "shore", "know", "knowledge", "knowledges", "knowledgement"};
		for(String word : wordsForInsert){
			trie.insert(word);
		}
		
		/* Search for words */
		String[] wordsForSearch = {"se", "sea", "a", "know"};
		for(String word : wordsForSearch){
			System.out.println("Is \"" + word + "\" present in Trie : " + trie.search(word));
		}
		System.out.println("==========================================================");
		
		/* count words with prefix */
		String[] wordsForCount = {"se", "s", "a", "know"};
		for(String word : wordsForCount){	
			System.out.println("Words with prefix \"" + word + "\" are : " + trie.words_with_prefix(word));
		}
		
		/* Delete Words */
		String[] wordsForDeletion = {"knowledge", "knowledgement", "she"};
		for(String word : wordsForDeletion){
			System.out.println("==========================================================");
			System.out.println("Is \"" + word + "\" present in Trie : " + trie.search(word));
			System.out.println("Deleting \"" + word + "\"...");
			trie.delete(word);
			System.out.println("Is \"" + word + "\" present in Trie : " + trie.search(word));
		}
		
		/* confirm prefix counts */
		String[] wordsToConfirmCount = {"s", "know"};
		for(String word:wordsToConfirmCount){
			System.out.println("==========================================================");
			System.out.println("Words with prefix \"" + word + "\" are : " + trie.words_with_prefix(word));
		}
	}
}
