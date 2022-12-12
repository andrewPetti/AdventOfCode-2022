package com.chemies.aoc2022.day;

import com.chemies.aoc2022.util.FileHelper;
import com.chemies.aoc2022.util.TextFormatter;
import com.diogonunes.jcolor.Attribute;
import com.google.common.collect.ImmutableList;
import org.javatuples.Pair;

public class Day04 implements Day {
    private final FileHelper _fileHelper = new FileHelper();
    private final TextFormatter _textFormatter = new TextFormatter();

    @Override
    public void executePartA() {
        final int result = partA("day04Input.txt");
        System.out.println("Part A answer: " + _textFormatter.format(result, Attribute.GREEN_TEXT()));
    }

    int partA(final String filename) {
        final ImmutableList<String> elfPairs = _fileHelper.fileToStringList(filename);

        final int[] sum = {0};
        elfPairs.forEach(pair -> {
            if (pairOverlaps(pair)) {
                sum[0]++;
            }
        });
        return sum[0];
    }

    private boolean pairOverlaps(final String pair) {
        final String[] ranges = pair.split(",");
        final Pair<Integer, Integer> range1 = rangeValues(ranges[0]);
        final Pair<Integer, Integer> range2 = rangeValues(ranges[1]);

        if (doesRangeOverlapFully(range1, range2)) {
            return true;
        } else return doesRangeOverlapFully(range2, range1);
    }

    private static boolean doesRangeOverlapFully(final Pair<Integer, Integer> first, final Pair<Integer, Integer> second) {
        return first.getValue0() <= second.getValue0() && first.getValue1() >= second.getValue1();
    }

    private Pair<Integer, Integer> rangeValues(final String range) {
        final String[] values = range.split("-");
        return Pair.with(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
    }

    @Override
    public void executePartB() {
        final int result = partB("day04Input.txt");
        System.out.println("Part B answer: " + _textFormatter.format(result, Attribute.GREEN_TEXT()));
    }

    int partB(final String filename) {

        return 0;
    }

    @Override
    public String getName() {
        return "Day 4";
    }

    @Override
    public boolean canExecute() {
        return true;
    }
}
