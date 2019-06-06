package com.mkx.seumedia.controller;

import com.mkx.seumedia.entity.User;
import com.mkx.seumedia.service.LoginService;
import com.mkx.seumedia.service.RegistService;
import com.mkx.seumedia.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private RegistService registService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private User user;
    @RequestMapping("/user/regist")
    @ResponseBody
    public Map<String, String> regist(String name,String password,String email,String phone){

        user.setUsername(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        return registService.regist(user);
    }
    @RequestMapping("/user/login")
    @ResponseBody
    public Map<String,String> login(String name, String password, int mode, HttpServletRequest request){
        Map<String,String> map= loginService.login(name,password,mode);
        if(map.get("result").equals("Y")){
            request.getSession().setAttribute("user",name);
        }
        return map;
    }
    @RequestMapping(value = "/user/userinfo",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getUserinfo(long id){
        return userInfoService.getUserinfo(id);
    }
    @RequestMapping(value = "/user/userinfo",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateUserinfo(long id, String realname, Boolean gender, @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday, String id_number, String description,@RequestParam("head_image_file") MultipartFile head_image_file){
        System.out.println(head_image_file.equals(null));
        user.setId(id);
        user.setRealName(realname);
        user.setGender(gender);
        user.setBirthday(birthday);
        user.setIdNumber(id_number);
        user.setDescription(description);
        user.setHeadPortrait("images\\"+String.valueOf(id)+"head_img.png");
        return userInfoService.updateUserinfo(user,head_image_file);
    }
}
