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
    @RequestMapping(value = "/saveHeaderPic", method = RequestMethod.POST)
    public void saveHeaderPic(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println("/saveHeaderPic");
        String resMsg = "";
        try {

            long  startTime=System.currentTimeMillis();

            System.out.println("fileName："+file.getOriginalFilename());
            String path="./"+new Date().getTime()+file.getOriginalFilename();
            System.out.println("path:" + path);

            File newFile=new File(path);
            //通过CommonsMultipartFile的方法直接写文件
            file.transferTo(newFile);
            long  endTime=System.currentTimeMillis();
            System.out.println("运行时间："+String.valueOf(endTime-startTime)+"ms");
            resMsg = "1";
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            resMsg = "0";
        }
        response.getWriter().write(resMsg);

    }


    @RequestMapping("/uploadPic")
    @ResponseBody
    public String uploadPic(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) throws Exception {
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        String fileNameStr = (new Date().getTime())+"__"+fileName;
        File targetFile = new File(path, fileNameStr);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileNameStr;
    }

}
