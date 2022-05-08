package sort;

import perfomance.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

interface StepGenerator {
    int nextStep();
}

class ShellStep implements StepGenerator {
    private int step;

    public ShellStep(int[] array) {
        this.step = array.length / 2;
    }

    @Override
    public int nextStep() {
        step = step / 2;
        return step;
    }
}

class HibbardStep implements StepGenerator {
    private int i;

    public HibbardStep(int[] array) {
        for (; (int) (Math.pow(2, i) - 1) < array.length; ) {
            i += 1;
        }
    }

    @Override
    public int nextStep() {
        i = i - 1;
        return (int) (Math.pow(2, i) - 1);
    }
}

class SedgewickStep implements StepGenerator {
    private int i;

    public SedgewickStep(int[] array) {
        long num = (long) (9 * (Math.pow(2, i) - Math.pow(2, i / 2)) + 1);
        for (; num < array.length; ) {
            i += 1;
            if (i % 2 == 0) {
                num = (long) (9 * (Math.pow(2, i) - Math.pow(2, i / 2)) + 1);
            } else {
                num = (long) (8 * Math.pow(2, i) - 6 * Math.pow(2, (i + 1) / 2) + 1);
            }
        }
    }

    @Override
    public int nextStep() {
        i = i - 1;
        if (i <= -1) {
            return 0;
        }
        if (i % 2 == 0) {
            return (int) (9 * (Math.pow(2, i) - Math.pow(2, i / 2)) + 1);
        } else {
            return (int) (8 * Math.pow(2, i) - 6 * Math.pow(2, (i + 1) / 2) + 1);
        }
    }
}

class KnuthStep implements StepGenerator {
    private int i;

    public KnuthStep(int[] array) {
        for (; (Math.pow(3, i) - 1) / 2 < array.length / 3; ) {
            i = i + 1;
        }
    }

    @Override
    public int nextStep() {
        int step = (int) ((Math.pow(3, i) - 1) / 2);
        i = i - 1;
        return step;
    }
}


public class ModifiedShellSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 0, -2, 7, 3};
        System.out.println(Arrays.toString(array));
        shellSort(array, new KnuthStep(array));
        System.out.println(Arrays.toString(array) + " - sort.KnuthStep");
        shellSort(array, new ShellStep(array));
        System.out.println(Arrays.toString(array) + " - sort.ShellStep");
        shellSort(array, new SedgewickStep(array));
        System.out.println(Arrays.toString(array) + " - sort.SedgewickStep");
        shellSort(array, new HibbardStep(array));
        System.out.println(Arrays.toString(array) + " - sort.HibbardStep");
        ArrayList<Integer> generated = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            generated.add(i);
        }
        Collections.shuffle(generated);
        int[] arr1 = generated.stream().mapToInt(i -> i).toArray();
        int[] arr2 = new int[arr1.length];
        System.arraycopy(arr1, 0, arr2, 0, arr1.length);
        int[] arr3 = new int[arr1.length];
        System.arraycopy(arr1, 0, arr3, 0, arr1.length);
        int[] arr4 = new int[arr1.length];
        System.arraycopy(arr1, 0, arr4, 0, arr1.length);
        Utils.measureTime(() -> shellSort(arr1, new KnuthStep(array)), "Knuth");
        Utils.measureTime(() -> shellSort(arr2, new ShellStep(array)), "Shell");
        Utils.measureTime(() -> shellSort(arr3, new SedgewickStep(array)), "sort.SedgewickStep");
        Utils.measureTime(() -> shellSort(arr4, new HibbardStep(array)), "sort.HibbardStep");
        Utils.assertTrue(Arrays.equals(arr2, arr3));
        Utils.assertTrue(Arrays.equals(arr3, arr4));
    }

    public static void shellSort(int[] array, StepGenerator stepGen) {
        int step = stepGen.nextStep();
        for (; step > 0; ) {
            for (int i = step; i < array.length; i++) {
                for (int j = i; j >= step && array[j] < array[j - step]; j -= step) {
                    int tmp = array[j];
                    array[j] = array[j - step];
                    array[j - step] = tmp;
                }
            }
            step = stepGen.nextStep();
        }
    }

}
