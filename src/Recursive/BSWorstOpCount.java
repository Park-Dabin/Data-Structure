public class BSWorstOpCount {
    public static int BSearch(int arr[], int target) {
        int first = 0;
        int last = arr.length - 1;
        int mid;
        int opCount = 0;

        while (first <= last) {
            mid = (first + last) / 2;

            if (target == arr[mid]) //중앙 = 타겟인지를 반복해서 찾는것이 BS
                return mid;
            else {
                if (target < arr[mid]) //이미 정렬된 배열 이므로 가능
                    last = mid - 1; //mid는 이미 탐색됐으므로 그 앞 인덱스가 last가 됨
                else
                    first = mid + 1;
            }
            opCount += 1;
        }
        System.out.println("비교 연산 횟수 : "+opCount);
        return -1;
    }

    public static void main(String[] args) {
        int arr1[] = new int[500]; //500의 크기를 가지고 초기값 0으로 채워진 배열이 생성되므로 아래 for문으로 0 채워줄 필요 없음
//        for(int i = 0;i<arr1.length;i++){
//            arr1[i] = 0;
//        }
        int arr2[] = new int[5000];
//        for(int i = 0;i<arr2.length;i++){
//            arr2[i] = 0;
//        }
        int arr3[] = new int[50000];
//        for(int i = 0;i<arr3.length;i++){
//            arr3[i] = 0;
//        }
        int idx;

        idx = BSearch(arr1, 1);
        if (idx == -1)
            System.out.println("탐색 실패");
        else
            System.out.println("타겟 저장 인덱스 : " + idx);

        idx = BSearch(arr2, 2);
        if (idx == -1)
            System.out.println("탐색 실패");
        else
            System.out.println("타겟 저장 인덱스 : " + idx);

        idx = BSearch(arr3, 3);
        if (idx == -1)
            System.out.println("탐색 실패");
        else
            System.out.println("타겟 저장 인덱스 : " + idx);
    }
}
