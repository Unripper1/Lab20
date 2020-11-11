import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;

public class Test {
    public static void quickSort(int[] array,String[] array2, int low, int high) {
        if (array.length == 0)
            return;//завершить выполнение, если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                String temp2=array2[i];
                array[i] = array[j];
                array2[i] = array2[j];
                array[j] = temp;
                array2[j] = temp2;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array,array2, low, j);

        if (high > i)
            quickSort(array,array2, i, high);
    }

    public static void main(String[] args) {



        File file = new File("test.txt");

        Scanner scf = null;
        int N = 10000;
        String[] words = new String[N];
        Arrays.fill(words,"");
        int[] index = new int[N];
        Arrays.fill(index,0);
        try {
            scf = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scf.hasNext()) {
            int k = 0;
            String word = scf.next();
            word=word.replace(",","");
            word=word.replace(".","");
            word=word.replace("!","");
            word=word.replace("?","");
            word=word.replace(" ","");
            word=word.replace(";","");
            word=word.replace(":","");
            word=word.replace("«","");
            word=word.replace("»","");
            word=word.replace("[","");
            word=word.replace("]","");
            word=word.replace("1","");
            word=word.replace("2","");
            word=word.replace("3","");
            word=word.replace("4","");
            word=word.replace("5","");
            word=word.replace("6","");
            word=word.replace("7","");
            word=word.replace("8","");
            word=word.replace("9","");
            word=word.replace("0","");
            word=word.replace(")","");
            word=word.replace("(","");
            word=word.replace("[ ,-","");
            word=word.toLowerCase();
            //System.out.println(scf.next());
            for (int i = 0; i < N; i++) {
                if (words[i].equals(word)){
                    index[i]++;
                    k = 1;
                }
            }
            if (k == 0) {
                    for (int j = 0; j < N; j++) {
                        if (words[j] == "") {
                            words[j] = word;
                            index[j]++;
                            break;
                        }
                    }
                }

            }
        quickSort(index,words,0,N-1);
        for(int i=N-1;i>=N-10;i--)
            System.out.println(words[i]+" "+ index[i]);

        scf.close();
      //  System.out.println(Arrays.toString(words));
       // System.out.println(Arrays.toString(index));
        FileInputStream fi=null;
        try {
           fi=new FileInputStream("test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileOutputStream fw=null;
        try {
            fw=new FileOutputStream("test2.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i=-1;
        while(true){
            try {
                if (!((i=fi.read())!=-1)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            char b= (char)i;
            if(b==' ')
            {
               b='#';
            }
            try {
                fw.write(b);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}