import java.util.ArrayList; 
import java.util.Random;
public class DoubleList {

        public static void main(String[] args){

            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(1);
            list.add(2);
            list.add(3);
            System.out.println(list);
            


                int size = list.size();
                for (int i = 0; i < size; i++) { 
                int pos = list.size(); // rand is a Random object myList.add(pos, i); 
                list.add(pos, i);
                System.out.println("step");

        }

        System.out.println(list);

        
}}
