package conference;

import emartinez.conference.exception.ConferenceOriginException;
import emartinez.conference.model.Talk;
import emartinez.conference.util.ConferenceUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Test class to manage Wrong filename, empty file and Own Conference Origin Exception
 *
 * @author Edwin Martinez
 */
public class ConferenceManagementTest {

    ConferenceUtil util = new ConferenceUtil();


    @Test(expected = FileNotFoundException.class)
    public void testFileInputNotFound() throws FileNotFoundException, ConferenceOriginException {
        List<Talk> talks = util.readInput("classes/talks-test-1.txt");
    }

    @Test
    public void testGetTalksEmptyFile() throws FileNotFoundException, ConferenceOriginException {
        List<Talk> talks = util.readInput("classes/talks-empty.txt");
        Assert.assertEquals(0, talks.size());
    }

    @Test(expected = ConferenceOriginException.class)
    public void testGetTalksInvalidFile() throws FileNotFoundException, ConferenceOriginException {
        List<Talk> talks = util.readInput("classes/talks-invalid.txt");
    }
}
