package io.github.eiot.charge;

import java.util.function.Function;

/**
 * frame translation.
 * raw frame: The data field is still byte[], and the other fields are already parsed.
 * Converts a raw frame into a frame of a specific type.
 *
 * created by wang007 on 2025/2/25
 */
public interface FrameConverter extends Function<Frame<?>, Frame<?>> {

    /**
     * Converts a raw frame into a frame of a specific type
     *
     * @param frame raw frame
     * @return The concrete type of frame
     */
    @Override
    Frame<?> apply(Frame<?> frame);
}
