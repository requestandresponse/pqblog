package com.fb.pqBlg.manage.web.controller;

import com.fb.pqBlog.common.eneity.common.User;
import com.fb.pqBlog.common.restult.CommonRestult;
import jdk.nashorn.internal.ir.CallNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("user")
public class ManageController {

    public static void main(String[] args) {
        int arr[] = {-1,0,1,2,-1,-4};
       p(arr);
    }

    public static void p(int[] arr){

            List<List<Integer>> lists = new ArrayList<>();
            Arrays.sort(arr);
            Map<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                if(!map.containsKey(arr[i])){
                    map.put(arr[i],i);

                }
            }

            for (int i = 0; i < arr.length -1; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if(j+1 <arr.length && arr[j] == arr[j + 1]){
                        continue;
                    }
                    int sum = -(arr[i] + arr[j]);
                    if(map.containsKey(sum) && map.get(sum) > i && map.get(sum) > j){
                        List<Integer> list = new ArrayList<>();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(sum);
                        lists.add(list);
                    }
                }
                if(arr[i] == arr[i+1]){
                    i++;
                }
            }
        System.out.println(lists);
    }


    @GetMapping
    public User userList(){
        User user = new User();
        user.setUsername("111");
        List<User> users = new ArrayList<>();
        users.add(user);
        return user;
      //  return users;
    }

    @PostMapping()
    public CommonRestult addUser(@RequestBody @Valid User user, BindingResult result){
        if(result.hasErrors()){
            String message = result.getFieldError().getDefaultMessage();
            CommonRestult fail = CommonRestult.getFail(message);
            return fail;
        }
        CommonRestult success = CommonRestult.getSuccess();
        return success;
    }
    
}
