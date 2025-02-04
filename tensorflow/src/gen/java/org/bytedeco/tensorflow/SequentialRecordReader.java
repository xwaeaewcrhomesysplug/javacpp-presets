// Targeted by JavaCPP version 1.5.6: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


// High-level interface to read TFRecord files.
//
// Note: this class is not thread safe; external synchronization required.
@Namespace("tensorflow::io") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class SequentialRecordReader extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SequentialRecordReader(Pointer p) { super(p); }

  // Create a reader that will return log records from "*file".
  // "*file" must remain live while this Reader is in use.
  public SequentialRecordReader(
        RandomAccessFile file,
        @Const @ByRef(nullValue = "tensorflow::io::RecordReaderOptions()") RecordReaderOptions options) { super((Pointer)null); allocate(file, options); }
  private native void allocate(
        RandomAccessFile file,
        @Const @ByRef(nullValue = "tensorflow::io::RecordReaderOptions()") RecordReaderOptions options);
  public SequentialRecordReader(
        RandomAccessFile file) { super((Pointer)null); allocate(file); }
  private native void allocate(
        RandomAccessFile file);

  // Reads the next record in the file into *record. Returns OK on success,
  // OUT_OF_RANGE for end of file, or something else for an error.
  public native @ByVal Status ReadRecord(@StdString @Cast({"char*", "std::string*"}) BytePointer record);

  // Returns the current offset in the file.
  public native @Cast("tensorflow::uint64") long TellOffset();

  // Seek to this offset within the file and set this offset as the current
  // offset. Trying to seek backward will throw error.
  public native @ByVal Status SeekOffset(@Cast("tensorflow::uint64") long offset);
}
