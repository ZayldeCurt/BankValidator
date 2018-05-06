package pl.sda;

import java.util.List;
import java.util.Map;

public class SDACardValidator {

    public ValidationResult analyze(String filePath,String numberCard) {
        ValidationResult result = new ValidationResult();
        MyGeneral dateSets= MyReadDate.myReadDate(filePath);
        MyAlgorithmLuhna algorithmLuhna = new MyAlgorithmLuhna();

        checkPrefix(numberCard, result, dateSets);
        boolean lengthResult = checkLengthOfNumberCard(numberCard,result.getIssuer(),dateSets.getDatesets());
        boolean luhmaResult = algorithmLuhna.checkNumber(numberCard);

        if(lengthResult&&luhmaResult){
            result.setVerificationPassed(true);
        }else {
            result.setVerificationPassed(false);
        }

        return result;
    }

    private boolean checkLengthOfNumberCard(String numberCard, String issuer, List<Map<String, String>> datesets) {
        int lengthOfNumberCard=0;

        for (int i = 0; i < datesets.size(); i++) {
            if(issuer.equals(datesets.get(i).get("issuer"))){
                lengthOfNumberCard=Integer.parseInt(datesets.get(i).get("numberOfChar"));
            }
        }
        int actualLength = numberCard.split("").length;

        if(lengthOfNumberCard==actualLength){
            return true;
        }
        return false;

    }

    private void checkPrefix(String numberCard, ValidationResult result, MyGeneral dateSets){
        int numberCardInt =Integer.parseInt(numberCard);

        for (int i = 0; i < dateSets.getDatesets().size(); i++) {
            String prefixFromFile = dateSets.getDatesets().get(i).get("prefix");
            if(prefixFromFile.contains("-")){
                String[] splitPrefix = prefixFromFile.split("-");
                int prefixLength = splitPrefix[1].length();
                int prefix =Integer.parseInt(numberCard.substring(0,prefixLength));

                int beginNumber = Integer.parseInt(splitPrefix[0]);
                int endNumber  = Integer.parseInt(splitPrefix[1]);

                if(prefix>beginNumber&&prefix<endNumber){
                    String issuer = dateSets.getDatesets().get(i).get("issuer");
                    result.setIssuer(issuer);
                }
            }else if(prefixFromFile.contains(",")) {

                String[] splitPrefix = prefixFromFile.split(",");
                int prefixLength = splitPrefix[0].length();
                String prefix = numberCard.substring(0,prefixLength);

                for (int j = 0; j < splitPrefix.length; j++) {
                    if(prefix.equals(splitPrefix[j])){
                        String issuer = dateSets.getDatesets().get(i).get("issuer");
                        result.setIssuer(issuer);
                    }
                }
            }else{
                int prefixLength = prefixFromFile.length();
                String prefixActual = numberCard.substring(0,prefixLength);
                if(prefixFromFile.equals(prefixActual))
                {
                    String issuer = dateSets.getDatesets().get(i).get("issuer");
                    result.setIssuer(issuer);
                }
            }
        }


    }


//    private void checkPrefixOLD(String numberCard, ValidationResult result, MyGeneral dateSets) {
//        String prefix = numberCard.substring(0,2);
//        int prefixInt =Integer.parseInt(prefix);
//
//        for (int i = 0; i < dateSets.getDatesets().size(); i++) {
//            String tmp = dateSets.getDatesets().get(i).get("prefix");
//            if(tmp.contains("-")){
//                String[] splitPrefix = tmp.split("-");
//                int beginNumber = Integer.parseInt(splitPrefix[0]);
//                int endNumber  = Integer.parseInt(splitPrefix[1]);
//
//                if(prefixInt>beginNumber&&prefixInt<endNumber){
//                    String issuer = dateSets.getDatesets().get(i).get("issuer");
//                    result.setIssuer(issuer);
//                }
//            }else if(tmp.contains(",")) {
//                String[] splitPrefix = tmp.split(",");
//                for (int j = 0; j < splitPrefix.length; j++) {
//                    if(prefix.equals(splitPrefix[j])){
//                        String issuer = dateSets.getDatesets().get(i).get("issuer");
//                        result.setIssuer(issuer);
//                    }
//                }
//            }else{
//                if(tmp.equals(prefix.split("")[0]))
//                {
//                    String issuer = dateSets.getDatesets().get(i).get("issuer");
//                    result.setIssuer(issuer);
//                }
//            }
//        }
//    }


}
