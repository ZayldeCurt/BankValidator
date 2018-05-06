package pl.sda;

import org.junit.Assert;
import org.junit.Test;


public class SDACardValidatorTest {

    @Test
    public void CheckAnylyzeMethod(){
        //given
        SDACardValidator sdaCardValidator = new SDACardValidator();

        String issuer = "test";
        String numberCard = "14321111";
        String filePath = "C:\\Users\\pllsym\\IdeaProjects\\J7_CardValidator\\src\\test\\resources\\nameIssuer.csv";

        //when
        ValidationResult validationResult= sdaCardValidator.analyze(filePath,numberCard);

        //then
        Assert.assertEquals(true, validationResult.isVerificationPassed());
        Assert.assertEquals(issuer,validationResult.getIssuer());

    }



}
