package com.jshbank.demo.ai.entity;
import java.util.List;
import java.util.Map;

public class AiResponse {
  private List<Prediction> predictions;
  private Metadata metadata;

  // 생성자, 게터, 세터 생략

  public static class Prediction {
    private String content;
    private CitationMetadata citationMetadata;
    private Logprobs logprobs;
    private SafetyAttributes safetyAttributes;

    // 생성자, 게터, 세터 생략
  }

  public static class CitationMetadata {
    private List<Citation> citations;

    // 생성자, 게터, 세터 생략
  }

  public static class Citation {
    private int startIndex;
    private int endIndex;
    private String url;
    private String title;
    private String license;
    private String publicationDate;

    // 생성자, 게터, 세터 생략
  }

  public static class Logprobs {
    private List<Float> tokenLogProbs;
    private List<String> tokens;
    private List<Map<String, Float>> topLogProbs;

    // 생성자, 게터, 세터 생략
  }

  public static class SafetyAttributes {
    private List<String> categories;
    private boolean blocked;
    private List<Float> scores;
    private List<Integer> errors;

    // 생성자, 게터, 세터 생략
  }

  public static class Metadata {
    private TokenMetadata tokenMetadata;

    // 생성자, 게터, 세터 생략
  }

  public static class TokenMetadata {
    private InputTokenCount input_token_count;
    private OutputTokenCount output_token_count;

    // 생성자, 게터, 세터 생략
  }

  public static class InputTokenCount {
    private int total_tokens;
    private int total_billable_characters;

    // 생성자, 게터, 세터 생략
  }

  public static class OutputTokenCount {
    private int total_tokens;
    private int total_billable_characters;

    // 생성자, 게터, 세터 생략
  }
}
