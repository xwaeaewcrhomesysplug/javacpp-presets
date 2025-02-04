// Targeted by JavaCPP version 1.5.7-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import org.bytedeco.arrow.Function;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;

@Name("std::vector<std::unique_ptr<arrow::compute::KernelState> >") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class KernelStateVector extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public KernelStateVector(Pointer p) { super(p); }
    public KernelStateVector()       { allocate();  }
    private native void allocate();


    public boolean empty() { return size() == 0; }
    public native long size();

    @Index(function = "at") public native @UniquePtr @Cast({"", "std::unique_ptr<arrow::compute::KernelState>&&"}) KernelState get(@Cast("size_t") long i);

    public native @ByVal Iterator begin();
    public native @ByVal Iterator end();
    @NoOffset @Name("iterator") public static class Iterator extends Pointer {
        public Iterator(Pointer p) { super(p); }
        public Iterator() { }

        public native @Name("operator ++") @ByRef Iterator increment();
        public native @Name("operator ==") boolean equals(@ByRef Iterator it);
        public native @Name("operator *") @UniquePtr @Cast({"", "std::unique_ptr<arrow::compute::KernelState>&&"}) KernelState get();
    }
}

