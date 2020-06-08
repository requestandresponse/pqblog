package com.fb.pqBlg.manage.web.controller;

import com.fb.pqBlog.common.eneity.common.User;
import com.fb.pqBlog.common.restult.CommonRestult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
public class ManageController {


    @GetMapping
    public User userList(){
        User user = new User();
        user.setUsername("111");
        List<User> users = new ArrayList<>();
        users.add(user);
        return user;
      //  return users;
    }

    @PostMapping("add")
    public CommonRestult addUser(@RequestBody @Valid User user, BindingResult result){
        CommonRestult success = CommonRestult.getSuccess();
        return success;
    }
}
