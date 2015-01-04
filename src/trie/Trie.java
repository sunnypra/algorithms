package trie;

import java.util.Map;
import java.util.Set;
import java.util.ArrayList;

//import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang.StringUtils;


public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String s) {
		TrieNode current = root;
		if (StringUtils.isEmpty(s)) {
			current.setWord(true); //for blank operator.
		}
		s = normailizeString(s);
		for (int i= 0; i<s.length();i++) {
			char c = s.charAt(i);
			TrieNode childNode = current.getChildNode(c);
			if (childNode == null) {
				childNode = new TrieNode(c);
				current.getChildNodes().put(c, childNode);
			}
			//update current node.
			current = childNode;
		}
		//update current node isWord to true.
		current.setWord(true);
		System.out.println("Inserted String:"+s+" into Trie");
	}

	public void search(String s) {
		TrieNode current = root;
		if(current != null && StringUtils.isNotEmpty(s)) {
			s = normailizeString(s);
			for (int i=0;i<s.length();i++) {
				char c = s.charAt(i);
				TrieNode childNode = current.getChildNode(c);
				if (childNode != null) {
					current = childNode; // increment child node.
				} else {
					System.out.println("String:"+s+" not found.");
					return;
				}
			}
			if (current.isWord())
				System.out.println("String:"+s+" found.");
		}
	}

	public void delete(String s, TrieNode node) {
		if (StringUtils.isNotEmpty(s)) {
			s = normailizeString(s);
			if (node != null) {
				char c = s.charAt(0);
				TrieNode childNode = node.getChildNode(c);
				delete(s.substring(1),childNode);
				Map<Character, TrieNode> childNodes = node.getChildNodes();
				if (childNodes == null || childNodes.keySet().size() == 0) {
					//delete current node only if there is no child nodes.
					node= null; //nulling the reference.
				}
				System.out.println("Deleted"+c);
			}
		}
	}

	public void printWordsMatchingPrefix(String prefix, TrieNode current, String entirePrefix) {
		if (StringUtils.isNotEmpty(prefix)) {
			prefix = normailizeString(prefix);
			char c = prefix.charAt(0);
			TrieNode child = current.getChildNode(c);
			if (child != null) {
				String word = entirePrefix+child.getContent();
				if (child.isWord())
					System.out.println("Found word1:"+word);
				printWordsMatchingPrefix(prefix.substring(prefix.indexOf(c)+1), child, word);
			}
		} else {
			//denotes reaching end of prefix, begin traversing to get matching words.
			Map<Character, TrieNode> map = current.getChildNodes();
			if (map != null) {
				for (char c: map.keySet()) {
					TrieNode child = current.getChildNode(c);
					if (child != null) {
						String word = entirePrefix+child.getContent();
						if (child.isWord())
							System.out.println("Found word2:"+word);
						printWordsMatchingPrefix("", child, word);
					}
				}
			}
		}
	}


	private String normailizeString(String s){
		return s.toLowerCase();
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		//trie.insert("Amrut");
		//trie.insert("All");
		//trie.insert("Ant");
		trie.insert("Budihal");
		trie.insert("Buddy");
		trie.insert("Buddygame");
		//trie.insert("abudihal");
		trie.printWordsMatchingPrefix("b", trie.getRoot(), "");
		trie.search("Buddy");
	}

	public TrieNode getRoot() {
		return root;
	}
}
