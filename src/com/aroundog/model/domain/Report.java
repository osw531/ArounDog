package com.aroundog.model.domain;

import org.springframework.web.multipart.MultipartFile;

public class Report {
   private int report_id;
   private String content;
   private String regdate;
   private String email;
   private String phone;
   // private Member member; ���߿� �߰��ؾ���#################
   private MultipartFile[] myFile;
   private double lati;
   private double longi;
   private int member_id;

   public MultipartFile[] getMyFile() {
      return myFile;
   }

   public void setMyFile(MultipartFile[] myFile) {
      this.myFile = myFile;
   }

   public int getReport_id() {
      return report_id;
   }

   public void setReport_id(int report_id) {
      this.report_id = report_id;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }

   public String getRegdate() {
      return regdate;
   }

   public void setRegdate(String regdate) {
      this.regdate = regdate;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public double getLati() {
      return lati;
   }

   public void setLati(double lati) {
      this.lati = lati;
   }

   public double getLongi() {
      return longi;
   }

   public void setLongi(double longi) {
      this.longi = longi;
   }

   public int getMember_id() {
      return member_id;
   }

   public void setMember_id(int member_id) {
      this.member_id = member_id;
   }
}