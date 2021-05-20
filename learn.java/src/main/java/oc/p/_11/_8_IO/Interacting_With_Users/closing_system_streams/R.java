package oc.p._11._8_IO.Interacting_With_Users.closing_system_streams;

import oc.p._11._2.Annotations.Rule;

@Rule("System.in, System.out, System.err" +
        "are static streams that are shared by the entire application." +
        "Closing them makes them permanently unavailable for all threads in the remainder of program")

@Rule("PrintStream methods do not throw any checked exceptions and rely on checkError to " +
        "report errors, so they fail silently")

class R {
}
