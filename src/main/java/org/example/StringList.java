package org.example;

import java.util.Arrays;

public class StringList {
    private String [] data;
    private int size;
    private int currentLength;

    public StringList(int startLength) {
        data = new String[startLength];
        size = 0;
        this.currentLength = startLength;
    }
    // Добавление элемента.// Вернуть добавленный элемент// в качестве результата выполнения.
    public String add(String item) {
        if (size == currentLength){
            currentLength = currentLength + currentLength /2;
            data = Arrays.copyOf(data, currentLength);
        }
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
    public String add(int index, String item) {
        if ((index < 0) || (index > size - 1)) {
            throw new ExceedingSizeException("Индекс выходит за переделы диапазона");
        }
        if (size == currentLength) {
            currentLength = currentLength + currentLength / 2;
            data = Arrays.copyOf(data, currentLength);
        }
        for (int i = size; i >= index; i--) {
            data[i + 1] = data[i];
        }
        size++;
        data[index] = item;
        return data[index];
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
        StringList that = (StringList) o;
        return size == that.size && Arrays.equals(data, that.data);
    }

    // Установить элемент
    // на определенную позицию,
    // затерев существующий.
    // Выбросить исключение,
    // если индекс больше
    // фактического количества элементов
    // или выходит за пределы массива.
    public String set(int index, String item){
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
    public String remove(String item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(data[i])) {
                String s = data[i];
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
    public String remove(int index) {
        if ((index < 0) || (index > size - 1)) {
            throw new ExceedingSizeException("Индекс выходит за переделы диапазона");
        }
        String s = data[index];
        for (int j = index; j < size; j++) {
            data[j] = data[j+1];
        }
        size--;
        return s;
    }

    // Проверка на существование элемента.
    // Вернуть true/false;
    public boolean contains(String item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    // Поиск элемента.// Вернуть индекс элемента// или -1 в случае отсутствия.
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    // Поиск элемента с конца // Вернуть индекс элемента // или -1 в случае отсутствия.
    public int lastIndexOf(String item) {
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
    public String get(int index) {
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
    public String[] toArray() {
        String [] result = new String[size];
        System.arraycopy(data, 0, result, 0, size);
        return result;
    }

}
