// Targeted by JavaCPP version 1.5.7-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.gandiva;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.gandiva.*;

@Name("std::unordered_set<gandiva::DecimalScalar128>") @Properties(inherit = org.bytedeco.arrow.presets.gandiva.class)
public class DecimalScalar128Set extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DecimalScalar128Set(Pointer p) { super(p); }
    public DecimalScalar128Set()       { allocate();  }
    private native void allocate();
    public native @Name("operator =") @ByRef DecimalScalar128Set put(@ByRef DecimalScalar128Set x);

    public boolean empty() { return size() == 0; }
    public native long size();

    public native void insert(@ByRef DecimalScalar128 value);
    public native void erase(@ByRef DecimalScalar128 value);
    public native @ByVal Iterator begin();
    public native @ByVal Iterator end();
    @NoOffset @Name("iterator") public static class Iterator extends Pointer {
        public Iterator(Pointer p) { super(p); }
        public Iterator() { }

        public native @Name("operator ++") @ByRef Iterator increment();
        public native @Name("operator ==") boolean equals(@ByRef Iterator it);
        public native @Name("operator *") @ByRef @Const DecimalScalar128 get();
    }
}

