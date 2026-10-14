class Solution {
    public boolean isHappy(int number) {
        var values = new HashSet<Integer>();
        var accumulator = number;

        while (true) {
            var value = sumOfSquareOfDigitsOf(accumulator);

            var terminating = value == 1;
            if (terminating) {
                break;
            }

            var cyclical = !values.add(value);
            if (cyclical) {
                return false;
            }

            accumulator = value;
        }

        return true;
    }

    private int sumOfSquareOfDigitsOf(int number) {
        return digitsOf(number)
            .stream()
            .map(digit -> digit * digit)
            .collect(Collectors.summingInt(Integer::intValue));
    }

    private List<Integer> digitsOf(int number) {
        var digits = new ArrayList<Integer>(10);
        var accumulator = number;

        do {
            var digit = accumulator % 10;
            digits.add(digit);

            accumulator /= 10;
        } while (accumulator != 0);

        return digits;
    }
}
