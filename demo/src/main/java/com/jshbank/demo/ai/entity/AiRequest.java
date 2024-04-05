package com.jshbank.demo.ai.entity;
import java.util.List;

public class AiRequest {
  private List<Instance> instances;
  private Parameters parameters;

  // 생성자, 게터, 세터 생략

  public static class Instance {
    private String prompt;

    // 생성자, 게터, 세터 생략
  }

  public static class Parameters {
    private double temperature;
    private int maxOutputTokens;
    private int topK;
    private double topP;
    private int logprobs;

    // 생성자, 게터, 세터 생략
  }
}
