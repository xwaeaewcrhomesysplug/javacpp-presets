// Targeted by JavaCPP version 1.5.7-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow_flight;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.arrow_flight.*;


/** \brief Opaque selection criteria for ListFlights RPC */
@Namespace("arrow::flight") @Properties(inherit = org.bytedeco.arrow.presets.arrow_flight.class)
public class Criteria extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public Criteria() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public Criteria(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Criteria(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public Criteria position(long position) {
        return (Criteria)super.position(position);
    }
    @Override public Criteria getPointer(long i) {
        return new Criteria((Pointer)this).offsetAddress(i);
    }

  /** Opaque criteria expression, dependent on server implementation */
  public native @StdString String expression(); public native Criteria expression(String setter);
}
