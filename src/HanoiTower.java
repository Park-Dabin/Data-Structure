public class HanoiTower {
    static void HanoiTowerMove(int num, char from, char by, char to) {
        if (num == 1)
            System.out.println("원반 1을 " + from + "에서 " + to + "로 이동");
        else {
            HanoiTowerMove(num - 1, from, to, by);
            System.out.println("원반 " + num + "을(를) " + from + "에서 " + to + "로 이동");
            HanoiTowerMove(num - 1, by, from, to);
        }
    }

    public static void main(String[] args) {
        //막대 A의 원반 3개를 B를 경유하여 C로 옮기기
        HanoiTowerMove(3, 'A', 'B', 'C');
    }
}
