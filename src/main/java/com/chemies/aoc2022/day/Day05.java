package com.chemies.aoc2022.day;

import com.chemies.aoc2022.util.FileHelper;
import com.chemies.aoc2022.util.TextFormatter;
import com.diogonunes.jcolor.Attribute;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Day05 implements Day {
    private final FileHelper _fileHelper = new FileHelper();
    private final TextFormatter _textFormatter = new TextFormatter();
    private final String BLANK_SPACE = " ";

    @Override
    public void executePartA() {
        final String result = partA("day05Input.txt");
        System.out.println("Part B answer: " + _textFormatter.format(result, Attribute.GREEN_TEXT()));
    }

    String partA(final String filename) {

        final ImmutableList<ImmutableList<String>> inputs = _fileHelper.fileToGroupedStringListNoTrim(filename);
        final ArrayList<ArrayList<String>> stacks = new ArrayList<>();
        buildStacks(stacks, inputs.get(0));
        moveCargo9000(stacks, inputs.get(1));

        return getTopCargo(stacks);
        // return "";
    }

    private String getTopCargo(final ArrayList<ArrayList<String>> stacks) {
        return stacks.stream()
                .map(x -> x.get(x.size() - 1))
                .collect(Collectors.joining(""));
    }

    private void buildStacks(final ArrayList<ArrayList<String>> stacks, final ImmutableList<String> stackSetup) {
        final String columns = stackSetup.get(stackSetup.size() - 1);

        for (int i = 1; i < columns.length(); i += 4) {
            stacks.add(new ArrayList<>());
        }
        System.out.println("Stack count " + stacks.size());

        for (int j = stackSetup.size() - 2; j >= 0; j--) {
//            String line = stackSetup.get(j);
            addCargoToStack(stacks, getCargo(stackSetup.get(j)));
        }


    }

    private void moveCargo9000(final ArrayList<ArrayList<String>> stacks, final ImmutableList<String> instructions) {
        instructions.forEach(line -> processLine9000(stacks, line));
    }

    private void processLine9000(final ArrayList<ArrayList<String>> stacks, final String line) {
        final String[] parts = line.split(" ");

        move9000(stacks, Integer.parseInt(parts[1]), Integer.parseInt(parts[3]) - 1, Integer.parseInt(parts[5]) - 1);
    }

    private void move9000(final ArrayList<ArrayList<String>> stacks, final int count, final int src, final int dest) {
        for (int i = 0; i < count; i++) {
            stacks.get(dest).add(stacks.get(src).remove(stacks.get(src).size() - 1));
        }
    }

    private void addCargoToStack(final ArrayList<ArrayList<String>> stacks, final ArrayList<String> cargo) {
        final int[] counter = {0};
        cargo.forEach(x ->
        {
            if (!x.equals(BLANK_SPACE)) {
                stacks.get(counter[0]).add(x);
            }
            counter[0]++;
        });
    }

    private ArrayList<String> getCargo(final String line) {
        final ArrayList<String> cargo = new ArrayList<>();
        for (int i = 1; i < line.length(); i += 4) {
            cargo.add(String.valueOf(line.charAt(i)));
        }

        return cargo;
    }

    @Override
    public void executePartB() {
        final String result = partB("day05Input.txt");
        System.out.println("Part B answer: " + _textFormatter.format(result, Attribute.GREEN_TEXT()));
    }

    String partB(final String filename) {

        final ImmutableList<ImmutableList<String>> inputs = _fileHelper.fileToGroupedStringListNoTrim(filename);
        final ArrayList<ArrayList<String>> stacks = new ArrayList<>();
        buildStacks(stacks, inputs.get(0));
        moveCargo9001(stacks, inputs.get(1));

        return getTopCargo(stacks);
    }

    private void moveCargo9001(final ArrayList<ArrayList<String>> stacks, final ImmutableList<String> instructions) {
        instructions.forEach(line -> processLine9001(stacks, line));
    }

    private void processLine9001(final ArrayList<ArrayList<String>> stacks, final String line) {
        final String[] parts = line.split(" ");

        move9001(stacks, Integer.parseInt(parts[1]), Integer.parseInt(parts[3]) - 1, Integer.parseInt(parts[5]) - 1);
    }

    private void move9001(final ArrayList<ArrayList<String>> stacks, final int count, final int src, final int dest) {
        final ArrayList<String> temp = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            temp.add(stacks.get(src).remove(stacks.get(src).size() - 1));
        }

        for (int j = temp.size() - 1; j >= 0; j--) {
            stacks.get(dest).add(temp.get(j));
        }
    }

    @Override
    public String getName() {
        return "Day 5";
    }

    @Override
    public boolean canExecute() {
        return true;
    }
}
