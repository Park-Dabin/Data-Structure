public class LinearSearch {
        public static int LSearch(int arr[], int target){
            for(int i=0; i<arr.length; i++){
                if(arr[i] == target)
                    return i;
            }
            return -1;
        }

    public static void main(String[] args) {
        int arr[] = {3, 5, 2, 4, 9};
        int idx;
        // LinearSearch L = new LinearSearch(); --> static 없이 하려면 객체를 만들어주면 됨
        idx = LSearch(arr, 4);
        if(idx == -1)
            System.out.println("탐색 실패");
        else
            System.out.println("타겟 저장 인덱스 : " + idx);

        idx = LSearch(arr, 7);
        if(idx == -1)
            System.out.println("탐색 실패");
        else
            System.out.println("타겟 저장 인덱스 : " + idx);
        }
}

