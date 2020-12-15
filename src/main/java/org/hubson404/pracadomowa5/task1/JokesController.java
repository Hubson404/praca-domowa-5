package org.hubson404.pracadomowa5.task1;

import lombok.RequiredArgsConstructor;
import org.hubson404.pracadomowa5.task1.model.Joke;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class JokesController {

    private final JokeService jokeService;

    @GetMapping("/jokes")
    public List<Joke> getJokes() {
        List<Joke> jokesList = jokeService.getJokes();
        return jokesList;
    }

}

