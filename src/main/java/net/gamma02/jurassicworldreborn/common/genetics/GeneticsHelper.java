package net.gamma02.jurassicworldreborn.common.genetics;

import net.minecraft.util.RandomSource;

import java.util.Random;

public class GeneticsHelper {
    public static final int GENETICS_LENGTH = 30;

    public static String randomGenetics(Random/*RandomSource*/ random) {
        String genetics = "";

        for (int i = 0; i < GENETICS_LENGTH; i++) {
            int character = random.nextInt(4);

            switch (character) {
                case 0:
                    genetics += "A";
                    break;
                case 1:
                    genetics += "C";
                    break;
                case 2:
                    genetics += "G";
                    break;
                case 3:
                    genetics += "T";
                    break;
            }
        }

        return genetics;
    }
    public static String randomGenetics(RandomSource/*Random*/ random) {
        String genetics = "";

        for (int i = 0; i < GENETICS_LENGTH; i++) {
            int character = random.nextInt(4);

            switch (character) {
                case 0:
                    genetics += "A";
                    break;
                case 1:
                    genetics += "C";
                    break;
                case 2:
                    genetics += "G";
                    break;
                case 3:
                    genetics += "T";
                    break;
            }
        }

        return genetics;
    }
}