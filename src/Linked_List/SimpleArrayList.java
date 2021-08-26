import java.lang.reflect.Array;

public class SimpleArrayList<T> {
    private static final int DEFAULT_ARRAY_SIZE = 8;
    private T[] plist;
    private T data;
    private int numOfData;
    private int curPosition; //마지막 참조 위치에 대한 정보 저장

    public SimpleArrayList(Class<T> clazz) {
        plist = (T[]) Array.newInstance(clazz, DEFAULT_ARRAY_SIZE);
        this.numOfData = 0;
        this.curPosition = -1; //빈 리스트는 top = -1
    }

    //push
    public void LInsert(T data) {
        if (numOfData > plist.length) {
            System.out.println("저장이 불가능합니다.");
            return;
        }
        plist[numOfData] = data;
        numOfData++;
    }

    public boolean LFirst() {
        if (numOfData == 0) { //빈 리스트라 LFirst가 없음
            return false;
        }
        curPosition = 0; //참조 위치를 첫 번째로 설정
        this.data = (T) plist[0]; //리스트의 0인덱스 값을 data에 삽입
        return true;
    }

    public boolean LNext() {
        if (curPosition >= numOfData - 1) { //더 이상 참조할 대상이 없음
            return false;
        }
        curPosition++;
        this.data = plist[curPosition];
        return true;
    }

    //pop
    public T LRemove() {
        int rpos = curPosition;
        int num = numOfData;
        int i;
        T rdata = plist[rpos]; //삭제 데이터 임시 저장 (rdata)

        for (i = rpos; i < num - 1; i++) {
            plist[i] = plist[i + 1]; //헷갈리면 LNext() 참고
        }
        numOfData--;
        curPosition--;
        return rdata;
    }

    public int LCount() {
        return numOfData;
    }

    public static void main(String[] args) {
        //ArrayList 생성
        SimpleArrayList<Integer> simpleArrayList = new SimpleArrayList<>(Integer.class);

        simpleArrayList.LInsert(11);
        simpleArrayList.LInsert(11);
        simpleArrayList.LInsert(22);
        simpleArrayList.LInsert(22);
        simpleArrayList.LInsert(33);

        //데이터 전체 출력
        System.out.println("현재 데이터의 수 : " + simpleArrayList.LCount());
        if (simpleArrayList.LFirst()) {
            System.out.print(simpleArrayList.data);

            while (simpleArrayList.LNext())
                System.out.print(" " + simpleArrayList.data);
        }
        System.out.println();
        System.out.println();

        //숫자 22 모두 삭제
        if (simpleArrayList.LFirst()) {
            if (simpleArrayList.data == 22)
                simpleArrayList.LRemove();

            while (simpleArrayList.LNext()) {
                if (simpleArrayList.data == 22)
                    simpleArrayList.LRemove();
            }
        }

        //삭제 후 저장된 데이터 전체 출력
        System.out.println("현재 데이터의 수 : " + simpleArrayList.LCount());
        if (simpleArrayList.LFirst()) {
            System.out.print(simpleArrayList.data);

            while (simpleArrayList.LNext())
                System.out.print(" " + simpleArrayList.data);
        }
    }
}