// Targeted by JavaCPP version 1.5.7-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import org.bytedeco.arrow.Function;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


@Namespace("arrow") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class DoubleScalar extends BaseDoubleScalar {
    static { Loader.load(); }

  
  
    public DoubleScalar(@Cast("arrow::NumericScalar<arrow::DoubleType>::ValueType") double value) { super((Pointer)null); allocate(value); }
    private native void allocate(@Cast("arrow::NumericScalar<arrow::DoubleType>::ValueType") double value);
  
    public DoubleScalar() { super((Pointer)null); allocate(); }
    private native void allocate();
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DoubleScalar(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public DoubleScalar(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public DoubleScalar position(long position) {
        return (DoubleScalar)super.position(position);
    }
    @Override public DoubleScalar getPointer(long i) {
        return new DoubleScalar((Pointer)this).offsetAddress(i);
    }

}
