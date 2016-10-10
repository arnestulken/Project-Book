package arstulke.projectbook.backend.implementation.Tests;

import android.os.Build;
import android.support.annotation.RequiresApi;

import org.junit.Assert;

import java.util.IllegalFormatCodePointException;
@RequiresApi(api = Build.VERSION_CODES.N)
interface ShouldFail {

    void failCode();

    default void test(String failMessage, Exception exceptionType) {
        try {
            failCode();
            Assert.fail(failMessage);
        } catch (Exception e) {
            if (exceptionType != null) {
                if (e.getClass().getName().equals(exceptionType.getClass().getName())) {
                    Assert.assertEquals(0, 0);
                } else {
                    Assert.fail("[FALSE ERROR]\nSHOULD BE: \n"+exceptionType.getClass().getName()+"\nIS ACTUALLY: \n"+e.getClass().getName());
                }
            }else{
                Assert.assertEquals(0, 0);
            }
        }
    }

    default void test(Exception e) {
        test("should fail", e);
    }

    default void test() {
        test(null);
    }
}