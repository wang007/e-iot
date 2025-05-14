package io.github.eiot.ocpp;

/**
 * created by wang007 on 2025/4/14
 */
public enum OcppVersion {

    OCPP1_6J("ocpp1.6", false, false),

    OCPP2_0_1("ocpp2.0.1", false, false),

    OCPP2_1("ocpp2.1", true, true),
    ;
    public final String versionName;

    private final boolean supportSend;
    private final boolean supportResultError;

    OcppVersion(String versionName, boolean supportSend, boolean supportResultError) {
        this.versionName = versionName;
        this.supportSend = supportSend;
        this.supportResultError = supportResultError;
    }

    /**
     * NOTE: only ocpp2.1 or later support to send frame
     *
     * @return whether support write {@link MessageTypeId#SEND} frame
     */
    public boolean supportSend() {
        return this.supportSend;
    }

    /**
     * NOTE: only ocpp2.1 or later support to send frame
     *
     * @return whether support write {@link MessageTypeId#CALLRESULTERROR} frame
     */
    public boolean supportResultError() {
        return this.supportResultError;
    }

    public static OcppVersion match(String protocol) {
        if (protocol == null) {
            return null;
        }
        for (OcppVersion value : values()) {
            if (value.versionName.equals(protocol)) {
                return value;
            }
        }
        return null;
    }


}
