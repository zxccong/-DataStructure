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
        String idCard= "341221199501122034";
        if (Integer.parseInt(idCard.substring(16,17))%2==1){
            System.out.println("男");
        }else {
            System.out.println("女");
        }


    }
}
