import java.lang.Math;
public class SearchAlgo {
    

    public int SqrtJumpSearch(int[] array, int val) {
        //average/worst case O(sqrt(n))
        int k = (int) Math.sqrt(array.length);
        int count = 1;
        int index = count*k;
        while(index < array.length) {
            index = count*k;
            if (index > array.length-1) { break;}
            if ( val == array[index] ) { return index; }
            else if (val < array[index] ) {
                for ( int i = index ; i >=0 ; i-- ) {
                    if (val == array[i]) {  return i;}
                }
            }
            count++;
        }

        if (count*k > array.length) {
            count--;
            for (int i = count*k ; i < array.length ; i++) {
                if ( val == array[i]) { return i;}
            }
        }
        
        return -1;

    }

    public int InterpolationSearch(int[] array, int val) {
        int high = array.length -1;
        int low = 0;
        //avg case O(loglogn) assuming uniformly distributed data, worst case O(n)
        while ( array[low] <= val && val <= array[high] && low<=high) {
            int probe = low + (high - low) * (val - array[low])/(array[high]-array[low]);
            if (array[probe] == val) { return probe;}
            else if(array[probe] > val) { high = probe -1;}
            else { low = probe + 1;}

        }
        return -1;
    }

    public static void main(String[] args) {
        SearchAlgo searchAlgo = new SearchAlgo();
        System.out.println(searchAlgo.SqrtJumpSearch(new int[] {1,2,3,4,5,100000,99999999}, 100));
        System.out.println(searchAlgo.InterpolationSearch(new int[] {1,2,3,4,5},3));
    } 
}
