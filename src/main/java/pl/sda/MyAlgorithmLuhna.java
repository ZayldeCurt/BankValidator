package pl.sda;

public class MyAlgorithmLuhna implements MyAlgorithm {
    public  boolean checkNumber(String numberCard){
        String[] numbers=numberCard.split("");

        int[] numbersInt = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbersInt[i]=Integer.parseInt(numbers[i]);
        }

        int sum=0;
        for (int i = numbersInt.length-1,j=1; i >= 0; i--,j++) {
            if(j%2==0){
                if(numbersInt[i]*2>9){
                    numbersInt[i]=addDigitOfNumber(numbersInt[i]*2);
                }else{
                    numbersInt[i]*=2;
                }
            }
            sum+=numbersInt[i];
        }

        return sum % 10 == 0;
    }

    private static int addDigitOfNumber(int i) {
        int sum = 0;
        while (i > 0) {
            sum = sum + i % 10;
            i = i / 10;
        }

        return sum;
    }

}
