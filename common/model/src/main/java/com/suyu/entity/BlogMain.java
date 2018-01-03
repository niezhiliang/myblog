package com.suyu.entity;

public class BlogMain {
    /**
     * 页码
     */
    private Integer pageno;
    /**
     * 页数
     */
    private Integer pagesize;
    /**
     * 查询条件
     */
    private String search;
    /**
     * 当前页
     */
    private int currpage;

    /**
     * 总页数
     */
    private int pages ;
    /**
     * 总记录
     */
    private int count;
    /**
     * 分页开始序号
     */
    private int begin;
    /**
     * 标签id
     */
    private int lid;

    /**
     * 返回总页数
     * @return
     */
    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCurrpage() {
        return currpage;
    }

    public void setCurrpage(int currpage) {
        this.currpage = currpage;
    }

    public Integer getPageno() {
        return pageno;
    }

    public void setPageno(Integer pageno) {
        this.pageno = pageno;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public int getBegin() {
        return (this.pageno-1)*this.pagesize;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }
}
