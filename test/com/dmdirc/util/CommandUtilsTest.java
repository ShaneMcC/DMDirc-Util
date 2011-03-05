/*
 * Copyright (c) 2006-2011 DMDirc Developers
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.dmdirc.util;

import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.*;

public class CommandUtilsTest {
    @Test
    public void testParseArguments() {
        final String[][][] tests = new String[][][]{
            {{"abcdef abcdef abcdef"}, {"abcdef", "abcdef", "abcdef"}},
            {{"abcdef \"abcdef abcdef\""}, {"abcdef", "abcdef abcdef"}},
            {{"abcdef \"abcdef foo abcdef\""}, {"abcdef", "abcdef foo abcdef"}},
            {{"abcdef \"abcdef\" \"abcdef\""}, {"abcdef", "abcdef", "abcdef"}},
            {{"abcdef \"\""}, {"abcdef", ""}},
            {{"abcdef \" foo?\""}, {"abcdef", " foo?"}},
        };

        for (String[][] test : tests) {
            final String[] res = CommandUtils.parseArguments(test[0][0]);
            assertTrue(test[0][0] + " - " + Arrays.toString(test[1]) + " - "
                    + Arrays.toString(res),
                    Arrays.equals(test[1], res));
        }
    }
}
