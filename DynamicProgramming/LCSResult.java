package DynamicProgramming;

public class LCSResult {
    private  String LCSString;
    private int LCSLength;

    public LCSResult(String LCSString, int LCSLength) {
        this.LCSString = LCSString;

        this.LCSLength = LCSLength;
    }

    public String getLCSString() {
        return LCSString;
    }

    public void setLCSString(String LCSString) {
        this.LCSString = LCSString;
    }

    public int getLCSLength() {
        return LCSLength;
    }

    public void setLCSLength(int LCSLength) {
        this.LCSLength = LCSLength;
    }
}
