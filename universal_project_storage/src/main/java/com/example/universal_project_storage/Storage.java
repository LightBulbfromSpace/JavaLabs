package com.example.universal_project_storage;

import java.util.Arrays;
import java.util.Objects;

public class Storage<T> {
    private final T[] buffer;
    private int size;

    public Storage(T[] buffer) {
        if (buffer == null || buffer.length == 0) {
            throw new IllegalArgumentException("Массив хранилища не должен быть null или пустым.");
        }

        this.buffer = buffer;
        this.size = 0;
    }

    public void add(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Нельзя добавить null.");
        }
        if (size == buffer.length) {
            throw new IllegalStateException("В хранилище нет свободного места.");
        }

        buffer[size] = value;
        size++;
    }

    public T get(int index) {
        checkIndex(index);
        return buffer[index];
    }

    public void set(int index, T value) {
        checkIndex(index);
        if (value == null) {
            throw new IllegalArgumentException("Нельзя сохранить null.");
        }

        buffer[index] = value;
    }

    public T remove(int index) {
        checkIndex(index);

        T removedValue = buffer[index];
        for (int i = index; i < size - 1; i++) {
            buffer[i] = buffer[i + 1];
        }
        size--;
        buffer[size] = null;
        return removedValue;
    }

    public boolean contains(T value) {
        return indexOf(value) >= 0;
    }

    public int indexOf(T value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(buffer[i], value)) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        Arrays.fill(buffer, 0, size, null);
        size = 0;
    }

    public T[] toArray(T[] target) {
        if (target == null) {
            throw new IllegalArgumentException("Массив-приёмник не должен быть null.");
        }

        T[] result = target.length >= size ? target : Arrays.copyOf(target, size);
        System.arraycopy(buffer, 0, result, 0, size);
        return result;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return buffer.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            String rangeDescription = (size == 0)
                    ? "пустой диапазон"
                    : "[0, " + (size - 1) + "]";
            throw new IndexOutOfBoundsException(
                    "Индекс " + index + " вне допустимого диапазона " + rangeDescription + ".");
        }
    }
}
