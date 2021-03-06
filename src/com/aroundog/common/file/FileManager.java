package com.aroundog.common.file;

import java.io.File;

import org.springframework.stereotype.Component;

@Component
public class FileManager {
   //파일명 중 확장자 추출하여 반환하는 메서드
   public String getExt(String path) {
      //지난 여름 .에 내가 찍은. 사진.jpg
      int lastIndex = path.lastIndexOf(".");
      return path.substring(lastIndex+1, path.length());
   }
   
   //지정한 경로에 파일을 저장하는 메서드!!
   public boolean save() {   
      return false;
   }
   
   //파일명 바꾸기 : 원리는 새로운 파일명을 날짜를 이용한다.
   public String reNameByDate(File ori,String dir) {
      long time = System.currentTimeMillis();
      String filename = time+"."+getExt(ori.getName());
      boolean result = ori.renameTo(new File(dir+"/"+filename));
      if(!result) {
         filename = null;
      }
      return filename;
   }
   
   /*
    * public static void main(String[] args) { FileManager fm = new FileManager();
    * System.out.println(fm.getExt("지난여름.에.한일알공ㅆ다.JPG")); }
    */
}