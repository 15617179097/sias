package com.nice.service;

import com.nice.utils.DataResult;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-03-04 22:27
 *
 * @author wmj
 * @version 1.0
 */
public interface SeatsService {

    DataResult findSubscribeSeats(Integer classroomId);
}
