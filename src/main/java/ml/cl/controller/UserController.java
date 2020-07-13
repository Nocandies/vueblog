package ml.cl.controller;


import ml.cl.common.lang.Result;
import ml.cl.entity.User;
import ml.cl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @since 2020-07-13
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService ;

    @GetMapping("/{id}")
    public Object getUser(@PathVariable String id){
        User user =userService.getById(Long.parseLong(id));
        return Result.succ(user);
    }

    @GetMapping("/index")
    public Object getUse(){
        return userService.getById(1L);
    }
    @GetMapping("/failt")
    public Object failtest(){
        return Result.fail("密码错误");
    }
}
