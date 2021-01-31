package org.hubson404.pracadomowa5.task1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.hubson404.pracadomowa5.exceptions.DataProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JokeService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public List<Joke> getJokes() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://api.icndb.com/jokes/random/10", String.class);

        String responseBody = response.getBody();
        ResponseModel responseModel;

        try {
            responseModel = objectMapper.readValue(responseBody, ResponseModel.class);

        } catch (JsonProcessingException e) {
            throw new DataProcessingException("Unable to process JSON data.");
        }

        return responseModel.getJokeList();
    }
}
