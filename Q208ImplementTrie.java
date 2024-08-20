import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MyTrie {
    List<int[]> tr;
    List<Boolean> isWord;
    int root, id;
    
    private int[] newchild() {
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        return arr;
    }
    
    public MyTrie() {
        tr = new ArrayList<>();
        isWord = new ArrayList<>();
        isWord.add(false);
        tr.add(newchild());
        root = 0;
        id = 1;
    }
    
    private int newnode() {
        int newnode = id;
        id++;
        isWord.add(false);
        tr.add(newchild());
        return newnode;
    }
    
    public void add(String s) {
        int u = root;
        for(int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if(tr.get(u)[c] == -1) {
                tr.get(u)[c] = newnode();
            }
            u = tr.get(u)[c];
        }
        isWord.set(u, true);
    }
    
    public int find(String s) {
        int u = root;
        for(int i = 0; i < s.length() && u != -1; i++) {
            int c = s.charAt(i) - 'a';
            u = tr.get(u)[c];
        }
        return u;
    }
}

public class Q208ImplementTrie {
    MyTrie tr;
    
    public Q208ImplementTrie() {
        tr = new MyTrie();
    }
    
    public void insert(String word) {
        tr.add(word);
    }
    
    public boolean search(String word) {
        int node = tr.find(word);
        return node != -1 && tr.isWord.get(node);
    }
    
    public boolean startsWith(String prefix) {
        int node = tr.find(prefix);
        return node != -1;
    }

    public static void main(String[] args) {
        Q208ImplementTrie obj = new Q208ImplementTrie();

        obj.insert("apple");

        System.out.println(obj.search("apple"));   // true
        System.out.println(obj.startsWith("app")); // true
        
        obj.insert("app");

        System.out.println(obj.search("app"));     // true
        System.out.println(obj.startsWith("app")); // true
        
        obj.insert("application");

        System.out.println(obj.search("application")); // true
        System.out.println(obj.startsWith("app"));     // true
        System.out.println(obj.startsWith("appl"));    // true
        System.out.println(obj.startsWith("appli"));   // true
        System.out.println(obj.startsWith("applia"));  // true
        System.out.println(obj.startsWith("applib"));  // false
    }
}
