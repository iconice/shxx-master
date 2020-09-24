package com.sjht.school.common.Link.algorithm;

/**
 * ***************************************************
 * @ClassName FootballNode
 * @Description 链表节点
 * @Author maojianyun
 * @Date 2019/9/30 13:56
 * @Version V1.0
 * ****************************************************
 **/
public class FootballNode {

    private Object element;

    private FootballNode next;

    public FootballNode() {
    }

    /**
     * 头节点构造
     * @param next
     */
    public FootballNode(FootballNode next) {
        this.next = next;
    }

    /**
     * 非头节点构造
     * @param element
     * @param next
     */
    public FootballNode(Object element, FootballNode next) {
        this.element = element;
        this.next = next;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public FootballNode getNext() {
        return next;
    }

    public void setNext(FootballNode next) {
        this.next = next;
    }
}
