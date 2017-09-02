package proj.security.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
 
 // ckeditor 다이얼로그 창에서 Ajax로 이미지를 업로드한 메서드
 @RequestMapping(value = "/imageUpload", method = RequestMethod.POST)
 public void commUpload(HttpServletRequest request,
   HttpServletResponse response, @RequestParam MultipartFile upload) {
  OutputStream out = null;
  PrintWriter printWriter = null;
  response.setCharacterEncoding("EUC-KR");
  response.setContentType("text/html;charset=EUC-KR");
  try {
   String fileName = upload.getOriginalFilename();
   byte[] bytes = upload.getBytes();
  // String path = request.getServletContext().getRealPath("/resources/upload");
   String path = request.getRealPath("/resources/upload");
   String uploadPath = path + "\\" + fileName;// 저장경로 
   out = new FileOutputStream(new File(uploadPath));
   out.write(bytes);
   String callback = request.getParameter("CKEditorFuncNum");

   printWriter = response.getWriter();

   String fileUrl = "resources/upload/" + fileName;// url경로
   // 파일 업로드를 비동기식으로 연결할 때 Callback을 정의한다.
   //printWriter.println("data:");
   printWriter.println("<script type='text/javascript'>"
     + "window.parent.CKEDITOR.tools.callFunction(" + callback
     + ",'" + fileUrl + "','이미지를 업로드 하였습니다.'" + ")</script>");
   printWriter.flush();

  } catch (IOException e) {
   e.printStackTrace();
  } finally {
   try {
    if (out != null) {
     out.close();
    }
    if (printWriter != null) {
     printWriter.close();
    }
   } catch (IOException e) {
    e.printStackTrace();
   }
  }

  return;
 }
}

