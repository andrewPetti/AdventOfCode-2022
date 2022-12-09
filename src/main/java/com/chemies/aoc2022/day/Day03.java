package com.chemies.aoc2022.day;

import com.chemies.aoc2022.util.FileHelper;
import com.chemies.aoc2022.util.TextFormatter;
import com.diogonunes.jcolor.Attribute;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Day03 implements Day {
    private final FileHelper _fileHelper = new FileHelper();
    private final TextFormatter _textFormatter = new TextFormatter();

    @Override
    public void executePartA() {
        final int result = partA("day03Input.txt");
        System.out.println("Part A answer: " + _textFormatter.format(result, Attribute.GREEN_TEXT()));
    }


    @Override
    public void executePartB() {
        final int result = partB("day03Input.txt");
        System.out.println("Part B answer: " + _textFormatter.format(result, Attribute.GREEN_TEXT()));
    }

    @Override
    public String getName() {
        return "Day 3";
    }

    @Override
    public boolean canExecute() {
        return true;
    }

    int partA(final String filename) {
        final ImmutableList<String> ruckSacks = _fileHelper.fileToStringList(filename);

        final ArrayList<Character> commonItems = new ArrayList<>();

        ruckSacks.forEach(sack -> {
            final String[] compartments = splitRuckSack(sack);
            commonItems.add(findCommonItem(compartments));
        });

        final Map<Character, Integer> priotities = buildItemPriotities();
        return commonItems.stream()
                .mapToInt(priotities::get)
                .sum();
    }

    private char findCommonItem(final String[] compartments) throws IllegalArgumentException {
        for (int i = 0; i < compartments[0].length(); i++) {
            final char c = compartments[0].charAt(i);
            if (compartments[1].indexOf(c) > -1) {
                return c;
            }
        }

        throw new IllegalArgumentException();
    }

    String[] splitRuckSack(final String ruckSack) {
        final int mid = ruckSack.length() / 2;
        return new String[]{ruckSack.substring(0, mid), ruckSack.substring(mid)};
    }

    int partB(final String filename) {
        final ImmutableList<String> ruckSacks = _fileHelper.fileToStringList(filename);
        final ArrayList<Character> badges = new ArrayList<>();

        for (int i = 0; i < ruckSacks.size(); i += 3) {
            badges.add(findCommonItemPartB(ruckSacks.get(i), ruckSacks.get(i + 1), ruckSacks.get(i + 2)));

        }

        final Map<Character, Integer> priotities = buildItemPriotities();
        return badges.stream()
                .mapToInt(priotities::get)
                .sum();

    }

    private char findCommonItemPartB(final String first, final String second, final String third) throws IllegalArgumentException {
        for (int i = 0; i < first.length(); i++) {
            final char c = first.charAt(i);
            if (second.indexOf(c) > -1 && third.indexOf(c) > -1) {
                return c;
            }
        }

        throw new IllegalArgumentException();
    }

    Map<Character, Integer> buildItemPriotities() {
        final Map<Character, Integer> priotities = new HashMap<>();
        char item = 'a';
        for (int i = 1; i < 27; i++, item++) {
            priotities.put(item, i);
        }
        item = 'A';
        for (int j = 27; j < 53; j++, item++) {
            priotities.put(item, j);
        }
        return priotities;
    }
}
