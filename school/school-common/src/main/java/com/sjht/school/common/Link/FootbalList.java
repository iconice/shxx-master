package com.sjht.school.common.Link;

import com.sjht.school.common.Link.algorithm.FootballNode;

/**
 * ***************************************************
 * @ClassName FootbalList
 * @Description 链表操作接口
 * @Author maojianyun
 * @Date 2019/9/30 14:01
 * @Version V1.0
 * ****************************************************
 **/
public interface FootbalList {

    /**
     * 从头部插入节点
     * @param object
     */
    void insertHead(Object object);

    /**
     * 从尾部插入节点
     * @param object
     */
    public void insertTail(Object object);

    /**
     * 指定的下标标添加节点
     * @param index
     * @param object
     * @throws Exception
     */
    public void insert(int index, Object object)throws Exception;

    /**
     * 删除头部
     * @return
     */
    public FootballNode deleteHead();

    /**
     * 删除尾部
     * @return
     */
    public FootballNode deleteTail() throws Exception;

    /**
     * 删除指定位置的元素
     * @param index
     * @return
     * @throws Exception
     */
    public FootballNode delete(int index) throws Exception;

}
