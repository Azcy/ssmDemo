package com.zcy.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Controller
public class TestController {
    @RequestMapping(value = "/upload", produces = "application/json;charset=UTF-8")
    public @ResponseBody
    boolean uploadFiles(@RequestParam("file_upload") MultipartFile[] files) {
        boolean result = false;
        String realPath;
        for (int i = 0; i < files.length; i++) {
            if (!files[i].isEmpty()) {
                String uniqueName = files[i].getOriginalFilename();//得到文件名
                realPath = "/tmp/upload/" + File.separator + uniqueName;//文件上传的路径
                try {
                    files[i].transferTo(new File(realPath));  // 转存文件

                    result = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    return result;
}

}
