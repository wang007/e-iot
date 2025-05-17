package io.github.eiot.ocpp;

/**
 * created by wang007 on 2025/4/14
 */
public enum OcppVersion {

    OCPP1_6J("ocpp1.6", 1),

    OCPP2_0_1("ocpp2.0.1", 2),

    OCPP2_1("ocpp2.1", 3),
    ;
    public final String versionName;
    public final int versionLevel;

    OcppVersion(String versionName, int versionLevel) {
        this.versionName = versionName;
        this.versionLevel = versionLevel;
    }

    /**
     * NOTE: only ocpp2.1 or later support to send frame
     *
     * @return whether support write {@link MessageTypeId#SEND} frame
     */
    public boolean supportSend() {
        return this.versionLevel >= 3;
    }

    /**
     * NOTE: only ocpp2.1 or later support to send frame
     *
     * @return whether support write {@link MessageTypeId#CALLRESULTERROR} frame
     */
    public boolean supportResultError() {
        return this.versionLevel >= 3;
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
