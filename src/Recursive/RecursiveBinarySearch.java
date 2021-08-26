public class RecursiveBinarySearch {
    static int RecurBSearch(int arr[], int first, int last, int target){
        int mid;
        if(first > last)
            return -1;
        mid = (first + last) /2;

        //재귀함수를 사용하지 않는다면 while문으로 first가 last보다 작을때까지 돌아가게 함
        if(arr[mid] == target)
            return mid;
        else if(arr[mid] < target)
            return RecurBSearch(arr, mid+1, last, target);
        else
            return RecurBSearch(arr, first, mid-1, target);
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 7, 9};
        int idx;

        idx = RecurBSearch(arr, 0, arr.length-1, 7);
        if(idx == -1)
            System.out.println("탐색 실패");
        else
            System.out.println("타겟 저장 인덱스 : " + idx);

        idx = RecurBSearch(arr, 0, arr.length-1, 4);
        if(idx == -1)
            System.out.println("탐색 실패");
        else
            System.out.println("타겟 저장 인덱스 : " + idx);
    }
}
