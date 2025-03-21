package io.github.eiot.charge.ykc.data;


import io.github.eiot.charge.annotation.Frame;
import io.github.eiot.charge.annotation.FrameField;
import io.github.eiot.charge.codec.Ascii;
import io.github.eiot.charge.codec.BCD;
import io.github.eiot.charge.codec.NumberUnit;
import lombok.Data;
import lombok.ToString;

/**
 * 充电握手 0x15
 *
 * BMS 相关
 *
 * @author yan
 * @since 2024-11-18
 */
@ToString(callSuper = true)
@Data
@Frame
public class YkcBmsShake {

    /**
     * 交易流水号 BCD 码 16 见名词解释
     */
    @FrameField(len = 16)
    private BCD orderNo;

    /**
     * 桩编码 BCD 码 7byte
     */
    @FrameField(len = 7)
    private BCD terminalNo;

    /**
     * 枪号 BCD 码 1
     */
    @FrameField(len = 1)
    private int gunNo;

    /**
     * bms通信协议版本号
     * 当前版本为 V1.1，表示为：byte3，
     * byte2—0001H；
     * byte1—01H
     */
    @FrameField(len = 3)
    private byte[] bmsProtocolVersion;

    /**
     * bms电池类型
     * 01H:铅酸电池;
     * 02H:氢电池;
     * 03H:磷酸铁锂电池;
     * 04H:锰酸锂电池;
     * 05H:钴酸锂电池;
     * 06H:三元材料电池;
     * 07H:聚合物锂离子电池;
     * 08H:钛酸锂电池;
     * FFH:其他;
     */
    @FrameField(len = 1)
    private int bmsType;

    /**
     * BMS 整车动力蓄电池系统额定容量
     *
     * 0.1 Ah /位，0 Ah 偏移量
     */
    @FrameField(len = 2, unit = 10)
    private NumberUnit ratedCapacity;

    /**
     * BMS 整车动力蓄电池系统额定总电压
     * 0.1V/位，0V 偏移量
     */
    @FrameField(len = 2, unit = 10)
    private NumberUnit ratedV;

    /**
     * BMS 电池组序号
     */
    @FrameField(len = 4)
    private Ascii manufacturer;

    /**
     * 电池组序号
     */
    @FrameField(len = 4)
    private BCD bmsSn;

    /**
     * BMS 电池组生产日期年
     * 1985 年偏移量，数据范围：1985～2235 年
     */
    @FrameField(len = 1)
    private int productionYear;

    /**
     * 电池生产月
     */
    @FrameField(len = 1)
    private int productionMonth;

    /**
     * 电池生产日
     */
    @FrameField(len = 1)
    private int productionDay;

    /**
     * 电池充电次数
     */
    @FrameField(len = 3)
    private int chargeCount;

    /**
     * BMS电池组产权标识
     * 0：租赁
     * 1：车自有
     */
    @FrameField(len = 1)
    private int owner;

    /**
     * 预留
     */
    @FrameField(len = 1)
    private int reverse1;

    /**
     * vin码
     */
    @FrameField(len = 17)
    private Ascii vin;

    /**
     * TODO 使用 SubByte
     *
     * BMS 软件版本号
     * Byte8、byte7、byte6—000001H～FFFFFEH，预留，填 FFFFFFH；
     * Byte5-byte2 作为 BMS 软件版本编译时间信息标记，
     * -Byte5，byte4—0001H～FFFEH 表示“年”（例如 2015 年：填写Byte5—DFH， byte4—07H）；
     * -Byte3—01H～0CH 表示“月”（例如 11 月：填写 Byte3—0BH）；
     * -Byte2—01H～1FH 表示“日”（例如 10 日：填写 Byte2—0AH）；
     * Byte1—01H～FEH 表示版本流水号（例如 16：填写 Byte1—10H）
     */
    @FrameField(len = 8)
    private byte[] bmsSoftVersion;
}
