package io.github.eiot.impl;


import io.github.eiot.CommandDef;
import io.github.eiot.Frame;

/**
 * created by wang007 on 2025/5/8
 */
public interface CommandDefFrame<T> extends Frame<T> {

    /**
     *
     * @return the commandDef
     */
    CommandDef<T> commandDef();

}
