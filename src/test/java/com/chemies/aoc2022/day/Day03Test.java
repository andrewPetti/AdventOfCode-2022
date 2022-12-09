package com.chemies.aoc2022.day;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day03Test {
    private Day03 _subject;

    @BeforeEach
    void setup() {
        _subject = new Day03();
    }

    @Test
    void executePartA_expectCorrectResult() {
        final Integer expected = 157;
        assertEquals(expected, _subject.partA("day03Sample.txt"));
    }

    @Test
    void partB_expectCorrectResult() {
        final Integer expected = 70;
        assertEquals(expected, _subject.partB("day03Sample.txt"));
    }
}