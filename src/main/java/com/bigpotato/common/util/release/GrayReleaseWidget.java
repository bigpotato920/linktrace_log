package com.bigpotato.common.util.release;

/**
 * Created by hjy on 17/12/23.
 */
public class GrayReleaseWidget {
    private String grayReleasePrefix = "";
    private String userIdWhiteList = "";
    private String uuidWhiteList = "";
    private long userId = 0L;
    private String uuid = "";
    private long cityId = 0L;

    public boolean isEffective() {
        return  isWhiteListEffective() || isGrayConditionEffective();
    }

    public boolean isWhiteListEffective() {
        return (isUUIDWhiteListEffective() || isUserIdWhiteListEffective());
    }

    public boolean isGrayConditionEffective() {
        return (isUserIdEffective(userId) &&
                isUUIDEffective(uuid) &&
                isCityIdEffective(cityId));
    }

    public String getGrayReleasePrefix() {
        return grayReleasePrefix;
    }

    public void setGrayReleasePrefix(String grayReleasePrefix) {
        this.grayReleasePrefix = grayReleasePrefix;
    }

    private boolean isUserIdWhiteListEffective() {
        return true;
    }

    private boolean isUUIDWhiteListEffective() {
        return true;
    }


    public GrayReleaseWidget addUserIdWhiteList(String userIdWhiteList) {
        this.userIdWhiteList = userIdWhiteList;
        return this;
    }

    public GrayReleaseWidget addUserIdStrategy(long userId) {
        this.userId = userId;

        return this;
    }

    public GrayReleaseWidget addUUIDStrategy(String uuid) {
        this.uuid = uuid;

        return this;
    }

    public GrayReleaseWidget release(String grayReleasePrefix) {
        this.grayReleasePrefix = grayReleasePrefix;
        return this;
    }

    private boolean isUserIdEffective(long userId) {
        return true;
    }

    private boolean isUUIDEffective(String uuid) {
        return true;
    }

    private boolean isCityIdEffective(long cityId) {
        return true;
    }

    public static void main(String args) {
        GrayReleaseWidget grayReleaseWidget = new GrayReleaseWidget();
        grayReleaseWidget.addUserIdWhiteList("abc|def")
                .addUserIdStrategy(1234L)
                .addUUIDStrategy("0233929abd")
                .release("insurance-gray");

        if (grayReleaseWidget.isEffective()) {
            System.out.println("....");
        }
    }
}
