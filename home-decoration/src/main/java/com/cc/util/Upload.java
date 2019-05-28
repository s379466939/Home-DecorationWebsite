package com.cc.util;


import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.*;
import java.util.Iterator;
import java.util.List;

//该接收文件方法使用于Servlet
public class Upload {
    private static final String tag = "com.cc.util.Upload";

//    public static String getPicUrl(Part part) throws IOException {
//        File uploadDir = new File("D:\\java\\javaEE\\IDEA-Tomcat8.5\\webapps\\ROOT\\upload");
//        if (!uploadDir.exists()) {
//            uploadDir.mkdirs();
//        }
//
//        String fileName = part.getHeader("content-disposition");
//        System.out.print("fileName:" + fileName);
//        fileName = fileName.substring(fileName.lastIndexOf('.'));
//        fileName = System.currentTimeMillis() + fileName;
//        File file = new File(uploadDir, fileName);
//
//        InputStream in = part.getInputStream();
//        OutputStream out = new FileOutputStream(file);
//        byte[] buf = new byte[1024 * 10];
//        int len = in.read(buf);
//        while (len > 0) {
//            out.write(buf, 0, len);
//            len = in.read(buf);
//        }
//        out.flush();
//        in.close();
//
//        return "/upload/" + fileName;
//    }

    public static String uploadFile(HttpServletRequest request) {
        String picUrl;
        String picUris = "";

        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //获取multiRequest 中所有的文件名
            Iterator<String> iter = multiRequest.getFileNames();
//            File uploadDir = new File("D:\\java\\javaEE\\PracticeCode_IDEA\\bluetravel\\src\\main\\webapp\\WEB-INF\\view\\pic");
            File uploadDir = new File("/home/devin/Documents/home-decorationPic/");
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            while (iter.hasNext()) {
                String fileName1 = iter.next();
                System.out.print(tag + ":  _________uploadFile:" + fileName1);
                List<MultipartFile> fileList = multiRequest.getFiles(fileName1);
                if (fileList.size() > 0) {
                    Iterator<MultipartFile> fileIte = fileList.iterator();
                    while (fileIte.hasNext()) {
                        //获得每一个文件
                        MultipartFile multipartFile = fileIte.next();
                        String fileName = System.currentTimeMillis() + multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf('.'));
                        picUrl = "/home/devin/Documents/home-decorationPic/" + fileName;
                        //上传
                        try {
                            multipartFile.transferTo(new File(picUrl));
                        } catch (IOException e) {
                            System.err.println("写入文件失败！");
                            e.printStackTrace();
                        }
                        picUris = picUris + " " + "http://10.54.10.57:8080/home-decorationPic/" + fileName;
                    }

                }

            }
            System.out.println();

        }
        System.out.println(tag + ">>>>>picUris: " + picUris);
        return picUris;
    }
}
