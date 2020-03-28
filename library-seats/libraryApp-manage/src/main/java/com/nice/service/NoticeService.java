package com.nice.service;

import com.nice.utils.DataResult;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-03-28 14:40
 *
 * @author wmj
 * @version 1.0
 */
public interface NoticeService {

    public DataResult findNotice(int pagenum,int pagesize);
}
