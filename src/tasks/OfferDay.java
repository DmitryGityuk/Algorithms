package tasks;

/**
 * Написать алгоритм, который превратит массив целых чисел, расположенных в порядке возрастания, в строку, содержащую через запятую:
 * отдельные значения или диапазон значений, в виде начального и конечного чисел, записанных через дефис (-).
 * Диапазон состоит из всех чисел, включая начальное и конечное. Диапазоном считается 3 и более чисел.
 */

public class OfferDay {
    private final static Integer INPUTS[][] = {{-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20},
            {-6, -3, -2, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20},
            {-4, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20},
            {-6, -5, -4, -3, -2, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20, 100, 101, 102, 103, 105},
            {1, 3, 4, 6, 7, 9, 20, 21}
    };

    private final static String[] RESULTS = {"-6,-3-1,3-5,7-11,14,15,17-20",
            "-6,-3,-2,0,1,3-5,7-11,14,15,17-20",
            "-4-1,3-5,7-11,14,15,17-20",
            "-6--2,0,1,3-5,7-11,14,15,17-20,100-103,105",
            "1,3,4,6,7,9,20,21"
    };

    public static void main(String[] args) {

        for(int i = 0; i < INPUTS.length; i++){
            var result = convertToIntervals(INPUTS[i]);
            var expectedResult = RESULTS[i];
            boolean correct = result.equalsIgnoreCase(expectedResult);
            System.out.println("The result is " + (correct ? "correct. " : "incorrect. ") + "Result:" + result + " ExpectedResult:" + expectedResult);
        }
    }

    private static String convertToIntervals(Integer[] input) {
        StringBuilder result = new StringBuilder();
        int rangeStart = 0;
        int i;
        char dash = '-';
        char comma = ',';
        for (i = 1; i < input.length; i++) {
            if (input[i] - input[i - 1] != 1) {
                if (rangeStart == i - 1) {
                    result.append(input[rangeStart]).append(comma);
                } else {
                    result.append(input[rangeStart]).append(i - 2 == rangeStart ? comma : dash).append(input[i - 1]).append(comma);
                }
                rangeStart = i;
            }
        }

        if (rangeStart == input.length - 1) {
            result.append(input[rangeStart]);
        } else {
            result.append(input[rangeStart]).append(i - 2 == rangeStart ? comma : dash).append(input[i - 1]);
        }

        return result.toString();
    }
}
