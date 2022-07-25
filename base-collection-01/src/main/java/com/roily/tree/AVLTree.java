package com.roily.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

/**
 * @version 1.0.0
 * @Description 平衡二叉查找树，是对二叉查找树的优化，避免其退化为链表，提高查找效率
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
        //该节点节对应子树高度
        int height;

        public AVLNode(T value) {
            this.value = value;
        }
    }

    private AVLNode root;

    public AVLTree() {
    }

    /**
     * 插入节点
     * <p>
     * 节点的高度如何确定
     * <p>
     * -左边插入一个
     *
     * @param t
     */
    void insert(T t) {

        root = insert(root, t);
    }

    private AVLNode insert(AVLNode root, T t) {
        //可比较的对象
        assert t instanceof Comparable;
        Comparable<? super T> tTemp = (Comparable<? super T>) t;

        //节点未初始化，递归出口
        if (ObjectUtils.isEmpty(root)) {
            root = new AVLNode(t);
            return root;
        }
        //插入右子树
        else if (tTemp.compareTo(root.value) > 0) {
            root.rChild = insert(root.rChild, t);
            //右右情况
            if (bf(root.rChild) < -1) {
                root = rrRotate(root);

            }
            //右左情况
            else if (bf(root.rChild) > 1) {
                root = rlRotate(root);
            }
        }
        //插入左子树
        else {
            root.lChild = insert(root.lChild, t);
            //左左情况
            if (bf(root.lChild) > 1) {
                root = llRotate(root);
            }
            //左右情况
            else if (bf(root.lChild) < -1) {
                root = lrRotate(root);
            }
        }
        //插入新节点跟新子树高度
        root.height = height(root);
        return root;
    }

    private AVLNode element(AVLNode node, T t) {

        assert t instanceof Comparable;

        Comparable tTemp = (Comparable) t;

        if (tTemp.compareTo(node.value) == 0)
            return node;
        else if (tTemp.compareTo(node.value) > 0)
            return element(node.rChild, t);
        else
            return element(node.lChild, t);
    }

    public AVLNode element(T t) {
        return element(root, t);
    }

    //递归计算节点高度
    private int height(AVLNode node) {
        //当前节点为空，直接返回-1
        if (node == null) return -1;
        //当前节点左右节点为空，返回0
        if (node.lChild == null && node.rChild == null)
            return 0;
        else {
            return Math.max(height(node.lChild), height(node.rChild)) + 1;
        }

    }

    //判断树是否不平衡
    private Boolean isBalance(AVLNode root) {
        return Math.abs(height(root.lChild) - height(root.rChild)) <= 1;
    }

    //小于0，右子树高  大于0 左子树高
    private int bf(AVLNode root) {

        return height(root.lChild) - height(root.rChild);

    }


    //左左情况
    private AVLNode llRotate(AVLNode root) {

        AVLNode lChild = root.lChild;
        //左子树的右节点为，根节点的左节点
        root.lChild = lChild.rChild;
        root.height = height(root);
        //左子树的右节点，为根节点
        lChild.rChild = root;
        //左左情况，只需要跟新  k1  和 k2高度，其他节点的子树叶子节点没有变化
        lChild.height = height(lChild);
        //新的根节点
        return lChild;
    }

    //右右情况
    private AVLNode rrRotate(AVLNode root) {

        AVLNode rChild = root.rChild;
        //左子树的右节点为，根节点的左节点
        root.rChild = rChild.lChild;
        root.height = height(root);
        //左子树的右节点，为根节点
        rChild.lChild = root;
        rChild.height = height(rChild);
        //新的根节点
        return rChild;
    }

    //左右情况
    private AVLNode lrRotate(AVLNode root) {

        //先将左子树进行右旋，并跟新
        root.lChild = rrRotate(root.lChild);
        //再将原树进行左旋
        return llRotate(root);
    }

    //右左情况
    private AVLNode rlRotate(AVLNode root) {
        //先将右子树进行左旋，并跟新
        root.rChild = llRotate(root.rChild);
        //再将原树进行右旋
        return rrRotate(root);
    }


    public static void main(String[] args) {
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

        //验证高度
        System.out.println(integerAVLTree.height(integerAVLTree.root));
        System.out.println(integerAVLTree.root.height);
        //查询节点
        System.out.println(integerAVLTree.element(8));
    }
}
