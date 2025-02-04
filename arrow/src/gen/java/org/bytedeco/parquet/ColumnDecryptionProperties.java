// Targeted by JavaCPP version 1.5.7-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.parquet;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.parquet.*;


@Namespace("parquet") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.parquet.class)
public class ColumnDecryptionProperties extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ColumnDecryptionProperties(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public ColumnDecryptionProperties(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public ColumnDecryptionProperties position(long position) {
        return (ColumnDecryptionProperties)super.position(position);
    }
    @Override public ColumnDecryptionProperties getPointer(long i) {
        return new ColumnDecryptionProperties((Pointer)this).offsetAddress(i);
    }

  @NoOffset public static class Builder extends Pointer {
      static { Loader.load(); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public Builder(Pointer p) { super(p); }
  
    public Builder(@StdString String name) { super((Pointer)null); allocate(name); }
    private native void allocate(@StdString String name);
    public Builder(@StdString BytePointer name) { super((Pointer)null); allocate(name); }
    private native void allocate(@StdString BytePointer name);

    public Builder(@SharedPtr ColumnPath path) { super((Pointer)null); allocate(path); }
    private native void allocate(@SharedPtr ColumnPath path);

    /** Set an explicit column key. If applied on a file that contains
     *  key metadata for this column the metadata will be ignored,
     *  the column will be decrypted with this key.
     *  key length must be either 16, 24 or 32 bytes. */
    public native Builder key(@StdString String key);
    public native Builder key(@StdString BytePointer key);

    public native @SharedPtr @ByVal ColumnDecryptionProperties build();
  }

  public ColumnDecryptionProperties() { super((Pointer)null); allocate(); }
  private native void allocate();
  public ColumnDecryptionProperties(@Const @ByRef ColumnDecryptionProperties other) { super((Pointer)null); allocate(other); }
  private native void allocate(@Const @ByRef ColumnDecryptionProperties other);

  public native @StdString String column_path();
  public native @StdString String key();
  public native @Cast("bool") boolean is_utilized();

  /** ColumnDecryptionProperties object can be used for reading one file only.
   *  Mark ColumnDecryptionProperties as utilized once it is used in
   *  FileDecryptionProperties as the encryption key will be wiped out upon
   *  completion of file reading. */
  public native void set_utilized();

  /** Upon completion of file reading, the encryption key
   *  will be wiped out. */
  public native void WipeOutDecryptionKey();

  public native @SharedPtr @ByVal ColumnDecryptionProperties DeepClone();
}
