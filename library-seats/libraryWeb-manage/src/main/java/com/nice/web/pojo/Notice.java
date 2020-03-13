package com.nice.web.pojo;

/**
 * @author msl
 * @version 1.0
 * @date 2020/3/13 13:37
 */
//公告内容
public class Notice {
    private Integer id;
    private String ntitle;
    private String ncontent;
    private String ntime;//YYYY-MM-DD HH:MM:SS

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNtitle() {
        return ntitle;
    }

    public void setNtitle(String ntitle) {
        this.ntitle = ntitle;
    }

    public String getNcontent() {
        return ncontent;
    }

    public void setNcontent(String ncontent) {
        this.ncontent = ncontent;
    }

    public String getNtime() {
        return ntime;
    }

    public void setNtime(String ntime) {
        this.ntime = ntime;
    }
}

