// Targeted by JavaCPP version 1.5.6: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


// The standard implementation of OpRegistryInterface, along with a
// global singleton used for registering ops via the REGISTER
// macros below.  Thread-safe.
//
// Example registration:
//   OpRegistry::Global()->Register(
//     [](OpRegistrationData* op_reg_data)->Status {
//       // Populate *op_reg_data here.
//       return Status::OK();
//   });
@Namespace("tensorflow") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class OpRegistry extends OpRegistryInterface {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public OpRegistry(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public OpRegistry(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public OpRegistry position(long position) {
        return (OpRegistry)super.position(position);
    }
    @Override public OpRegistry getPointer(long i) {
        return new OpRegistry((Pointer)this).offsetAddress(i);
    }


  public OpRegistry() { super((Pointer)null); allocate(); }
  private native void allocate();

  public native void Register(@Cast("const tensorflow::OpRegistry::OpRegistrationDataFactory*") @ByRef Pointer op_data_factory);

  public native @ByVal Status LookUp(@StdString BytePointer op_type_name,
                  @Cast("const tensorflow::OpRegistrationData**") PointerPointer op_reg_data);
  public native @ByVal Status LookUp(@StdString BytePointer op_type_name,
                  @Const @ByPtrPtr OpRegistrationData op_reg_data);
  public native @ByVal Status LookUp(@StdString String op_type_name,
                  @Const @ByPtrPtr OpRegistrationData op_reg_data);

  // Fills *ops with all registered OpDefs (except those with names
  // starting with '_' if include_internal == false) sorted in
  // ascending alphabetical order.
  public native void Export(@Cast("bool") boolean include_internal, OpList ops);

  // Returns ASCII-format OpList for all registered OpDefs (except
  // those with names starting with '_' if include_internal == false).
  public native @StdString BytePointer DebugString(@Cast("bool") boolean include_internal);

  // A singleton available at startup.
  public static native OpRegistry Global();

  // Get all registered ops.
  public native void GetRegisteredOps(OpDefVector op_defs);

  // Get all `OpRegistrationData`s.
  public native void GetOpRegistrationData(@StdVector OpRegistrationData op_data);

  // Watcher, a function object.
  // The watcher, if set by SetWatcher(), is called every time an op is
  // registered via the Register function. The watcher is passed the Status
  // obtained from building and adding the OpDef to the registry, and the OpDef
  // itself if it was successfully built. A watcher returns a Status which is in
  // turn returned as the final registration status.

  // An OpRegistry object has only one watcher. This interface is not thread
  // safe, as different clients are free to set the watcher any time.
  // Clients are expected to atomically perform the following sequence of
  // operations :
  // SetWatcher(a_watcher);
  // Register some ops;
  // op_registry->ProcessRegistrations();
  // SetWatcher(nullptr);
  // Returns a non-OK status if a non-null watcher is over-written by another
  // non-null watcher.
  public native @ByVal Status SetWatcher(@Cast("const tensorflow::OpRegistry::Watcher*") @ByRef Pointer watcher);

  // Process the current list of deferred registrations. Note that calls to
  // Export, LookUp and DebugString would also implicitly process the deferred
  // registrations. Returns the status of the first failed op registration or
  // Status::OK() otherwise.
  public native @ByVal Status ProcessRegistrations();

  // Defer the registrations until a later call to a function that processes
  // deferred registrations are made. Normally, registrations that happen after
  // calls to Export, LookUp, ProcessRegistrations and DebugString are processed
  // immediately. Call this to defer future registrations.
  public native void DeferRegistrations();

  // Clear the registrations that have been deferred.
  public native void ClearDeferredRegistrations();
}
