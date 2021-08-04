public class BinarySearch { //이미 정렬된 배열 사용

    public static int BSearch(int arr[], int target) {
        int first = 0;
        int last = arr.length - 1;
        int mid;

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
        }
        return -1;
    }
        public static void main (String[] args){
        int arr[] = {1, 3, 5, 7, 9};
        int idx;

        idx = BSearch(arr, 7);
        if(idx == -1)
            System.out.println("탐색 실패");
        else
            System.out.println("타겟 저장 인덱스 : " + idx);

        idx = BSearch(arr, 4);
        if(idx == -1)
            System.out.println("탐색 실패");
        else
            System.out.println("타겟 저장 인덱스 : " + idx);
        }
    }
