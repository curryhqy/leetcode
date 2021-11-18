package editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LruCache {
    public static void main(String[] args) {
        LRUCache lruCache = new LruCache().new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        System.out.println(lruCache.get(1));
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    class DlinkedNode {
        int key;
        int value;
        DlinkedNode pre;
        DlinkedNode nex;
        DlinkedNode(){}
        DlinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    int capacity;
    int size;
    Map<Integer, DlinkedNode> cache;
    DlinkedNode head;
    DlinkedNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.cache = new HashMap<>();
        this.head = new DlinkedNode();
        this.tail = new DlinkedNode();
        head.nex = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        DlinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(DlinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DlinkedNode node) {
        node.pre.nex = node.nex;
        node.nex.pre = node.pre;
    }

    private void addToHead(DlinkedNode node) {
        node.pre = head;
        node.nex = head.nex;
        //node.nex.pre = node;
        head.nex.pre = node;
        head.nex = node;
    }

    public void put(int key, int value) {
        DlinkedNode node = cache.get(key);
        if (node == null) {
            DlinkedNode newNode = new DlinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                DlinkedNode delNode = removeTail();
                cache.remove(delNode.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private DlinkedNode removeTail() {
        DlinkedNode node = tail.pre;
        removeNode(node);
        return node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}