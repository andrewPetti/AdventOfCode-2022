package com.chemies.aoc2022.day;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day02Test {
    private Day02 _subject;

    @BeforeEach
    void setup() {
        _subject = new Day02();
    }

    @Test
    void executePartA_expectCorrectResult() {
        final Integer expected = 15;
        assertEquals(expected, _subject.partA("day02Sample.txt"));
    }

    @Test
    void partB_expectCorrectResult() {
        final Integer expected = 12;
        assertEquals(expected, _subject.partB("day02Sample.txt"));
    }
}