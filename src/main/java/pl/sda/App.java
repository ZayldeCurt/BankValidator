package pl.sda;



public class App
{
    public static void main( String[] args )
    {
//        SDACardValidator sdaCardValidator = new SDACardValidator();
//        ValidationResult validationResult= sdaCardValidator.analyze("C:\\Users\\pllsym\\IdeaProjects\\J7_CardValidator\\src\\main\\resources\\nameIssuer.csv","423456");
//
        MyAlgorithmIBAN myAlgorithmIBAN = new MyAlgorithmIBAN();
        boolean result = myAlgorithmIBAN.checkNumber("PL12345678901234567890123456");

    }
}
