package com.nice.controller;

import com.nice.service.UserService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-01-12 23:01
 *
 * @author wmj
 * @version 1.0
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public DataResult index(){
        return  null;
    }

    /**
     * @Description 根据token获取用户信息
     * @param request
     * @return com.nice.utils.DataResult
     **/
    @GetMapping("userInfo")
    public DataResult findUserByLoginStateUUid(HttpServletRequest request){
        return  userService.findUserByLoginStateUUid(request);
    }

    /**
     * @Description 添加学号
     * @param request
     * @param studentId
     * @return com.nice.utils.DataResult
     **/
    @PostMapping("userInfo")
    public DataResult saveUserByLoginStateUUid(HttpServletRequest request, String studentId){
        return  userService.saveUserByLoginStateUUid(request, studentId);
    }


    /**
     * @Description 查询我的违约记录
     * @param request
     * @return com.nice.utils.DataResult
     **/
    @GetMapping("/findUserRecordByUserId")
    public DataResult findUserRecordByUserId(HttpServletRequest request){
        return userService.findUserRecordByUserId(request);
    }

    /**
     * @Description 查询我的预约记录
     * @param request
     * @return com.nice.utils.DataResult
     **/
    @GetMapping("/findMyAllSubscribe")
    public DataResult findMyAllSubscribe(HttpServletRequest request,
                                         @RequestParam(value = "pagenum",defaultValue = "1") Integer pagenum,
                                         @RequestParam(value = "pagesize",defaultValue = "10")Integer pagesize) {
        return userService.findMyAllSubscribe(request,pagenum,pagesize);
    }

    /**
     * @Description 解除绑定学号
     * @param request
     * @return com.nice.utils.DataResult
     **/
    @DeleteMapping("userInfo")
    public DataResult deleteUserInfo(HttpServletRequest request){
        return userService.deleteUserInfo(request);
    }
}
