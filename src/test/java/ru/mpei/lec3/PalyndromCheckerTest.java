package ru.mpei.lec3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


class PalyndromCheckerTest {
    PalindromeChecker p = new PalindromeChecker();

    @Test
    public void success_test1(){
        boolean res = p.check(12321);
        Assertions.assertTrue(res);
    }


    @Test
    public void success_test2(){
        boolean res = p.check(12345);
        Assertions.assertFalse(res);
    }

    @Test
    public void success_test3(){
        boolean res = p.check(3);
        Assertions.assertEquals(true, res);
    }

    @Test
    public void success_test4(){
        boolean res = p.check(-3);
        Assertions.assertEquals(false, res);
    }

    @Test
    public void fail_test_negativeNumber(){
        Executable e = new Executable() {
            @Override
            public void execute() throws Throwable {
                p.check(-12321);
            }
        };

        Assertions.assertThrows(PalindromeException.class, e);
    }


}