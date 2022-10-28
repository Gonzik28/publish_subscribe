package com.gonzik28.react;

import com.gonzik28.dto.NumberDto;
import reactor.core.publisher.Flux;

import static com.gonzik28.dto.NumberDto.getNumbers;

public class Main {

    public static final int MAX_SIZE_LIMIT = 4;
    public static final int LIMIT = 6;

    public static void main(String[] args) {

        Flux<NumberDto> streaming = Flux.fromStream(() -> getNumbers());
        streaming.limitRate(LIMIT).skip(MAX_SIZE_LIMIT)
                .map(s -> "Example: " + s.getOne() + " * " + s.getTwo() + " = " + s.getOne() * s.getTwo())
                .subscribe(new ReactSubscriber<>());
    }

}

