package org.hellofalcon.leetcode;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author chugang.cg
 * @create - 2021/10/7.
 */
public class LRUCache {

    Map<Integer, DNode> cache;
    int capacity;
    DNode head;
    DNode tail;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>(capacity + 1);
        this.capacity = capacity;
        head = new DNode();
        tail = new DNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DNode v = cache.get(key);
        if (v == null) {
            return -1;
        }

        moveToHead(v);
        return v.value;
    }

    public void put(int key, int value) {
        DNode oldVlue = cache.get(key);
        if (oldVlue != null) {
            oldVlue.value = value;
            moveToHead(oldVlue);
        } else {
            DNode newNode = new DNode(key, value);
            this.cache.put(key, newNode);
            addToHead(newNode);

            if (cache.keySet().size() > capacity) {
                removeOldestKey();
            }
        }

    }



    private void moveToHead(DNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }


    private void removeOldestKey() {
        DNode oldest = tail.prev;
        removeNode(oldest);
        this.cache.remove(oldest.key);
    }

    private void removeNode(DNode oldVlue) {
        DNode tmpNext = oldVlue.next;
        DNode tmpPrev = oldVlue.prev;
        tmpPrev.next = tmpNext;
        tmpNext.prev = tmpPrev;
    }


    class DNode {
        int key;
        int value;
        DNode prev;
        DNode next;

        DNode() {}

        DNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }


    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4

    }
}
