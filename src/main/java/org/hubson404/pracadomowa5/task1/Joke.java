package org.hubson404.pracadomowa5.task1;

import lombok.Data;

import java.util.List;

@Data
public class Joke {

    private Long id;
    private String joke;
    private List<String> categories;
}
