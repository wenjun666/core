package com.ukubuka.core.writer;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.ukubuka.core.model.FileRecord;

/**
 * Ukubuka Writer Test
 * 
 * @author agrawroh
 * @version v1.0
 */
public class UkubukaWriterTest {

    /**************************** Dependency Mocks ***************************/
    @Mock
    private ObjectMapper mapper;

    @Mock
    private ObjectWriter writer;

    @Mock
    private JsonParseException jsonParseException;

    @InjectMocks
    private UkubukaWriter ukubukaWriter;

    /**************************** Initialize Mocks ***************************/
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    /******************************** Test(s) ********************************/
    @Test
    public void test_prettyPrint_success() throws IOException {
        Mockito.when(mapper.writerWithDefaultPrettyPrinter())
                .thenReturn(writer);
        Mockito.when(
                mapper.readValue(Mockito.anyString(), Mockito.eq(Object.class)))
                .thenReturn("fooBar");
        Mockito.when(writer.writeValueAsString(Mockito.anyString()))
                .thenReturn("fooBar");
        String output = ukubukaWriter.prettyPrint("{\"foo\":\"bar\"}");
        assertEquals("fooBar", output);
    }

    @Test(expected = JsonParseException.class)
    public void test_prettyPrint_writer_json_parse_exception()
            throws IOException {
        Mockito.when(mapper.writerWithDefaultPrettyPrinter())
                .thenReturn(writer);
        Mockito.when(
                mapper.readValue(Mockito.anyString(), Mockito.eq(Object.class)))
                .thenReturn("fooBar");
        Mockito.when(writer.writeValueAsString(Mockito.anyString())).thenThrow(
                jsonParseException);
        ukubukaWriter.prettyPrint("{\"foo\":\"bar\"}");
    }

    @Test(expected = JsonParseException.class)
    public void test_prettyPrint_mapper_json_parse_exception()
            throws IOException {
        Mockito.when(mapper.writerWithDefaultPrettyPrinter())
                .thenReturn(writer);
        Mockito.when(
                mapper.readValue(Mockito.anyString(), Mockito.eq(Object.class)))
                .thenThrow(jsonParseException);
        Mockito.when(writer.writeValueAsString(Mockito.anyString())).thenThrow(
                jsonParseException);
        ukubukaWriter.prettyPrint("{\"foo\":\"bar\"}");
    }

    @Test
    public void test_writeJSON_success() {
        List<String> fileHeader = Arrays.asList("foo", "bar");
        List<FileRecord> fileRecords = Arrays.asList(new FileRecord(Arrays
                .asList("bar", "foo")));
        JSONArray jsonArray = ukubukaWriter.writeJSON(fileHeader, fileRecords);
        assertEquals(1, jsonArray.length());
    }
}
