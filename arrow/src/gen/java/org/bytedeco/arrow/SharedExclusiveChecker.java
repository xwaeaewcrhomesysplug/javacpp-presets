// Targeted by JavaCPP version 1.5.7-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import org.bytedeco.arrow.Function;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


// Debug concurrency checker that marks "shared" and "exclusive" code sections,
// aborting if the concurrency rules get violated.  Does nothing in release mode.
// Note that we intentionally use the same class declaration in debug and
// release builds in order to avoid runtime failures when e.g. loading a
// release-built DLL with a debug-built application, or the reverse.

@Namespace("arrow::io::internal") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class SharedExclusiveChecker extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SharedExclusiveChecker(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SharedExclusiveChecker(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public SharedExclusiveChecker position(long position) {
        return (SharedExclusiveChecker)super.position(position);
    }
    @Override public SharedExclusiveChecker getPointer(long i) {
        return new SharedExclusiveChecker((Pointer)this).offsetAddress(i);
    }

  public SharedExclusiveChecker() { super((Pointer)null); allocate(); }
  private native void allocate();
  public native void LockShared();
  public native void UnlockShared();
  public native void LockExclusive();
  public native void UnlockExclusive();

  public native @ByVal SharedExclusiveCheckerSharedLockGuard shared_guard();

  public native @ByVal SharedExclusiveCheckerExclusiveLockGuard exclusive_guard();
}
