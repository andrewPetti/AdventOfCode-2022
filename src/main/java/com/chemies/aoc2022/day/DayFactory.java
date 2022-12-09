package com.chemies.aoc2022.day;


public class DayFactory {

    public static Day getDay(final int day) {
        if (day == 1) {
            return new Day01();
        } else if (day == 2) {
            return new Day02();
        } else if (day == 3) {
            return new Day03();
        }/* else if (day == 4) {
            return new Day04();
        } else if (day == 5) {
            return new Day05();
        } else if (day == 6) {
            return new Day06();
        } else if (day == 7) {
            return new Day07();
        } else if (day == 8) {
            return new Day08();
        } else if (day == 9) {
            return new Day09();
        }*/

        return new UnimplementedDay(day);
    }
}
