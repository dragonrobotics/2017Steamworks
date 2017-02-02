// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: org/usfirst/frc/team5002/robot/replay.proto

package org.usfirst.frc.team5002.robot.replay;

/**
 * Protobuf type {@code team5002.ControlState}
 */
public  final class ControlState extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:team5002.ControlState)
    ControlStateOrBuilder {
  // Use ControlState.newBuilder() to construct.
  private ControlState(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ControlState() {
    forwardAxis_ = 0D;
    horizontalAxis_ = 0D;
    turnAxis_ = 0D;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private ControlState(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 9: {

            forwardAxis_ = input.readDouble();
            break;
          }
          case 17: {

            horizontalAxis_ = input.readDouble();
            break;
          }
          case 25: {

            turnAxis_ = input.readDouble();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.usfirst.frc.team5002.robot.replay.ReplayOuterClass.internal_static_team5002_ControlState_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.usfirst.frc.team5002.robot.replay.ReplayOuterClass.internal_static_team5002_ControlState_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.usfirst.frc.team5002.robot.replay.ControlState.class, org.usfirst.frc.team5002.robot.replay.ControlState.Builder.class);
  }

  public static final int FORWARD_AXIS_FIELD_NUMBER = 1;
  private double forwardAxis_;
  /**
   * <pre>
   * Forward / backward movement axis.
   * </pre>
   *
   * <code>optional double forward_axis = 1;</code>
   */
  public double getForwardAxis() {
    return forwardAxis_;
  }

  public static final int HORIZONTAL_AXIS_FIELD_NUMBER = 2;
  private double horizontalAxis_;
  /**
   * <pre>
   * Left / right strafing axis.
   * </pre>
   *
   * <code>optional double horizontal_axis = 2;</code>
   */
  public double getHorizontalAxis() {
    return horizontalAxis_;
  }

  public static final int TURN_AXIS_FIELD_NUMBER = 3;
  private double turnAxis_;
  /**
   * <pre>
   * CW / CCW rotation axis.
   * </pre>
   *
   * <code>optional double turn_axis = 3;</code>
   */
  public double getTurnAxis() {
    return turnAxis_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (forwardAxis_ != 0D) {
      output.writeDouble(1, forwardAxis_);
    }
    if (horizontalAxis_ != 0D) {
      output.writeDouble(2, horizontalAxis_);
    }
    if (turnAxis_ != 0D) {
      output.writeDouble(3, turnAxis_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (forwardAxis_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(1, forwardAxis_);
    }
    if (horizontalAxis_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(2, horizontalAxis_);
    }
    if (turnAxis_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(3, turnAxis_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof org.usfirst.frc.team5002.robot.replay.ControlState)) {
      return super.equals(obj);
    }
    org.usfirst.frc.team5002.robot.replay.ControlState other = (org.usfirst.frc.team5002.robot.replay.ControlState) obj;

    boolean result = true;
    result = result && (
        java.lang.Double.doubleToLongBits(getForwardAxis())
        == java.lang.Double.doubleToLongBits(
            other.getForwardAxis()));
    result = result && (
        java.lang.Double.doubleToLongBits(getHorizontalAxis())
        == java.lang.Double.doubleToLongBits(
            other.getHorizontalAxis()));
    result = result && (
        java.lang.Double.doubleToLongBits(getTurnAxis())
        == java.lang.Double.doubleToLongBits(
            other.getTurnAxis()));
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    hash = (37 * hash) + FORWARD_AXIS_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getForwardAxis()));
    hash = (37 * hash) + HORIZONTAL_AXIS_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getHorizontalAxis()));
    hash = (37 * hash) + TURN_AXIS_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getTurnAxis()));
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.usfirst.frc.team5002.robot.replay.ControlState parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.usfirst.frc.team5002.robot.replay.ControlState parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.usfirst.frc.team5002.robot.replay.ControlState parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.usfirst.frc.team5002.robot.replay.ControlState parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.usfirst.frc.team5002.robot.replay.ControlState parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.usfirst.frc.team5002.robot.replay.ControlState parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.usfirst.frc.team5002.robot.replay.ControlState parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.usfirst.frc.team5002.robot.replay.ControlState parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.usfirst.frc.team5002.robot.replay.ControlState parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.usfirst.frc.team5002.robot.replay.ControlState parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(org.usfirst.frc.team5002.robot.replay.ControlState prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code team5002.ControlState}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:team5002.ControlState)
      org.usfirst.frc.team5002.robot.replay.ControlStateOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.usfirst.frc.team5002.robot.replay.ReplayOuterClass.internal_static_team5002_ControlState_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.usfirst.frc.team5002.robot.replay.ReplayOuterClass.internal_static_team5002_ControlState_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.usfirst.frc.team5002.robot.replay.ControlState.class, org.usfirst.frc.team5002.robot.replay.ControlState.Builder.class);
    }

    // Construct using org.usfirst.frc.team5002.robot.replay.ControlState.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      forwardAxis_ = 0D;

      horizontalAxis_ = 0D;

      turnAxis_ = 0D;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.usfirst.frc.team5002.robot.replay.ReplayOuterClass.internal_static_team5002_ControlState_descriptor;
    }

    public org.usfirst.frc.team5002.robot.replay.ControlState getDefaultInstanceForType() {
      return org.usfirst.frc.team5002.robot.replay.ControlState.getDefaultInstance();
    }

    public org.usfirst.frc.team5002.robot.replay.ControlState build() {
      org.usfirst.frc.team5002.robot.replay.ControlState result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public org.usfirst.frc.team5002.robot.replay.ControlState buildPartial() {
      org.usfirst.frc.team5002.robot.replay.ControlState result = new org.usfirst.frc.team5002.robot.replay.ControlState(this);
      result.forwardAxis_ = forwardAxis_;
      result.horizontalAxis_ = horizontalAxis_;
      result.turnAxis_ = turnAxis_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof org.usfirst.frc.team5002.robot.replay.ControlState) {
        return mergeFrom((org.usfirst.frc.team5002.robot.replay.ControlState)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.usfirst.frc.team5002.robot.replay.ControlState other) {
      if (other == org.usfirst.frc.team5002.robot.replay.ControlState.getDefaultInstance()) return this;
      if (other.getForwardAxis() != 0D) {
        setForwardAxis(other.getForwardAxis());
      }
      if (other.getHorizontalAxis() != 0D) {
        setHorizontalAxis(other.getHorizontalAxis());
      }
      if (other.getTurnAxis() != 0D) {
        setTurnAxis(other.getTurnAxis());
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      org.usfirst.frc.team5002.robot.replay.ControlState parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.usfirst.frc.team5002.robot.replay.ControlState) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private double forwardAxis_ ;
    /**
     * <pre>
     * Forward / backward movement axis.
     * </pre>
     *
     * <code>optional double forward_axis = 1;</code>
     */
    public double getForwardAxis() {
      return forwardAxis_;
    }
    /**
     * <pre>
     * Forward / backward movement axis.
     * </pre>
     *
     * <code>optional double forward_axis = 1;</code>
     */
    public Builder setForwardAxis(double value) {
      
      forwardAxis_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Forward / backward movement axis.
     * </pre>
     *
     * <code>optional double forward_axis = 1;</code>
     */
    public Builder clearForwardAxis() {
      
      forwardAxis_ = 0D;
      onChanged();
      return this;
    }

    private double horizontalAxis_ ;
    /**
     * <pre>
     * Left / right strafing axis.
     * </pre>
     *
     * <code>optional double horizontal_axis = 2;</code>
     */
    public double getHorizontalAxis() {
      return horizontalAxis_;
    }
    /**
     * <pre>
     * Left / right strafing axis.
     * </pre>
     *
     * <code>optional double horizontal_axis = 2;</code>
     */
    public Builder setHorizontalAxis(double value) {
      
      horizontalAxis_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Left / right strafing axis.
     * </pre>
     *
     * <code>optional double horizontal_axis = 2;</code>
     */
    public Builder clearHorizontalAxis() {
      
      horizontalAxis_ = 0D;
      onChanged();
      return this;
    }

    private double turnAxis_ ;
    /**
     * <pre>
     * CW / CCW rotation axis.
     * </pre>
     *
     * <code>optional double turn_axis = 3;</code>
     */
    public double getTurnAxis() {
      return turnAxis_;
    }
    /**
     * <pre>
     * CW / CCW rotation axis.
     * </pre>
     *
     * <code>optional double turn_axis = 3;</code>
     */
    public Builder setTurnAxis(double value) {
      
      turnAxis_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * CW / CCW rotation axis.
     * </pre>
     *
     * <code>optional double turn_axis = 3;</code>
     */
    public Builder clearTurnAxis() {
      
      turnAxis_ = 0D;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:team5002.ControlState)
  }

  // @@protoc_insertion_point(class_scope:team5002.ControlState)
  private static final org.usfirst.frc.team5002.robot.replay.ControlState DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.usfirst.frc.team5002.robot.replay.ControlState();
  }

  public static org.usfirst.frc.team5002.robot.replay.ControlState getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ControlState>
      PARSER = new com.google.protobuf.AbstractParser<ControlState>() {
    public ControlState parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ControlState(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ControlState> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ControlState> getParserForType() {
    return PARSER;
  }

  public org.usfirst.frc.team5002.robot.replay.ControlState getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

