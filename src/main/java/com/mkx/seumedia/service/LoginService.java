package com.mkx.seumedia.service;

import com.mkx.seumedia.entity.User;
import com.mkx.seumedia.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class LoginService {
    @Autowired
    private UserMapper mapper;
    public Map<String,String> login(String name,String password,int mode){
        Map<String,String> map=new HashMap<>();
        if(mode==0){
            User user=mapper.selectByPhone(name);
            if(user.equals(null)){
                map.put("result","N");
                map.put("msg","查无此人");
            }else {
                if(user.getPassword().equals(password)){
                    map.put("result","Y");
                }else {
                    map.put("result","N");
                    map.put("msg","密码错误");
                }
            }
        }else{
            User user=mapper.selectByEmail(name);
            if(user.equals(null)){
                map.put("result","N");
                map.put("msg","查无此人");
            }else {
                if(user.getPassword().equals(password)){
                    map.put("result","Y");
                }else {
                    map.put("result","N");
                    map.put("msg","密码错误");
                }
            }
        }
        return map;
    }
}
