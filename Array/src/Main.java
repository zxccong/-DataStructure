public class Main {
    public static void main(String[] args) {
//        int[] arr = new int[10];
//
//        for (int i = 0; i < arr.length; i++) {
//            arr[i]=i;
//            int[] scores = new int[]{100,99,66};
//            for (int j = 0; j < scores.length; j++) {
//                System.out.println("scores = " + scores[j]);
//            }
//
//            scores[0] = 98 ;
//
//        }


//        String idCard= "341221199501122034";
//        String idCard= "341221199501122034";
//        if (Integer.parseInt(idCard.substring(16,17))%2==1){
//            System.out.println("男");
//        }else {
//            System.out.println("女");
//        }

//        Array arr = new Array(20);
//        Array2<Integer> arr = new Array2(20);
        Array3<Integer> arr = new Array3();//默认10个数据
        for (int i = 0; i < 30; i++) {
            arr.addLast(i);
        }
        System.out.println("arr = " + arr);

        arr.add(1,100);
        System.out.println("arr = " + arr);

        arr.addFirst(500);
        System.out.println("arr = " + arr);

        arr.addLast(600);
        System.out.println("arr = " + arr);

        arr.remove(2);
        System.out.println("arr = " + arr);

        arr.removeElement(5);
        System.out.println("arr = " + arr);

        arr.removeFirst();
        System.out.println("arr = " + arr);

        arr.removeLast();
        System.out.println("arr = " + arr);

    }
}
