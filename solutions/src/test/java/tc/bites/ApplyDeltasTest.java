package tc.bites;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ApplyDeltasTest {
    @Test
    public void testBasic() {
        String source = "April is the cruellest month";
        List<TextDelta> changes = Arrays.asList(
            new TextDelta(9, "the", "THE"),
            new TextDelta(13, "cruel", "CRUELLA")
        );
        String got = ApplyDeltas.apply(source, changes);
        String want = "April is THE CRUELLAlest month";
        Assert.assertEquals(got, want);
    }
}
