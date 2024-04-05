package com.jshbank.demo.ai;

import com.jshbank.demo.ai.entity.AiRequest;
import com.jshbank.demo.ai.entity.AiResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AiService {
  public AiResponse sendRequest(AiRequest request) {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<AiRequest> entity = new HttpEntity<>(request, headers);
    String url = "https://us-central1-aiplatform.googleapis.com/v1/projects/bold-gearbox-419315/locations/us-central1/publishers/google/models/text-bison:predict";

    return restTemplate.postForObject(url, entity, AiResponse.class);
  }
}
