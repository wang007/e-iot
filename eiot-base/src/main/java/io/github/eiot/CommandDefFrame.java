package io.github.eiot;



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
