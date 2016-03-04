import java.util.HashMap;

public class Trie {

	TrieNode root;
	
	public Trie(){
		this.root = new TrieNode();
	}
	
	public void insert(TrieNode root, String word){
		
		HashMap<Character, TrieNode> childrens = root.children;
		TrieNode t=null;
		
		for(int i=0;i<word.length();i++){
			char c = word.charAt(i);
			
			if(childrens.containsKey(c)){
				t = childrens.get(c);
			}
			else{
				t = new TrieNode(c);
				childrens.put(c, t);
			}
			childrens = t.children;
			
			if(i == word.length()-1){
				t.isLeaf=true;
			}
		}
		
	}
	
	
	public String searchNode(String word){
		
		if(word.length()==0){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		HashMap<Character, TrieNode> children = root.children;
		TrieNode t = null;
		for(int i=0;i<word.length();i++){
			char c = word.charAt(i);
			
			if(children.containsKey(c)){
				t = children.get(c);
				sb.append(c);
				children = t.children;
			}
			else{
				return null;
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Trie t = new Trie();
		
		t.insert(t.root, "to");
		t.insert(t.root, "tea");
		t.insert(t.root, "ted");
		t.insert(t.root, "ten");
		t.insert(t.root, "a");
		
		System.out.println(t.searchNode("ten"));
		
	}
	
	
}


class TrieNode {
    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isLeaf;
 
    public TrieNode() {}
 
    public TrieNode(char c){
        this.c = c;
    }
}
