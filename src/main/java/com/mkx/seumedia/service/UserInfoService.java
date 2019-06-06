package com.mkx.seumedia.service;

import com.mkx.seumedia.entity.User;
import com.mkx.seumedia.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserInfoService {
    @Autowired
    private UserMapper userMapper;
    public Map<String,Object> getUserinfo(long id){
        Map<String,Object> map=new HashMap<>();
        User user=userMapper.selectByPrimaryKey(id);
        if(user.equals(null)){
            map.put("msg","无信息");
        }else{
            map.put("realname",user.getRealName());
            map.put("gender",user.getGender());
            map.put("birthday",user.getBirthday());
            map.put("id_number",user.getIdNumber());
            map.put("description",user.getDescription());
            map.put("head_portrait",user.getHeadPortrait());
        }
        return map;
    }
    public Map<String,Object> updateUserinfo(User user, MultipartFile head_image_file){
        Map<String,Object> map=new HashMap<>();
        if(head_image_file.isEmpty()){
            System.out.println("shangchuanshibai");
        }
        File dest=new File(user.getHeadPortrait());
        try {
            head_image_file.transferTo(dest);
            User u=userMapper.selectByPrimaryKey(user.getId());
            if(u.equals(null)){
                map.put("result","N");
                map.put("msg","无信息");
            }else {
                userMapper.updateByPrimaryKeySelective(user);
                map.put("result","Y");
            }
        }catch (Exception e){

            map.put("result","N");
        }
        return map;

    }
}
