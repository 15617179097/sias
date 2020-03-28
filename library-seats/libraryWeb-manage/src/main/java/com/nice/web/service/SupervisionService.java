package com.nice.web.service;

import com.nice.web.utils.DataResult;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-03-28 21:33
 *
 * @author wmj
 * @version 1.0
 */
public interface SupervisionService {
    //获取监督占位列表
    DataResult findSupervision(String query,int pagenum,int pagesize);

    //完成
    DataResult updateSupervision(int id);
}
