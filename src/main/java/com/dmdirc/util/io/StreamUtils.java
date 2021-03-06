/*
 * Copyright (c) 2006-2017 DMDirc Developers
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 * OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.dmdirc.util.io;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.WillClose;

/**
 * Utilities for dealing with streams.
 *
 * @since 0.6.3m2
 */
public final class StreamUtils {

    /** Shouldn't be called. */
    private StreamUtils() {
    }

    public static void readStream(@WillClose final InputStream inputStream) {
        new StreamIgnorer(inputStream).run();
    }

    /**
     * Closes the stream if it is non-null, and ignores any IOExceptions
     * raised by doing so.
     *
     * @param stream The stream to be closed
     */
    public static void close(final Closeable stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException ex) {
                // Do nothing. We don't care.
            }
        }
    }

}
