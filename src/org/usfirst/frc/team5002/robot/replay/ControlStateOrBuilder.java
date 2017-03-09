// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: replay.proto

package org.usfirst.frc.team5002.robot.replay;

public interface ControlStateOrBuilder extends
    // @@protoc_insertion_point(interface_extends:team5002.ControlState)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Forward / backward movement axis.
   * </pre>
   *
   * <code>optional double forward_axis = 1;</code>
   */
  double getForwardAxis();

  /**
   * <pre>
   * Left / right strafing axis.
   * </pre>
   *
   * <code>optional double horizontal_axis = 2;</code>
   */
  double getHorizontalAxis();

  /**
   * <pre>
   * CW / CCW rotation axis.
   * </pre>
   *
   * <code>optional double turn_axis = 3;</code>
   */
  double getTurnAxis();

  /**
   * <pre>
   * Button ID = 1
   * </pre>
   *
   * <code>optional bool button_A = 4;</code>
   */
  boolean getButtonA();

  /**
   * <pre>
   * Button ID = 2
   * </pre>
   *
   * <code>optional bool button_B = 5;</code>
   */
  boolean getButtonB();

  /**
   * <pre>
   * Button ID = 3
   * </pre>
   *
   * <code>optional bool button_X = 6;</code>
   */
  boolean getButtonX();

  /**
   * <pre>
   * Button ID = 4
   * </pre>
   *
   * <code>optional bool button_Y = 7;</code>
   */
  boolean getButtonY();

  /**
   * <pre>
   * Button ID = 5
   * </pre>
   *
   * <code>optional bool button_LB = 8;</code>
   */
  boolean getButtonLB();

  /**
   * <pre>
   * Button ID = 6
   * </pre>
   *
   * <code>optional bool button_RB = 9;</code>
   */
  boolean getButtonRB();

  /**
   * <pre>
   * Button ID = 7
   * </pre>
   *
   * <code>optional bool button_home = 10;</code>
   */
  boolean getButtonHome();

  /**
   * <pre>
   * Button ID = 8
   * </pre>
   *
   * <code>optional bool button_menu = 11;</code>
   */
  boolean getButtonMenu();

  /**
   * <pre>
   * Button ID = 7 (alias of menu?)
   * </pre>
   *
   * <code>optional bool toggle_FOC = 12;</code>
   */
  boolean getToggleFOC();

  /**
   * <pre>
   * button ID = 10 (left paddle)
   * </pre>
   *
   * <code>optional bool activate_low_speed = 13;</code>
   */
  boolean getActivateLowSpeed();

  /**
   * <pre>
   * button ID = 11 (right paddle)
   * </pre>
   *
   * <code>optional bool activate_high_speed = 14;</code>
   */
  boolean getActivateHighSpeed();
}
