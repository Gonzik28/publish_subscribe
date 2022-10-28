package com.gonzik28.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class NumberDto {
    public static final int MAX_SIZE_LIST = 100;

    int one;
    int two;

    public NumberDto(int one, int two) {
        this.one = one;
        this.two = two;
    }

    public int getOne() {
        return one;
    }

    public void setOne(int one) {
        this.one = one;
    }

    public int getTwo() {
        return two;
    }

    public void setTwo(int two) {
        this.two = two;
    }

    public static NumberDto getNumberDto() {
        return new NumberDto(new Random().nextInt(10), new Random().nextInt(10));
    }

    public static Stream<NumberDto> getNumbers() {
        List<NumberDto> numbers = new ArrayList<>();
        for (int i = 0; i < MAX_SIZE_LIST; i++) {
            numbers.add(NumberDto.getNumberDto());
        }
        return numbers.stream();
    }
}
