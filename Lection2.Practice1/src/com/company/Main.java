package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        StudyArray ar = new StudyArray();


        // Найти максимальный
        ar.FindMax(ar.array);
        ar.RandomizeArray(ar.array);

        // Сортировка методом выбора
        ar.SortBySelect(ar.array);

        // Сортировка пузырьком
        ar.SortByBubble(ar.array);

        // найти позицию элемента в массиве бинарным поиском
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Введите искомое число. exit для завершения.");

            if(sc.hasNext("exit")) {
                break;
            }

            int searchElement = sc.nextInt();
            int element = ar.BinarySearch(ar.array, searchElement );
            System.out.println(element >= 0 ? "Элемент: " + Integer.toString(element): "Элемент " + searchElement + " не найден" );

        }while(true);





    }

}

/**
 * Практческое занятие по массивам
 */
 class StudyArray{
     private final int ARRAYSIZE = 10;
     private final int RANDOMRANGE = 100;
     int[] array = new int[ARRAYSIZE];

     /**
      *Заполняем массив случайными значениями
      * */
     public void RandomizeArray(int[] a){
         Random rnd = new Random();
         for (int i = 0; i < a.length; i++) {
             a[i] = rnd.nextInt(RANDOMRANGE);
         }
     }

     /**
      * Поиск максимального значения перебором
      * */
     public int FindMax(int[] a){
         int maxEl = 0;
         for(int i:a){
             if (i>maxEl){
                 maxEl=i;
             }
         }
         System.out.println("Maxel: " + maxEl);
         return maxEl;
     }

    /**
     * Сортировка методом выбора
     * @param a сортируемый массив
     */
    public void SortBySelect(int[] a){
        int element, elementNumber=0;
        for(int i= 0; i<a.length-1;i++){
            for(int j = i+1; j<a.length;j++){
                if(a[elementNumber]<a[j]){
                    elementNumber=j;
                }
            }
            element = a[i];
            a[i] = a[elementNumber];
            a[elementNumber] = element;
            elementNumber=i+1;
        }
        PrintArray("Массив отсортирован методом выбора: ", a);
    }

    /**
     * Сортировка пузырьком
     * @param a сортируемый массив
     */
    public void SortByBubble(int[] a){
        int element=0;
        for(int i= 0; i<a.length-1;i++) {
            for (int j = 1; j < a.length; j++) {
                if (a[j - 1] > a[j]) {
                    element = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = element;
                }
            }
        }
        PrintArray("Пузырек по возрастанию:", a);
    }

    /**
     * Бинарный поиск
     * @param array сортируемый массив
     * @param element искомый элемент
     * @return номер искомого элемента
     */
    public int BinarySearch(int[] array, int element){

            if(array.length == 0) return -1;

            SortByBubble(array);

            int     elNumber,
                    first = 0,
                    mid =  array.length,
                    last = array.length - 1;

            do {
                if(mid != 1){
                    mid = ((last - first) + 1) >>> 1;
                }else {
                    if(element == array[first]) {
                        return first;
                    }
                    else if (element == array[last]) {
                        return last;
                    } else
                        return -1;
                }
                elNumber = first + mid - 1;
                if(element == array[elNumber]) {
                    return elNumber;
                } else if(element < array[elNumber]) {
                    last = elNumber;
                } else if (element == array[elNumber+1])
                {
                    return elNumber + 1;
                } else
                    first = elNumber + 1;
            }while(true);
    }

    /**
      * Распечатать массив
      * @param text текст для описания выводимого массива
      * @param a массив который распечатаем
      */
     public void PrintArray(String text, int[] a){
         System.out.println(text +" "+ Arrays.toString(a));
     }

     StudyArray(){
         RandomizeArray(array);
         PrintArray("Init aray: ", array);
     }


 }

