package by.it.akhmelev.JD02_04.SimpleMatlab;

import org.junit.Assert;
import org.junit.Test;

public class ParserTest {

    @Test
    public void testProcess() throws Exception {
        char[] xok="6.2".toCharArray();
        char[] x=Parser.process("x=3+3.2").toCharArray();
        System.out.print(x);
        Assert.assertArrayEquals(x, xok);
    }
}