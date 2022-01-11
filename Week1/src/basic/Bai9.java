package basic;

public class Bai9 {
    static int demSo(int n){
        int count = 0;
        while (n>0){
            n=n/10;
            count++;
        }
        return count;
    }
    static int[] convertToArr(int n){
        int scs = demSo(n);
        int[] arr = new int[scs];
        int i=0;
        while (n>0){
            arr[i] = n%10;
            i++;
            n=n/10;
        }
        return arr;
    }
    static int sumArr(int[] arr){
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            s+= arr[i];
        }
        return s;
    }

    static boolean kt(int n){
        int[] arr = convertToArr(n);
        if(sumArr(arr)%10!=0) return false;
        for (int i = 0; i < arr.length/2; i++) {
            if(arr[i]==1 ||arr[i] == 2 ||arr[i] == 3 ||arr[i] == 4 ||arr[i] == 5 ||arr[i] == 7 ||arr[i] == 9 ) return false;
            if(arr[i] != arr[arr.length-i-1]) return false;

        }
        return true;
    }

    public static void main(String[] args) {
        int dem = 0;
        for (int i = 6000000; i<=888888888 ; i++) {
           // System.out.println(i);
            if(kt(i)){
                System.out.print(i+" ");
                dem++;
            }
        }
        if(dem ==0) System.out.println("khong co so phu hop");
    }
}
