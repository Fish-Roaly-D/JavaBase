package com.roily.tree;

import org.junit.Test;
import org.openjdk.jol.util.ObjectUtils;

/**
 * @version 1.0.0
 * @Description java实现二叉查找树
 * @ClassName BST.java
 * @author: RoilyFish
 * @date: 2022/5/18 0:03
 */
public class BST<T> {

    /**
     * 二叉查找树，是特殊的完全二叉树，任意父节点的值大于其左子节点，小于其右子节点，如此表现有序性
     *
     * - 注意
     * -- 若所插入数据已表现为有序性，二叉查找数会退化为链表，导致查找效率底下
     */
    class BSTNode {
        //左右子节点
        BSTNode lChild;
        BSTNode rChild;
        //value值
        T value;

        public BSTNode(T value) {
            this.value = value;
        }
    }

    BSTNode root;

    public BST() {
        this.root = new BSTNode(null);
    }

    /**
     * 插入节点
     *
     * @param t
     */
    void insert(T t) {
        Comparable<? super T> tTemp = (Comparable<? super T>) t;
        //可比较的对象
        assert t instanceof Comparable;

        BSTNode rootTemp = root;

        for (; ; ) {
            //头节点未初始化
            if (rootTemp.value == null) {
                rootTemp.value = t;
                return;
            } else if (tTemp.compareTo(rootTemp.value) > 0) {
                if ((rootTemp.rChild) == null) {
                    rootTemp.rChild = new BSTNode(t);
                    return;
                }
                rootTemp = rootTemp.rChild;
            } else {
                if ((rootTemp.lChild) == null) {
                    rootTemp.lChild = new BSTNode(t);
                    return;
                }
                rootTemp = rootTemp.lChild;
            }
        }

    }

    boolean search(T t) {
        Comparable<? super T> tTemp = (Comparable<? super T>) t;
        //可比较的对象
        assert t instanceof Comparable;

        BSTNode rootTemp = root;

        for (; ; ) {
            if (rootTemp == null) {
                return false;
            } else if (tTemp.compareTo(rootTemp.value) == 0) {
                return true;
            } else if (tTemp.compareTo(rootTemp.value) > 0) {
                rootTemp = rootTemp.rChild;
            } else if (tTemp.compareTo(rootTemp.value) < 0) {
                rootTemp = rootTemp.lChild;
            }

        }

    }

    @Test
    public void test() {

        BST<Integer> integerBST = new BST<>();
        integerBST.insert(6);
        integerBST.insert(2);
        integerBST.insert(3);
        integerBST.insert(1);
        integerBST.insert(5);
        integerBST.insert(9);
        integerBST.insert(10);
        integerBST.insert(120);

        System.out.println(integerBST.search(2));
        System.out.println(integerBST.search(10000));
        System.out.println(integerBST.search(10));
        System.out.println(integerBST.search(10));
        System.out.println(integerBST.search(120));
        System.out.println(integerBST.search(5));

    }

}
