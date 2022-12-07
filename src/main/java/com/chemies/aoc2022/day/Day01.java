package com.chemies.aoc2022.day;

import com.chemies.aoc2022.util.FileHelper;
import com.chemies.aoc2022.util.TextFormatter;
import com.diogonunes.jcolor.Attribute;
import com.google.common.collect.ImmutableList;

import java.util.Collections;
import java.util.OptionalInt;

public class Day01 implements Day {

    private final FileHelper _fileHelper = new FileHelper();
    private final TextFormatter _textFormatter = new TextFormatter();

    @Override
    public void executePartA() {
        final int result = partA("day01Input.txt");
        System.out.println("Part A answer: " + _textFormatter.format(result, Attribute.GREEN_TEXT()));
    }

    @Override
    public void executePartB() {
        final int result = partB("day01Input.txt");
        System.out.println("Part B answer: " + _textFormatter.format(result, Attribute.GREEN_TEXT()));
    }


    @Override
    public String getName() {
        return "Day 1";
    }

    @Override
    public boolean canExecute() {
        return true;
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public int partA(final String filename) {
        ImmutableList<ImmutableList<Integer>> groupedList = _fileHelper.fileToGroupedIntegerList(filename);

        OptionalInt max = groupedList.stream()
                .mapToInt(person -> person.stream()
                        .mapToInt(Integer::intValue).sum())
                .max();

        return max.getAsInt();
    }

    public int partB(final String filename) {

        ImmutableList<ImmutableList<Integer>> groupedList = _fileHelper.fileToGroupedIntegerList(filename);
        return groupedList.stream()
                .mapToInt(person -> person.stream()
                        .mapToInt(Integer::intValue).sum())
                .boxed()
                .sorted(Collections.reverseOrder())
                .limit(3)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
