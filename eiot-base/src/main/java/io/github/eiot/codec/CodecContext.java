package io.github.eiot.codec;

import io.github.eiot.AttributeHolder;

import java.util.Collections;
import java.util.Map;

/**
 * The codec context is used to transmit information during the codec process
 *
 * created by wang007 on 2025/2/25
 */
public interface CodecContext extends AttributeHolder {

    String DATA_LEN_KEY = "_data_len";

    CodecContext EMPTY = new CodecContext() {
        @Override
        public CodecContext put(String key, Object obj) {
            return null;
        }

        @Override
        public <T> T get(String key) {
            return null;
        }

        @Override
        public <T> T get(String key, T defaultValue) {
            return null;
        }

        @Override
        public <T> T remove(String key) {
            return null;
        }

        @Override
        public Map<String, Object> attributes() {
            return Collections.emptyMap();
        }
    };
}
