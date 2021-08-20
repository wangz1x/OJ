package com.wzx.access;

public class Main7 {

//    public static void main(String[] args){
//
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        LinkedList<Integer> res = new LinkedList<Integer>();
//        for(int i=0;i<n;i++){
//            arr[i] = sc.nextInt();
//        }
//        reAdd(arr,res,0,n-1);
//        for (int l = 0;l<n;l++){
//            System.out.print(res.get(l));
//        }
//
//    }
//    public static void reAdd(int[] arr, LinkedList<Integer> res, int i, int j){
//        if(i>j) return;
//        int n = i,m=j;
//        while (arr[n]==arr[m]&&n<=m){
//            n++;
//            m--;
//        }
//        if(arr[n]<arr[m]){
//            res.add(arr[i]);
//            i++;
//        }else {
//            res.add(arr[j]);
//            j--;
//        }
//        reAdd(arr,res,i,j);
//    }

    public static void main(String[] args) {

        int n = 1000000;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = 9;
        }


        int[] res = reAdd(arr, 0, n - 1);

//        for (int l = 0; l < n; l++) {
//            System.out.print(res[l]);
//        }
    }

    public static int[] reAdd(int[] arr, int i, int j) {
        int[] res = new int[arr.length];
        int idx = 0;

        while (i <= j) {

            if (arr[i] < arr[j]) {
                res[idx++] = arr[i];
                i++;
            } else if (arr[i] > arr[j]) {
                res[idx++] = arr[j];
                j++;
            } else {
                int n = i + 1, m = j - 1;
                while (n <= m && arr[n] == arr[m]) {
                }
                if (arr[n] < arr[m]) {
                    res[idx++] = arr[i];
                    i++;
                } else {
                    res[idx++] = arr[j];
                    j--;
                }
            }
        }

        return res;
    }
}
