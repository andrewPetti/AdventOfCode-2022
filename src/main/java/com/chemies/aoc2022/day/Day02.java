package com.chemies.aoc2022.day;

import com.chemies.aoc2022.util.FileHelper;
import com.chemies.aoc2022.util.TextFormatter;
import com.diogonunes.jcolor.Attribute;
import com.google.common.collect.ImmutableList;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Day02 implements Day {
    private final FileHelper _fileHelper = new FileHelper();
    private final TextFormatter _textFormatter = new TextFormatter();

    private final Map<String, String> winningPairs = new HashMap<>() {{
        put("A", "Y");
        put("B", "Z");

        put("C", "X");
    }};

    private final Map<String, String> drawPairs = new HashMap<>() {{
        put("A", "X");
        put("B", "Y");
        put("C", "Z");

    }};

    @Override
    public void executePartA() {
        final int result = partA("day02Input.txt");
        System.out.println("Part A answer: " + _textFormatter.format(result, Attribute.GREEN_TEXT()));
    }

    @Override
    public void executePartB() {
        final int result = partB("day02Input.txt");
        System.out.println("Part B answer: " + _textFormatter.format(result, Attribute.GREEN_TEXT()));
    }


    @Override
    public String getName() {
        return "Day 2";
    }

    @Override
    public boolean canExecute() {
        return true;
    }

    public int partA(final String filename) {
        final ImmutableList<String> rawStrings = _fileHelper.fileToStringList(filename);

        return rawStrings.stream()
                .mapToInt(line -> {
                            final String[] s = line.split(" ");
                            return getPoints(s);
                        }
                )
                .sum();

        //return 0;
    }

    private int getPoints(final String[] s) {
        int points = 0;
        if (s[1].equals(winningPairs.get(s[0]))) {
            points += 6;
        } else if (s[1].equals(drawPairs.get(s[0]))) {
            points += 3;
        }

        points += getBasePoints(s[1]);
        return points;
    }

    private int getBasePoints(final String s) {
        final HashMap<String, Integer> basePoints = new HashMap<>() {
            {
                put("X", 1);
                put("Y", 2);
                put("Z", 3);
            }
        };

        return basePoints.get(s);
    }

    public int partB(final String filename) {

        final ImmutableList<ImmutableList<Integer>> groupedList = _fileHelper.fileToGroupedIntegerList(filename);
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
