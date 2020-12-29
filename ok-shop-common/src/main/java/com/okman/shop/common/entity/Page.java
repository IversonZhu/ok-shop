package com.okman.shop.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Page<T> implements Serializable {

    // 页数（第几页）
    private long currentPage;

    // 查询数据库里面对应的数据有多少条
    private long total;// 从数据库查处的总记录数

    // 每页查5条
    private int size;

    // 下页
    private int next;

    private List<T> list;

    // 最后一页
    private int last;

    private int lPage;

    private int rPage;

    //从哪条开始查
    private long start;

    //全局偏移量
    public int offSize = 2;

    public Page() {
        super();
    }

    /****
     *
     * @param currentPage
     * @param total
     * @param pageSize
     */
    public void setCurrentPage(long currentPage, long total, long pageSize) {
        //可以整除的情况下
        long pageCount = total / pageSize;

        //如果整除表示正好分N页，如果不能整除在N页的基础上+1页
        int totalPages = (int) (total % pageSize == 0 ? total / pageSize : (total / pageSize) + 1);

        //总页数
        this.last = totalPages;

        //判断当前页是否越界,如果越界，我们就查最后一页
        if (currentPage > totalPages) {
            this.currentPage = totalPages;
        } else {
            this.currentPage = currentPage;
        }

        //计算start
        this.start = (this.currentPage - 1) * pageSize;
    }

    //上一页
    public long getUpper() {
        return currentPage > 1 ? currentPage - 1 : currentPage;
    }

    //总共有多少页，即末页
    public void setLast(int last) {
        this.last = (int) (total % size == 0 ? total / size : (total / size) + 1);
    }

    /****
     * 带有偏移量设置的分页
     * @param total
     * @param currentPage
     * @param pageSize
     * @param offSize
     */
    public Page(long total, int currentPage, int pageSize, int offSize) {
        this.offSize = offSize;
        initPage(total, currentPage, pageSize);
    }

    /****
     *
     * @param total   总记录数
     * @param currentPage    当前页
     * @param pageSize    每页显示多少条
     */
    public Page(long total, int currentPage, int pageSize) {
        initPage(total, currentPage, pageSize);
    }

    /****
     * 初始化分页
     * @param total
     * @param currentPage
     * @param pageSize
     */
    public void initPage(long total, int currentPage, int pageSize) {
        //总记录数
        this.total = total;
        //每页显示多少条P
        this.size = pageSize;

        //计算当前页和数据库查询起始值以及总页数
        setCurrentPage(currentPage, total, pageSize);

        //分页计算
        int leftCount = this.offSize,    //需要向上一页执行多少次
                rightCount = this.offSize;

        //起点页
        this.lPage = currentPage;
        //结束页
        this.rPage = currentPage;

        //2点判断
        this.lPage = currentPage - leftCount;            //正常情况下的起点
        this.rPage = currentPage + rightCount;        //正常情况下的终点

        //页差=总页数和结束页的差
        int topDiv = this.last - rPage;                //判断是否大于最大页数

        /***
         * 起点页
         * 1、页差<0  起点页=起点页+页差值
         * 2、页差>=0 起点和终点判断
         */
        this.lPage = topDiv < 0 ? this.lPage + topDiv : this.lPage;

        /***
         * 结束页
         * 1、起点页<=0   结束页=|起点页|+1
         * 2、起点页>0    结束页
         */
        this.rPage = this.lPage <= 0 ? this.rPage + (this.lPage * -1) + 1 : this.rPage;

        /***
         * 当起点页<=0  让起点页为第一页
         * 否则不管
         */
        this.lPage = this.lPage <= 0 ? 1 : this.lPage;

        /***
         * 如果结束页>总页数   结束页=总页数
         * 否则不管
         */
        this.rPage = this.rPage > last ? this.last : this.rPage;
    }

    /**
     * @return the list
     */
    public List<T> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<T> list) {
        this.list = list;
    }

    public static void main(String[] args) {
        //总记录数
        //当前页
        //每页显示多少条
        int cPage = 17;
        Page page = new Page(1001, cPage, 50, 7);
        System.out.println("开始页:" + page.getLPage() + "__当前页：" + page.getCurrentPage() + "__结束页" + page.getRPage() + "____总页数：" + page.getLast());
    }
}
