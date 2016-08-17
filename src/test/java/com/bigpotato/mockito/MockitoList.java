package com.bigpotato.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

/**
 * Created by hjy on 16/8/14.
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoList {
    @Mock
    private List<String> stringList;

    @Test
    public void testList() {
        when(stringList.get(anyInt())).thenReturn("hello");
//        doReturn("hello").when(stringList).get(anyInt());
        System.out.println("result = " + stringList.get(0));
    }
}
