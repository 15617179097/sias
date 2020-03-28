package com.nice.service;

import com.nice.pojo.Supervision;
import com.nice.utils.DataResult;

import javax.servlet.http.HttpServletRequest;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-03-28 20:41
 *
 * @author wmj
 * @version 1.0
 */
public interface SupervisionService {

    //添加座位监督信息
    public DataResult insertSupervision(Supervision supervision, HttpServletRequest request);
}
