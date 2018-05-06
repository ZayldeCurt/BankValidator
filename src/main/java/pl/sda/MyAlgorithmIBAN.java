package pl.sda;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class MyAlgorithmIBAN implements MyAlgorithm {
    @Override
    public boolean checkNumber(String number) {

        boolean lengthForCountryFlag = checkLengthForCountry(number);
        if(!lengthForCountryFlag) return false;


        String firstString = number.substring(4,number.length());
        String countryString = number.substring(0,2);
        String sumControlString = number.substring(2,4);

        countryString = changeCountryNumber(countryString);

        String sumString = firstString+countryString+sumControlString;

        BigInteger sumNumber = new BigInteger(sumString);
        BigInteger rest = sumNumber.mod(new BigInteger("97"));

        Integer restInt = rest.intValue();


        return restInt==1 ? true:false;
    }

    private String changeCountryNumber(String countryString) {
//        String[] numbersString =countryString.toUpperCase().split("");

        char[] numbersChar = countryString.toUpperCase().toCharArray();

        int[] numbersInt = new int[2];

        numbersInt[0]=((int) numbersChar[0])-55;
        numbersInt[1]=((int) numbersChar[1])-55;

        String numberCountry = Integer.toString(numbersInt[0])+Integer.toString(numbersInt[1]);

        return numberCountry; //ma zwrócić np:   'A' na '10', 'B' na '11' itd., aż do 'Z' na '35' (dla Polski 2521).
    }

    private boolean checkLengthForCountry(String numberCard) {
        String CSV_FILE_NAME = "countryNumberOfBankAccount.csv";
        String filePath = getClass().getClassLoader().getResource(CSV_FILE_NAME).getPath();
        MyGeneral dateSets = MyReadDate.myReadDate(filePath);
        List<Map<String, String>> date = dateSets.getDatesets();

        String codeCountry = numberCard.substring(0,2);
        Map<String, String> country;
        try{
             country= date.stream()
                .filter(x -> x.get("code").equals(codeCountry))
                .findFirst().get();
        }catch (NoSuchElementException e){
            return false;
        }

        int lengthCountry = Integer.parseInt(country.get("length"));

        if(lengthCountry == numberCard.length()){
            return true;
        }
        return false;
    }
}
