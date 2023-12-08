package org.example;

import java.util.Arrays;
import java.util.Objects;

public class IntegerListWithRecursion{
    private Integer[] data;
    private int size;
    private int currentLength;

    public IntegerListWithRecursion(int startLength) {
        data = new Integer[startLength];
        size = 0;
        this.currentLength = startLength;
    }
  /*  public static void main(String[] args) {
        IntegerListWithRecursion integerListWithRecursion = new IntegerListWithRecursion(3);
        Integer arr[] = new Integer[10];
        for (int i = 0; i < 10; i++) {
            integerListWithRecursion.add(((int)(Math.random() * 31) - 15));
        }
        System.out.println(Arrays.toString(integerListWithRecursion.toArray()));
        System.out.println(integerListWithRecursion.contains(0));
        System.out.println(Arrays.toString(integerListWithRecursion.sortedTest(arr, 0)));
    }*/
    private void swapElements(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private Integer[] sortedSelection(Integer[] arr, int i) {
        int minElementIndex = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[minElementIndex]) {
                minElementIndex = j;
            }
        }
        swapElements(arr, i, minElementIndex);
        if (i < arr.length - 1) sortedSelection(arr, i+1);
        return arr;
    }

    private void grown() {
        currentLength = currentLength + currentLength /2;
        data = Arrays.copyOf(data, currentLength);
    }
    // Добавление элемента.// Вернуть добавленный элемент// в качестве результата выполнения.
    public Integer add(Integer item) {
        if (size == currentLength) grown();
        data[size] = item;
        size++;
        return data[size - 1];
    }
    // Добавление элемента
    // на определенную позицию списка.
    // Если выходит за пределы фактического
    // количества элементов или массива,
    // выбросить исключение.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    public Integer add(int index, Integer item) {
        if ((index >= 0) && (index <= size - 1)) {
            if (size == currentLength) grown();
            for (int i = size; i >= index; i--) {
                data[i + 1] = data[i];
            }
            size++;
            data[index] = item;
            return data[index];
        } else {
            throw new ExceedingSizeException("Индекс выходит за переделы диапазона");
        }
    }
    // Сравнить текущий список с другим.
    // Вернуть true/false или исключение,
    // если передан null.
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            throw new ListNullException("Переданный список пустой");
        }
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        IntegerListWithRecursion that = (IntegerListWithRecursion) o;
        return size == that.size && Arrays.equals(data, that.data);
    }

    // Установить элемент
    // на определенную позицию,
    // затерев существующий.
    // Выбросить исключение,
    // если индекс больше
    // фактического количества элементов
    // или выходит за пределы массива.
    public Integer set(int index, Integer item){
        if ((index < 0) || (index > size - 1)) {
            throw new ExceedingSizeException("Индекс выходит за переделы диапазона");
        }
        data[index] = item;
        return data[index];
    }

    // Удаление элемента.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    public Integer remove(Integer item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(data[i])) {
                Integer s = data[i];
                for (int j = i; j < size; j++) {
                    data[j] = data[j+1];
                }
                size--;
                return s;
            }
        }
        throw new ElementNotFoundException("Элемент не найден");
    }

    // Удаление элемента по индексу.
    // Вернуть удаленный элемент
    // или исключение, если подобный
//     элемент отсутствует в списке.
    public Integer remove(int index) {
        if ((index < 0) || (index > size - 1)) {
            throw new ExceedingSizeException("Индекс выходит за переделы диапазона");
        }
        Integer s = data[index];
        for (int j = index; j < size; j++) {
            data[j] = data[j+1];
        }
        size--;
        return s;
    }

    // Проверка на существование элемента.
    // Вернуть true/false;
    /*public boolean contains(Integer item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(data[i])) {
                return true;
            }
        }
        return false;
    }*/

    // Поиск элемента.// Вернуть индекс элемента// или -1 в случае отсутствия.
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    // Поиск элемента с конца // Вернуть индекс элемента // или -1 в случае отсутствия.
    public int lastIndexOf(Integer item) {
        for (int i = size-1; i >= 0; i--) {
            if (item.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    // Получить элемент по индексу.
    // Вернуть элемент или исключение,
    // если выходит за рамки фактического
    // количества элементов.
    public Integer get(int index) {
        if ((index < 0) || (index > size - 1)) {
            throw new ExceedingSizeException("Индекс выходит за переделы диапазона");
        }
        return data[index];
    }

    // Вернуть фактическое количество элементов.
    public int size() {
        return size;
    }

    // Вернуть true,
    // если элементов в списке нет,
    // иначе false.
    public boolean isEmpty() {
        return size == 0;
    }

    // Удалить все элементы из списка.
    public void clear() {
        size = 0;
    }

    // Создать новый массив
    // из строк в списке
    // и вернуть его.
    public Integer[] toArray() {
        Integer[] result = new Integer[size];
        System.arraycopy(data, 0, result, 0, size);
        return result;
    }
    public boolean contains(Integer element) {
        Integer[] dataSort = Arrays.copyOf(data, size);
        sortedSelection(dataSort, 0);
        int min = 0;
        int max = dataSort.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (Objects.equals(element, dataSort[mid])) {
                return true;
            }

            if (element < dataSort[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}
