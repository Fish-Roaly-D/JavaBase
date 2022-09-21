package com.roily.tree;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @version 1.0.0
 * @Description trie字典树的实现
 * @ClassName TrieTest.java
 * @author: RoilyFish
 * @date: 2022/5/17 23:31
 */
public class TrieTest {

    /**
     * 字典树节点
     * <p>
     * 每个节点有多个子节点，且子节点互不重复
     */
    static class TrieNode {
        //子节点
        HashMap<Character, TrieNode> children = new HashMap<>();
        //字符串结束标志
        Boolean isEnd;

        public TrieNode() {
            this.children = new HashMap<Character, TrieNode>();
            this.isEnd = false;
        }
    }

    //字典树根节点
    private TrieNode root;

    public TrieTest() {
        this.root = new TrieNode();
    }

    //插入字典树
    void insert(String value) {

        TrieNode nodeTemp = root;

        for (int i = 0; i < value.length(); i++) {
            //获取字符
            Character c = value.charAt(i);
            //是否包含此节点
            if (!nodeTemp.children.containsKey(c)) {
                nodeTemp.children.put(c, new TrieNode());
            }
            nodeTemp = nodeTemp.children.get(c);
        }
        //最后一个插入的字符为叶子节点
        nodeTemp.isEnd = true;
    }

    //查找 也是从根节点开始搜索
    boolean search(String value) {

        TrieNode nodeTemp = root;

        for (int i = 0; i < value.length(); i++) {
            //获取字符
            Character c = value.charAt(i);
            //是否包含此节点
            if (!nodeTemp.children.containsKey(c)) {
                return false;
            }
            nodeTemp = nodeTemp.children.get(c);
        }

        return nodeTemp.isEnd;
    }

    @Test
    public void test() {
        TrieTest trieTest = new TrieTest();
        String[] values = new String[]{"a", "to", "tea", "ted", "ten", "i", "in", "ind", "ifd"};
        for (int i = 0; i < values.length; i++) {
            trieTest.insert(values[i]);
        }
        System.out.println("==是否包含ten==>" + trieTest.search("ten"));
        System.out.println("==是否包含xxxx==>" + trieTest.search("xxxx"));
    }

}



