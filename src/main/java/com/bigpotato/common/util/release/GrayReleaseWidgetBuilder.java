package com.bigpotato.common.util.release;

/**
 * Created by hjy on 17/12/23.
 */
public class GrayReleaseWidgetBuilder {
    public GrayReleaseWidget build(String grayReleasePrefix) {
        GrayReleaseWidget grayReleaseWidget = new GrayReleaseWidget();
        grayReleaseWidget
    }

    public static GrayReleaseWidgetBuilder getInstance() {
        return new GrayReleaseWidgetBuilder();
    }


    public static void main(String args) {
        GrayReleaseWidgetBuilder grayReleaseWidgetBuilder = GrayReleaseWidgetBuilder.getInstance();

        grayReleaseWidgetBuilder.build()
    }

}
