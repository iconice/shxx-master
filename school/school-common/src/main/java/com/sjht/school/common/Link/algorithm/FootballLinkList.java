package com.sjht.school.common.Link.algorithm;

import com.sjht.school.common.Link.FootbalList;
import com.sjht.school.common.Link.algorithm.FootballNode;

/**
 * ***************************************************
 *
 * @ClassName FootballLinkList
 * @Description 单向链表操作
 * @Author maojianyun
 * @Date 2019/9/30 14:05
 * @Version V1.0
 * ****************************************************
 **/
public class FootballLinkList implements FootbalList {

    private FootballNode head; // 头指针

    private int size; // 节点个数

    /**
     * 构造一个拥有头节点的连链表
     */
    public FootballLinkList() {
        this.size = 0;
        this.head = new FootballNode(null);
    }

    @Override
    public void insertHead(Object object) {
        // 构造节点
        FootballNode node = new FootballNode(object, null);
        FootballNode temp = head;
        FootballNode next = head.getNext();
        if (next == null) {
            temp.setNext(node);
            size++;
        } else {
            node.setNext(next);
            temp.setNext(node);
            size++;
        }

    }

    @Override
    public void insertTail(Object object) {
        FootballNode node = new FootballNode(object, null);
        FootballNode temp = head;
        while (temp.getNext() != null){
            temp = temp.getNext();
        }
        size++;
        temp.setNext(node);
    }

    @Override
    public void insert(int index, Object object) throws Exception {
        if (index > size) {
            throw new Exception("下标越界");
        }
        FootballNode node = new FootballNode(object, null);
        FootballNode temp = head;
        FootballNode next = head.getNext();
        for (int i = 0; i < index - 1; i++){
            temp = temp.getNext();
            next = next.getNext();
        }
        size++;
        node.setNext(next);
        temp.setNext(node);
    }

    @Override
    public FootballNode deleteHead(){
        if (size <= 0){
            return null;
        }
        FootballNode temp = head;
        FootballNode deleteNode = head.getNext();
        temp.setNext(temp.getNext().getNext());
        size--;
        return deleteNode;
    }

    @Override
    public FootballNode deleteTail() throws Exception{
        if (size <= 0){
            throw new Exception("链表没有元素");
        }
        FootballNode temp = head;
        FootballNode next = head.getNext();
        while (next.getNext() != null){
            temp = temp.getNext();
            next = next.getNext();
        }
        temp.setNext(null);
        size--;
        return next;
    }

    @Override
    public FootballNode delete(int index) throws Exception {
        if (size <= 0){
            throw new Exception("链表没有元素");
        }
        FootballNode temp = head;
        FootballNode next = head.getNext();
        for(int i = 0; i < index - 1; i++){
            temp = temp.getNext();
            next = next.getNext();
        }
        temp.setNext(next.getNext());
        size--;
        return next;
    }

    public FootballNode getHead() {
        return head;
    }

    public void setHead(FootballNode head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
