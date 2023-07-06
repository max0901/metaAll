package com.ohgiraffers.file;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class FileUploadController {
    @PostMapping("single-file")
    public String singleFileUpload(@RequestParam MultipartFile singleFile,@RequestParam String singleFileDescription,
                                   Model model){
        System.out.println("singleFile = " + singleFile);
        System.out.println("singleFileDescription = " + singleFileDescription);

        String root="C:\\app-file";
        String filePath=root+"/uploadFiles";
        //저장할 위치 설정
        File dir=new File(filePath);
        if(!dir.exists()){
            dir.mkdirs();
        }
        String originalFilename=singleFile.getOriginalFilename();
        //올릴ㄹ 파일 이름
        System.out.println("orogonFileName = " + originalFilename);

        String ext=originalFilename.substring(originalFilename.lastIndexOf("."));
        //올릴파일 파일타입만 나누기
        System.out.println(ext);
        String savedName= UUID.randomUUID().toString().replaceAll("-","")+ext;
        //uuid.randomUUID로 random한 이름 생성후 ext로 나눈 파일타입 합치기
        //replaceAll은 기호나 단어를 설정하여 없앨수있다
        System.out.println("savedName = " + savedName);
        try{
        singleFile.transferTo(new File(filePath+"/"+savedName));
        model.addAttribute("message","파일업로드 성공");
        }
        catch (IOException e){
            new File(filePath+"/"+savedName).delete();
            //실패시 파일을 삭제해주는 코드 작성
            model.addAttribute("message","파일 업로드 실패");

        }
        return "result";
    }

    @PostMapping("multi-file")
    public String multiFileUpload(@RequestParam List<MultipartFile> multifiles,
                                  @RequestParam String mulitFileDescription,
                                  Model model){

        System.out.println("multifiles = " + multifiles);
        System.out.println("mulitFileDescription = " + mulitFileDescription);


        String root="C:\\app-file";
        String filePath=root+"/uploadFiles";
        File dir=new File(filePath);
        if(!dir.exists()){
            dir.mkdirs();
        }

        List<Map<String,String>> files=new ArrayList<>();
        for(int i=0;i<multifiles.size();i++){
            String originFileName=multifiles.get(i).getOriginalFilename();
            String ext=originFileName.substring(originFileName.lastIndexOf("."));
            String savedName=UUID.randomUUID().toString().replaceAll("-","")+ext;

            Map<String,String> file=new HashMap<>();
            file.put("originFielName",originFileName);
            file.put("savedName",savedName);
            file.put("filePath",filePath);

            files.add(file);
        }
try {
    for(int i=0;i<multifiles.size();i++){
        Map<String,String> file=files.get(i);

        multifiles.get(i).transferTo(new File(filePath+"/"+file.get("savedName")));

    }
    model.addAttribute("massage","파일업로드성공");
}catch (Exception e){
    for(int i=0;i<multifiles.size();i++){
        Map<String,String> file=files.get(i);
        new File(filePath+"/"+file.get("savedName")).delete();
    }
    model.addAttribute("messsage","파일업로드 실패");
}
        return "result";
    }
}
