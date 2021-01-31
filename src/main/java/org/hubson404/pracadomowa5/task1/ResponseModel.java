package org.hubson404.pracadomowa5.task1;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ResponseModel {

    private String type;

    @JsonProperty("value")
    private List<Joke> jokeList;


}
