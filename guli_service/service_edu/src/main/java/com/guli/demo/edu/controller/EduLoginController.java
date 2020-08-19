package com.guli.demo.edu.controller;

import com.guli.commonutils.R;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class EduLoginController {
    @PostMapping("/login")
    public R login(){

        return R.ok().data("token","admin");
    }

    @GetMapping("/info")
    public R info(){

        return R.ok().data("roles","[roles]").data("name","admin").data("avatar","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1597814602419&di=bac3940ca826227f0f49e0208aa360c9&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20170202%2Fcb8112b890ee4b90b1d362a9d6174675_th.gif");
    }
}
