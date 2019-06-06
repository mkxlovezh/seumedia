package com.mkx.seumedia.service;

import com.mkx.seumedia.entity.User;
import com.mkx.seumedia.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RegistService {
    @Autowired
    private UserMapper userMapper;
    public Map<String,String> regist(User user){
        Map<String,String> map=new HashMap<>();
        User u1=userMapper.selectByPhone(user.getPhone());
        User u2=userMapper.selectByEmail(user.getEmail());
        if(u1==null&&u2==null){
            userMapper.insert(user);
            map.put("result","Y");
            return map;
        }else {
            map.put("result","N");
            map.put("msg","已被注册");
            return map;
        }
    }
}
