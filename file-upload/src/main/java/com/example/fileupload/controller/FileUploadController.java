package com.example.fileupload.controller;


import org.apache.log4j.Logger;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
public class FileUploadController {
    private static Logger logger=Logger.getLogger(FileUploadController.class);

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String uploadFile(@RequestParam(value = "file",required = true)MultipartFile file){
        try {
            System.out.println("Exec.....");
            byte[] bytes = file.getBytes();
            File fileSave=new File(file.getOriginalFilename());
            FileCopyUtils.copy(bytes,fileSave);
            return fileSave.getAbsolutePath();
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return "null";
    }
}
