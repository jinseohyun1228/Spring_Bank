package com.jshbank.demo.ai;

import com.jshbank.demo.ai.entity.AiRequest;
import com.jshbank.demo.ai.entity.AiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Aitest {

  @Autowired
  AiService aiService;

  @GetMapping("/ai")
  public String ai(){

    AiRequest aiRequest = new AiRequest();

    AiResponse aiResponse = aiService.sendRequest(aiRequest);

    System.out.println(aiResponse);


    return "안녕";
  }

}
