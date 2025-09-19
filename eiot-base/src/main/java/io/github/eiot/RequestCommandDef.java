package io.github.eiot;

/**
 * created by wang007 on 2025/9/19
 */
public interface RequestCommandDef<Req, Resp> extends CommandDef<Req> {

    /**
     * @return If no response frame exists, return null.
     */
    CommandDef<Resp> responseType();
}
