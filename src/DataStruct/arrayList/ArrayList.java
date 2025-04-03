package DataStruct.arrayList;

import org.junit.Test;

import java.util.Arrays;

public class ArrayList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    /**
     * ArrayList 元素数组缓存区
     */
    transient Object[] elementData;

    /**
     * List 集合元素数量
     */
    private int size;

    @Override
    public boolean add(E e) {
        int minCap = size + 1;
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            minCap = Math.max(DEFAULT_CAPACITY, minCap);
        }
        if (minCap > elementData.length) {
            int oldCap = elementData.length;
            int newCap = oldCap + oldCap >> 1;
            if (newCap < minCap) {
                newCap = minCap;
            }
            // 创建了一个新的数组，把原来数组拷贝进去
            elementData = Arrays.copyOf(elementData, newCap);
        }
        elementData[size++] = e;
        return true;
    }

    @Override
    public E remove(int index) {
        E oldValue = (E) elementData[index];
        System.arraycopy(elementData, index+1, elementData, index, size-index-1);
        size -= 1;
        return oldValue;
    }

    @Override
    public E get(int index) {
        return (E)elementData[index];
    }

    @Test
    public void test_array_list() {
        List<String> list = new ArrayList<>();
        list.add("01");
        list.add("02");
        list.add("03");
        list.add("04");
        list.add("05");
        list.add("06");
        list.add("07");
        list.add("08");
        list.add("09");
        list.add("10");
        list.add("11");
        list.add("12");

        System.out.println(list);

        list.remove(9);

        System.out.println(list);
    }

}
