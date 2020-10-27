package oc.p._8._6_ExceptionsAndAssertions.z.reviewQuestions.tw;

import java.io.IOException;
import java.sql.SQLException;

class Q19 {

    static void read() throws SQLException{
        try {
            readFromDatabase();
        }catch (Exception e){
//            e = new Exception();
            throw e;
            /**
             * Special case: it works because e is of type SQLException and the method
             * throws SQLException
             */
        }
    }

    static void readFromDatabase() throws SQLException {
        throw new SQLException("SQLE");
    }

    static void m() throws Exception {
        throw new Exception();
    }
}
