package br.com.politec.sao.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DebugInputStream extends FilterInputStream {
    private final OutputStream copyStream;

    private long count = 0;

    public DebugInputStream(InputStream in,
            OutputStream out) throws IOException {
        super(in);
        this.copyStream = out;
    }

    public long getCount() {
        return this.count;
    }

    public int read() throws IOException {
        int result = in.read();
        if (result != -1) {
            this.copyStream.write(result);
            this.copyStream.flush();
            this.count++;
        }
        return result;
    }

    public int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    public int read(byte[] b, int off, int len) throws IOException {
        int length = in.read(b, off, len);
        if (length != -1) {
            this.copyStream.write(b, off, length);
            this.copyStream.flush();
            this.count += length;
        }
        return length;
    }

    public void close() throws IOException {
        super.close();
        this.copyStream.close();
    }
}
