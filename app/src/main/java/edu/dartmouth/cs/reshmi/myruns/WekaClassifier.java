package edu.dartmouth.cs.reshmi.myruns;

/**
 * Created by reshmi on 5/10/16.
 */
class WekaClassifier {

    public static double classify(Object[] i)
            throws Exception {

        double p = Double.NaN;
        p = WekaClassifier.N26857ff50(i);
        return p;
    }
    static double N26857ff50(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 334.416259) {
            p = WekaClassifier.N79b4154b1(i);
        } else if (((Double) i[0]).doubleValue() > 334.416259) {
            p = WekaClassifier.N3e36cff634(i);
        }
        return p;
    }
    static double N79b4154b1(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 53.486098) {
            p = WekaClassifier.N427a8ad52(i);
        } else if (((Double) i[0]).doubleValue() > 53.486098) {
            p = WekaClassifier.N7e7df0af8(i);
        }
        return p;
    }
    static double N427a8ad52(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 29.523031) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() > 29.523031) {
            p = WekaClassifier.Nc5560743(i);
        }
        return p;
    }
    static double Nc5560743(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 2;
        } else if (((Double) i[2]).doubleValue() <= 2.846002) {
            p = WekaClassifier.N122dcdc4(i);
        } else if (((Double) i[2]).doubleValue() > 2.846002) {
            p = WekaClassifier.N58e59ffe5(i);
        }
        return p;
    }
    static double N122dcdc4(Object []i) {
        double p = Double.NaN;
        if (i[7] == null) {
            p = 2;
        } else if (((Double) i[7]).doubleValue() <= 0.769224) {
            p = 2;
        } else if (((Double) i[7]).doubleValue() > 0.769224) {
            p = 0;
        }
        return p;
    }
    static double N58e59ffe5(Object []i) {
        double p = Double.NaN;
        if (i[21] == null) {
            p = 0;
        } else if (((Double) i[21]).doubleValue() <= 0.844331) {
            p = WekaClassifier.N4e5f9a156(i);
        } else if (((Double) i[21]).doubleValue() > 0.844331) {
            p = 1;
        }
        return p;
    }
    static double N4e5f9a156(Object []i) {
        double p = Double.NaN;
        if (i[29] == null) {
            p = 0;
        } else if (((Double) i[29]).doubleValue() <= 0.39355) {
            p = 0;
        } else if (((Double) i[29]).doubleValue() > 0.39355) {
            p = WekaClassifier.N692e156a7(i);
        }
        return p;
    }
    static double N692e156a7(Object []i) {
        double p = Double.NaN;
        if (i[15] == null) {
            p = 1;
        } else if (((Double) i[15]).doubleValue() <= 0.594228) {
            p = 1;
        } else if (((Double) i[15]).doubleValue() > 0.594228) {
            p = 0;
        }
        return p;
    }
    static double N7e7df0af8(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 77.005225) {
            p = WekaClassifier.Na138af19(i);
        } else if (((Double) i[0]).doubleValue() > 77.005225) {
            p = WekaClassifier.N35c9eea816(i);
        }
        return p;
    }
    static double Na138af19(Object []i) {
        double p = Double.NaN;
        if (i[17] == null) {
            p = 1;
        } else if (((Double) i[17]).doubleValue() <= 1.46667) {
            p = WekaClassifier.N38ae369410(i);
        } else if (((Double) i[17]).doubleValue() > 1.46667) {
            p = 2;
        }
        return p;
    }
    static double N38ae369410(Object []i) {
        double p = Double.NaN;
        if (i[22] == null) {
            p = 2;
        } else if (((Double) i[22]).doubleValue() <= 0.16115) {
            p = 2;
        } else if (((Double) i[22]).doubleValue() > 0.16115) {
            p = WekaClassifier.N21b2f1ae11(i);
        }
        return p;
    }
    static double N21b2f1ae11(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 2;
        } else if (((Double) i[1]).doubleValue() <= 4.631981) {
            p = 2;
        } else if (((Double) i[1]).doubleValue() > 4.631981) {
            p = WekaClassifier.N30db95bf12(i);
        }
        return p;
    }
    static double N30db95bf12(Object []i) {
        double p = Double.NaN;
        if (i[15] == null) {
            p = 0;
        } else if (((Double) i[15]).doubleValue() <= 0.319278) {
            p = 0;
        } else if (((Double) i[15]).doubleValue() > 0.319278) {
            p = WekaClassifier.N2609d55713(i);
        }
        return p;
    }
    static double N2609d55713(Object []i) {
        double p = Double.NaN;
        if (i[19] == null) {
            p = 1;
        } else if (((Double) i[19]).doubleValue() <= 0.922241) {
            p = WekaClassifier.N6f5a4d9414(i);
        } else if (((Double) i[19]).doubleValue() > 0.922241) {
            p = WekaClassifier.N5953ee5015(i);
        }
        return p;
    }
    static double N6f5a4d9414(Object []i) {
        double p = Double.NaN;
        if (i[7] == null) {
            p = 0;
        } else if (((Double) i[7]).doubleValue() <= 0.46238) {
            p = 0;
        } else if (((Double) i[7]).doubleValue() > 0.46238) {
            p = 1;
        }
        return p;
    }
    static double N5953ee5015(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 3;
        } else if (((Double) i[0]).doubleValue() <= 60.219961) {
            p = 3;
        } else if (((Double) i[0]).doubleValue() > 60.219961) {
            p = 0;
        }
        return p;
    }
    static double N35c9eea816(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() <= 65.955383) {
            p = WekaClassifier.N5d82262b17(i);
        } else if (((Double) i[1]).doubleValue() > 65.955383) {
            p = WekaClassifier.N2bdca53f29(i);
        }
        return p;
    }
    static double N5d82262b17(Object []i) {
        double p = Double.NaN;
        if (i[13] == null) {
            p = 1;
        } else if (((Double) i[13]).doubleValue() <= 5.401864) {
            p = WekaClassifier.N6089e6e218(i);
        } else if (((Double) i[13]).doubleValue() > 5.401864) {
            p = WekaClassifier.N5e2e298325(i);
        }
        return p;
    }
    static double N6089e6e218(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 258.286966) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() > 258.286966) {
            p = WekaClassifier.N26eeb5cd19(i);
        }
        return p;
    }
    static double N26eeb5cd19(Object []i) {
        double p = Double.NaN;
        if (i[29] == null) {
            p = 1;
        } else if (((Double) i[29]).doubleValue() <= 0.331798) {
            p = WekaClassifier.N5c28b31620(i);
        } else if (((Double) i[29]).doubleValue() > 0.331798) {
            p = WekaClassifier.N105765c621(i);
        }
        return p;
    }
    static double N5c28b31620(Object []i) {
        double p = Double.NaN;
        if (i[16] == null) {
            p = 1;
        } else if (((Double) i[16]).doubleValue() <= 1.044197) {
            p = 1;
        } else if (((Double) i[16]).doubleValue() > 1.044197) {
            p = 2;
        }
        return p;
    }
    static double N105765c621(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 1;
        } else if (((Double) i[3]).doubleValue() <= 36.713101) {
            p = WekaClassifier.N3f462fd822(i);
        } else if (((Double) i[3]).doubleValue() > 36.713101) {
            p = 1;
        }
        return p;
    }
    static double N3f462fd822(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() <= 36.92314) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() > 36.92314) {
            p = WekaClassifier.N6cd5a52023(i);
        }
        return p;
    }
    static double N6cd5a52023(Object []i) {
        double p = Double.NaN;
        if (i[20] == null) {
            p = 1;
        } else if (((Double) i[20]).doubleValue() <= 1.836354) {
            p = WekaClassifier.N75fc1baf24(i);
        } else if (((Double) i[20]).doubleValue() > 1.836354) {
            p = 3;
        }
        return p;
    }
    static double N75fc1baf24(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 3;
        } else if (((Double) i[2]).doubleValue() <= 28.457266) {
            p = 3;
        } else if (((Double) i[2]).doubleValue() > 28.457266) {
            p = 1;
        }
        return p;
    }
    static double N5e2e298325(Object []i) {
        double p = Double.NaN;
        if (i[24] == null) {
            p = 3;
        } else if (((Double) i[24]).doubleValue() <= 3.466796) {
            p = WekaClassifier.N5098f57126(i);
        } else if (((Double) i[24]).doubleValue() > 3.466796) {
            p = WekaClassifier.N11a5b6e727(i);
        }
        return p;
    }
    static double N5098f57126(Object []i) {
        double p = Double.NaN;
        if (i[24] == null) {
            p = 3;
        } else if (((Double) i[24]).doubleValue() <= 2.354865) {
            p = 3;
        } else if (((Double) i[24]).doubleValue() > 2.354865) {
            p = 2;
        }
        return p;
    }
    static double N11a5b6e727(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() <= 18.317111) {
            p = WekaClassifier.N491f61f28(i);
        } else if (((Double) i[4]).doubleValue() > 18.317111) {
            p = 1;
        }
        return p;
    }
    static double N491f61f28(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() <= 16.867949) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() > 16.867949) {
            p = 3;
        }
        return p;
    }
    static double N2bdca53f29(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 3;
        } else if (((Double) i[4]).doubleValue() <= 20.288095) {
            p = WekaClassifier.N3cf8ee4830(i);
        } else if (((Double) i[4]).doubleValue() > 20.288095) {
            p = 1;
        }
        return p;
    }
    static double N3cf8ee4830(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 234.496166) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() > 234.496166) {
            p = WekaClassifier.Nd675be31(i);
        }
        return p;
    }
    static double Nd675be31(Object []i) {
        double p = Double.NaN;
        if (i[10] == null) {
            p = 3;
        } else if (((Double) i[10]).doubleValue() <= 6.97438) {
            p = WekaClassifier.Nb7c5ab532(i);
        } else if (((Double) i[10]).doubleValue() > 6.97438) {
            p = 1;
        }
        return p;
    }
    static double Nb7c5ab532(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 3;
        } else if (((Double) i[3]).doubleValue() <= 29.221396) {
            p = 3;
        } else if (((Double) i[3]).doubleValue() > 29.221396) {
            p = WekaClassifier.N4547e3b833(i);
        }
        return p;
    }
    static double N4547e3b833(Object []i) {
        double p = Double.NaN;
        if (i[12] == null) {
            p = 1;
        } else if (((Double) i[12]).doubleValue() <= 3.308217) {
            p = 1;
        } else if (((Double) i[12]).doubleValue() > 3.308217) {
            p = 3;
        }
        return p;
    }
    static double N3e36cff634(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 3;
        } else if (((Double) i[4]).doubleValue() <= 45.963584) {
            p = WekaClassifier.Ndfe260b35(i);
        } else if (((Double) i[4]).doubleValue() > 45.963584) {
            p = WekaClassifier.N14e14b57(i);
        }
        return p;
    }
    static double Ndfe260b35(Object []i) {
        double p = Double.NaN;
        if (i[7] == null) {
            p = 3;
        } else if (((Double) i[7]).doubleValue() <= 28.499761) {
            p = WekaClassifier.N643e7cf336(i);
        } else if (((Double) i[7]).doubleValue() > 28.499761) {
            p = WekaClassifier.N25f4b9c255(i);
        }
        return p;
    }
    static double N643e7cf336(Object []i) {
        double p = Double.NaN;
        if (i[6] == null) {
            p = 3;
        } else if (((Double) i[6]).doubleValue() <= 30.640107) {
            p = WekaClassifier.N1e1e09ef37(i);
        } else if (((Double) i[6]).doubleValue() > 30.640107) {
            p = WekaClassifier.N79971dd054(i);
        }
        return p;
    }
    static double N1e1e09ef37(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 3;
        } else if (((Double) i[0]).doubleValue() <= 381.511925) {
            p = WekaClassifier.N165f3ca538(i);
        } else if (((Double) i[0]).doubleValue() > 381.511925) {
            p = WekaClassifier.N6d834cae45(i);
        }
        return p;
    }
    static double N165f3ca538(Object []i) {
        double p = Double.NaN;
        if (i[10] == null) {
            p = 3;
        } else if (((Double) i[10]).doubleValue() <= 12.23912) {
            p = WekaClassifier.N6a6d8e1b39(i);
        } else if (((Double) i[10]).doubleValue() > 12.23912) {
            p = 2;
        }
        return p;
    }
    static double N6a6d8e1b39(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() <= 64.058595) {
            p = WekaClassifier.N7d23ae4140(i);
        } else if (((Double) i[1]).doubleValue() > 64.058595) {
            p = WekaClassifier.N7cc93db942(i);
        }
        return p;
    }
    static double N7d23ae4140(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 2;
        } else if (((Double) i[5]).doubleValue() <= 8.389774) {
            p = 2;
        } else if (((Double) i[5]).doubleValue() > 8.389774) {
            p = WekaClassifier.N139c817b41(i);
        }
        return p;
    }
    static double N139c817b41(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 3;
        } else if (((Double) i[3]).doubleValue() <= 26.58329) {
            p = 3;
        } else if (((Double) i[3]).doubleValue() > 26.58329) {
            p = 1;
        }
        return p;
    }
    static double N7cc93db942(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 3;
        } else if (((Double) i[3]).doubleValue() <= 53.57491) {
            p = WekaClassifier.N7a52796d43(i);
        } else if (((Double) i[3]).doubleValue() > 53.57491) {
            p = 1;
        }
        return p;
    }
    static double N7a52796d43(Object []i) {
        double p = Double.NaN;
        if (i[18] == null) {
            p = 3;
        } else if (((Double) i[18]).doubleValue() <= 1.726039) {
            p = WekaClassifier.N1a6391c044(i);
        } else if (((Double) i[18]).doubleValue() > 1.726039) {
            p = 3;
        }
        return p;
    }
    static double N1a6391c044(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 3;
        } else if (((Double) i[5]).doubleValue() <= 7.942555) {
            p = 3;
        } else if (((Double) i[5]).doubleValue() > 7.942555) {
            p = 2;
        }
        return p;
    }
    static double N6d834cae45(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 3;
        } else if (((Double) i[3]).doubleValue() <= 72.595079) {
            p = WekaClassifier.N5892805246(i);
        } else if (((Double) i[3]).doubleValue() > 72.595079) {
            p = WekaClassifier.N54159d8453(i);
        }
        return p;
    }
    static double N5892805246(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 3;
        } else if (((Double) i[1]).doubleValue() <= 109.183008) {
            p = WekaClassifier.N3162133c47(i);
        } else if (((Double) i[1]).doubleValue() > 109.183008) {
            p = WekaClassifier.N2d9e242451(i);
        }
        return p;
    }
    static double N3162133c47(Object []i) {
        double p = Double.NaN;
        if (i[7] == null) {
            p = 3;
        } else if (((Double) i[7]).doubleValue() <= 19.079798) {
            p = WekaClassifier.N3709794148(i);
        } else if (((Double) i[7]).doubleValue() > 19.079798) {
            p = 2;
        }
        return p;
    }
    static double N3709794148(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 3;
        } else if (((Double) i[3]).doubleValue() <= 49.106875) {
            p = WekaClassifier.N4018a53249(i);
        } else if (((Double) i[3]).doubleValue() > 49.106875) {
            p = 2;
        }
        return p;
    }
    static double N4018a53249(Object []i) {
        double p = Double.NaN;
        if (i[6] == null) {
            p = 3;
        } else if (((Double) i[6]).doubleValue() <= 18.602429) {
            p = 3;
        } else if (((Double) i[6]).doubleValue() > 18.602429) {
            p = WekaClassifier.Ncc43d7350(i);
        }
        return p;
    }
    static double Ncc43d7350(Object []i) {
        double p = Double.NaN;
        if (i[64] == null) {
            p = 2;
        } else if (((Double) i[64]).doubleValue() <= 16.037809) {
            p = 2;
        } else if (((Double) i[64]).doubleValue() > 16.037809) {
            p = 3;
        }
        return p;
    }
    static double N2d9e242451(Object []i) {
        double p = Double.NaN;
        if (i[10] == null) {
            p = 3;
        } else if (((Double) i[10]).doubleValue() <= 15.1153) {
            p = 3;
        } else if (((Double) i[10]).doubleValue() > 15.1153) {
            p = WekaClassifier.N512193a752(i);
        }
        return p;
    }
    static double N512193a752(Object []i) {
        double p = Double.NaN;
        if (i[6] == null) {
            p = 2;
        } else if (((Double) i[6]).doubleValue() <= 18.997068) {
            p = 2;
        } else if (((Double) i[6]).doubleValue() > 18.997068) {
            p = 3;
        }
        return p;
    }
    static double N54159d8453(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 2;
        } else if (((Double) i[0]).doubleValue() <= 673.796307) {
            p = 2;
        } else if (((Double) i[0]).doubleValue() > 673.796307) {
            p = 3;
        }
        return p;
    }
    static double N79971dd054(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 2;
        } else if (((Double) i[0]).doubleValue() <= 893.311978) {
            p = 2;
        } else if (((Double) i[0]).doubleValue() > 893.311978) {
            p = 3;
        }
        return p;
    }
    static double N25f4b9c255(Object []i) {
        double p = Double.NaN;
        if (i[30] == null) {
            p = 2;
        } else if (((Double) i[30]).doubleValue() <= 9.739591) {
            p = 2;
        } else if (((Double) i[30]).doubleValue() > 9.739591) {
            p = WekaClassifier.N7815aa7056(i);
        }
        return p;
    }
    static double N7815aa7056(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 2;
        } else if (((Double) i[4]).doubleValue() <= 43.873505) {
            p = 2;
        } else if (((Double) i[4]).doubleValue() > 43.873505) {
            p = 3;
        }
        return p;
    }
    static double N14e14b57(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 2;
        } else if (((Double) i[0]).doubleValue() <= 988.08154) {
            p = WekaClassifier.N412c150458(i);
        } else if (((Double) i[0]).doubleValue() > 988.08154) {
            p = WekaClassifier.N678840c163(i);
        }
        return p;
    }
    static double N412c150458(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 2;
        } else if (((Double) i[4]).doubleValue() <= 63.134084) {
            p = WekaClassifier.N41969e4a59(i);
        } else if (((Double) i[4]).doubleValue() > 63.134084) {
            p = 2;
        }
        return p;
    }
    static double N41969e4a59(Object []i) {
        double p = Double.NaN;
        if (i[32] == null) {
            p = 2;
        } else if (((Double) i[32]).doubleValue() <= 5.43564) {
            p = 2;
        } else if (((Double) i[32]).doubleValue() > 5.43564) {
            p = WekaClassifier.N1405fa2260(i);
        }
        return p;
    }
    static double N1405fa2260(Object []i) {
        double p = Double.NaN;
        if (i[7] == null) {
            p = 3;
        } else if (((Double) i[7]).doubleValue() <= 35.826581) {
            p = WekaClassifier.N333c4f5061(i);
        } else if (((Double) i[7]).doubleValue() > 35.826581) {
            p = 2;
        }
        return p;
    }
    static double N333c4f5061(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 2;
        } else if (((Double) i[1]).doubleValue() <= 116.377211) {
            p = WekaClassifier.N1219e80662(i);
        } else if (((Double) i[1]).doubleValue() > 116.377211) {
            p = 3;
        }
        return p;
    }
    static double N1219e80662(Object []i) {
        double p = Double.NaN;
        if (i[25] == null) {
            p = 3;
        } else if (((Double) i[25]).doubleValue() <= 7.104013) {
            p = 3;
        } else if (((Double) i[25]).doubleValue() > 7.104013) {
            p = 2;
        }
        return p;
    }
    static double N678840c163(Object []i) {
        double p = Double.NaN;
        if (i[12] == null) {
            p = 3;
        } else if (((Double) i[12]).doubleValue() <= 36.486286) {
            p = WekaClassifier.N5ce762f864(i);
        } else if (((Double) i[12]).doubleValue() > 36.486286) {
            p = 2;
        }
        return p;
    }
    static double N5ce762f864(Object []i) {
        double p = Double.NaN;
        if (i[11] == null) {
            p = 3;
        } else if (((Double) i[11]).doubleValue() <= 55.169445) {
            p = 3;
        } else if (((Double) i[11]).doubleValue() > 55.169445) {
            p = 2;
        }
        return p;
    }
}