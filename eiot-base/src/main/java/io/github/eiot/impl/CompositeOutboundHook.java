package io.github.eiot.impl;

import io.github.eiot.Frame;
import io.github.eiot.OutboundHook;
import io.github.eiot.RequestFrame;
import io.vertx.core.Future;

import java.util.ArrayList;
import java.util.List;

/**
 * created by wang007 on 2025/5/8
 */
public class CompositeOutboundHook implements OutboundHook {

    private static final String BEFORE_REQ_IDX_KEY = "__before_r_idx";

    private static final String BEFORE_WR_IDX_KEY = "__before_w_idx";

    private final List<OutboundHook> hooks;

    public CompositeOutboundHook(OutboundHook[] hooks) {
        List<OutboundHook> list = new ArrayList<>(hooks.length);
        for (OutboundHook hook : hooks) {
            if (hook instanceof CompositeOutboundHook) {
                list.addAll(((CompositeOutboundHook) hook).getHooks());
            } else {
                list.add(hook);
            }
        }
        this.hooks = list;
    }

    public List<OutboundHook> getHooks() {
        return hooks;
    }

    @Override
    public Future<RequestFrame<?, Frame<?>>> beforeRequest(RequestFrame<?, Frame<?>> frame) {
        Integer idx = frame.get(BEFORE_REQ_IDX_KEY, 0);
        if (idx >= hooks.size()) {
            return Future.succeededFuture(frame);
        }
        frame.put(BEFORE_REQ_IDX_KEY, idx + 1);
        return hooks.get(idx).beforeRequest(frame)
                .flatMap(this::beforeRequest);
    }

    @Override
    public Future<Frame<?>> beforeWrite(Frame<?> frame) {
        Integer idx = frame.get(BEFORE_WR_IDX_KEY, 0);
        if (idx >= hooks.size()) {
            return Future.succeededFuture(frame);
        }
        frame.put(BEFORE_WR_IDX_KEY, idx + 1);
        return hooks.get(idx).beforeWrite(frame)
                .flatMap(this::beforeWrite);
    }
}