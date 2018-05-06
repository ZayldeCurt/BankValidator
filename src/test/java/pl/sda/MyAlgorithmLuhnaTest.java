package pl.sda;

import org.junit.Assert;
import org.junit.Test;

public class AlgorithmLuhnaTest {

    @Test
    public void testAlgorithm(){
        //given
        AlgorithmLuhna algorithmLuhna = new AlgorithmLuhna();
        String numberCardsGood = "4024007189065781";
        //when
        boolean result = algorithmLuhna.checkNumber(numberCardsGood);
        //then
        Assert.assertEquals(true,result);
    }

    @Test
    public void testAlgorithmWithFalseResult(){
        //given
        AlgorithmLuhna algorithmLuhna = new AlgorithmLuhna();
        String numberCards= "4024007189065782";
        //when
        boolean result = algorithmLuhna.checkNumber(numberCards);
        //then
        Assert.assertEquals(false,result);
    }



}
