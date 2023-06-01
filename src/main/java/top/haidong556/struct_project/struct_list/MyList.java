package top.haidong556.struct_project.struct_list;

import java.util.*;

public class MyList<E> implements List<E> {
    private int bounds=10;
    private int size;

    private E[] array;

    public MyList(){

        array= (E[]) new Object[bounds];
        size=0;

    }
    //返回true说明，需要扩容.
    private boolean checkBounds(){
        return size>bounds-2;
    }
    private boolean checkBounds(int index){
        return size>index-2;
    }
    //自动扩容
    private boolean ensureCapacity(){
        bounds= (int) ((int)bounds*1.5);
        array=(E[]) new Object[bounds];
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object o) {
        for(int i=0;i<size;i++){
            if(array[i].equals(o))
                return true;
        }
        return false;
    }


    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    private class MyIterator<E> implements Iterator<E>{
        private int currentIndex=0;

        @Override
        public boolean hasNext() {
            return currentIndex<size;
        }

        @Override
        public E next() {

            return (E) array[currentIndex];
        }
    }
    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }


    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        if(checkBounds()==true){
            ensureCapacity();
        }
        array[size]=e;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for(int i=0;i<size;i++){
            if(array[i].equals(o)){
                for(int j=i;j<size;j++){
                    array[j]=array[j+1];
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }


    @Override
    public E get(int index) {
        return array[index];
    }

    @Override
    public E set(int index, E element) {
        array[index]=element;
        return array[index];
    }

    @Override
    public void add(int index, E element) {
        while(checkBounds(index)==true){
            ensureCapacity();
        }
        if (index <= size) {
            for (int i = size; i > index; i--) {
                array[i] = array[i - 1];
            }
        }
        array[index]=element;

    }

    @Override
    public E remove(int index) {
        E r=array[index];
        for(int i=index;i<size;i++){
            array[i]=array[i+1];
        }
        return r;
    }

    @Override
    public int indexOf(Object o) {
        for(int i=0;i<size;i++){
            if(array[i].equals(o))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }


    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    public String toString(){
        return Arrays.toString(array);
    }

    public static void main(String[] args) {
        MyList<Integer> l=new MyList<>();
        l.add(3);
        l.add(43);
        l.add(4);
        System.out.println(l.toString());
        l.remove(2);
        System.out.println(l.toString());
        l.remove((Integer) 3);
        System.out.println(l.toString());
    }
}
