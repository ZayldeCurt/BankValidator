package pl.sda;

import org.junit.Assert;
import org.junit.Test;

public class MyAlgorithmLuhnaTest {

    @Test
    public void testAlgorithm(){
        //given
        MyAlgorithmLuhna algorithmLuhna = new MyAlgorithmLuhna();
        String numberCardsGood = "4024007189065781";
        //when
        boolean result = algorithmLuhna.checkNumber(numberCardsGood);
        //then
        Assert.assertEquals(true,result);
    }

    @Test
    public void testAlgorithmWithFalseResult(){
        //given
        MyAlgorithmLuhna algorithmLuhna = new MyAlgorithmLuhna();
        String numberCards= "4024007189065782";
        //when
        boolean result = algorithmLuhna.checkNumber(numberCards);
        //then
        Assert.assertEquals(false,result);
    }



}
