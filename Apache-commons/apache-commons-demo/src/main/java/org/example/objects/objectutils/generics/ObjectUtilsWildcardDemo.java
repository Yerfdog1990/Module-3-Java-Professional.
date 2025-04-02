package org.example.objects.objectutils.generics;

import java.util.Comparator;
import org.apache.commons.lang3.ObjectUtils;

public class ObjectUtilsWildcardDemo {

    // Generic method to find the max value with wildcard support
    public static <T extends Comparable<? super T>> T findMax(T... values) {
        return ObjectUtils.max(values);
    }

    // Generic method to find the min value with wildcard support
    public static <T extends Comparable<? super T>> T findMin(T... values) {
        return ObjectUtils.min(values);
    }

    // Generic method to find the median with wildcard support
    public static <T extends Comparable<? super T>> T findMedian(T... values) {
        return ObjectUtils.median(values);
    }

    // Generic method to find the median using a comparator
    public static <T> T findMedianWithComparator(Comparator<? super T> comparator, T... values) {
        return (T) ObjectUtils.median(comparator, values);
    }

    // Generic method to find the mode (most frequently occurring item)
    public static <T> T findMode(T... values) {
        return ObjectUtils.mode(values);
    }

    // Method to check if two objects are not equal
    public static boolean areNotEqual(Object object1, Object object2) {
        return ObjectUtils.notEqual(object1, object2);
    }

    // Method to ensure a non-empty value
    public static <T> T requireNonEmptyValue(T obj, String message) {
        return ObjectUtils.requireNonEmpty(obj, message);
    }

    public static void main(String[] args) {
        Integer[] numbers = {5, 8, 3, 12, 7, 3, 5, 8};
        String[] words = {"apple", "orange", "banana", "banana", "apple"};

        // Using max with wildcard support
        Integer maxNumber = findMax(numbers);
        System.out.println("Max value: " + maxNumber); // 12

        // Using min with wildcard support
        Integer minNumber = findMin(numbers);
        System.out.println("Min value: " + minNumber); // 3

        // Using median with wildcard support
        Integer medianNumber = findMedian(numbers);
        System.out.println("Median value: " + medianNumber); // Some middle value

        // Using median with Comparator
        String medianWord = findMedianWithComparator(Comparator.naturalOrder(), words);
        System.out.println("Median word: " + medianWord); // Middle lexicographical word

        // Using mode
        String modeWord = findMode(words);
        System.out.println("Mode word: " + modeWord); // "apple" or "banana"

        // Checking inequality
        boolean isDifferent = areNotEqual("hello", "world");
        System.out.println("Are 'hello' and 'world' different? " + isDifferent); // true

        // Ensuring non-empty value
        try {
            String nonEmpty = requireNonEmptyValue("", "Value must not be empty!");
            System.out.println("Non-empty value: " + nonEmpty);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage()); // Error message
        }
    }
}

