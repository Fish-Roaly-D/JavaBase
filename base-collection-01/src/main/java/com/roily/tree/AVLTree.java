package com.roily.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;
import org.springframework.util.ObjectUtils;

/**
 * @version 1.0.0
 * @Description 平衡二叉查找树
 * @ClassName AVLTree.java
 * @author: RoilyFish
 * @date: 2022/5/18 22:55
 */
public class AVLTree<T> {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class AVLNode {
        //左右子节点
        AVLNode lChild;
        AVLNode rChild;
        //value值
        T value;
        //需要一个高度，来判断是否需要旋转，平衡
        int height;
    }

    AVLNode root;

    public AVLTree() {
    }

    //节点的高度
    public int height(AVLNode avlNode) {
        return avlNode.height;
    }

    /**
     * 插入节点
     *
     * 节点的高度如何确定
     *
     * @param t
     */
    void insert(T t) {
        Comparable<? super T> tTemp = (Comparable<? super T>) t;
        //可比较的对象
        assert t instanceof Comparable;

        //是否运行高度加1
        int sure = 1;

        AVLNode rootTemp = root;

        for (; ; ) {
            //头节点未初始化
            if (ObjectUtils.isEmpty(rootTemp)) {
                root = new AVLNode(null,null,t,0);
                return;
            } else if (tTemp.compareTo(rootTemp.value) > 0) {
                if (!ObjectUtils.isEmpty(rootTemp.rChild)) {
                    rootTemp.height++;
                    rootTemp = rootTemp.rChild;
                }
                if (sure)
                rootTemp.height++;
                rootTemp.rChild = new AVLNode(null,null,t,0);
                return;
            } else {
                if (ObjectUtils.isEmpty(rootTemp.lChild)) {
                    rootTemp.height++;
                    rootTemp.lChild = new AVLNode( null,null,t,0);
                    return;
                }
                rootTemp.height++;
                rootTemp = rootTemp.lChild;
            }
        }

    }

    @Test
    public void test(){

        AVLTree<Integer> integerAVLTree = new AVLTree<Integer>();

        integerAVLTree.insert(8);
        integerAVLTree.insert(9);
        integerAVLTree.insert(10);
        integerAVLTree.insert(1);
        integerAVLTree.insert(2);
        integerAVLTree.insert(3);
        integerAVLTree.insert(4);
        integerAVLTree.insert(6);
        integerAVLTree.insert(5);

    }

}
