package org.example.objects.objectutils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GenericsDemo<T> {
  private T data;

  public static <T> void printData(T data) {
    System.out.println(data);
  }
}

class MainClass {
  public static void main(String[] args) {
    GenericsDemo stringData = new GenericsDemo("Hello world");
    GenericsDemo intData = new GenericsDemo(123);
    GenericsDemo doubleData = new GenericsDemo(4.56);
    GenericsDemo booleanData = new GenericsDemo(true);
    GenericsDemo floatData = new GenericsDemo(3.14f);
    GenericsDemo charData = new GenericsDemo('A');
    GenericsDemo objectData = new GenericsDemo(new Object());
    GenericsDemo nullData = new GenericsDemo(null);
    GenericsDemo arrayData = new GenericsDemo(new int[] {1, 2, 3});
    GenericsDemo listData = new GenericsDemo(java.util.Arrays.asList(1, 2, 3));
    GenericsDemo mapData = new GenericsDemo(java.util.Map.of("key", "value"));
    GenericsDemo setData = new GenericsDemo(java.util.Set.of(1, 2, 3));
    GenericsDemo streamData = new GenericsDemo(java.util.stream.Stream.of(1, 2, 3));
    GenericsDemo dateDate = new GenericsDemo(java.util.Date.from(java.time.Instant.now()));

    // Print data for all examples
    GenericsDemo.printData(stringData.getData());
    GenericsDemo.printData(intData.getData());
    GenericsDemo.printData(doubleData.getData());
    GenericsDemo.printData(booleanData.getData());
    GenericsDemo.printData(floatData.getData());
    GenericsDemo.printData(charData.getData());
    GenericsDemo.printData(objectData.getData());
    GenericsDemo.printData(nullData.getData());
    GenericsDemo.printData(arrayData.getData());
    GenericsDemo.printData(listData.getData());
    GenericsDemo.printData(mapData.getData());
    GenericsDemo.printData(setData.getData());
    GenericsDemo.printData(streamData.getData());
    GenericsDemo.printData(dateDate.getData());
  }
}
