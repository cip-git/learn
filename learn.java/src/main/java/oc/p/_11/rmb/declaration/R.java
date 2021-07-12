package oc.p._11.rmb.declaration;

class R {

//    int a = b = c = 100;

    int b, c;
    int a = b = c = 100;

    int a1 = 1, a2 = 2, a3;
}

class R2 {


//    var a = 100;

    {
//        var a = b = c = 100;

//        var b = 1, c = 1;

        var b = 1;
        var c = 1;

        var a = b = c = 100;
    }
}
