package com.nice.web.service;

import com.nice.web.pojo.Subscribe;
import com.nice.web.utils.DataResult;

/**
 * Company: 预约 <br>
 * Description:  <br>
 * Date: 2020-03-04 22:36
 *
 * @author wmj
 * @version 1.0
 */
public interface SubscribeService {

    //进行预约座位
    DataResult insertSubscribe(Subscribe subscribe, String token);

}
