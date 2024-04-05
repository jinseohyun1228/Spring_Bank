package com.jshbank.demo.apachePOI;

import com.jshbank.demo.entity.User;
import com.jshbank.demo.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class excellTest {

  @Autowired
  UserRepository userRepository;

  @GetMapping("/user/excell")
  public void excellDownload(HttpServletResponse response) throws Exception {
    List<User> list = userRepository.findAll();
    String excelFileName = "고객 정보";

    ExcellUtil.excelDownload(response, list, excelFileName);

  }
}
