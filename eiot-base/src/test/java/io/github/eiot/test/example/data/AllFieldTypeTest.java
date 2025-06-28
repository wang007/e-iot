package io.github.eiot.test.example.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import io.github.eiot.annotation.FrameFieldDynamics;
import io.github.eiot.annotation.FrameFieldLoop;
import io.github.eiot.codec.*;
import java.util.List;

/**
 * created by wang007 on 2025/5/25
 */
@Frame(withContext = true)
public class AllFieldTypeTest {

    @FrameField(len = 8)
    private Ascii asciiTest;

    @FrameField(len = 4)
    private BCD bcdTest;

    @FrameField(len = 2)
    private int bin4Test;

    @FrameField(len = 6)
    private long bin8Test;

    @FrameField(len = 2, intoContext = true)
    private int bytesLen;

    @FrameField(lenByField = "bytesLen")
    private byte[] bytesTest;

    @FrameField
    private BCDTime bcdTimeTest;

    @FrameField(len = 2)
    private Hex hexTest;

    @FrameField(len = 2, unit = 100)
    private BCDNumber bcdNumberTest;

    @FrameField(len = 4, unit = 100, offset = -500)
    private OffsetBCDNumber offsetBCDNumberTest;

    @FrameField(len = 4, unit = 1000)
    private NumberUnit numberUnitTest;

    @FrameField(len = 6, unit = 10000, offset = 1000)
    private OffsetNumberUnit offsetNumberUnitTest;

    @FrameField(len = 1, intoContext = true)
    private int count;

    @FrameFieldLoop(loopByField = "count", frameField = @FrameField(len = 4))
    private List<Integer> numList;

    @FrameFieldLoop(loopByField = "count", frameField = @FrameField(len = 10))
    private List<Ascii> stringList;

    @FrameFieldDynamics(isLast = true)
    private ByteBufRef reversed;

    /**
     * getter auto generated
     */
    public Ascii getAsciiTest() {
        return asciiTest;
    }

    /**
     * setter auto generated
     */
    public void setAsciiTest(Ascii asciiTest) {
        this.asciiTest = asciiTest;
    }

    /**
     * setter auto generated
     */
    public void setAsciiTest(String asciiTest) {
        io.github.eiot.utils.ValidationUtil.lteLen(asciiTest, 8, asciiTest);
        this.asciiTest = Ascii.from(asciiTest, 8);
    }

    /**
     * getter auto generated
     */
    public BCD getBcdTest() {
        return bcdTest;
    }

    /**
     * setter auto generated
     */
    public void setBcdTest(BCD bcdTest) {
        this.bcdTest = bcdTest;
    }

    /**
     * setter auto generated
     */
    public void setBcdTest(String bcdTest) {
        io.github.eiot.utils.ValidationUtil.lteLen(bcdTest, 8, bcdTest);
        this.bcdTest = BCD.from(bcdTest, 8);
    }

    /**
     * getter auto generated
     */
    public BCDNumber getBcdNumberTest() {
        return bcdNumberTest;
    }

    /**
     * setter auto generated
     */
    public void setBcdNumberTest(BCDNumber bcdNumberTest) {
        this.bcdNumberTest = bcdNumberTest;
    }

    /**
     * setter auto generated
     */
    public void setBcdNumberTest(double bcdNumberTest) {
        this.bcdNumberTest = BCDNumber.from(bcdNumberTest, 100,4);
    }

    /**
     * getter auto generated
     */
    public int getBin4Test() {
        return bin4Test;
    }

    /**
     * setter auto generated
     */
    public void setBin4Test(int bin4Test) {
        this.bin4Test = bin4Test;
    }

    /**
     * getter auto generated
     */
    public long getBin8Test() {
        return bin8Test;
    }

    /**
     * setter auto generated
     */
    public void setBin8Test(long bin8Test) {
        this.bin8Test = bin8Test;
    }

    /**
     * getter auto generated
     */
    public int getBytesLen() {
        return bytesLen;
    }

    /**
     * setter auto generated
     */
    public void setBytesLen(int bytesLen) {
        this.bytesLen = bytesLen;
    }

    /**
     * getter auto generated
     */
    public byte[] getBytesTest() {
        return bytesTest;
    }

    /**
     * setter auto generated
     */
    public void setBytesTest(byte[] bytesTest) {
        this.bytesTest = bytesTest;
    }

    /**
     * getter auto generated
     */
    public BCDTime getBcdTimeTest() {
        return bcdTimeTest;
    }

    /**
     * setter auto generated
     */
    public void setBcdTimeTest(BCDTime bcdTimeTest) {
        this.bcdTimeTest = bcdTimeTest;
    }

    /**
     * getter auto generated
     */
    public Hex getHexTest() {
        return hexTest;
    }

    /**
     * setter auto generated
     */
    public void setHexTest(Hex hexTest) {
        this.hexTest = hexTest;
    }

    /**
     * setter auto generated
     */
    public void setHexTest(String hexTest) {
        io.github.eiot.utils.ValidationUtil.lteLen(hexTest, 4, hexTest);
        this.hexTest = Hex.from(hexTest, 4);
    }

    /**
     * getter auto generated
     */
    public OffsetBCDNumber getOffsetBCDNumberTest() {
        return offsetBCDNumberTest;
    }

    /**
     * setter auto generated
     */
    public void setOffsetBCDNumberTest(OffsetBCDNumber offsetBCDNumberTest) {
        this.offsetBCDNumberTest = offsetBCDNumberTest;
    }

    /**
     * setter auto generated
     */
    public void setOffsetBCDNumberTest(double offsetBCDNumberTest) {
        this.offsetBCDNumberTest = OffsetBCDNumber.from(offsetBCDNumberTest, 100, -500, false, 8);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getNumberUnitTest() {
        return numberUnitTest;
    }

    /**
     * setter auto generated
     */
    public void setNumberUnitTest(NumberUnit numberUnitTest) {
        this.numberUnitTest = numberUnitTest;
    }

    /**
     * setter auto generated
     */
    public void setNumberUnitTest(double numberUnitTest) {
        this.numberUnitTest = NumberUnit.from(numberUnitTest, 1000);
    }

    /**
     * getter auto generated
     */
    public OffsetNumberUnit getOffsetNumberUnitTest() {
        return offsetNumberUnitTest;
    }

    /**
     * setter auto generated
     */
    public void setOffsetNumberUnitTest(OffsetNumberUnit offsetNumberUnitTest) {
        this.offsetNumberUnitTest = offsetNumberUnitTest;
    }

    /**
     * setter auto generated
     */
    public void setOffsetNumberUnitTest(double offsetNumberUnitTest) {
        this.offsetNumberUnitTest = OffsetNumberUnit.from(offsetNumberUnitTest, 10000, 1000, false);
    }

    /**
     * getter auto generated
     */
    public int getCount() {
        return count;
    }

    /**
     * setter auto generated
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * getter auto generated
     */
    public List<Integer> getNumList() {
        return numList;
    }

    /**
     * setter auto generated
     */
    public void setNumList(List<Integer> numList) {
        this.numList = numList;
    }

    /**
     * getter auto generated
     */
    public List<Ascii> getStringList() {
        return stringList;
    }

    /**
     * setter auto generated
     */
    public void setStringList(List<Ascii> stringList) {
        this.stringList = stringList;
    }

    /**
     * getter auto generated
     */
    public ByteBufRef getReversed() {
        return reversed;
    }

    /**
     * setter auto generated
     */
    public void setReversed(ByteBufRef reversed) {
        this.reversed = reversed;
    }
}
