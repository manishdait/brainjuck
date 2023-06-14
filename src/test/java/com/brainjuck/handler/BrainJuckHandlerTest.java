/*
 * MIT License
 * Copyright (c) 2023 Manish Dait
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 */

package com.brainjuck.handler;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.brainjuck.error.BrainJuckException;

/**
 * The {@link BrainJuckHandlerTest} is a class for testing {@link BrainJuckHandler}.
 *
 */

public class BrainJuckHandlerTest {
    @Test(expected = BrainJuckException.class)
    public void testFileExtentionError() throws BrainJuckException {
        String args = "src/test/resources/handler/Somecode.txt";
        BrainJuckHandler.readFile(args);
    }     

    @Test(expected = BrainJuckException.class)
    public void testFileNotFoundError() throws BrainJuckException {
        String args = "src/test/resources/handler/Newcode.bf";
        BrainJuckHandler.readFile(args);
    }     

    @Test
    public void validateOutout() throws BrainJuckException{
        String expected = "+[-->-[>>+>-----<<]<--<---]>-.>>>+.>>..+++[.>]<<<<.+++.------.<<-.>>>>+.";
        String actual = BrainJuckHandler.readFile("src/test/resources/handler/Somecode.bf");
        assertEquals(expected,actual);
    }
}
