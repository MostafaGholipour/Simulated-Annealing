package com.example.Simulated.Annealing;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RequiredArgsConstructor
@RestController
@RequestMapping("/a")
public class Controller {
    private final Controller controller;

    @GetMapping
    public void run() {
        controller.run();
    }

    public static void main(String[] args) {
        Service service = new Service();
//        Long[] random = service.random();
//        service.offer(service.random(), 10L);
        service.run();
    }
}
