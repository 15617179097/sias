package com.nice.service;

import com.nice.utils.DataResult;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-01-13 15:13
 *
 * @author wmj
 * @version 1.0
 */
public interface UserRecordService {
    DataResult findUserRecordByUserId(String loginStateUUID);
}
